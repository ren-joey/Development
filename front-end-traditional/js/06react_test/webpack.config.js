var path = require('path');
var webpack = require('webpack');

module.exports = {
  context: path.resolve(__dirname, './src'),
  entry: {
    main: './index.jsx'
  },
  output: {
    path: path.resolve(__dirname, './dist'),
    filename: "[name].react.js"
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: [['es2015', {modules: false}], 'react'],
            plugins: ['transform-class-properties']
          }
        }
      }
    ]
  }
}
