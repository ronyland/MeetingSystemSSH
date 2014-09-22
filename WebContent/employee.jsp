<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
<title>个人信息</title>
<link href="${path}/common/bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${path}/css/user.css" rel="stylesheet" type="text/css">
<link href="${path}/css/subscribe.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${path}/common/jquery.js"></script>
<!--jquery要放在最前边-->
<script type="text/javascript" src="${path}/common/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<!--bootstrap-datetimepicker.min.js不能和jquery-datetimepicker.js重复，会冲突-->
<script type="text/javascript" src="${path}/common/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/common/jquery-dateFormat/jquery.dateFormat.js"></script>
<script type="text/javascript" src="${path}/js/employee.js"></script>
<script type="text/javascript" src="${path}/common/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${path}/common/jquery-ui.js"></script>

</head>

<body>

	<c:import url="navBar.jsp"></c:import>
	<c:import url="navLeft2.jsp"></c:import>

	<div class="bodyright">
		<div style="padding-left: 40px; font-size: 30px; font-weight: bold; margin-bottom: 10px;">个人信息 (不填写则不修改)</div>
		<div class="spliter"></div>
		
		<div style="margin-top: 10px;">
			<form class="form-horizontal" role="form" id="form" method="POST">
				<div class="form-group">
					<label for="username" class="col-sm-2 control-label">姓名</label>
					<div class=" col-sm-6">
						<input class="form-control" name="name" placeholder="用户名" value="${user.name}">
					</div>
				</div>
				<div class="form-group">
					<label for="newpassword" class="col-sm-2 control-label">新密码</label>
					<div class=" col-sm-6">
						<input class="form-control" name="pwd1" placeholder="新密码">
					</div>
				</div>
				<div class="form-group">
					<label for="verifypass" class="col-sm-2 control-label">确认密码</label>
					<div class=" col-sm-6">
						<input class="form-control" name="pwd2" placeholder="确认密码">
					</div>
				</div>
				<div class="form-group">
					<label for="phone" class="col-sm-2 control-label">电话</label>
					<div class=" col-sm-6">
						<input class="form-control" name="email" placeholder="电话" value="${user.phone}">
					</div>
				</div>
				<div class="form-group">
					<label for="mail" class="col-sm-2 control-label">电子邮件</label>
					<div class=" col-sm-6">
						<input class="form-control" name="email" placeholder="电子邮件" value="${user.email}">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<a class="btn btn-success" id="submit">确认修改</a>
					</div>
				</div>
			</form>
		</div>
		<div class="alert alert-danger" role="alert" <c:if test="${empty info}">style="display: none;"</c:if>>${info}</div>
		<div class="alert alert-success" role="alert" <c:if test="${empty success}">style="display: none;"</c:if>>${success}</div>
	</div>


</body>
</html>
