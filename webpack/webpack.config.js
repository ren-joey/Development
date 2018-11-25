const webpack = require('webpack');
const path = require('path');

module.exports = {
    // entry: ['./src/index', './src/app'],
    entry: {
        main: './src/index',
        app: './src/app'
    },
    output: {
        filename: '[name].js',
        path: __dirname + '/dist'
    },
    // output: {
    //     path: path.join(__dirname, 'dist'),
    //     filename: 'bundle.js'
    // },
    module: {
        rules: [
            { test: /\.css$/, use: 'css-loader' }
        ]
    },
    mode: 'none'
    // plugins: [
    //     new HtmlWebpackPlugin({template: './src/index.html'})
    // ]
}