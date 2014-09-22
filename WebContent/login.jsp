<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" href="images/favicon.ico" type="${path}/image/x-icon" />
<title>登录</title>

<link href="${path}/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${path}/common/jquery.js"></script>
<link href="${path}/common/bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${path}/common/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/login.js"></script>
</head>

<body onkeydown="if(event.keyCode==13){$('#login').click();}">
	<div class="container" style="vertical-align: middle;">
		<section class="loginBox row-fluid">
			<h2>欢迎登录会议管理系统</h2>

			<form action="${path}/login" method="post" id="form">
				<div class="form-group has-feedback">
					<input type="text" name="username" class="form-control" placeholder="请输入用户名" value="admin"> <span class="glyphicon glyphicon-user form-control-feedback itop"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" class="form-control" placeholder="请输入密码" value="123123" onkeydown="if(event.keyCode==13){$('#login').click();}"> <span class="glyphicon glyphicon-lock form-control-feedback itop" itop></span>
				</div>
				<div class="form-group">
					<a class="btn btn-info btn-large btn-block submit" id="login">登录</a>
				</div>
			</form>
		</section>
	</div>
</body>
</html>



