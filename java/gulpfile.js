var gulp = require("gulp"),
    javac = require("gulp-javac");

var paths = {
  src: './src/',
  build: './build/',
  lib: './lib/'
};

gulp.task('javac', function () {
    return gulp.src(paths.src + '**/*.java')
        .pipe(javac.javac().addLibraries(paths.lib + '**/*.jar'))
        .pipe(gulp.dest(paths.build));
});