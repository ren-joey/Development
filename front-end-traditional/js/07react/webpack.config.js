var path = require ('path');
var webpack = require('webpack');

module.exports = {
  context: path.resolve(__dirname, './src'),
  entry: {
    index: './index.jsx',
    vendor: ['react', 'react-dom']
  },
  output: {
    path: path.resolve(__dirname, './dist'),
    filename: '[name].bundle.js'
  },
  module: {
    rules: [{
      test: /\.css$/,
      use: ['style-loader', 'css-loader']
    },
    {
      test: /\.(js|jsx)$/,
      exclude: /node_modules/,
      use: [{
        loader: 'babel-loader',
        options: {
          presets: [['es2015', {modules: false}], 'react'],
          plugins: ['transform-class-properties']
        }
      }]
    }]
  },
  // resolve: {
  //   alias: {
  //     components: path.resolve(__dirname, 'components')
  //   }
  // },
  plugins: [
    new webpack.optimize.CommonsChunkPlugin({
      name: 'vendor',
      filename: 'vendor.bundle.js',
      minChunks: 2
    })
  ]
  // ,
  // devServer: {
  //   contentBase: distPath,
  //   compress: true,
  //   port: 7070
  // }
}
