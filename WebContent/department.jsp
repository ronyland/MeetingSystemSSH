<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" type="image/x-icon" href="${path}/images/favicon.ico" />
<title>部门管理</title>
<link href="${path}/common/bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${path}/css/user.css" rel="stylesheet" type="text/css">
<link href="${path}/css/department.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${path}/common/jquery.js"></script>
<!--jquery要放在最前边-->
<script type="text/javascript" src="${path}/common/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<!--bootstrap-datetimepicker.min.js不能和jquery-datetimepicker.js重复，会冲突-->
<script type="text/javascript" src="${path}/common/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/common/jquery-dateFormat/jquery.dateFormat.js"></script>
<script type="text/javascript" src="${path}/common/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${path}/common/jquery-ui.js"></script>
<script type="text/javascript" src="${path}/js/department.js"></script>


<link href="${path}/common/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">
<link href="${path}/common/Font-Awesome-3.2.1/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${path}/common/jquery-ui.css" rel="stylesheet" type="text/css">
</head>

<body>

	<c:import url="navBar.jsp"></c:import>
	<c:import url="navLeft.jsp"></c:import>
	<div class="bodyright3">


		<div style="padding-left: 40px; font-size: 30px; font-weight: bold; height: 50px;">部门管理</div>
		<span id="triangle-topright"><a id="SeniorSearch" class="icon-search"></a></span>
		<div style="border: 1px solid #ccc;"></div>
		<div id="Slide" <c:if test="${searching == false}">style="display: none;margin:6px 0 6px 0;"</c:if>>
			<input id="name" type="text" placeholder="名称" value="${name}" /> <a class="btn btn-small btn-info" onclick="departmentSearch('${path}',1,${pager.size})">查询</a>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>部门名称</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${totalCount>0}">
					<c:forEach items="${departments}" var="department" varStatus="i">
						<tr>
							<td id="name_${i.count }" style="line-height: 30px;">${department.name }</td>
							<td><a class="btn btn-sm" data-toggle="modal" data-target="#alter" onclick="altId=${department.id};alterDepartment(${i.count});">修改</a> 
							<a class="btn btn-sm" data-toggle="modal" data-target="#del" onclick="delId=${department.id};$('#msg').text('确定要删除编号为‘'+delId+'’的部门吗？')">删除</a></td>
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
			<a class="btn btn-primary" data-toggle="modal" data-target="#addOne" style="margin-left: 300px;">添加部门</a>
		</div>
	</div>

	<c:if test="${no-3<=0 }">
		<div class="bottomspan">
			<ul class="pagination pull-right">
				<li><a onclick="departmentSearch('${path}',${no-1},${size})"> &laquo;</a></li>
				<li><a onclick="departmentSearch('${path}',1,${size})"> 1</a></li>
				<li><a onclick="departmentSearch('${path}',2,${size})"> 2</a></li>
				<li><a onclick="departmentSearch('${path}',3,${size})"> 3</a></li>
				<li><a onclick="departmentSearch('${path}',4,${size})"> 4</a></li>
				<li><a onclick="departmentSearch('${path}',5,${size})"> 5</a></li>
				<li><a onclick="departmentSearch('${path}',${no+1},${size})"> &raquo;</a></li>
			</ul>
		</div>
	</c:if>

	<c:if test="${no-3>0 }">
		<div class="bottomspan">
			<ul class="pagination pull-right">
				<li><a onclick="departmentSearch('${path}',${no-1},${size})"> &laquo;</a></li>
				<li><a onclick="departmentSearch('${path}',1,${size})"> 首页</a></li>
				<li><a onclick="departmentSearch('${path}',${no-2},${size})"> ${no-2}</a></li>
				<li><a onclick="departmentSearch('${path}',${no-1},${size})"> ${no-1}</a></li>
				<li><a onclick="departmentSearch('${path}',${no},${size})"> ${no}</a></li>
				<li><a onclick="departmentSearch('${path}',${no+1},${size})"> ${no+1}</a></li>
				<li><a onclick="departmentSearch('${path}',${no+2},${size})"> ${no+2}</a></li>
				<li><a onclick="departmentSearch('${path}',${no+1},${size})"> &raquo;</a></li>
			</ul>
		</div>
	</c:if>

	<div class="modal fade" id="del">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">删除会议</h4>
				</div>
				<div class="modal-body">
					<p id="msg"></p>
				</div>
				<div class="modal-footer">
					<a class="btn btn-primary" onclick="delDepartment('${path}',delId);">确定</a> <a class="btn btn-default" data-dismiss="modal">取消</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="alter" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改部门信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="meetingname" class="col-sm-3 control-label">部门名称</label>
							<div class=" col-sm-7">
								<input type="text" class="form-control" id="alter_name" name="alter_name" placeholder="部门名称">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="updateDepartment('${path}',altId)">确认修改</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>

				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="addOne" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加部门信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">

						<div class="form-group">
							<label for="meetingname" class="col-sm-2 control-label">部门名称</label>
							<div class=" col-sm-6">
								<input id="add_name" type="text" class="form-control"placeholder="部门名称" style="width: 436px;">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="addDepartment('${path}')">确认添加</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>

				</div>
			</div>
		</div>
	</div>
</body>
</html>

