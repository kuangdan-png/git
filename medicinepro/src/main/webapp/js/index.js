//动态日期
function getDate() {
    var today = new Date();
    var date = today.getFullYear() + "年" + twoDigits(today.getMonth() + 1) + "月" + twoDigits(today.getDate()) + "日";
    var week = " 星期" + "日一二三四五六 ".charAt(today.getDay());
    var time = twoDigits(today.getHours()) + ":" + twoDigits(today.getMinutes()) + ":" + twoDigits(today.getSeconds());
    $("#font_3").html(date + " " + time+week);
}

function twoDigits(val) {
    if (val < 10) return "0" + val;
    return val;
}
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function () {
    var element = layui.element;

    //引入底层的jqurey
    var $ = layui.jquery;


    //按照指定的周期(以毫秒计)来调用函数
    setInterval(getDate, 1000);

    //获得名字：建议获得全部信息
    $.post("/userManager/searchLoginName.action", function(data){
        $('#loginName').text(data);
    });

    $(function () {
        //获得菜单
        $.ajax({
            type: "GET",
            url: "/userManager/excuteSearchMunu.action",
            dataType: "json",
            success: function (data) {
                //声明变量 listInfo 存储循环的数据
                var listInfo = "";
                // var dataObj=$.parseJSON(data);
                var c=0;
                //循环编写需要的html语句
                for(var key in data){
                    c++;
                    if(c==1){
                        listInfo += "<li class='layui-nav-item layui-nav-itemed'>" +
                            "<a href='javascript:;' ><i class=\"layui-icon layui-icon-set-sm\"></i> " + key + "</a>" +
                            "  <dl class=\"layui-nav-child\"> ";
                    }else if(c==2) {
                        listInfo += "<li class='layui-nav-item'>" +
                            "<a href='javascript:;' ><i class=\"layui-icon layui-icon-top\"></i> " + key + "</a>" +
                            "  <dl class=\"layui-nav-child\"> ";
                    }else if(c==3){
                        listInfo += "<li class='layui-nav-item'>" +
                            "<a href='javascript:;' ><i class=\"layui-icon layui-icon-templeate-1\"></i> " + key + "</a>" +
                            "  <dl class=\"layui-nav-child\"> ";
                    }else{
                        listInfo += "<li class='layui-nav-item'>" +
                            "<a href='javascript:;' ><i class=\"layui-icon layui-icon-form\"></i> " + key + "</a>" +
                            "  <dl class=\"layui-nav-child\"> ";
                    }


                    //根据键获得值
                    var value=data[key];
                    for(var i=0;i<value.length; i++){
                        if(c==1&&i==0){
                            listInfo+=
                                "<dd class=\"layui-this\"><a href=\"javascript:;\" id='"+value[i].autUrl+"'><i class=\"layui-icon "+value[i].autButton+"\"></i>"+value[i].autName+"</a></dd>"
                        }else{
                            listInfo+=
                                "<dd ><a href=\"javascript:;\" id='"+value[i].autUrl+"'><i class=\"layui-icon "+value[i].autButton+"\"></i>"+value[i].autName+"</a></dd>"
                        }

                    }
                    listInfo +="</dl></li>"
                }
                //为menu赋值

                $("#menu").html(listInfo);
                element.render('nav');
                // 悬浮在一级菜单上时，显示二级菜单
                var b=$('.layui-this a').attr("id");
                $('#qian').attr({ src: b});
                // //为menu中的所有a标记添加点击事件
                $('#menu dd a').click(function () {
                    var no = $(this).attr("id");
                    $('#qian').attr({ src: no});
            });
            }
        });
    });
});