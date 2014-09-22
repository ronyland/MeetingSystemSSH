<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" type="image/x-icon"
	href="${path}/images/favicon.ico" />
<title>员工管理</title>
<link href="${path}/common/bootstrap-3.2.0-dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="${path}/css/user.css" rel="stylesheet" type="text/css">
<link href="${path}/css/admin.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${path}/common/jquery.js"></script>
<!--jquery要放在最前边-->
<script type="text/javascript"
	src="${path}/common/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<!--bootstrap-datetimepicker.min.js不能和jquery-datetimepicker.js重复，会冲突-->
<script type="text/javascript"
	src="${path}/common/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${path}/common/jquery-dateFormat/jquery.dateFormat.js"></script>
<script type="text/javascript" src="${path}/js/admin.js"></script>
<script type="text/javascript"
	src="${path}/common/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${path}/common/jquery-ui.js"></script>
<link href="${path}/common/Font-Awesome-3.2.1/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="${path}/js/transition.js"></script>
<script type="text/javascript" src="${path}/js/modal.js"></script>

</head>

<body>

	<c:import url="navBar.jsp"></c:import>
	<c:import url="navLeft.jsp"></c:import>
	<div class="bodyright2">


		<div
			style="padding-left: 40px; font-size: 30px; font-weight: bold; height: 50px;">
			员工管理</div>
		<div style="border: 1px solid #ccc;"></div>
		<span id="triangle-topright"><a id="SeniorSearch"
			class="icon-search"></a> </span>

		<div id="Slide"
			<c:if test="${searching == false}">style="display: none;margin:6px 0 6px 0;"</c:if>>

			<input id="name" type="text" placeholder="名字" value="${name}" /> 
			<input id="username" type="text" placeholder="用户名" value="${username}" />
			<input id="department" type="text" placeholder="部门"
				value="${department}" /> <input id="phone" type="text"
				placeholder="电话" value="${phone}" /> <input id="email" type="text"
				placeholder="邮件" value="${email}" /> <a
				class="btn btn-small btn-info"
				onclick="employeeSearch('${path}',1,${pager.size})">查询</a>
		</div>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>员工号</th>
					<th>姓名</th>
					<th>部门</th>
					<th>密码</th>
					<th>用户名</th>
					<th>权限</th>
					<th>电话</th>
					<th>邮件</th>
					<!-- <th>用户审核</th> -->
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${totalCount>0}">
					<c:forEach items="${employees}" var="employee" varStatus="i">
						<tr>
							<td id="id_${i.count }" style="line-height: 30px;">${employee.id}</td>
							<td id="name_${i.count }" style="line-height: 30px;">${employee.name}</td>
							<td id="departmentname_${i.count }" style="line-height: 30px;">${employee.department.name}</td>
							<td id="password_${i.count }" style="line-height: 30px;">${employee.password}</td>
							<td id="username_${i.count }" style="line-height: 30px;">${employee.username}</td>
							<td id="role_${i.count }" style="line-height: 30px;">${employee.role.string}</td>
							<td id="phone_${i.count }" style="line-height: 30px;">${employee.phone}</td>
							<td id="email_${i.count }" style="line-height: 30px;">${employee.email}</td>

							<td><a class="btn btn-sm" data-toggle="modal"
								data-target="#alter"
								onclick="altId=${employee.id};alterEmployee(${i.count});">修改</a>
								<a class="btn btn-sm" data-toggle="modal" data-target="#del"
								onclick="delId=${employee.id};$('#msg').text('确定要删除编号为‘'+delId+'’的员工吗？')">删除</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${totalCount==0}">
					<tr align="center">
						<td height="50px">亲，没有数据哦</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<div>
			<a class="btn btn-primary" data-toggle="modal" data-target="#addOne"
				style="margin-left: 370px;">添加人员</a>
		</div>

	</div>

	<c:if test="${no-3<=0}">
		<div class="bottomspan">
			<ul class="pagination pull-right">
				<li><a onclick="employeeSearch('${path}',${no-1},${size})">
						&laquo;</a></li>
				<li><a onclick="employeeSearch('${path}',1,${size})"> 1</a></li>
				<li><a onclick="employeeSearch('${path}',2,${size})"> 2</a></li>
				<li><a onclick="employeeSearch('${path}',3,${size})"> 3</a></li>
				<li><a onclick="employeeSearch('${path}',4,${size})"> 4</a></li>
				<li><a onclick="employeeSearch('${path}',5,${size})"> 5</a></li>
				<li><a onclick="employeeSearch('${path}',${no+1},${size})">
						&raquo;</a></li>
			</ul>
		</div>
	</c:if>

	<c:if test="${no-3>0}">
		<div class="bottomspan">
			<ul class="pagination pull-right">
				<li><a onclick="employeeSearch('${path}',${no-1},${size})">
						&laquo;</a></li>
				<li><a onclick="employeeSearch('${path}',1,${size})"> 首页</a></li>
				<li><a onclick="employeeSearch('${path}',${no-2},${size})">
						${no-2}</a></li>
				<li><a onclick="employeeSearch('${path}',${no-1},${size})">
						${no-1}</a></li>
				<li><a onclick="employeeSearch('${path}',${no},${size})">
						${no}</a></li>
				<li><a onclick="employeeSearch('${path}',${no+1},${size})">
						${no+1}</a></li>
				<li><a onclick="employeeSearch('${path}',${no+2},${size})">
						${no+2}</a></li>
				<li><a onclick="employeeSearch('${path}',${no+1},${size})">
						&raquo;</a></li>
			</ul>
		</div>
	</c:if>

	<!-- Modal -->
	<div class="modal fade" id="alter" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改员工信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">姓名</label>
							<div class=" col-sm-6">
								<input type="text" class="form-control" id="alter_name"
									name="name" placeholder="姓名" style="width: 436px;" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">部门</label>
							<div class=" col-sm-6">
								<select class="form-control" id="alter_departmentId"
									name="departmentId" style="text-align: center;">
									<option value="">选择部门</option>
									<c:forEach items="${departments}" var="department">
										<option value="${department.id}">${department.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">密码</label>
							<div class=" col-sm-6">
								<input type="text" class="form-control" id="alter_password"
									name="password" placeholder="密码" style="width: 436px;" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">用户名</label>
							<div class=" col-sm-6">
								<input type="text" class="form-control" id="alter_username"
									name="username" placeholder="用户名" style="width: 436px;"
									value="">
							</div>
						</div>
						<!-- <div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">权限</label>
							<div class=" col-sm-6">
								<input type="text" class="form-control" id="alter_admin"
									placeholder="权限" style="width: 436px;">
							</div>
						</div> -->
						<div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">电话</label>
							<div class=" col-sm-6">
								<input type="text" class="form-control" id="alter_phone"
									name="phone" placeholder="电话" style="width: 436px;" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">邮件</label>
							<div class=" col-sm-6">
								<input type="text" class="form-control" id="alter_email"
									name="email" placeholder="邮件" style="width: 436px;" value="">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"
						onclick="updateEmployee('${path}',altId)">确认修改</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>

				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->

	<div class="modal fade" id="del">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">删除员工</h4>
				</div>
				<div class="modal-body">
					<p id="msg"></p>
				</div>
				<div class="modal-footer">
					<a class="btn btn-primary" onclick="delEmployee('${path}',delId);">确定</a>
					<a class="btn btn-default" data-dismiss="modal">取消</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>


	<!-- Modal -->
	<div class="modal fade" id="addOne" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加新员工</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">姓名</label>
							<div class=" col-sm-6">
								<input type="text" class="form-control" id="add_name"
									name="name" placeholder="姓名" style="width: 436px;">
							</div>
						</div>
						<div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">部门</label>
							<div class=" col-sm-6">
								<select class="form-control" name="departmentId"
									id="add_department" style="text-align: center;">
									<option value="">选择部门</option>
									<c:forEach items="${departments}" var="department">
										<option value="${department.id}">${department.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">密码</label>
							<div class=" col-sm-6">
								<input type="text" class="form-control" id="add_password"
									name="password" placeholder="密码" style="width: 436px;">
							</div>
						</div>
						<div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">用户名</label>
							<div class=" col-sm-6">
								<input type="text" class="form-control" id="add_username"
									name="username" placeholder="用户名" style="width: 436px;">
							</div>
						</div>
						<!-- <div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">权限</label>
							<div class=" col-sm-6">
								<input type="text" class="form-control" id="alter_admin"
									placeholder="权限" style="width: 436px;">
							</div>
						</div> -->
						<div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">电话</label>
							<div class=" col-sm-6">
								<input type="text" class="form-control" id="add_phone"
									name="phone" placeholder="电话" style="width: 436px;">
							</div>
						</div>
						<div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">邮件</label>
							<div class=" col-sm-6">
								<input type="text" class="form-control" id="add_email"
									name="email" placeholder="邮件" style="width: 436px;">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"
						onclick="addEmployee('${path}')">确认添加</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
