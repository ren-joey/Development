var path = require ('path');

module.exports = {
  context: path.resolve(__dirname, './src'),
  entry: {
    main: './main.js',
    module: ['./module-1.js', './module-2.js']
  },
  output: {
    path: path.resolve(__dirname, './dist'),
    filename: '[name].bundle.js'
  }
}
