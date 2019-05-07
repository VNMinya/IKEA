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
	<%--<admin>基于Bean方式的控制:</admin>--%>
	<%--<br>没注册的用户，请<admin  href="${pageContext.request.contextPath }/register">注册</admin>！--%>
	<%--<br>已注册的用户，去<admin href="${pageContext.request.contextPath }/login">登录</admin>！--%>
	<%--<br>--%>
	<%--<admin>------------------</admin>--%>
	<%--<br><admin>基于注解方式的控制:</admin>--%>
	<%--<br>没注册的用户，请<admin href="${pageContext.request.contextPath }/index/register">注册</admin>！--%>
	<%--<br>已注册的用户，去<admin href="${pageContext.request.contextPath }/index/login">登录</admin>！--%>

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
	<link rel="stylesheet" href="/layui/css/layui.css"  media="all">
	<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>


<ul class="layui-nav">
	<li class="layui-nav-item layui-this"><a href="">最新活动</a></li>
	<li class="layui-nav-item">
		<a href="javascript:;">商品</a>
		<dl class="layui-nav-child">
			<dd><a href="">选项1</a></dd>
			<dd><a href="">选项2</a></dd>
			<dd><a href="">选项3</a></dd>
		</dl>
	</li>
	<li class="layui-nav-item"><a href="/jsp/before/login.jsp">登陆</a></li>
	<li class="layui-nav-item"><a href="/jsp/before/register.jsp">注册</a></li>
	<li class="layui-nav-item">
		<a href="javascript:;">解决方案</a>
		<dl class="layui-nav-child">
			<dd><a href="">移动模块</a></dd>
			<dd><a href="">后台模版</a></dd>
			<dd class="layui-this"><a href="">选中项</a></dd>
			<dd><a href="">电商平台</a></dd>
		</dl>
	</li>
	<li class="layui-nav-item">
		<a href="">个人中心<span class="layui-badge-dot"></span></a>
	</li>
	<li class="layui-nav-item" lay-unselect="">
		<a href="javascript:;"><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
		<dl class="layui-nav-child">
			<dd><a href="javascript:;">修改信息</a></dd>
			<dd><a href="javascript:;">安全管理</a></dd>
			<dd><a href="javascript:;">退了</a></dd>
		</dl>
	</li>
	<li class="layui-nav-item"><a href="">社区</a></li>
</ul>


<div class="layui-carousel" id="test10">
	<div carousel-item="">
		<div><img src="/images/index/1.jpg"></div>
		<div><img src="/images/index/2.jpg"></div>
		<div><img src="/images/index/3.jpg"></div>
		<div><img src="/images/index/4.jpg"></div>
	</div>
</div>


<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['carousel', 'form','element'], function(){
        var carousel = layui.carousel
            ,form = layui.form
			,element = layui.element;

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