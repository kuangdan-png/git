$(function(){
    layui.config({
        version: '1573457678857' //为了更新 js 缓存，可忽略
    });

    layui.use(['laydate','table','element'], function(){
        var table = layui.table //表格
            ,$=layui.$
            ,element = layui.element ;//元素操作

        //监听Tab切换
        element.on('tab(demo)', function(data){
            layer.tips('切换了 '+ data.index +'：'+ this.innerHTML, this, {
                tips: 1
            });
        });
        //执行一个 table 实例
        table.render({
            elem: '#demo'
            ,height: 400//表单的高
            ,width:1000//表单的宽
            ,url: '/searchAllemployeemapList.action' //数据接口
            ,title: '供货商表'
            ,shade : 0//不显示遮罩
            ,page: true //开启分页
            ,limits: [10,20,50]  //每页条数的选择项，默认：[10,20,30,40,50,60,70,80,90]。
            ,limit: 10 //每页默认显示的数量
            /*,method:'post'  //提交方式*/
            ,skin: 'line ' //表格风格 line （行边框风格）row （列边框风格）nob （无边框风格）
            ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档true/default
            ,totalRow: true //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left',LAY_CHECKED:true}//LAY_CHECKED:true默认单选框选中
                ,{field: 'employeeId', title: '供货商编号', width:120,  align:'center',sort: true}//sort: true排序
                ,{field: 'firstName', title: '联系人', align:'center', width: 90}
                ,{field: 'lastName', title: '联系电话',  align:'center',width:120}
                ,{field: 'email', title: '我方应付金额', width: 180,  align:'center',totalRow: true, sort: true}// totalRow: true合计
                ,{field: 'phoneNumber', title: '联系地址',  align:'center',width:160}
                ,{field: 'jobId', title: '所属地址', align:'center', width: 160}
                ,{field: 'salary', title: '默认供货商', align:'center', width: 100,templet: function (row) {
                        var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                        if (row.supDefault == 1) {
                            html += " checked ";
                        }
                        html += ">";
                        return html;
                    }
                }
                ,{field: 'commissionPct',  align:'center',title: '备注', width: 180}
                ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
            ]],parseData: function(res, curr, count){ //res 即为原始返回的数据 //curr得到当前页码//count得到数据总量
                return {
                    "code": res.status, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.row //解析数据列表
                }
            },done: function (obj) {//复选框函数
                layer.closeAll();
                form.on('checkbox(checkboxIsSelected)', function (data) {
                    var _index = $(data.elem).attr('table-index') || 0;
                    if (data.elem.checked) {
                        obj.data[_index].supDefault = data.value;
                    } else {
                        obj.data[_index].supDefault = 2;
                    }
                });
                var supplierList = table.cache.js_table_reource_invite_supplier_index_table;
            }
        });
        $.ajax({
            type:"POST",
            url:'/searchProcess.action',  //从数据库查询返回的是个list
            dataType: "json",
            success: function (data) {
                $.each(data,function(index,item){
                    $('#proName').append(new Option(item.proName,item.proId));//往下拉菜单里添加元素
                })
            }
        })
        $("#proName").change(function () {
           var checkred=JSON.stringify($("select option:selected").val())
            $.ajax({
                type:"POST",
                url:'/searchCity.action?processId='+checkred,  //从数据库查询返回的是个list
                dataType: "json",
                success: function (data) {
                    $.each(data,function(index,item){
                        $('#citName').append(new Option(item.citName,item.citId));//往下拉菜单里添加元素
                    })
                }
            })
        });
        $("#citName").change(function () {
            var checkrede=$("#citName option:selected").val()
            $.ajax({
                type:"POST",
                url:'/searchDistrict.action?cityId='+checkrede,  //从数据库查询返回的是个list
                dataType: "json",
                success: function (data1) {
                    $.each(data1,function(index,item){
                        $('#disName').append(new Option(item.disName,item.disId));//往下拉菜单里添加元素
                    })
                }
            })
        });
        //监听头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    /*layer.msg('添加');*/
                    layer.open({
                        //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
                        type:1,
                        closeBtn:2,//×的样式
                        /*moveOut: false,*/
                        shade : 0,//不显示遮罩
                        title:"新增供货商信息",
                        area: ['35%','93%'],//增加框的宽高
                        content:$('#popSearchRoleTest'),// $('#id')
                        skin:'demo-class',//自定义样式风格
                        success: function(layero, index){//JQ函数
                            $("#addtotton").css({ "display": "none" });
                            //表单提交数据
                            layui.use(['layer','form'],function() {
                                var form = layui.form;
                                var layer = layui.layer;
                                $ = layui.jquery;

                                form.on('submit(suu)', function (data) {
                                    var citId=$("#citName option:selected").val()
                                    var proId=$("#proName option:selected").val()
                                    var disId=$("#disName option:selected").val()
                                    window.alert(proId)
                                    $.ajax({
                                        url: "/insertSystemsetup.action?proId="+proId,
                                        type: 'post',
                                        data: data.field,
                                        dataType: 'JSON',
                                        success: function (data) {
                                            if (data == 1) {
                                                window.alert("新增成功")
                                            }
                                        }
                                    })
                                })
                            })
                        }
                    });
                    break;
                case 'update':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else if(data.length > 1){
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.open({
                            //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
                            type:1,
                            closeBtn:2,//×的样式
                            shade : 0,//不显示遮罩
                            title:"编辑供货商信息",
                            area: ['35%','93%'],//增加框的宽高
                            content:$('#popSearchRoleTest'),// $('#id')
                            skin:'demo-class',//自定义样式风格
                            success: function(layero, index){//JQ函数
                                $('#popSearchRoleTest').css({"display": "block"});
                                console.log(layero, index);
                            }
                        });
                    }
                    break;
                case 'delete':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else {
                        layer.msg('删除');
                    }
                    break;
            }
        });


    })

})