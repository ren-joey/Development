const gulp = require('gulp'),
      pug = require('gulp-pug'),
      sass = require('gulp-sass'),
      prefixer = require('gulp-autoprefixer'),
      browserify = require('browserify'),
      source = require('vinyl-source-stream'),
      buffer = require('vinyl-buffer'),
      uglify = require('gulp-uglify'),
      sync = require('browser-sync');

var paths = {
  output: './dist/',
  sass: './sass/',
  js: './js/',
  pug: './views/',
  bower: './bower_components/'
};

gulp.task('browserify', function(){
  return browserify()
    .require('jquery')
    .bundle()
    .pipe(source('lib.js'))
    .pipe(buffer())
    .pipe(uglify())
    .pipe(gulp.dest(paths.output + 'lib/'))
});

gulp.task('pug', function(){
  return gulp.src(paths.pug + '**/*.pug')
    .pipe(pug())
    .pipe(gulp.dest(paths.output))
    .pipe(sync.reload({
      stream: true
    }))
});

gulp.task('sass', function(){
  return gulp.src(paths.sass + '**/*.sass')
    .pipe(sass({
      includePaths: [paths.bower + 'bootstrap/scss/'],
      outputStyle: 'compressed'
    }))
    .pipe(prefixer(['last 15 versions', '> 1%', 'ie 8', 'ie 7'], {
      cascade: true
    }))
    .pipe(gulp.dest(paths.output + 'style/'))
    .pipe(sync.reload({
      stream: true
    }))
});

gulp.task('plugins', function(){
  return gulp.src(paths.bower + '**/*.scss')
  .pipe(sass({
    outputStyle: 'compressed'
  }))
  .pipe(prefixer(['last 15 versions', '> 1%', 'ie 8', 'ie 7'], {
    cascade: true
  }))
  .pipe(gulp.dest(paths.output + 'plugins/'))
  .pipe(sync.reload({
    stream: true
  }))
});

gulp.task('js', function(){
  return gulp.src(paths.js + '**/*.js')
    .pipe(uglify())
    .pipe(gulp.dest(paths.output + 'js/'))
    .pipe(sync.reload({
      stream: true
    }))
})

gulp.task('watch', function(){
  gulp.watch(paths.sass + '**/*.sass', ['sass']);
  gulp.watch(paths.pug + '**/*.pug', ['pug']);
  gulp.watch(paths.js + '**/*.js', ['js']);
})

gulp.task('sync', function(){
  sync({
    server: {
      baseDir: paths.output
    },
    notify: false
  });
});

gulp.task('run', ['sync', 'watch', 'browserify', 'plugins']);
