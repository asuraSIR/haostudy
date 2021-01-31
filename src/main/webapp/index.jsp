<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>haoStudy</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="static/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="static/layuiadmin/style/admin.css" media="all">

    <script>
        /^http(s*):\/\//.test(location.href) || alert('请先部署到 localhost 下再访问');
    </script>
</head>
<body class="layui-layout-body">

<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <!-- 头部区域 -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item layadmin-flexible" lay-unselect>
                    <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                    </a>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">

                <li class="layui-nav-item" lay-unselect>
                    <a lay-href="app/message/index.html" layadmin-event="message" lay-text="消息中心" title="消息中心">
                        <i class="layui-icon layui-icon-notice"></i>

                        <!-- 如果有新消息，则显示小圆点 -->
                        <span class="layui-badge-dot"></span>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="theme">
                        <i class="layui-icon layui-icon-theme"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="note">
                        <i class="layui-icon layui-icon-note"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="fullscreen" title="全屏模式">
                        <i class="layui-icon layui-icon-screen-full"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;">
                        <cite>贤心</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a lay-href="set/user/info.html">基本资料</a></dd>
                        <dd><a lay-href="set/user/password.html">修改密码</a></dd>
                        <hr>
                        <dd layadmin-event="logout" style="text-align: center;"><a>退出</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="about"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
                <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
                    <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
            </ul>
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
                            <dd data-name="console" class="layui-this">
                                <a href="javascript:;">控制语句</a>
                                <dl class="layui-nav-child">
                                    <dd data-name="list"><a lay-href="component/grid/list.html">等比例列表排列</a></dd>
                                    <dd data-name="mobile"><a lay-href="component/grid/mobile.html">按移动端排列</a></dd>
                                    <dd data-name="mobile-pc"><a lay-href="component/grid/mobile-pc.html">移动桌面端组合</a></dd>
                                    <dd data-name="all"><a lay-href="component/grid/all.html">全端复杂组合</a></dd>
                                    <dd data-name="stack"><a lay-href="component/grid/stack.html">低于桌面堆叠排列</a></dd>
                                    <dd data-name="speed-dial"><a lay-href="component/grid/speed-dial.html">九宫格</a></dd>
                                </dl>
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
                    <li data-name="component" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="web" lay-direction="2">
                            <i class="layui-icon layui-icon-website"></i>
                            <cite>web</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="grid">
                                <a lay-href="component/button/index.html">HTML</a>
                            </dd>
                            <dd data-name="button">
                                <a lay-href="component/button/index.html">CSS</a>
                            </dd>
                            <dd data-name="grid">
                                <a lay-href="component/button/index.html">js</a>
                            </dd>
                            <dd data-name="nav">
                                <a lay-href="component/nav/index.html">Jquery</a>
                            </dd>
                            <dd data-name="tabs">
                                <a lay-href="component/tabs/index.html">Servlet</a>
                            </dd>
                            <dd data-name="progress">
                                <a lay-href="component/progress/index.html">JSP</a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="template" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="框架" lay-direction="2">
                            <i class="layui-icon layui-icon-template-1"></i>
                            <cite>框架</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a lay-href="template/personalpage.html">Mybatis</a></dd>
                            <dd><a lay-href="template/msgboard.html">Hibernate</a></dd>
                            <dd><a lay-href="template/addresslist.html">Spring</a></dd>
                            <dd><a lay-href="template/goodslist.html">Spring MVC</a></dd>
                            <dd><a lay-href="template/search.html">Spring boot</a></dd>
                        </dl>
                    </li>
                    <li data-name="app" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="工具" lay-direction="2">
                            <i class="layui-icon layui-icon-util"></i>
                            <cite>工具</cite>
                        </a>
                        <dl class="layui-nav-child">

                            <dd>
                                <a lay-href="app/message/index.html">idea</a>
                            </dd>
                            <dd data-name="workorder">
                                <a lay-href="app/workorder/list.html">数据库</a>
                            </dd>
                            <dd data-name="content">
                            <a lay-href="template/search.html">Tomcat</a></dd>
                            <dd data-name="workorder">
                                <a lay-href="app/workorder/list.html">Maven</a>
                            </dd>
                            <dd data-name="workorder">
                                <a lay-href="app/workorder/list.html">SVN</a>
                            </dd>
                            <dd data-name="workorder">
                                <a lay-href="app/workorder/list.html">Git</a>
                            </dd>
                            <dd data-name="workorder">
                                <a lay-href="app/workorder/list.html">Git</a>
                            </dd>
                            <dd data-name="workorder">
                                <a lay-href="app/workorder/list.html">nginx</a>
                            </dd>


                        </dl>
                    </li>
                    <li data-name="senior" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="应用" lay-direction="2">
                            <i class="layui-icon layui-icon-app"></i>
                            <cite>应用</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="richTextEditor">
                                <a lay-href="richtexteditor/jsp/richtexteditorview.do">富文本编辑器</a>
                            </dd>
                            <dd data-name="echarts">
                                <a lay-href="richtexteditor/jsp/ueditor.do">excel上传下载</a>
                            </dd>
                            <dd data-name="echarts">
                                <a layadmin-event="im">图片上传下载</a>
                            </dd>
                            <dd data-name="echarts">
                                <a layadmin-event="im">流程图</a>
                            </dd>
                            <dd data-name="echarts">
                                <a layadmin-event="im">分页</a>
                            </dd>
                            <dd data-name="echarts">
                                <a layadmin-event="im">统计图</a>
                            </dd>

                        </dl>
                    </li>
                    <li data-name="senior" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="前端模板" lay-direction="2">
                            <i class="layui-icon layui-icon-templeate-1"></i>
                            <cite>前端模板</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="AdminLTETemplate">
                                <a href="/uitemplate/AdminLTE/index2.html" target="_blank">AdminLTE</a>
                            </dd>
                            <dd data-name="layuiAdminTemplate">
                                <a href="/uitemplate/layuiAdmin/views/index.html" target="_blank">LayuiAdmin</a>
                            </dd>
                            <dd data-name="ueditorTemplate">
                                <a href="/uitemplate/ueditor/index.html" target="_blank">ueditor</a>
                            </dd>

                        </dl>
                    </li>

                </ul>
            </div>
        </div>

        <!-- 页面标签 -->
        <div class="layadmin-pagetabs" id="LAY_app_tabs">
            <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-down">
                <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;"></a>
                        <dl class="layui-nav-child layui-anim-fadein">
                            <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                            <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                            <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                    <li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
                </ul>
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

<script src="static/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: 'static/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use('index');
</script>
</body>
</html>




