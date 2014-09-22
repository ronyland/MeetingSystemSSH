<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" type="image/x-icon" href="${path}/images/favicon.ico" />
<title>审核失败</title>
<link href="${path}/common/bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${path}/css/user.css" rel="stylesheet" type="text/css">
<link href="${path}/css/subscribe.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${path}/common/jquery.js"></script>
<!--jquery要放在最前边-->
<script type="text/javascript" src="${path}/common/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<!--bootstrap-datetimepicker.min.js不能和jquery-datetimepicker.js重复，会冲突-->
<script type="text/javascript" src="${path}/common/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/common/jquery-dateFormat/jquery.dateFormat.js"></script>
<script type="text/javascript" src="${path}/js/subscribe.js"></script>
<script type="text/javascript" src="${path}/common/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${path}/common/jquery-ui.js"></script>


<link href="${path}/common/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">
<link href="${path}/common/Font-Awesome-3.2.1/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${path}/common/jquery-ui.css" rel="stylesheet" type="text/css">
</head>

<body>

	<c:import url="navBar.jsp"></c:import>

	<div class="bodyright">
		<div style="padding-left: 40px; font-size: 30px; font-weight: bold; color: #F00;">审核未通过，请重新修改信息</div>
		<div class="spliter"></div>
		
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">用户名</label>
				<div class=" col-sm-6">
					<input type="text" class="form-control" id="username" placeholder="用户名">
				</div>
			</div>
			<div class="form-group">
				<label for="newpassword" class="col-sm-2 control-label">新密码</label>
				<div class=" col-sm-6">
					<input type="text" class="form-control" id="newpassword" placeholder="新密码">
				</div>
			</div>
			<div class="form-group">
				<label for="verifypass" class="col-sm-2 control-label">确认密码</label>
				<div class=" col-sm-6">
					<input type="text" class="form-control" id="verifypass" placeholder="确认密码">
				</div>
			</div>
			<div class="form-group">
				<label for="phone" class="col-sm-2 control-label">电话</label>
				<div class=" col-sm-6">
					<input type="text" class="form-control" id="phone" placeholder="电话">
				</div>
			</div>
			<div class="form-group">
				<label for="mail" class="col-sm-2 control-label">电子邮件</label>
				<div class=" col-sm-6">
					<input type="text" class="form-control" id="mail" placeholder="电子邮件">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<a type="submit" class="btn btn-success">确认修改</a> <a type="cancel" class="btn btn-default">取消</a>
				</div>
			</div>
		</form>

	</div>

</body>
</html>
