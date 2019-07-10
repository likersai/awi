require.config({
    baseUrl:'modules',
    map: {
        '*': {
            'css': 'requireJs/css'
        }

    },
    paths:{
        jquery: 'jquery/jquery-3.3.1.min.js',
        text:"requireJs/text"
    }
})


require(["main/js/mainDo"],function (mainDo) {
    mainDo.init();
});
