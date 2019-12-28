$(function(){
    var threeOpen;
    var indexs;

            var seniorSeclct=null;
            //商品期限获取当前时间
    $(document).ready(function () {
        var time = new Date();
        var day = ("0" + time.getDate()).slice(-2);
        var month = ("0" + (time.getMonth() + 1)).slice(-2);
        var today = time.getFullYear() + "-" + (month) + "-" + (day);
        $('#test-startDate').val(today);
        $('#test-endDate').val(today);
    })
    $("#commoditytejia").change(function(){
        if($("#commoditytejia").prop("checked")==true){
            $("#commodityText").removeAttr("disabled");
            $("#test-startDate").removeAttr("disabled");
            $("#huiyuancheck").removeAttr("disabled");
        }else {
            $("#commodityText").attr("disabled",true);
            $("#test-startDate").attr("disabled",true);
            $("#huiyuancheck").attr("disabled",true);
        }
    })
    //隐藏上传文件区域
    $("#box02").dblclick(function(){
        $("#secondform").css({"display": " none"});
    })
            //点击回到全部类别按钮
            $("#iconbotton2").click(function(){
                seniorSeclct=null;
                $.ajax({
                    type: "POST",
                    url: "/systemsetup/searchCommodityParentType.action?seniorSeclct="+seniorSeclct,
                    success: function(msg){
                        var commodityTypeMap=JSON.stringify(msg);
                        layui.use('tree', function(){
                            var tree = layui.tree;
                            //渲染
                            var inst1 = tree.render({
                                elem: '#test1'  //绑定元素
                                ,type: "POST"
                                , data: msg,
                                click:function(obj){
                                    layui.use('table', function() {
                                        var table = layui.table //表格
                                        var comTypeId=obj.data.catId
                                        if(comTypeId==undefined){
                                            comTypeId=obj.data.id
                                        }
                                        // 执行一个 table 实例
                                        table.render({
                                            elem: '#demo'
                                            , height:  608
                                            , url: '/systemsetup/searchCommodityForType.action?comTypeId=' + comTypeId//数据接口
                                            , title: '商品表'
                                            , page: true //开启分页
                                            ,id: 'listReload'
                                            ,defaultToolbar: ['filter', 'print', 'exports', {
                                                title: '导入' //标题
                                                ,layEvent: 'upload' //事件名，用于 toolbar 事件中使用
                                                ,icon: 'layui-icon-upload-circle' //图标类名

                                            }]
                                            , toolbar: '#button' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
                                            , totalRow: true //开启合计行
                                            , cols: [[ //表头
                                                {type: 'checkbox', title:"ee"}
                                                , {field: 'comId', title: '商品编号', width: 90, sort: true}
                                                , {field: 'comName', title: '商品名称', width: 90}
                                                , {field: 'comSimpleCode', title: '简码', width: 90}
                                                , {templet:'<div>{{d.category.title}}</div>', title: '类别名称', width: 90}
                                                , {field: 'comGenericName', title: '通用名', width: 90}
                                                , {field: 'comBarCode', title: '生产日期', width: 60}
                                                , {field: 'comUnit', title: '单位', width: 60}
                                                , {field: 'comEpherine', title: '含有麻黄碱', width: 60,templet: function (row) {
                                                        var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                        if (row.comEpherine == 1) {
                                                            html += " checked ";
                                                        }
                                                        html += ">";
                                                        return html;
                                                    }}
                                                , {field: 'comElectonic', title: '电子监管', width: 165,templet: function (row) {
                                                        var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                        if (row.comElectonic == 1) {
                                                            html += " checked ";
                                                        }
                                                        html += ">";
                                                        return html;
                                                    }}
                                                , {field: 'comProduct', title: '产品规格', width: 165}
                                                , {field: 'comMedicame', title: '药剂类型', width: 165}
                                                , {field: 'comRegister', title: '注册证号', width: 165}
                                                , {field: 'comApproval', title: '批准文号', width: 165}
                                                , {field: 'comMinKuNumber', title: '最低库存', width: 165, totalRow: true}
                                                , {field: 'comState', title: '禁用',width: 165,templet: function (row) {
                                                        var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                        if (row.comState == 1) {
                                                            html += " checked ";
                                                        }
                                                        html += ">";
                                                        return html;
                                                    }}
                                                , {field: 'comElectonic', title: '电子监管', width: 165,templet: function (row) {
                                                        var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                        if (row.comElectonic == 1) {
                                                            html += " checked ";
                                                        }
                                                        html += ">";
                                                        return html;
                                                    }}
                                                , {field: 'comProduct', title: '产品规格', width: 165}
                                                , {field: 'comMedicame', title: '药剂类型', width: 165}
                                                , {field: 'comRegister', title: '注册证号', width: 165}
                                                , {field: 'comApproval', title: '批准文号', width: 165}
                                                , {field: 'comMinKuNumber', title: '最低库存', width: 165, totalRow: true}
                                                , {field: 'comState', title: '禁用',width: 165,templet: function (row) {
                                                        var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                        if (row.comState == 1) {
                                                            html += " checked ";
                                                        }
                                                        html += ">";
                                                        return html;
                                                    }}
                                                , {field: 'comQuality', title: '保质期',width: 165, sort: true}
                                                , {field: 'comSpecial', title: '特价商品',width: 165,templet: function (row) {
                                                        var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                        if (row.comState == 1) {
                                                            html += " checked ";
                                                        }
                                                        html += ">";
                                                        return html;
                                                    }}
                                                , {field: 'comPurchase', title: '预设进价', width: 165, sort: true}
                                                , {field: 'comPrice', title: '预设售价', width: 165, sort: true, totalRowText: '合计：'}
                                                , {templet:'<div>{{d.manufacturer.manName}}</div>', title: '生产厂商', width: 165}
                                                , {templet:'<div>{{d.supplier.supName}}</div>', title: '供货商', width: 165}
                                                , {field: 'comRemarks', title: '备注', width: 165}
                                            ]],parseData: function (res, curr, count) { //res 即为原始返回的数据 //curr得到当前页码//count得到数据总量
                                                return {
                                                    "code": res.status, //解析接口状态
                                                    "msg": res.msg, //解析提示文本
                                                    "count": res.count, //解析数据长度
                                                    "data": res.row //解析数据列表
                                                }
                                            },done: function (obj) {//复选框函数
                                                form.on('checkbox(checkboxIsSelected)', function (data) {
                                                    var _index = $(data.elem).attr('table-index') || 0;
                                                    if (data.elem.checked) {
                                                        obj.data[_index  ].comEpherine = data.value;
                                                    } else {
                                                        obj.data[_index].comEpherine = 2;
                                                    }
                                                    if (data.elem.checked) {
                                                        obj.data[_index].comElectonic = data.value;
                                                    } else {
                                                        obj.data[_index].comElectonic = 2;
                                                    }
                                                    if (data.elem.checked) {
                                                        obj.data[_index].comState = data.value;
                                                    } else {
                                                        obj.data[_index].comState = 2;}
                                                    if (data.elem.checked) {
                                                        obj.data[_index].comSpecial = data.value;
                                                    } else {
                                                        obj.data[_index].comSpecial = 2;
                                                    }
                                                });
                                                var supplierList = table.cache.js_table_reource_invite_supplier_index_table;
                                            }
                                        });
                                    })
                                }
                            });
                        });
                    }
                });
            })
            //点击搜索框
            $("#iconbotton").click(function(){
                seniorSeclct= $("#seniorSeclct").val();
                $.ajax({
                    type: "POST",
                    url: "/systemsetup/searchCommodityParentType.action?seniorSeclct="+seniorSeclct,
                    data:"json",
                    success: function(msg){
                        var commodityTypeMap=JSON.stringify(msg);
                        layui.use('tree', function(){
                            var tree = layui.tree;
                            //渲染
                            var inst1 = tree.render({
                                elem: '#test1'  //绑定元素
                                ,type: "POST"
                                ,method:"POST"
                                , data: msg,
                                click:function(obj){
                                    layui.use('table', function() {
                                        var table = layui.table //表格
                                        comTypeId=obj.data.id
                                        // 执行一个 table 实例
                                        table.render({
                                            elem: '#demo'
                                            , height:  450
                                            , url: '/systemsetup/searchCommodityForType.action?comTypeId=' +comTypeId  //数据接口
                                            , title: '商品表'
                                            , page: true //开启分页
                                            ,id: 'listReload'
                                            ,defaultToolbar: ['filter', 'print', 'exports', {
                                                title: '导入' //标题
                                                ,layEvent: 'upload' //事件名，用于 toolbar 事件中使用
                                                ,icon: 'layui-icon-upload-circle' //图标类名

                                            }]
                                            , toolbar: '#button' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
                                            , totalRow: true //开启合计行
                                            , cols: [[ //表头
                                                {type: 'checkbox', title:"ee"}
                                                , {field: 'comId', title: '商品编号', width: 90, sort: true}
                                                , {field: 'comName', title: '商品名称', width: 90}
                                                , {field: 'comSimpleCode', title: '简码', width: 90}
                                                , {templet:'<div>{{d.category.title}}</div>', title: '类别名称', width: 90}
                                                , {field: 'comGenericName', title: '通用名', width: 90}
                                                , {field: 'comBarCode', title: '生产日期', width: 60}
                                                , {field: 'comUnit', title: '单位', width: 60}
                                                , {field: 'comEpherine', title: '含有麻黄碱', width: 60,templet: function (row) {
                                                        var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                        if (row.comEpherine == 1) {
                                                            html += " checked ";
                                                        }
                                                        html += ">";
                                                        return html;
                                                    }}
                                                , {field: 'comElectonic', title: '电子监管', width: 165,templet: function (row) {
                                                        var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                        if (row.comElectonic == 1) {
                                                            html += " checked ";
                                                        }
                                                        html += ">";
                                                        return html;
                                                    }}
                                                , {field: 'comProduct', title: '产品规格', width: 165}
                                                , {field: 'comMedicame', title: '药剂类型', width: 165}
                                                , {field: 'comRegister', title: '注册证号', width: 165}
                                                , {field: 'comApproval', title: '批准文号', width: 165}
                                                , {field: 'comMinKuNumber', title: '最低库存', width: 165, totalRow: true}
                                                , {field: 'comState', title: '禁用',width: 165,templet: function (row) {
                                                        var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                        if (row.comState == 1) {
                                                            html += " checked ";
                                                        }
                                                        html += ">";
                                                        return html;
                                                    }}
                                                , {field: 'comElectonic', title: '电子监管', width: 165,templet: function (row) {
                                                        var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                        if (row.comElectonic == 1) {
                                                            html += " checked ";
                                                        }
                                                        html += ">";
                                                        return html;
                                                    }}
                                                , {field: 'comProduct', title: '产品规格', width: 165}
                                                , {field: 'comMedicame', title: '药剂类型', width: 165}
                                                , {field: 'comRegister', title: '注册证号', width: 165}
                                                , {field: 'comApproval', title: '批准文号', width: 165}
                                                , {field: 'comMinKuNumber', title: '最低库存', width: 165, totalRow: true}
                                                , {field: 'comState', title: '禁用',width: 165,templet: function (row) {
                                                        var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                        if (row.comState == 1) {
                                                            html += " checked ";
                                                        }
                                                        html += ">";
                                                        return html;
                                                    }}
                                                , {field: 'comQuality', title: '保质期',width: 165, sort: true}
                                                , {field: 'comSpecial', title: '特价商品',width: 165,templet: function (row) {
                                                        var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                        if (row.comState == 1) {
                                                            html += " checked ";
                                                        }
                                                        html += ">";
                                                        return html;
                                                    }}
                                                , {field: 'comPurchase', title: '预设进价', width: 165, sort: true}
                                                , {field: 'comPrice', title: '预设售价', width: 165, sort: true, totalRowText: '合计：'}
                                                , {templet:'<div>{{d.manufacturer.manName}}</div>', title: '生产厂商', width: 165}
                                                ,{templet:'<div>{{d.supplier.supName}}</div>', title: '供货商', width: 165}
                                                , {field: 'comRemarks', title: '备注', width: 165}
                                            ]],parseData: function (res, curr, count) { //res 即为原始返回的数据 //curr得到当前页码//count得到数据总量
                                                return {
                                                    "code": res.status, //解析接口状态
                                                    "msg": res.msg, //解析提示文本
                                                    "count": res.count, //解析数据长度
                                                    "data": res.row //解析数据列表
                                                }
                                            },done: function (obj) {//复选框函数
                                                form.on('checkbox(checkboxIsSelected)', function (data) {
                                                    var _index = $(data.elem).attr('table-index') || 0;
                                                    if (data.elem.checked) {
                                                        obj.data[_index].comEpherine = data.value;

                                                    } else {
                                                        obj.data[_index].comEpherine = 2;
                                                    }
                                                    if (data.elem.checked) {
                                                        obj.data[_index].comElectonic = data.value;
                                                    } else {
                                                        obj.data[_index].comElectonic = 2;
                                                    }
                                                    if (data.elem.checked) {
                                                        obj.data[_index].comState = data.value;
                                                    } else {
                                                        obj.data[_index].comState = 2;
                                                    }
                                                    if (data.elem.checked) {
                                                        obj.data[_index].comSpecial = data.value;
                                                    } else {
                                                        obj.data[_index].comSpecial = 2;
                                                    }
                                                });
                                                var supplierList = table.cache.js_table_reource_invite_supplier_index_table;
                                            }
                                        });
                                    })
                                }
                            });
                        });
                    }
                });
            })
            $.ajax({
                type: "POST",
                url: "/systemsetup/searchCommodityParentType.action?seniorSeclct="+seniorSeclct,
                success: function(msg){
                    var commodityTypeMap=JSON.stringify(msg);
                    //页面初始化时自动加载
                    layui.use('tree', function(){
                        var tree = layui.tree;
                        //渲染
                        var inst1 = tree.render({
                            elem: '#test1'  //绑定元素
                            , data: msg

                            , click:function(obj){
                                layui.use('table', function() {
                                    var table = layui.table //表格
                                    var comTypeIds=obj.data.catId
                                    if(comTypeIds==undefined){
                                        comTypeIds=obj.data.id
                                    }
                                    // 执行一个 table 实例
                                    table.render({
                                        elem: '#demo'
                                        , height:  608
                                        , url: '/systemsetup/searchCommodityForType.action?comTypeId=' + comTypeIds//数据接口
                                        , title: '商品表'
                                        , page: true //开启分页
                                        ,id: 'listReload'

                                        ,defaultToolbar: ['filter', 'print', 'exports', {
                                            title: '导入' //标题
                                            ,layEvent: 'upload' //事件名，用于 toolbar 事件中使用
                                            ,icon: 'layui-icon-upload-circle' //图标类名

                                        }]
                                        , toolbar: '#button' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
                                        , totalRow: true //开启合计行
                                        , cols: [[ //表头
                                            {type: 'checkbox', title:"ee"}
                                            , {field: 'comId', title: '商品编号', width: 90, sort: true}
                                            , {field: 'comName', title: '商品名称', width: 90}
                                            , {field: 'comSimpleCode', title: '简码', width: 90}
                                            , {templet:'<div>{{d.category.title}}</div>', title: '类别名称', width: 90}
                                            , {field: 'comGenericName', title: '通用名', width: 90}
                                            , {field: 'comQuality', title: '保质期', width: 90}
                                            , {field: 'comBarCode', title: '生产日期', width: 60}
                                            , {field: 'comUnit', title: '单位', width: 60}
                                            , {field: 'comEpherine', title: '含有麻黄碱', width: 60,templet: function (row) {
                                                    var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                    if (row.comEpherine == 1) {
                                                        html += " checked ";
                                                    }
                                                    html += ">";
                                                    return html;
                                                }}
                                            , {field: 'comElectonic', title: '电子监管', width: 165,templet: function (row) {
                                                    var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                    if (row.comElectonic == 1) {
                                                        html += " checked ";
                                                    }
                                                    html += ">";
                                                    return html;
                                                }}
                                            , {field: 'comProduct', title: '产品规格', width: 165}
                                            , {field: 'comMedicame', title: '药剂类型', width: 165}
                                            , {field: 'comRegister', title: '注册证号', width: 165}
                                            , {field: 'comApproval', title: '批准文号', width: 165}
                                            , {field: 'comMinKuNumber', title: '最低库存', width: 165, totalRow: true}
                                            , {field: 'comState', title: '禁用',width: 165,templet: function (row) {
                                                    var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                    if (row.comState == 1) {
                                                        html += " checked ";
                                                    }
                                                    html += ">";
                                                    return html;
                                                }}
                                            , {field: 'comElectonic', title: '电子监管', width: 165,templet: function (row) {
                                                    var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                    if (row.comElectonic == 1) {
                                                        html += " checked ";
                                                    }
                                                    html += ">";
                                                    return html;
                                                }}
                                            , {field: 'comProduct', title: '产品规格', width: 165}
                                            , {field: 'comMedicame', title: '药剂类型', width: 165}
                                            , {field: 'comRegister', title: '注册证号', width: 165}
                                            , {field: 'comApproval', title: '批准文号', width: 165}
                                            , {field: 'comMinKuNumber', title: '最低库存', width: 165, totalRow: true}
                                            , {field: 'comState', title: '禁用',width: 165,templet: function (row) {
                                                    var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                    if (row.comState == 1) {
                                                        html += " checked ";
                                                    }
                                                    html += ">";
                                                    return html;
                                                }}
                                            , {field: 'comQuality', title: '保质期',width: 165, sort: true}
                                            , {field: 'comSpecial', title: '特价商品',width: 165,templet: function (row) {
                                                    var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                                    if (row.comState == 1) {
                                                        html += " checked ";
                                                    }
                                                    html += ">";
                                                    return html;
                                                }}
                                            , {field: 'comPurchase', title: '预设进价', width: 165, sort: true}
                                            , {field: 'comPrice', title: '预设售价', width: 165, sort: true, totalRowText: '合计：'}
                                            , {templet:'<div>{{d.manufacturer.manName}}</div>', title: '生产厂商', width: 165}
                                            , {templet:'<div>{{d.supplier.supName}}</div>', title: '供货商', width: 165}
                                            , {field: 'comRemarks', title: '备注', width: 165}
                                        ]],parseData: function (res, curr, count) { //res 即为原始返回的数据 //curr得到当前页码//count得到数据总量
                                            return {
                                                "code": res.status, //解析接口状态
                                                "msg": res.msg, //解析提示文本
                                                "count": res.count, //解析数据长度
                                                "data": res.row //解析数据列表
                                            }
                                        },done: function (obj) {//复选框函数
                                            form.on('checkbox(checkboxIsSelected)', function (data) {
                                                var _index = $(data.elem).attr('table-index') || 0;
                                                if (data.elem.checked) {
                                                    obj.data[_index].comEpherine = data.value;
                                                } else {
                                                    obj.data[_index].comEpherine = 2;
                                                }
                                                if (data.elem.checked) {
                                                    obj.data[_index].comElectonic = data.value;
                                                } else {
                                                    obj.data[_index].comElectonic = 2;
                                                }
                                                if (data.elem.checked) {
                                                    obj.data[_index].comState = data.value;
                                                } else {
                                                    obj.data[_index].comState = 2;
                                                }
                                                if (data.elem.checked) {
                                                    obj.data[_index].comSpecial = data.value;
                                                } else {9
                                                    obj.data[_index].comSpecial = 2;
                                                }
                                            });
                                            var supplierList = table.cache.js_table_reource_invite_supplier_index_table;
                                        }
                                    });
                                })
                            }

                        });
                    });
                    layui.use('tree', function(){
                        var tree = layui.tree;
                        //渲染
                        var inst1 = tree.render({
                            elem: '#test2'  //绑定元素
                            , data: msg
                            ,id:''
                            ,
                            click: function(obj){
                                var cat=$('#catName');
                                cat.val(obj.data.title)
                                layer.close(threeOpen)
                            }
                        });

                    });
                }
            });
            layui.config({
                version: '1574408596514' //为了更新 js 缓存，可忽略
            });

            layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function() {
                var table = layui.table //表格
                    , element = layui.element //元素操作

                //监听Tab切换
                element.on('tab(demo)', function (data) {
                    layer.tips('切换了 ' + data.index + '：' + this.innerHTML, this, {
                        tips: 1
                    });
                });

                table.render({
                    elem: '#demo'
                    , height: 608
                    , url: '/systemsetup/searchCommodity.action' //数据接口
                    , title: '商品表'
                    , page: true //开启分页
                    ,id: 'listReload'
                    ,defaultToolbar: ['filter', 'print', 'exports', {
                        title: '导入' //标题
                        ,layEvent: 'upload' //事件名，用于 toolbar 事件中使用
                        ,icon: 'layui-icon-upload-circle' //图标类名

                    }]
                    , toolbar: '#button' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
                    , totalRow: true //开启合计行
                    , cols: [[ //表头
                        {type: 'checkbox', title:"ee"}
                        , {field: 'comId', title: '商品编号', width: 90, sort: true}
                        , {field: 'comName', title: '商品名称', width: 90}
                        , {field: 'comSimpleCode', title: '简码', width: 90}
                        , {templet:'<div>{{d.category.title}}</div>', title: '类别名称', width: 90}
                        , {field: 'comGenericName', title: '通用名', width: 90}
                        , {field: 'comQuality', title: '保质期', width: 90}
                        , {field: 'comBarCode', title: '生产日期', width: 60}
                        , {field: 'comUnit', title: '单位', width: 60}
                        , {field: 'comEpherine', title: '含有麻黄碱', width: 60,templet: function (row) {
                                var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                if (row.comEpherine == 1) {
                                    html += " checked ";
                                }
                                html += ">";
                                return html;
                            }}
                        , {field: 'comElectonic', title: '电子监管', width: 165,templet: function (row) {
                                var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                if (row.comElectonic == 1) {
                                    html += " checked ";
                                }
                                html += ">";
                                return html;
                            }}
                        , {field: 'comProduct', title: '产品规格', width: 165}
                        , {field: 'comMedicame', title: '药剂类型', width: 165}
                        , {field: 'comRegister', title: '注册证号', width: 165}
                        , {field: 'comApproval', title: '批准文号', width: 165}
                        , {field: 'comMinKuNumber', title: '最低库存', width: 165, totalRow: true}
                        , {field: 'comState', title: '禁用',width: 165,templet: function (row) {
                                var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                if (row.comState == 1) {
                                    html += " checked ";
                                }
                                html += ">";
                                return html;
                            }}
                        , {field: 'comQuality', title: '保质期',width: 165, sort: true}
                        , {field: 'comSpecial', title: '特价商品',width: 165,templet: function (row) {
                                var html = "<input type='checkbox' lay-skin='primary' lay-filter='checkboxIsSelected' table-index='" + row.LAY_TABLE_INDEX + "' class='checkboxIsSelected' value='1' ";
                                if (row.comState == 1) {
                                    html += " checked ";
                                }
                                html += ">";
                                return html;
                            }}
                        , {field: 'comPurchase', title: '预设进价', width: 165, sort: true}
                        , {field: 'comPrice', title: '预设售价', width: 165, sort: true, totalRowText: '合计：'}
                        , {templet:'<div>{{d.manufacturer.manName}}</div>', title: '生产厂商', width: 165}
                       , {templet:'<div>{{d.supplier.supName}}</div>', title: '供货商', width: 165}
                        , {field: 'comRemarks', title: '备注', width: 165}

                    ]],parseData: function (res, curr, count) { //res 即为原始返回的数据 //curr得到当前页码//count得到数据总量
                        return {
                            "code": res.status, //解析接口状态
                            "msg": res.msg, //解析提示文本
                            "count": res.count, //解析数据长度
                            "data": res.row //解析数据列表
                        }
                    },done: function (obj) {//复选框函数
                        form.on('checkbox(checkboxIsSelected)', function (data) {
                            var _index = $(data.elem).attr('table-index') || 0;
                            if (data.elem.checked) {
                                obj.data[_index].comEpherine = data.value;
                            } else {
                                obj.data[_index].comEpherine = 2;
                            }
                            if (data.elem.checked) {
                                obj.data[_index].comElectonic = data.value;
                            } else {
                                obj.data[_index].comElectonic = 2;
                            }
                            if (data.elem.checked) {
                                obj.data[_index].comState = data.value;
                            } else {
                                obj.data[_index].comState = 2;
                            }
                            if (data.elem.checked) {
                                obj.data[_index].comSpecial = data.value;
                            } else {
                                obj.data[_index].comSpecial = 2;
                            }
                        });
                        var supplierList = table.cache.js_table_reource_invite_supplier_index_table;
                    }
                });
                $(document).ready(function(){
                    $.ajax({
                        type:"POST",
                        url:'/systemsetup/selectUnit.action',  //从数据库查询返回的是个list
                        dataType: "json",
                        success: function (data) {

                            $.each(data,function(index,item){
                                $('#bg_id').append(new Option(item,item));//往下拉菜单里添加元素
                            })
                            form.render();//菜单渲染 把内容加载进去
                        }

                    })

                    $.ajax({
                        type:"POST",
                        url:'/systemsetup/getSupplier.action',  //从数据库查询返回的是个list
                        dataType: "json",
                        success: function (data) {
                            $.each(data,function(index,item){
                                $('#selectSupplier').append(new Option(item.supName,item.supID));//往下拉菜单里添加元素
                            })
                            form.render();//菜单渲染 把内容加载进去
                        }

                    })
                    $.ajax({
                        type:"POST",
                        url:'/systemsetup/selectManufacturer.action',  //从数据库查询返回的是个list
                        dataType: "json",
                        success: function (data) {
                            $.each(data,function(index,item){
                                $('#selectManufacturer').append(new Option(item.manName,item.manId));//往下拉菜单里添加元素
                            })
                            form.render();//菜单渲染 把内容加载进去
                        }

                    })



                });

                //监听头工具栏事件
                table.on('toolbar(test)', function (obj) {
                    var checkStatus = table.checkStatus(obj.config.id)
                        , data = checkStatus.data; //获取选中的数据

                    switch (obj.event) {
                        case 'add':
                            $.ajax({
                                type:"post",
                                url:"/systemsetup/returnCommodityId.action",
                                success:function (data) {
                                    var textId=$("#textId");//根据文本框的id找到这个文本框，并将其变成jquery对象
                                    textId.val(data);
                                }
                            })
                            //增加商品信息的第二层弹出框
                            indexs=layer.open({
                                type: 1,
                                zIndex:1,
                                title:'增加商品',
                                skin: 'demo-class',
                                closeBtn:2,

                                shade:0,
                                area: ['540px', '500px'],//宽高
                                shadeClose:true,//点击弹出框外部弹出框关闭
                                btn:null,//取消确定按钮
                                // maxmin: true,
                                content: $('#addtotton'),
                                end:function () {
                                    layer.close(threeOpen)
                                    $("#addtotton").css({ "display": "none" });
                                    $("#catName").val("");
                                    $("#comName").val("");
                                    $("#selectSupplier").val("SU0001");
                                    $("#comSimpleCode").val("");
                                    $("#comGenericName").val("");
                                    $("#bg_id").val("板");
                                    $("#comProduct").val("");
                                    $("#comPrice").val("");
                                    $("#comPurchase").val("");
                                    $("#comMinKuNumber").val("");
                                    $("#comQuality").val("");
                                    $("#comBarCode").val("");
                                    $("#comGenericNamee").val("");
                                    $("#comApproval").val("");
                                    $("#xishu").val("");
                                    $("#selectManufacturer").val("MF0001");
                                    $("#comRemarks").val("");
                                }
                            });
                            layui.use(['layer','form'],function() {
                                var form=layui.form;
                                var layer=layui.layer;
                                $=layui.jquery;
                                form.on('submit(suu)',function (data) {
                                    alert(JSON.stringify(data));
                                    $.ajax({
                                        url:"/systemsetup/insertCommodity.action",
                                        type:'post',
                                        data:data.field,
                                        dataType:'JSON',
                                        success: function (data) {
                                            if(data==1){
                                                window.alert("新增成功")
                                                layer.close(indexs)
                                                table.reload("listReload")
                                            }
                                        }
                                    })
                                })
                            })

                            break;
                        case 'update':
                            if (data.length === 0) {
                                layer.msg('请选择一行');
                            } else if (data.length > 1) {
                                layer.msg('只能同时编辑一个');
                            } else {
                                if(data[0].manufacturer.manId==null){
                                    data[0].manufacturer.manId='10001'
                                }
                                $("#catName").val(data[0].category.title);
                                $("#textId").val(data[0].comId)
                                $("#comName").val(data[0].comName);
                                 $("#selectSupplier").val(data[0].supplier.supID);
                                $("#comGenericName").val(data[0].comGenericName);
                                $("#comSimpleCode").val(data[0].comSimpleCode);
                                $("#bg_id").val(data[0].comUnit);
                                $("#comProduct").val(data[0].comProduct);
                                $("#comPrice").val(data[0].comPrice);
                                $("#comPurchase").val(data[0].comPurchase);
                                $("#comMinKuNumber").val(data[0].comMinKuNumber);
                                $("#comQuality").val(data[0].comQuality.substring(0, 10));
                                $("#comBarCode").val(data[0].comBarCode.substring(0, 10));
                                $("#comGenericNamee").val(data[0].comGenericName);
                                $("#comApproval").val(data[0].comApproval);
                                $("#selectManufacturer").val(data[0].manufacturer.manId);
                                $("#comRemarks").val(data[0].comRemarks);
                                var index = layer.open({
                                    type: 1,
                                    zIndex: 1,
                                    title: '编辑商品',
                                    skin: 'demo-class',
                                    closeBtn: 2,
                                    shade: 0,
                                    area: ['540px', '500px'],//宽高
                                    shadeClose: true,//点击弹出框外部弹出框关闭
                                    btn: null,//取消确定按钮
                                    // maxmin: true,
                                    content: $('#addtotton'),
                                    end: function () {
                                        $("#addtotton").css({"display": "none"});
                                        $("#catName").val("");
                                        $("#comName").val("");
                                        $("#selectSupplier").val("SU0001");
                                        $("#comSimpleCode").val("");
                                        $("#comGenericName").val("");
                                        $("#bg_id").val("板");
                                        $("#comProduct").val("");
                                        $("#comPrice").val("");
                                        $("#comPurchase").val("");
                                        $("#comMinKuNumber").val("");
                                        $("#comQuality").val("");
                                        $("#comBarCode").val("");
                                        $("#comGenericNamee").val("");
                                        $("#comApproval").val("");
                                        $("#xishu").val("");
                                        $("#selectManufacturer").val("MF0001");
                                        $("#comRemarks").val("");
                                    }
                                });

                                layui.use(['layer', 'form'], function () {
                                    var form = layui.form;
                                    var layer = layui.layer;
                                    $ = layui.jquery;
                                    form.on('submit(suu)', function (data) {
                                        alert(JSON.stringify(data));
                                        $.ajax({
                                            url: "/systemsetup/updateCommodity.action",
                                            type: 'post',
                                            data: data.field,
                                            dataType: 'JSON',
                                            success: function (data) {
                                                if (data == 1) {
                                                    window.alert("编辑成功")
                                                    layer.close(index)
                                                    table.reload("listReload")
                                                }
                                            }
                                        })
                                    })
                                })
                            }
                            break;
                        case 'delete':
                            if (data.length === 0) {
                                layer.msg('请选择一行');
                            } else {

                                var deleteNo="";
                                for(var i=0;data.length>i;i++) {
                                    var dataRowObj = checkStatus.data[i];
                                    var bookNostr = dataRowObj.comId;
                                    deleteNo += bookNostr + ",";
                                }
                                deleteNo=deleteNo.substring(0, deleteNo.length-1);//去掉多余的，

                                $.ajax({
                                    type:"post",
                                    url:"/systemsetup/deleteCommodity.action?comId="+deleteNo,
                                    success:function (data) {
                                        if(data>0){
                                            window.alert("删除成功")
                                            table.reload("listReload")
                                        }
                                    }
                                })
                            }
                            break;
                        case 'upload':
                            $("#secondform").css({"display": " inline-block"});

                            $("#secondsum").unbind('click').bind('click',function(){
                                var data=new FormData($("#secondform")[0]);
                                $.ajax({
                                    url:"/addController/batchimport.action",
                                    type:'post',
                                    data:data,
                                    processData: false,
                                    contentType: false,
                                    success: function (data1) {
                                        if(data1!=0){
                                            window.alert("导入成功")
                                            layui.use('table', function() {
                                                var table = layui.table //表格
                                                table.reload("listReload")
                                                $("#secondform").css({"display": " none"});
                                            })
                                        }else{
                                            window.alert("数据表格式错误")
                                        }
                                    }
                                })
                            })
                    };

                });

            })

            //监听行工具事件
            //点击添加里的搜索按钮的弹出框
            $('#icon-click').click(function () {
                //第三次弹出框
                threeOpen=layer.open({
                    type: 1,
                    offset:['155px','470px'],
                    title:null,
                    skin: 'demo-class',
                    closeBtn:0,
                    shade:0,
                    zIndex:2,
                    btn: ['确定', '取消'],
                    yes: function(index, layero){
                        //按钮【按钮一】的回调
                        layer.close(index); //如果设定了yes回调，需进行手工关闭
                    },btn2: function(index, layero){
                        //按钮【按钮二】的回调
                        //return false 开启该代码可禁止点击该按钮关闭
                    },
                    area: ['200px', '180px'],//宽高
                    content: $('#layopener2'),
                    end: function () {
                        $("#layopener2").css({"display": "none"});
                    }
                })
            })

                    });
