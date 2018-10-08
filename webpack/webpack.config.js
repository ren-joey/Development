const webpack = require('webpack');
const path = require('path');

module.exports = {
    entry: ['./src/index'],
    output: {
        path: path.join(__dirname, 'dist'),
        filename: 'bundle.js'
    },
    module: {
        rules: [
            { test: /\.css$/, use: 'css-loader' }
        ]
    }
}