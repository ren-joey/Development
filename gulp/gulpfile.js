/*global require*/
"use strict";

const gulp = require('gulp'),
      sass = require('gulp-sass'),
      minCSS = require('gulp-csso'),
      minJS = require('gulp-jsmin'),
      pug = require('gulp-pug'),
      browserSync = require('browser-sync'),
      autoprefix = require('gulp-autoprefixer');

/*
 * Directories here
 */
var paths = {
    public: './dist/',
    sass: './sass/',
    views: './views/',
    js: './script/'
};

/**
 * Compile .pug files and pass in data from json file
 * matching file name. index.pug - index.pug.json
 */
gulp.task('pug', function () {
  return gulp.src(paths.views + '**/*.pug')
    .pipe(pug())
    .on('error', function (err) {
      process.stderr.write(err.message + '\n');
      this.emit('end');
    })
    .pipe(gulp.dest(paths.public))
    .pipe(browserSync.reload({
      stream: true
    }));
});

/**
 * Compile .scss files into public css directory With autoprefixer no
 * need for vendor prefixes then live reload the browser.
 */
gulp.task('sass', function () {
  return gulp.src(paths.sass + '**/*.sass')
    .pipe(sass({
      includePaths: [paths.sass],
      outputStyle: 'compressed'
    }))
    .on('error', sass.logError)
    .pipe(autoprefix(['last 15 versions', '> 1%', 'ie 8', 'ie 7'], {
      cascade: true
    }))
    .pipe(minCSS())
    .pipe(gulp.dest(paths.public + 'css/'))
    .pipe(browserSync.reload({
      stream: true
    }));
});


// Compile .js files into uglify file
gulp.task('js', function(){
  return gulp.src(paths.js + '**/*.js')
    .pipe(minJS())
    .on('error', function (err) {
      process.stderr.write(err.message + '\n');
      this.emit('end');
    })
    .pipe(gulp.dest(paths.public + 'js/'))
    .pipe(browserSync.reload({
      stream: true
    }));
});


/**
 * Watch scss files for changes & recompile
 * Watch .pug files run pug-rebuild then reload BrowserSync
 */
gulp.task('watch', function () {
  gulp.watch(paths.sass + '**/*.sass', ['sass']);
  gulp.watch(paths.views + '**/*.pug', ['pug']);
  gulp.watch(paths.js + '**/*.js', ['js']);
});

/**
 * Wait for pug and sass tasks, then launch the browser-sync Server
 */
gulp.task('browser-sync', ['js', 'sass', 'pug'], function () {
  browserSync({
    server: {
      baseDir: paths.public
    },
    notify: false
  });
});

// Build task compile sass and pug.
gulp.task('build', ['sass', 'pug', 'js']);

/**
 * Default task, running just `gulp` will compile the sass,
 * compile the jekyll site, launch BrowserSync then watch
 * files for changes
 */
gulp.task('default', ['browser-sync', 'watch']);
