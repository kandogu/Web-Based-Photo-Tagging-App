module.exports = {
    build: {
        //magic stuff
    },
    dev: {
        env: require('./dev.env'),
        port: 8081,
        autoOpenBrowser: true,
        assetsSubDirectory: 'static',
        assetsPublicPath: '/',
        proxyTable: {
            '/': {
                target: 'http://localhost:8086',
                changeOrigin: true
            }
        },
        cssSourceMap: false
    }
}
