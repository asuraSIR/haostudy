<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="en-US">

<head>
    <meta charset="UTF-8">
    <title>ueditor demo</title>
</head>

<body>
<!-- 加载编辑器的容器 -->
<script id="container" name="content" type="text/plain">这里写你的初始化内容</script>
aaaaaaaaaaaaaaaaaaaaaa
<!-- 配置文件 -->
<script type="text/javascript" src="ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="ueditor.all.js"></script>
<!-- 实例化编辑器 -->
</body>
<script>
    var  heig = $(window).height()-375;
    editor = UE.getEditor('container', {
        autoHeightEnabled : false,
        initialFrameHeight : heig,
        initialFrameWidth:$(window).width()-60
    });
</script>

</html>



