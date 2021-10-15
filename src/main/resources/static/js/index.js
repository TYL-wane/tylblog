
$(function(){

    var app = new Vue({
        el:"#article",
        data:{
            article:[]
        },
        mounted :function(){
            this.getAriticle()
        },
        methods: {
            getAriticle: function(){
                var that = this;
                axios.get("/artcile").then(function (response){
                    // console.log(response.data)
                    that.article = response.data;
                })
            }
        }
    })






})

