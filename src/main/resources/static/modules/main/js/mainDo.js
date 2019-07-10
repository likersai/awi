define([
    "text!main/templates/mainShow.html",
    "css!main/css/main.css"],
    function(mainShow,css){
        var global = this;
        this.$("#awiMain").html(mainShow);
        this.$("#menu").html('导航目录');
        var theView = {
            init : function(){
                this.fun1();
                this.setOnClick();
            },

            render : function(){
                console.log("render");
            },

            globalTest : function () {
                console.log("globalTest");
            },

            fun1 : function () {
                alert("hello");
                global.$("#ulsy").append('<li><i class="fa fa-inbox"></i><span id="span1" data-path="data-path">Inbox</span></li>')
                global.$("#ulsy").append('<li><i class="fa fa-inbox"></i><span id="span2" data-path="data-path">Inbox</span></li>')
            },

            spanClick : function (v1) {
                var dataPath = $(v1).attr('data-path');
            },

            setOnClick : function () {
                var thisIn = this;
                global.$("span").click(function () {
                    thisIn.spanClick(this);
                });
            }
        };
    return theView;
})