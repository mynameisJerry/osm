<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

<title>登录</title>
<script type="text/javascript">
	$(function(){
		//1.验证用户名是否存在
		$("#username").change(function(){
			$.get("${pageContext.request.contextPath}/user/checkusername?username="+this.value+"&num="+Math.random(),function(data){
				if(data==0){
					$("#nameMsg").html("用户名不存在").css("color","red");
                    $("#btn").prop("disabled",true);
				}else{
					$("#nameMsg").html("");
                    $("#btn").removeAttr("disabled");
				}
			})
		});
		//2.点击验证码 更新验证码
		$("#pagecode").click(function(){
			$("#pagecode").prop("src","${pageContext.request.contextPath }/user/code?num="+Math.random());
		});

		//3.验证输入的验证码 是否正确
		<%--$("#vcode").change(function(){--%>
			<%--$.get("${pageContext.request.contextPath }/user/checkCode","code="+this.value+"&num="+Math.random(),function(data){--%>
				<%--//alert(data);--%>
				<%--if(data=="0"){--%>
					<%--$("#checkMsg").html("<font color='green'>OK</font>");--%>
					<%--$("#btn").removeAttr("disabled");--%>
				<%--}else{--%>
					<%--$("#checkMsg").html("<font color='red'>ERROR</font>");--%>
					<%--$("#pagecode").prop("src","${pageContext.request.contextPath }/user/code?num="+Math.random());--%>
					<%--$("#btn").prop("disabled",true);--%>
				<%--}--%>
			<%--})--%>
		<%--});--%>

		//4.两周以内自动登录  友好提示 
		$("#autoLogin").click(function(){
			if(this.checked){
				$("#autoLoginMsg").html("公司电脑请勿勾选此项").css("color","red");
			}else{
				$("#autoLoginMsg").html("");
			}
		});
		
		
		//5.form表单添加事件
		$("#userLogin").submit(function(){
			var result;
			$.ajax({
				url:"${pageContext.request.contextPath }/user/checkCode?code="+$("#vcode").val()+"&num="+Math.random(),
				type:"get",
				async:false,
				success:function(msg){
					result=msg;
				}
			});
			if(result=="0"){
				$("#checkMsg").html("<font color='green'>OK</font>");
				return true;
			}
			$("#checkMsg").html("<font color='red'>ERROR</font>");
			return false;

		});

	});

</script>
</head>
<body>
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="${pageContext.request.contextPath }/index.jsp" target="_blank"><img src="${pageContext.request.contextPath}/image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<form  method="post" action="${pageContext.request.contextPath}/user/login" class="form center" id="userLogin">
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">会员登录</div>
					<div class="right fr">您还不是我们的会员？<a href="${pageContext.request.contextPath }/register.jsp" target="_self">立即注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">
						<div class="left fl">用户名:&nbsp;</div>
						<div class="right fl">
						<input class="shurukuang" type="text" name="username" id="username"  placeholder="请输入你的用户名"/>
						<label id="nameMsg"></label>
						</div>
					</div>
					<div class="username">
						<div class="left fl">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;</div>
						<div class="right fl">
						<input class="shurukuang" type="password" name="password"  id="pwd"  placeholder="请输入你的密码"/>	
						</div>
					</div>
					<div class="username">
						<div class="left fl">验证码:&nbsp;</div>
						<div class="right fl"><input class="yanzhengma" id="vcode" name="vcode" type="text" placeholder="验证码"/>
						<img  id="pagecode" src="${pageContext.request.contextPath}/user/code"><label id="checkMsg"></label></div>
						<%--<img id="pagecode" src="" alt="点击更换验证码" /><a href="" rel="nofollow">看不清，换一张</a>--%>
					</div>
					<div class="username">
						<div class="left fl">&nbsp;&nbsp;&nbsp;&nbsp;</div>
						<div class="right fl"><label id="checkMsg"></label></div>
					</div>
					<div class="username">
						<input id="autoLogin" name="auto" type="checkbox" />&nbsp;&nbsp;两周以内自动登录
						<span id="autoLoginMsg"></span>
					</div>
					<div class="login_submit">
						<input class="submit" type="submit" name="submit" value="立即登录" id="btn" >
						<%--<button class="submit" id="btn" >立即登录</button>--%>
					</div>
					<span style="color:red">${msg}</span>
				</div>	
			</div>
		</div>
		</form>
		<footer>
			<div class="copyright">简体 | 繁体 | English | 常见问题</div>
			<div class="copyright">攀枝花学院-数学与计算机学院-15级软件工程三班-陈建宇-201510804097</div>

		</footer>
	</body>
</html>