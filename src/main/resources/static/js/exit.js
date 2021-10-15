$(function(){
    $("#exit").click(function(){
        $.ajax({
            type: "get",
            url: "exit",
            success: function (data) {
                if(data.code == 200){
                    setTimeout(function(){
                        window.location.reload();
                    },2500);
                    layer.msg("退出成功",{
                        icon:1
                    })
                }else{
                    setTimeout(function(){
                        window.location.reload();
                    },2500);
                    layer.msg("退出失败",{
                        icon:2
                    })
                }
            }
        })
    })
})