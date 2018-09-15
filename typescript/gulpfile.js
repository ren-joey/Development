/*global require*/
"use strict";

const gulp = require('gulp'),
      ts = require('gulp-typescript');

const path = {
    output: './dist/'
};

const tsProject = ts.createProject('tsconfig.json');

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
    var tsResult = gulp.src("./src/**/*.ts") // or tsProject.src()
        .pipe(tsProject());

    return tsResult.js.pipe(gulp.dest(path.output));
});

gulp.task('watch', function(){
    gulp.watch('./src/**/*.ts', ['ts']);
});

gulp.task('run', ['ts', 'watch']);