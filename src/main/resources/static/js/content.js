$(function(){
    $(".reply_div").mouseover(function(){
        $(this).find(".comment-item-hidden").css({"display":"block"})
    })
    $(".reply_div").mouseout(function(){
        $(this).find(".comment-item-hidden").css({"display":"none"})
    })


    $(".commentsReply").mouseover(function(){
        $(this).find(".comment-item-hidden").css({"display":"block"})
    })
    $(".commentsReply").mouseout(function(){
        $(this).find(".comment-item-hidden").css({"display":"none"})
    })


    $(".reply").click(function(){
        $("#wang").remove();
        $(this).parent().parent().parent().parent().parent().parent().parent().parent().find(".hui").append(' <div id="wang">\n' +
            '                                                        <div id="comment-children-wangEditor" style="width: 730px;" class="children children-mark">\n' +
            '\n' +
            '                                                        </div>\n' +
            '                                                        <div class="commit_btn" style="margin-left: 750px;margin-top: -36px;">\n' +
            '                                                            <button class="text fr commit">提交</button>\n' +
            '                                                        </div>\n' +
            '                                                    </div>');
        var username = $(this).parent().parent().parent().parent().parent().find(".nickname").text();
        var parentuid = $(this).parent().parent().parent().parent().parent().find(".nickname").attr("parentuid");
        const  c = wang(username)
        //点击提交
        //
        $(".commit_btn").click(function(){
            //获取博文id
            var artid = $(".content-area").attr("artid");
            //用户id
            var uid = $("#exit").attr("uid");
            //获取评论id
            var commid = $(this).parent().parent().parent().parent().parent().parent().parent().parent().attr("commid");
            //获取回复用户的id
            var parentId = parentuid;
            //获取评论类容
            var commContent = c.txt.html();
            console.log("commit_=="+artid+"---"+uid+"---"+commid+"---"+parentId+"---"+commContent)
            if(typeof(artid)!= "undefined" || typeof(commid)!= "undefined" || typeof(parentId)!= "undefined"){
                if( typeof(uid)== "undefined" ){
                    layer.msg("请先登录再评论",{
                        icon:2
                    })
                }else{
                    if(!commContent && typeof(commContent) != "undefined"){
                        layer.msg("内容不能为空",{
                            icon:2
                        })
                    }else{
                        //发送请求
                        $.ajax({
                            type:"post",
                            url:"addComment",
                            data :{
                                artId:artid,
                                uId:uid,
                                commId:commid,
                                parentId:parentId,
                                commContent:commContent
                            },
                            success:function(data){
                                setTimeout(function(){
                                    window.location.reload();
                                },2000);
                                if(data.code==200){
                                    layer.msg("评论成功",{
                                        icon:1
                                    })
                                }else{
                                    layer.msg(data.massage,{
                                        icon:2
                                    })
                                }
                            }
                        })

                    }
                }

            }
        })
    })

$(".parent-reply").click(function(){
    $("#wang").remove();
    $(this).parent().parent().parent().parent().parent().append('<div id="wang">\n' +
        '                                                        <div id="comment-children-wangEditor" style="width: 730px;" class="children children-mark">\n' +
        '\n' +
        '                                                        </div>\n' +
        '                                                        <div class="parent-commit" style="margin-left: 750px;margin-top: -36px;">\n' +
        '                                                            <button class="text fr">提交</button>\n' +
        '                                                        </div>\n' +
        '                                                    </div>');

    var username = $(this).parent().parent().parent().parent().parent().find(".parUname").attr("paruname");
    var parentuid = $(this).parent().parent().parent().parent().parent().find(".parUname").attr("parid");
    const c1 = wang(username);
    //点击提交
    $(".parent-commit").click(function(){
        //获取博文id
        var artid = $(".content-area").attr("artid");
        //用户id
        var uid = $("#exit").attr("uid");
        //获取评论id
        var commid = $(this).parent().parent().parent().parent().attr("commid");
        //获取回复用户的id
        var parentId = parentuid;
        //获取评论类容
        var commContent = c1.txt.html();
    console.log("commit"+artid+"---"+uid+"---"+commid+"---"+parentId+"---"+commContent)
        if(typeof(artid)!= "undefined" || typeof(commid)!= "undefined" || typeof(parentId)!= "undefined"){
            if( typeof(uid)== "undefined" ){
                layer.msg("请先登录再评论",{
                    icon:2
                })
            }else{
                if(!commContent && typeof(commContent) != "undefined"){
                    layer.msg("内容不能为空",{
                        icon:2
                    })
                }else{
                    //发送请求
                    $.ajax({
                        type:"post",
                        url:"addComment",
                        data :{
                            artId:artid,
                            uId:uid,
                            commId:commid,
                            parentId:parentId,
                            commContent:commContent
                        },
                        success:function(data){
                            setTimeout(function(){
                                window.location.reload();
                            },2000);
                            if(data.code==200){
                                layer.msg("评论成功",{
                                    icon:1
                                })
                            }else{
                                layer.msg(data.massage,{
                                    icon:2
                                })
                            }
                        }
                    })

                }
            }

        }
    })
})



// 博文点赞
    $("#xihuan").find(".icon-aixin").click(function(){
        //获取状态
        var data_d = $("#xihuan").attr("data_d");
        //获取博文id
        var artid = $(".content-area").attr("artid");
        //获取数量
        var num =  $("#xihuan").find("b").text();
        //用户id
        var uid = $("#exit").attr("uid");
        if( typeof(uid)== "undefined" ){
            layer.msg("请先登录再点赞",{
                icon:2
            })
        }else {
            //判断状态
            if (data_d == 0) {
                //发送请求
                $.ajax({
                    type: "post",
                    url: "outArtThumbsSize",
                    data: {
                        artId: artid,
                        uId:uid
                    },
                    success: function (data) {
                        if (data.code == 200) {
                            $("#xihuan").find("b").text(parseInt(num) - 1);
                            $("#xihuan").attr("data_d", 1)
                            //没有点赞
                            $("#xihuan").find(".icon-aixin").css({"color": "#696a6e"})
                            layer.msg("取消成功", {
                                icon: 1
                            })
                        } else {
                            layer.msg("取消失败", {
                                icon: 1
                            })
                        }
                    }
                })
            } else if (data_d == 1) {
                //发送请求
                $.ajax({
                    type: "post",
                    url: "onArtThumbsSize",
                    data: {
                        artId: artid,
                        uId:uid
                    },
                    success: function (data) {
                        if (data.code == 200) {
                            $("#xihuan").find("b").text(parseInt(num) + 1);
                            $("#xihuan").attr("data_d", 0)
                            $("#xihuan").find(".icon-aixin").css({"color": "red"});
                            layer.msg("点赞成功", {
                                icon: 1
                            })
                        } else {
                            layer.msg("点赞失败", {
                                icon: 1
                            })
                        }
                    }
                })
            }
        }
    })



    //评论点赞
    //喜欢
    $(".comments-area-content").find(".up").click(function(){
        //获取评论id
        var commid = $(this).attr("commid");
        //用户id
        var uid = $("#exit").attr("uid");
        //获取博文id
        var artid = $(".content-area").attr("artid");
        if( typeof(uid)== "undefined" ){
            layer.msg("请先登录再点赞",{
                icon:2
            })
        }else{
            var dataD = $(this).attr("data_d");
            if(dataD == 0){
                //没有做点赞
                $(this).css({"color":"red"});
                $(this).attr("commid",1);

            }else{
                //点赞
                $(this).css({"color":"#2882c5"});
                $(this).attr("commid",0);
            }
        }
    })

    //不喜欢
    $(".comments-area-content").find(".down").click(function(){
        //获取评论id
        var commid = $(this).attr("commid");
        //用户id
        var uid = $("#exit").attr("uid");
        if( typeof(uid)== "undefined" ){
            layer.msg("请先登录再点赞",{
                icon:2
            })
        }
    })

})

function wang(name){
    //富文本
    const E1 = window.wangEditor
    const editor1 = new E1('#comment-children-wangEditor');
    editor1.config.height=60
    editor1.config.placeholder = '回复 @ '+name;
    editor1.config.emotions = [
        {
            title: '新浪', // tab 的标题
            type: 'image', // 'emoji' 或 'image' ，即 emoji 形式或者图片形式
            content: [
                { alt: '[坏笑]', src: `http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/7a/shenshou_thumb.gif` },
                { alt: '[舔屏]', src: `http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/60/horse2_thumb.gif` },
                {alt: '[浮云]',src: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/bc/fuyun_thumb.gif'},
                {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c9/geili_thumb.gif",
                    alt : "[给力]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f2/wg_thumb.gif",
                    alt : "[围观]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/70/vw_thumb.gif",
                    alt : "[威武]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6e/panda_thumb.gif",
                    alt : "[熊猫]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/81/rabbit_thumb.gif",
                    alt : "[兔子]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/bc/otm_thumb.gif",
                    alt : "[奥特曼]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/15/j_thumb.gif",
                    alt : "[囧]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/89/hufen_thumb.gif",
                    alt : "[互粉]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c4/liwu_thumb.gif",
                    alt : "[礼物]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/ac/smilea_thumb.gif",
                    alt : "[呵呵]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/0b/tootha_thumb.gif",
                    alt : "[嘻嘻]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6a/laugh.gif",
                    alt : "[哈哈]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/14/tza_thumb.gif",
                    alt : "[可爱]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/af/kl_thumb.gif",
                    alt : "[可怜]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/a0/kbsa_thumb.gif",
                    alt : "[挖鼻屎]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f4/cj_thumb.gif",
                    alt : "[吃惊]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6e/shamea_thumb.gif",
                    alt : "[害羞]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c3/zy_thumb.gif",
                    alt : "[挤眼]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/29/bz_thumb.gif",
                    alt : "[闭嘴]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/71/bs2_thumb.gif",
                    alt : "[鄙视]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6d/lovea_thumb.gif",
                    alt : "[爱你]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/9d/sada_thumb.gif",
                    alt : "[泪]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/19/heia_thumb.gif",
                    alt : "[偷笑]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/8f/qq_thumb.gif",
                    alt : "[亲亲]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/b6/sb_thumb.gif",
                    alt : "[生病]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/58/mb_thumb.gif",
                    alt : "[太开心]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/17/ldln_thumb.gif",
                    alt : "[懒得理你]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/98/yhh_thumb.gif",
                    alt : "[右哼哼]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6d/zhh_thumb.gif",
                    alt : "[左哼哼]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/a6/x_thumb.gif",
                    alt : "[嘘]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/af/cry.gif",
                    alt : "[衰]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/73/wq_thumb.gif",
                    alt : "[委屈]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/9e/t_thumb.gif",
                    alt : "[吐]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f3/k_thumb.gif",
                    alt : "[打哈欠]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/27/bba_thumb.gif",
                    alt : "[抱抱]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/7c/angrya_thumb.gif",
                    alt : "[怒]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/5c/yw_thumb.gif",
                    alt : "[疑问]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/a5/cza_thumb.gif",
                    alt : "[馋嘴]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/70/88_thumb.gif",
                    alt : "[拜拜]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/e9/sk_thumb.gif",
                    alt : "[思考]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/24/sweata_thumb.gif",
                    alt : "[汗]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/7f/sleepya_thumb.gif",
                    alt : "[困]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6b/sleepa_thumb.gif",
                    alt : "[睡觉]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/90/money_thumb.gif",
                    alt : "[钱]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/0c/sw_thumb.gif",
                    alt : "[失望]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/40/cool_thumb.gif",
                    alt : "[酷]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/8c/hsa_thumb.gif",
                    alt : "[花心]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/49/hatea_thumb.gif",
                    alt : "[哼]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/36/gza_thumb.gif",
                    alt : "[鼓掌]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d9/dizzya_thumb.gif",
                    alt : "[晕]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/1a/bs_thumb.gif",
                    alt : "[悲伤]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/62/crazya_thumb.gif",
                    alt : "[抓狂]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/91/h_thumb.gif",
                    alt : "[黑线]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6d/yx_thumb.gif",
                    alt : "[阴险]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/89/nm_thumb.gif",
                    alt : "[怒骂]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/40/hearta_thumb.gif",
                    alt : "[心]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/ea/unheart.gif",
                    alt : "[伤心]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/58/pig.gif",
                    alt : "[猪头]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d6/ok_thumb.gif",
                    alt : "[ok]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d9/ye_thumb.gif",
                    alt : "[耶]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d8/good_thumb.gif",
                    alt : "[good]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c7/no_thumb.gif",
                    alt : "[不要]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d0/z2_thumb.gif",
                    alt : "[赞]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/40/come_thumb.gif",
                    alt : "[来]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d8/sad_thumb.gif",
                    alt : "[弱]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/91/lazu_thumb.gif",
                    alt : "[蜡烛]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6a/cake.gif",
                    alt : "[蛋糕]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d3/clock_thumb.gif",
                    alt : "[钟]"
                }, {
                    src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/1b/m_thumb.gif",
                    alt : "[话筒]"
                }

            ]
        }
    ]
    //显示表情img
    editor1.config.emotionsShow = 'icon';

    // 默认情况下，显示所有菜单
    editor1.config.menus = [
        'bold',
        'emoticon'

    ]
    // 挂载highlight插件
    editor1.highlight = hljs;
    editor1.create();
return editor1;
}