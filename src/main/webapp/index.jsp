<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--<html>--%>
<%--<head>--%>
<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
<%--<title>SpringMVC+Spring+Mybatis</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div  align="center">--%>
	<%--<a>基于Bean方式的控制:</a>--%>
	<%--<br>没注册的用户，请<a  href="${pageContext.request.contextPath }/register">注册</a>！--%>
	<%--<br>已注册的用户，去<a href="${pageContext.request.contextPath }/login">登录</a>！--%>
	<%--<br>--%>
	<%--<a>------------------</a>--%>
	<%--<br><a>基于注解方式的控制:</a>--%>
	<%--<br>没注册的用户，请<a href="${pageContext.request.contextPath }/index/register">注册</a>！--%>
	<%--<br>已注册的用户，去<a href="${pageContext.request.contextPath }/index/login">登录</a>！--%>

<%--</div>--%>
<%--</body>--%>
<%--</html>--%>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>首页</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="/css/layui/css/layui.css"  media="all">
	<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
	<legend>填充轮播元素 - 以图片为例</legend>
</fieldset>

<div class="layui-carousel" id="test10">
	<div carousel-item="">
		<div><img src="/images/index/1.jpg"></div>
		<div><img src="/images/index/2.jpg"></div>
		<div><img src="/images/index/3.jpg"></div>
		<div><img src="/images/index/4.jpg"></div>
	</div>
</div>


<script src="/css/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
            ,form = layui.form;

        //常规轮播
        carousel.render({
            elem: '#test1'
            ,arrow: 'always'
        });

        //改变下时间间隔、动画类型、高度
        carousel.render({
            elem: '#test2'
            ,interval: 1800
            ,anim: 'fade'
            ,height: '120px'
        });

        //设定各种参数
        var ins3 = carousel.render({
            elem: '#test3'
        });
        //图片轮播
        carousel.render({
            elem: '#test10'
            ,width: '1280px'
            ,height: '800px'
            ,interval: 5000
        });

        //事件
        carousel.on('change(test4)', function(res){
            console.log(res)
        });

        var $ = layui.$, active = {
            set: function(othis){
                var THIS = 'layui-bg-normal'
                    ,key = othis.data('key')
                    ,options = {};

                othis.css('background-color', '#5FB878').siblings().removeAttr('style');
                options[key] = othis.data('value');
                ins3.reload(options);
            }
        };

        //监听开关
        form.on('switch(autoplay)', function(){
            ins3.reload({
                autoplay: this.checked
            });
        });

        $('.demoSet').on('keyup', function(){
            var value = this.value
                ,options = {};
            if(!/^\d+$/.test(value)) return;

            options[this.name] = value;
            ins3.reload(options);
        });

        //其它示例
        $('.demoTest .layui-btn').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });
    });
</script>

</body>
</html>