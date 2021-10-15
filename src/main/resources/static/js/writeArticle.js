$(function(){
    layui.use(['dropdown', 'util', 'layer'], function(){
        var element = layui.element;
        var layer = layui.layer;

        //监听折叠
        element.on('collapse(test)', function(data){
            layer.msg('展开状态：'+ data.show);
        });
    });
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'selectAllArticle'
            ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            ,title: '用户数据表'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'artId', title:'ID',width: 80, fixed: 'left', unresize: true, sort: true}
                ,{field:'artTitle', title:'文章标题',width: 360}
                ,{field:'artDescribe', title:'文章描述',width: 360}
                ,{field:'artTime', title:'创建时间', sort: true}
                ,{field:'artUpdateTime', title:'修改时间', sort: true}
                ,{field:'artThumbsSize', title:'点赞数量' ,sort: true}
                ,{field:'artBrowseSize', title:'浏览数量', sort: true}
                ,{fixed: 'right', title:'操作',fixed: 'right', toolbar: '#barDemo'}
            ]]
            ,page: true
            ,limit: 6
        });

        // //头工具栏事件
        // table.on('toolbar(test)', function(obj){
        //     var checkStatus = table.checkStatus(obj.config.id);
        //     switch(obj.event){
        //         case 'getCheckData':
        //             var data = checkStatus.data;
        //             layer.alert(JSON.stringify(data));
        //             break;
        //         case 'getCheckLength':
        //             var data = checkStatus.data;
        //             layer.msg('选中了：'+ data.length + ' 个');
        //             break;
        //         case 'isAll':
        //             layer.msg(checkStatus.isAll ? '全选': '未全选');
        //             break;
        //
        //         //自定义头工具栏右侧图标 - 提示
        //         case 'LAYTABLE_TIPS':
        //             layer.alert('这是工具栏右侧自定义的一个图标按钮');
        //             break;
        //     };
        // });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.prompt({
                    formType: 2
                    ,value: data.email
                }, function(value, index){
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });
    });
})