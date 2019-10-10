const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = (env, argv) => {
  return {
    mode: argv.mode,
    devtool: 'source-map',
    entry: {
      main: path.resolve(__dirname, 'src/main/web/index.tsx')
    },
    output: {
      path: path.resolve(__dirname, "target/classes/web"),
      filename: 'static/[name].[contenthash].js',
      chunkFilename: 'static/[name].[contenthash].chunk.js'
    },
    module: {
      rules: [
        {
          test: /\.jsx?$/,
          loader: 'babel-loader',
          exclude: /node_modules/
        },
        {
          test: /\.tsx?$/,
          use: [{
            loader: 'babel-loader'
          }],
          exclude: /node_modules/
        },
        {
          test: /.webmanifest$|.svg$|.png$/,
          use: 'file-loader',
        },
        {
          test: /favicon\.ico$/,
          use: 'file-loader?name=[name].[ext]',
        }

      ]
    },
    optimization: {
      splitChunks: {
        chunks: 'all',
        maxInitialRequests: Infinity,
        minSize: 0,
        cacheGroups: {
          vendor: {
            test: /[\\/]node_modules[\\/]/,
            name(module) {
              // get the name. E.g. node_modules/packageName/not/this/part.js
              // or node_modules/packageName
              const packageName = module.context.match(
                  /[\\/]node_modules[\\/](.*?)([\\/]|$)/)[1];
              // npm package names are URL-safe, but some servers don't like @ symbols
              return `npm.${packageName.replace('@', '')}`;
            },
          },
        },
      },
    },
    resolve: {
      extensions: ['.tsx', '.ts', '.js', '.scss', '.svg',
        '.webmanifest'],
    },
    plugins: [
      new HtmlWebpackPlugin({
        template: path.resolve(__dirname, 'src/main/web/index.html')
      })
    ]
  }
};
