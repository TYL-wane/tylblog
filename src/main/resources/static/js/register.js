$(function(){
    var nicknameflag;
    var usernameflag;
    var passwordflag;
    var repasswordflag;
    var emailflag;
    $(".form_text_ipt").click(function(){
        $(".form_text_ipt").css({"box-shadow":"rgb(187 187 187) 0px 0px 3px"});

    })
    //注册
    var registerApp = new Vue({
        el:".register_div",
        methods:{
            toRegister:function(){
                if($("input[name='nickname']").val().length==0 ||$("input[name='username']").val().length==0 ||$("input[name='password']").val().length==0 ||$("input[name='repassword']").val().length==0 ||$("input[name='email']").val().length==0 ){
                    layer.msg("请输入完整信息",{
                        icon:2
                    })

                }else {
                    //加密的盐
                    var salt = "1a2b3c4c";
                    var passwords = $("input[name='repassword']").val();
                    var str = "" + salt.charAt(0) + salt.charAt(2) + passwords + salt.charAt(5) + salt.charAt(4);
                    $.ajax({
                        type: 'post',
                        url: "toRegister",
                        data: {
                            nickname: $("input[name='nickname']").val(),
                            username: $("input[name='username']").val(),

                            repassword: md5(str),
                            email: $("input[name='email']").val()
                        },
                        success: function (data) {
                            if(data.code==500){
                                layer.msg(data.massage,{
                                    icon:2
                                });
                            }else if(data.code==200){
                                setTimeout(function(){
                                    $(".login_div").css({"display":"block"});
                                    $(".register_div").css({"display":"none"});

                                },3000);
                                layer.msg("注册成功",{
                                    icon:1
                                });
                            }
                        }

                    })
                }
            }
        }
    })


    //昵称
    $(".register_div input[name='nickname']").blur(function(){
        //用户名不能为中文字符和特殊符号
        var reg = /^(\d+[a-zA-Z]+|[a-zA-Z]+\d+)([0-9a-zA-Z]*)$/;
        var value = $(".register_div input[name='nickname']").val();
        nicknameflag = nicknamefun(value,0,reg);
        $(".register_div input[name='nickname']").css({"color":"#00bcd4"});
        $(".register_div input[name='nickname']").parent(".form_text_ipt").css({"box-shadow":"0px 0px 2px #00bcd4","border":"1px solid #00bcd4"});
    })
    function nicknamefun(value,index,reg) {
        if(value.length==0) {
            ececk(index,"昵称不能为空");
            return false;
        }else if(value.length<6){
            ececk(index,"昵称长度不能小于6位");
            return false;
        }else if(value.length>15){
            ececk(index,"昵称长度不能大于15位");
            return false;
        }else if(!reg.test(value)){
            ececk(index,"用户名必须包含英文和数字，不能含有中文和特殊字符");
            return false;
        } else {
            $(".register_div .ececk_warning:eq("+index+")").css({"display":"none"});
            return true;
        }
    }

    //用户名/账号
    $(".register_div input[name='username']").blur(function(){
        //用户名不能为中文字符和特殊符号
        var reg = /^(\d+[a-zA-Z]+|[a-zA-Z]+\d+)([0-9a-zA-Z]*)$/;
        //验证手机号码
        var phoneRegex = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;
        var value = $(".register_div input[name='username']").val();
        usernameflag =  usernamefun(value,1,reg,phoneRegex);
        $(".register_div input[name='username']").css({"color":"#00bcd4"});
        $(".register_div input[name='username']").parent(".form_text_ipt").css({"box-shadow":"0px 0px 2px #00bcd4","border":"1px solid #00bcd4"});
    })
    function usernamefun(value,index,reg,phoneRegex){
        if(value.length==0) {
            ececk(index,"账号或电话号码不能为空");
            return false;

        }else if(!reg.test(value) && !phoneRegex.test(value)){
            ececk(index,"用户昵称不符合规范/电话号码不规范");
            return false;
        } else {
            $(".register_div .ececk_warning:eq("+index+")").css({"display":"none"});
            return true;
        }
    }

    //密码
    $(".register_div input[name='password']").blur(function(){
        var value = $(".register_div input[name='password']").val();
        $(".register_div input[name='password']").parent(".form_text_ipt").css({"box-shadow":"0px 0px 2px #00bcd4","border":"1px solid #00bcd4"});
        passwordflag =  passwordfun(value,2);

    })
    function passwordfun(value,index){
        if(value.length==0){
            ececk(index,"密码不能为空");
            return false;
        } else{
            $(".register_div .ececk_warning:eq("+index+")").css({"display":"none"});
            return true;
        }
    }

    //确认密码
    $(".register_div input[name='repassword']").blur(function(){
        $(".register_div input[name='repassword']").parent(".form_text_ipt").css({"box-shadow":"0px 0px 2px #00bcd4","border":"1px solid #00bcd4"});
        //上一级密码
        var password = $(".register_div input[name='password']").val();
        //拿到确认密码
        var repassword = $(".register_div input[name='repassword']").val();
        repasswordflag =  repasswordfun(password,repassword,3);

    })
    function repasswordfun(password,repassword,index){
        if(repassword.length==0){
            ececk(index,"密码不能为空");
            return false;
        }else if(password!=repassword){
            ececk(index,"两次密码不正确");
            return false;
        }
        else{
            $(".register_div .ececk_warning:eq("+index+")").css({"display":"none"});
            return true;
        }
    }

    //邮箱验证
    $(".register_div input[name='email']").blur(function(){
        $(".register_div input[name='email']").parent(".form_text_ipt").css({"box-shadow":"0px 0px 2px #00bcd4","border":"1px solid #00bcd4"});
        //邮箱验证
        var emailReg = /^[1-9][0-9]{4,10}@qq.com$/;
        // var emailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
        //上一级密码
        var emailval = $(".register_div input[name='email']").val();
        emailflag = emailfun(emailReg,emailval,4);

    })
    function emailfun(emailReg,emailval,index,){
        if(emailval.length==0){
            ececk(index,"邮箱不能为空");
            return false;
        }else if(!emailReg.test(emailval)){
            ececk(index,"请输入正确的邮箱格式");
            return false;
        }
        else{
            $(".register_div .ececk_warning:eq("+index+")").css({"display":"none"});
            return true;
        }
    }

    function ececk(index,content){
        $(".register_div .ececk_warning:eq("+index+")").css({"display":"block"});
        $(".register_div .ececk_warning:eq("+index+")").find("span").text(content);
    }


    $("#button1").click(function(){
        formsubmit();
    })
    function inputflag(){
        if($(".register_div input[name='nickname']").val().length==0 ||$("input[name='username']").val().length==0 ||$("input[name='password']").val().length==0 ||$("input[name='repassword']").val().length==0 ||$("input[name='email']").val().length==0 ){
            return true;
        }
    }
    //form表单提交验证
    function formsubmit(){
        var flag = nicknameflag && usernameflag && passwordflag && repasswordflag && emailflag;
        // alert(!inputflag())
        if(!inputflag || !flag){
            return flag;
        }else{
            // alert(5645)
            return true;
        }


    }
    // 绑定取消按钮
    $(".register_div .close").click(function(){
        $(".register_div input").parent(".form_text_ipt").css({"box-shadow":"0px 0px 1px #cccccc","border":"1px solid #cccccc"});
        $(".register_div .ececk_warning").css({"display":"none"});
        $(".register_div").css({"display":"none"})
    })

})