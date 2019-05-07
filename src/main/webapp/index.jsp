<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login2.css">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<title>小米商城首页</title>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="header.jsp"%>
<!--网站中间内容开始  banner2.jpg-->
<div id="thred">
      <img src="${pageContext.request.contextPath}/image/dianshi1.jpg" width="1230" height="460" />
</div>
   <div id="forth">
   		<span>
        	<a href=""><img src="${pageContext.request.contextPath}/image/hjh_01.gif" /></a>
            <a href=""><img src="${pageContext.request.contextPath}/image/hjh_02.gif" /></a>
            <a href=""><img src="${pageContext.request.contextPath}/image/hjh_03.gif" /></a>
            <a href=""><img src="${pageContext.request.contextPath}/image/hjh_04.gif" /></a>
            <a href=""><img src="${pageContext.request.contextPath}/image/hjh_05.gif" /></a>
            <a href=""><img src="${pageContext.request.contextPath}/image/hjh_06.gif" /></a>
        </span>
        <a href="" id="a_left"><img src="${pageContext.request.contextPath}/image/first_image.jpg" width="316" height="170" /></a>
        <a href="" id="a_left"><img src="${pageContext.request.contextPath}/image/sec_image.jpg" width="316" height="170" /></a>
    	<a href="" id="a_left"><img src="${pageContext.request.contextPath}/image/third_image.jpg" width="316" height="170" /></a>
   </div>
   <div id="fifth">
   		<span id="fif_text">小米明星单品</span>
   </div>
    <div id="sixth">
            <span style="margin-left:0px; border-top:#ffa500 1px solid">
            	<a href="" id="siximg"><img src="${pageContext.request.contextPath}/image/shouji1.jpg" width="234" height="240" /></a>
            	<a href="" id="na">小米9 6GB+128GB</a>
                <p id="chip">骁龙855，索尼4800万超广角微距三摄</p>
                <p id="pri">2999元起</p>
            </span>
            <span style=" border-top:#008000 1px solid">
            	<a href="" id="siximg"><img src="${pageContext.request.contextPath}/image/shouji2.jpg" width="234" height="240" /></a>
                <a href="" id="na">Redmi Note7 3GB+32G</a>
                <p id="chip">4800万拍照千元机，18个月超长质保</p>
                <p id="pri">999元起</p>
            </span>
            <span style="border-top:#0000ff 1px solid">
            	<a href="" id="siximg"><img src="${pageContext.request.contextPath}/image/shouji3.png" width="234" height="240" /></a>
                <a href="" id="na">小米Play 4GB+64GB</a>
                <p id="chip">5.84"小水滴全面屏，后置1200万...</p>
                <p id="pri">1099元起</p>
            </span>
            <span style="border-top:#ff0000 1px solid">
            	<a href="" id="siximg"><img src="${pageContext.request.contextPath}/image/xiyiji1.jpg" width="234" height="240" /></a>
                <a href="" id="na">米家互联网洗烘一体机</a>
                <p id="chip">5月9日-21日享花呗12期分期免息</p>
                <p id="pri">2199元起</p>
            </span>
            <span style="border-top:#008080 1px solid">
            	<a href="" id="siximg"><img src="${pageContext.request.contextPath}/image/computer1.png" width="234" height="240" /></a>
                <a href="" id="na">15.6''小米笔记本</a>
                <p id="chip">5月9日-21日享花呗12期分期免息</p>
                <p id="pri">4199元起</p>
            </span>
    </div>
   <!-- 底部 -->
   <%@ include file="footer.jsp"%>
   
  
</body>
</html>