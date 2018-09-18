/*global require*/
'use strict';

var gulp = require('gulp'),
    ts = require('gulp-typescript');

var path = {
    output: './dist/'
};

var tsProject = ts.createProject('tsconfig.json');

gulp.task('ts', function(){
    /**
     * usage without tsconfig.ts
     */

    // return gulp.src("./src/**/*.ts")
    // .pipe(ts({
    //     noImplicitAny: true,
    //     outFile: 'output.js'
    // })).pipe(gulp.dest(path.output));

    /**
     * usage with tsconfig.ts
     */
    var tsResult = gulp.src('./src/**/*.ts') // or tsProject.src()
        .pipe(tsProject());

    return tsResult.js.pipe(gulp.dest(path.output));
});

gulp.task('watch', function(){
    gulp.watch('./src/**/*.ts', ['ts']);
});

gulp.task('run', ['ts', 'watch']);