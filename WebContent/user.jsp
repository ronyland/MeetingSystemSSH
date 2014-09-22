<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" type="image/x-icon" href="${path}/images/favicon.ico" />
<title>个人中心</title>
<link href="${path}/common/bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${path}/css/user.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${path}/common/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/common/jquery.js"></script>
<script type="text/javascript" src="${path}/js/user.js"></script>
</head>

<body>

	<c:import url="navBar.jsp"></c:import>
	<c:import url="navLeft2.jsp"></c:import>
	<div class="bodyright">

		<div style="padding-left: 40px; font-size: 30px; font-weight: bold; margin-bottom: 10px;">会议通知</div>
		<table class="table table-hover">
			<c:forEach items="${meetings}" var="meeting" varStatus="id">
				<tr>
					<td style="line-height: 30px;"><p>
							<label style="font-size: 26px;">${meeting.hostEmployee.name}</label><label style="font-size: 18px;"> 邀请您于${meeting.date}的${meeting.time.string}在${meeting.meetingRoom.address}参加“${meeting.topic}会议”。 该会议是有关“${meeting.info}”。。。</label>
						</p></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="bottomspan">
		<ul class="pagination pull-right">
			<c:if test="${pager.no>1}">
				<li><a onclick="document.location='${path}${current}?no=${pager.no-1}&size=${pager.size}'"> &laquo;</a></li>
			</c:if>
			<c:if test="${pager.no<=1}">
				<li><a onclick="'"> &laquo;</a></li>
			</c:if>
			<li><a onclick="">${pager.no}</a></li>
			<li><a onclick="">OF</a></li>
			<li><a onclick="">${pager.totalPage}</a></li>
			<c:if test="${pager.no<pager.totalPage}">
				<li><a onclick="document.location='${path}${current}?no=${pager.no+1}&size=${pager.size}'"> &raquo;</a></li>
			</c:if>
			<c:if test="${pager.no>=pager.totalPage}">
				<li><a onclick=""> &raquo;</a></li>
			</c:if>
		</ul>
	</div>

</body>
</html>
