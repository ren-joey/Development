// https://segmentfault.com/a/1190000005363030

const webpack = require('webpack');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
    module: {
        rules: [
            {
                test: /\.vue$/,
                loader: 'vue-loader',
                options: {
                    extractCSS: true
                }
            }
        ]
    },
    plugins: [
        new ExtractTextPlugin("style.css")
    ],
    mode: 'production'
}