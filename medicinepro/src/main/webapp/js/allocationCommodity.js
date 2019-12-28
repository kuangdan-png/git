layui.use(['table', 'layer'], function () {
    var table = layui.table;
    var layer = layui.layer;
    //添加单击事件【将增加商品添加至添加新商品中】
    $('#addNew-shop').on('click', function () {
        layer.open({
            type: 2,
            title: '增加商品'
            , content: 'newAddition.html'
            , area: ['495px', '560px']
            , skin: 'demo-class'
            , shade: 0
            , moveOut: true
        });
    });

    //当点击退出时，关闭当前层
    $('#cancle').on('click', function () {
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index);
    });

    //定义全局数组变量保存右边被选中数据表格数据
    var tableData = [];

    //全部变量赋值方法
    function tableLoad(checkData,num){
        //点击 单条添加
        if(num=="one") {
            if(tableData.length > 0){//判断全局数组是否有数据
                var states = false;//定义重复状态
                for(var y = 0; y < tableData.length; y++){//循环全局数组数据
                    if(checkData.data.commodity.comId == tableData[y].commodity.comId){
                        states = true;//有重复改变重复状态为真
                        //有重复值数量＋1
                        tableData[y].duo1=Number(tableData[y].duo1)+1;
                    }
                }
                if(!states){//判断不重复则将选中的数据插入全局数组中
                    checkData.data.duo1=1;
                    tableData.push(checkData.data);
                }
            }else {
                //全局数组变量没有数据则直接把选中的数据赋给它
                checkData.data.duo1=1;
                tableData[0] = checkData.data;
            }
            //按钮点击事件添加
        }else{
            if(tableData.length > 0){//判断全局数组是否有数据
                for(var i = 0; i < checkData.data.length; i++){//循环选中每条的数据
                    var states = false;//定义重复状态
                    for(var y = 0; y < tableData.length; y++){//循环全局数组数据
                        if(checkData.data[i].commodity.comId == tableData[y].commodity.comId){
                            states = true;//有重复改变重复状态为真
                            tableData[y].duo1=Number(tableData[y].duo1)+1;
                        }
                    }
                    if(!states){//判断不重复则将选中的数据插入全局数组中
                        checkData.data[i].duo1=1;
                        tableData.push(checkData.data[i]);
                    }
                }
            } else {//全局数组变量没有数据则直接把选中的数据赋给它
                for (var b = 0; b < checkData.data.length; b++) {
                    checkData.data[b].duo1 = 1;
                }
                tableData = checkData.data;
            }
        }
    }

    //获得父类传递的数据
    var warehouseNo = parent.PartitionId;

    //获得商品清单信息
    table.render({
        elem: '#product'
        , url: "/allocationManager/searchCommidyInfo.action"
        , where: {"repComId": "", "repId": warehouseNo}
        , cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            {type: 'checkbox', fixed: true} //LAY_CHECKED:true默认单选框选中
            , {field: 'repComId', width: 100, title: '商品编号'}
            , {field: 'repProName', width: 100, title: '商品名称'}
            , {field: 'reqCurrent', width: 100, title: '库存数'}
            , {templet: '<div>{{d.commodity.comUnit}}</div>', width: 80, title: '单位'}
            , {templet: '<div>{{d.commodity.comProduct}}</div>', width: 100, title: '产品规格'}
            , {templet: '<div>{{d.commodity.comPrice}}</div>', width: 100, title: '参考进价'}
            , {templet: '<div>{{d.commodity.manufacturer.manName}}</div>', width: 160, title: '生产厂商'}
        ]], response: {
            statusCode: 0 //重新规定成功的状态码为 200，table 组件默认为 0
        }, parseData: function (res) { //将原始数据解析成 table 组件所规定的数据
            return {
                "code": res.status, //解析接口状态
                "msg": res.msg, //解析提示文本
                "count": res.count, //解析数据长度
                "data": res.row//解析数据列表
            };
        }
        , height: 300
        , width: 800
        , page: true //开启分页
    });

    // 监控输入框
    $("#searchText").bind("input", function () {
        //传递参数给数据表格方法
        table.reload('product', {
            where: {"repComId": $(this).val(), "repId": warehouseNo}//设定异步数据接口的额外参数
        });
    });

    // 监听行双击事件（双击事件为：rowDouble）
    table.on('rowDouble(product)', function (obj) {
        //将双击的行数据做参数 并带区分参数
        tableLoad(obj, "one");
        //渲染表格方法
        comchoosedTable(tableData);
    });

    //点击加入所有商品
    $('#join-product').on('click', function () {
        //product
        var checkStatus = table.checkStatus('product');
        //将复选框选中的行数据做参数 并带区分参数
        tableLoad(checkStatus, "more");
        //渲染表格方法
        comchoosedTable(tableData);
        table.reload('product', {})
    });

    /*3.右边列表*/
    function comchoosedTable(list) {
        console.log(list);
        table.render({
            elem: '#test-right'
            , data: list
            , height: 400
            , id: "tbCommodity"
            , totalRow: true //开启合计行
            , page: true
            , limit: 15
            , limits: [1, 15, 30, 45]
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'} //LAY_CHECKED:true默认单选框选中
                , {field: 'repProName', title: '商品名称', fixed: 'left', sort: true}
                , {templet: '<div>{{d.commodity.comUnit}}</div>', title: '单位'}
                , {templet: '<div>{{d.commodity.comProduct}}</div>', title: '规格'}
                , {field: 'duo1', title: '数量', edit: 'text', totalRow: true,templet: function(d){
                        if(d.duo1>d.reqCurrent){
                            return d.reqCurrent
                        }else{
                            return d.duo1
                        }
                    }}
                , {templet: '<div>{{d.commodity.comRegister}}</div>', title: '产品批号', sort: true}
                , {templet: '<div>{{d.commodity.comEndTime}}</div>', title: '有效期', sort: true}
                , {templet: '<div>{{d.commodity.comRemarks}}</div>', title: '备注', sort: true}
            ]], parseData: function (res, curr, count) { //res 即为原始返回的数据 //curr得到当前页码//count得到数据总量
                return {
                    "code": res.status, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.row //解析数据列表
                }
            }, done: function (obj) {
                layer.closeAll();
            }
            , toolbar: false
        });
        //监听表格复选框选择
        table.on('checkbox(tbCommodity)', function (obj) {

        });

        $('#delete').on('click', function () {
            var checkStatus = table.checkStatus('tbCommodity')
                ,data = checkStatus.data;
            //删除选中全局数组变量数据
            layui.use('layer',function () {
                layer.confirm('确认要删除吗？', {
                    btn : [ '确定', '取消' ]//按钮
                }, function(index) {
                    deleteChoosedCom(checkStatus)
                    table.reload('tbCommodity',{data : tableData});
                    layer.close(index);
                });
            })
        });

        //监听单元格编辑
        table.on('edit(test-right)', function (obj) {
            var value = obj.value //得到修改后的值
                , data = obj.data //得到所在行所有键值
                , field = obj.field; //得到字段
            //获得
        });
    }

    //删除方法
    function deleteChoosedCom(checkData) {
        for(var i = 0; i < checkData.data.length; i++){//循环选中每条的数据
            for(var y = 0; y < tableData.length; y++){//循环全局数组数据
                if(checkData.data[i].commodity.comId == tableData[y].commodity.comId){
                    tableData.splice(y,1);
                }
            }
        }
    }


    //确定按钮 将全局变量保存传至父弹窗
    $('#right').on('click', function () {
        window.parent.saledCom(tableData);
        //关闭当前弹窗
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    });
});
