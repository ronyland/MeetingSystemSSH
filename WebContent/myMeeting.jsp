<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" type="image/x-icon" href="${path}/images/favicon.ico" />
<title>我的会议</title>
<link href="${path}/common/bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${path}/css/user.css" rel="stylesheet" type="text/css">
<link href="${path}/css/myMeeting.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${path}/common/jquery.js"></script>
<script type="text/javascript" src="${path}/common/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/myMeeting.js"></script>
<link href="${path}/common/Font-Awesome-3.2.1/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>

	<c:import url="navBar.jsp"></c:import>
	<c:import url="navLeft2.jsp"></c:import>

	<div class="bodyright">
		<div style="padding-left: 40px; font-size: 30px; font-weight: bold; margin-bottom: 10px;">我的会议</div>
		<span id="triangle-topright"><a id="SeniorSearch" class="icon-search"></a></span>
		<div id="Slide" <c:if test="${searching == false}">style="display: none"</c:if>>
			<input name="topic" id="topic" type="text" placeholder="会议主题" value="${topic}" /> <input name="address" id="address" type="text" placeholder="会议室地址" value="${address}" /> <input name="date" id="date" type="text" placeholder="会议日期" value="${date}" /> <select id="time" name="time"><option value=""></option>
				<option value="0">上午</option>
				<option value="1">中午</option>
				<option value="2">下午</option>
				<option value="3">傍晚</option>
				<option value="4">晚上</option></select> <select id="state" name="state"><option value=""></option>
				<option value="0">审核通过</option>
				<option value="1">审核失败</option>
				<option value="2">未审核</option></select><a class="btn btn-small btn-info" style="margin-left: 5px;" onclick="meetingSearch('${path}',1,${pager.size})">查询</a>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th width="20%">主题</th>
					<th width="20%">地址</th>
					<th width="10%">日期</th>
					<th width="10%">时间段</th>
					<th width="10%">参与人数</th>
					<th width="15%">状态</th>
					<th width="25%">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${meetings}" var="meeting" varStatus="id">
					<tr <c:if test="${meeting.state==Submit}">class=".warning"</c:if>>
						<td style="line-height: 30px;">${meeting.topic}</td>
						<td style="line-height: 30px;">${meeting.meetingRoom.address}</td>
						<td style="line-height: 30px;">${meeting.date}</td>
						<td style="line-height: 30px;">${meeting.time.string}</td>
						<td style="line-height: 30px;">${meeting.count}</td>
						<td style="line-height: 30px;">${meeting.state.string}</td>
						<td><a class="btn btn-sm" href="${path}/meeting/update_prepare?id=${meeting.id }">修改</a><a class="btn btn-sm" data-toggle="modal" data-target="#del" onclick="delId=${meeting.id};$('#msg').text('确定要删除编号为`'+delId+'`的会议吗？')">撤销</a></td>
					</tr>
				</c:forEach>
		</table>
	</div>

	<div class="modal fade" id="del">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">删除会议</h4>
				</div>
				<div class="modal-body">
					<p id="msg"></p>
				</div>
				<div class="modal-footer">
					<a class="btn btn-primary" onclick="delMeeting('${path}',delId);">确定</a> <a class="btn btn-default" data-dismiss="modal">取消</a>
				</div>
			</div>
		</div>
	</div>

	<div class="bottomspan">
		<ul class="pagination pull-right">
			<c:if test="${pager.no>1}">
				<li><a onclick="meetingSearch('${path}',${pager.no-1},${pager.size})"> &laquo;</a></li>
			</c:if>
			<c:if test="${pager.no<=1}">
				<li><a onclick="'"> &laquo;</a></li>
			</c:if>
			<li><a onclick="">${pager.no}</a></li>
			<li><a onclick="">OF</a></li>
			<li><a onclick="">${pager.totalPage}</a></li>
			<c:if test="${pager.no<pager.totalPage}">
				<li><a onclick="meetingSearch('${path}',${pager.no+1},${pager.size})"> &raquo;</a></li>
			</c:if>
			<c:if test="${pager.no>=pager.totalPage}">
				<li><a onclick=""> &raquo;</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>
