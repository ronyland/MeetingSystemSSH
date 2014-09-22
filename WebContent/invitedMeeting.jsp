<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" type="image/x-icon" href="${path}/images/favicon.ico" />
<title>参与会议</title>
<link href="${path}/common/bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${path}/css/user.css" rel="stylesheet" type="text/css">
<link href="${path}/css/invitedMeeting.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${path}/common/jquery.js"></script>
<script type="text/javascript" src="${path}/common/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/invitedMeeting.js"></script>
<script type="text/javascript" src="${path}/common/jquery-ui.js"></script>
<link href="${path}/common/Font-Awesome-3.2.1/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>

	<c:import url="navBar.jsp"></c:import>
	<c:import url="navLeft2.jsp"></c:import>
	<div class="bodyright">


		<div style="padding-left: 40px; font-size: 30px; font-weight: bold; margin-bottom: 10px;">参与会议</div>
		<span id="triangle-topright"><a id="SeniorSearch" class="icon-search"></a></span>


		<div id="Slide" <c:if test="${searching == false}">style="display: none"</c:if>>
			<input name="topic" id="topic" type="text" placeholder="会议主题" value="${topic}" /> <input name="address" id="address" type="text" placeholder="会议室地址" value="${address}" /> <input name="date" id="date" type="text" placeholder="会议日期" value="${date}" /> <select id="time" name="time"><option value=""></option>
				<option value="0">上午</option>
				<option value="1">中午</option>
				<option value="2">下午</option>
				<option value="3">傍晚</option>
				<option value="4">晚上</option></select> <input name="hostEmployeeName" id="hostEmployeeName" type="text" placeholder="会议发起人" value="${hostEmployeeName}" /> <a class="btn btn-small btn-info" onclick="meetingSearch('${path}',1,${size})">查询</a>
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
					<th width="15%">发起人</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${meetings}" var="meeting" varStatus="id">
					<tr>
						<td style="line-height: 30px;">${meeting.topic}</td>
						<td style="line-height: 30px;">${meeting.meetingRoom.address}</td>
						<td style="line-height: 30px;">${meeting.date}</td>
						<td style="line-height: 30px;">${meeting.time.string}</td>
						<td style="line-height: 30px;">${meeting.count}</td>
						<td style="line-height: 30px;">${meeting.state.string}</td>
						<td style="line-height: 30px;">${meeting.hostEmployee.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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
