<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>haoStudy</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="/static/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/static/layuiadmin/style/admin.css" media="all">

</head>
<body class="layui-layout-body">


<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <!-- 头部区域 -->
            <iframe src="/forall/jsp/adminpage_top.do" frameborder="0" class="layadmin-iframe"></iframe>
        </div>
        <!-- 侧边菜单 -->
        <div class="layui-side layui-side-menu">
            <div class="layui-side-scroll">
                <div class="layui-logo" lay-href="home/console.html">
                    <span>灏</span>
                </div>

                <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
                    <li data-name="component" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="java" lay-direction="2">
                            <i class="layui-icon layui-icon-read"></i>
                            <cite>java</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="console">
                                <a href="base/avabase.do">Java基础</a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="home/homepage1.html">oop</a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="home/homepage7.html">API</a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="home/homepage2.html">集合</a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="home/homepage3.html">线程</a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="home/homepage4.html">异常</a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="home/homepage5.html">网络</a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="home/homepage8.html">JDBC</a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="home/homepage6.html">流式编程</a>
                            </dd>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>
        </div>


        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show">
                <iframe src="home/console.html" frameborder="0" class="layadmin-iframe"></iframe>
            </div>
        </div>

        <!-- 辅助元素，一般用于移动设备下遮罩 -->
        <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
</div>

<script src="/static/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '/static/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use('index');
</script>
</body>
</html>




