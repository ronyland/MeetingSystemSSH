<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" href="${path}/images/favicon.ico" type="image/x-icon" />
<title>注册</title>
<link href="${path}/css/register.css" rel="stylesheet" type="text/css">
<link href="${path}/common/bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${path}/common/jquery.js"></script>
<script type="text/javascript" src="${path}/common/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${path}/js/register.js"></script>
</head>

<body>
	<div class="container">
		<section class="loginBox row-fluid">
			<h2>注册账号</h2>
			<form action="register" method="post" id="form">
				<div class="form-group input-group has-feedback">
					<span class="input-group-addon">员工姓名</span> <input type="text" id="name" name="name" class="form-control"> <span class="glyphicon glyphicon-user form-control-feedback itop"></span>
				</div>
				<div class="form-group input-group has-feedback">
					<span class="input-group-addon">用&nbsp;户&nbsp;名</span> <input type="text" id="username" name="username" class="form-control"> <span class="glyphicon glyphicon-user form-control-feedback itop"></span>
				</div>
				<div class="form-group input-group has-feedback">
					<span class="input-group-addon"> &nbsp;密&nbsp;&nbsp;码&nbsp;</span> <input type="password" id="password" name="password" class="form-control" /> <span class="glyphicon glyphicon-lock form-control-feedback itop"></span>
				</div>
				<div class="form-group input-group has-feedback">
					<span class="input-group-addon">确认密码</span> <input type="password" name="password2" id="password2" class="form-control" /> <span class="glyphicon glyphicon-lock form-control-feedback itop"></span>
				</div>
				<div class="form-group input-group">
					<span class="input-group-addon"> &nbsp;部&nbsp;&nbsp;门&nbsp;</span> <select id="department" name="department" class="form-control">
						<c:forEach items="${departments}" var="department">
							<option value="${department.id}">${department.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group input-group has-feedback">
					<span class="input-group-addon">&nbsp;电&nbsp;&nbsp;话&nbsp;</span> <input type="text" id="phone" name="phone" class="form-control" /> <span class="glyphicon glyphicon-phone-alt form-control-feedback itop"></span>
				</div>
				<div class="form-group input-group has-feedback">
					<span class="input-group-addon">&nbsp;邮&nbsp;&nbsp;件&nbsp;</span> <input type="text" id="email" name="email" class="form-control" /> <span class="glyphicon glyphicon-envelope form-control-feedback itop"></span>
				</div>

				<div class="line3">
					<a class="btn btn-info btn-large btn-block" id="register" onclick="register('${path}');">注册</a>
				</div>
				<div class="line4">
					<span class="line43"> <a href="${path}/login">已有账号，现在就登录</a>
					</span>
				</div>
			</form>

			<div class="alert alert-danger" role="alert" <c:if test="${empty info}">style="display: none;"</c:if>>${info}</div>
		</section>
	</div>
</body>
</html>
