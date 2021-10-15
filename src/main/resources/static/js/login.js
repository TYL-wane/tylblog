$(function(){
    $(".form_text_ipt").click(function(){
        $(".form_text_ipt").css({"box-shadow":"rgb(187 187 187) 0px 0px 3px"});

    })
    //登录
    var loginspp = new Vue({
        el:".login_div",
        methods:{
            toLogin :function(){
                // document.write("<script language='javascript' src='register.js'></script>")

                //加密的盐
                var salt = "1a2b3c4c";

                //获取账号
                var username = $("input[name='loginusername']").val();
                var password = $("input[name='loginpassword']").val();
                var str = ""+salt.charAt(0)+salt.charAt(2)+password+salt.charAt(5)+salt.charAt(4);
                var jiamiPass = md5(str);
                $.ajax({
                    type:"get",
                    url:"login?username="+username+"&password="+jiamiPass,
                    success:function(data){
                        console.log(data)
                        layer.closeAll();
                        if (data.code == 200) {

                            setTimeout(function(){
                                $(".login_div").css({"display":"none"});
                                window.location.reload();
                            },3000);

                            layer.msg("登录成功",{
                                icon:1
                            });


                        } else {
                            layer.msg(data.massage,{
                                icon: 2
                            });
                        }
                    }
                })
            }
        }
    })

    //绑定登录按钮
    $("#userlogin").click(function(){
        $(".login_div").css({"display":"block"})
    })
    //登录页面跳转
    $("#tologin").click(function(){
        $(".register_div").css({"display":"none"})
        $(".login_div").css({"display":"block"})
        $(".login_box .ececk_warning").css({"display":"none"});
        $(".login_div input").parent(".form_text_ipt").css({"box-shadow":"0px 0px 1px #cccccc","border":"1px solid #cccccc"});

    })

    //绑定注册按钮
    $("#userregister").click(function(){
        $(".register_div").css({"display":"block"})
    })
    //注册页面跳转
    $("#toregister").click(function(){
        $(".register_div").css({"display":"block"})
        $(".login_div").css({"display":"none"})
        $(".login_box .ececk_warning").css({"display":"none"});
        $(".login_div input").parent(".form_text_ipt").css({"box-shadow":"0px 0px 1px #cccccc","border":"1px solid #cccccc"});
    })

    //账号
    $(".login_box input[name='loginusername']").blur(function(){
        var value = $("input[name='loginusername']").val();
        usernamefun(value,0);
        $(".login_box input[name='loginusername']").css({"color":"#00bcd4"});
        $(".login_box input[name='loginusername']").parent(".form_text_ipt").css({"box-shadow":"0px 0px 2px #00bcd4","border":"1px solid #00bcd4"});
    })
    //密码
    $(".login_box input[name='loginpassword']").blur(function(){
        var value = $(".login_box input[name='loginpassword']").val();
        $(".login_box input[name='loginpassword']").parent(".form_text_ipt").css({"box-shadow":"0px 0px 2px #00bcd4","border":"1px solid #00bcd4"});
        usernamefun(value,1);
    })

    function usernamefun(value,index) {
        if(value.length==0) {
            $(".login_box .ececk_warning:eq("+index+")").css({"display":"block"});
            return false;
        }else {
            $(".login_box .ececk_warning:eq("+index+")").css({"display":"none"});
            return true;
        }
    }
    // 绑定取消按钮
    $(".login_div .close").click(function(){
        $(".login_div").css({"display":"none"})
        $(".login_box .ececk_warning").css({"display":"none"});
        $(".login_div input").parent(".form_text_ipt").css({"box-shadow":"0px 0px 1px #cccccc","border":"1px solid #cccccc"});
    })



})