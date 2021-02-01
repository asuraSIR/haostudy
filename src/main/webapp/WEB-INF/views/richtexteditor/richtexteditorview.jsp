<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>富文本编辑器</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/layuiadmin/layui/css/layui.css"  media="all">
</head>
<body>
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title">
        <li class="layui-this">ueditor</li>
        <li>用户管理</li>
        <li>权限分配</li>
        <li>商品管理</li>
        <li>订单管理</li>
    </ul>
    <div class="layui-tab-content" style="height: 100%;">
        <div class="layui-tab-item layui-show"><iframe scrolling="no" id="ueditor" name="ueditor" frameborder="0" src="ueditor.do" style="width:100%;height: 100%"></iframe></div>
        <div class="layui-tab-item">内容2</div>
        <div class="layui-tab-item">内容3</div>
        <div class="layui-tab-item">内容4</div>
        <div class="layui-tab-item">内容5</div>
    </div>
</div>
<script src="/static/layuiadmin/layui/layui.js" charset="utf-8"></script>
<script src="/static/layuiadmin/layui/lay/modules/jquery.js"></script>
<script>
    layui.use('element', function () {
        var $ = layui.jquery
            , element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
    });

/*
    // 计算页面的实际高度，iframe自适应会用到
    function calcPageHeight(doc) {
        var cHeight = Math.max(doc.body.clientHeight, doc.documentElement.clientHeight);
        var sHeight = Math.max(doc.body.scrollHeight, doc.documentElement.scrollHeight);
        var height = Math.max(cHeight, sHeight);
        return height;
    }


    function iframeInit(id) {
        //根据ID获取iframe对象
        var ifr = document.getElementById(id);
        ifr.onload = function () {
            //解决打开高度太高的页面后再打开高度较小页面滚动条不收缩
            ifr.style.height = '0px';
            var iDoc = ifr.contentDocument || ifr.document;
            var height = calcPageHeight(iDoc);
            if (height < 850) {
                height = 850;
            }
            ifr.style.height = height + 'px';
        };
    }


    $(function () {
        iframeInit('ueditor');
    });

 */
</script>
</body>
</html>
