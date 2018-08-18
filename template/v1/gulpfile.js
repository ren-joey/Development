const gulp = require('gulp'),
      pug = require('gulp-pug'),
      sass = require('gulp-sass'),
      prefixer = require('gulp-autoprefixer'),
      sync = require('browser-sync');

var paths = {
  output: './dist/',
  sass: './sass/',
  pug: './views/',
  bower: './bower_components/'
};

gulp.task('pug', function(){
  return gulp.src(paths.pug + './*.pug')
    .pipe(pug())
    .pipe(gulp.dest(paths.output))
    .pipe(sync.reload({
      stream: true
    }));
});

gulp.task('sass', function(){
  return gulp.src(paths.sass + '**/*.sass')
    .pipe(sass({
      outputStyle: 'compressed'
    }))
    .pipe(prefixer(['last 15 versions', '> 1%', 'ie 8', 'ie 7'], {
      cascade: true
    }))
    .pipe(gulp.dest(paths.output + 'css/'))
    .pipe(sync.reload({
      stream: true
    }));
});

gulp.task('watch', function(){
  gulp.watch(paths.sass + '**/*.sass', ['sass']);
  gulp.watch(paths.pug + '**/*.pug', ['pug']);
});

gulp.task('sync', function(){
  sync({
    server: {
      baseDir: paths.output
    },
    notify: false
  });
});

gulp.task('run', ['sync', 'watch']);
