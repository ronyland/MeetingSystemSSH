<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" type="image/x-icon" href="${path}/images/favicon.ico"/>
<title>会议审核</title>
<link href="${path}/common/bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${path}/css/user.css" rel="stylesheet" type="text/css">
<link href="${path}/css/subscribe.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${path}/common/jquery.js"></script>
<script type="text/javascript" src="${path}/common/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/meetingCheck.js"></script>
</head>

<body>

	<c:import url="navBar.jsp"></c:import>
	<c:import url="navLeft.jsp"></c:import>
		<div class="bodyright">
			<table class="table table-hover">
				<thead>
				<td style="padding-left:40px;font-size:30px; font-weight:bold;"> 会议审核 </td>
				</thead>
				<tbody>
				<c:if test="${totalCount>0}">
				<c:forEach items="${meetings}" var="meeting" varStatus="id">
				<tr>
					<td style="line-height:30px;"> ${meeting.hostEmployeeName}请求 于${meeting.date} ${meeting.time}在 ${meeting.address}召开 ${meeting.topic}会议关于 ${meeting.info} </td>
					<td><a class="btn btn-sm" onclick="confirm('${path}',${meeting.id})">通过</a><a class="btn btn-sm" onclick="reject('${path}',${meeting.id})">拒绝</a></td>
				</tr>
				</c:forEach>
				</c:if>
				<c:if test="${totalCount==0 or empty totalCount}">
						      <tr align="center">
						        <td height="50px">亲，没有数据哦</td>
						      </tr>
						   </c:if>
				</tbody>
			</table>
		</div>
		
       <c:if test="${no-3<=0}">
		<div class="bottomspan">
			<ul class="pagination pull-right">
				<li><a href="${path}${current}?no=${no-1}&&size=${size}"> &laquo;</a></li>
				<li><a href="${path}${current}?no=1&&size=${size}">1</a></li>
				<li><a href="${path}${current}?no=2&&size=${size}">2</a></li>
				<li><a href="${path}${current}?no=3&&size=${size}">3</a></li>
				<li><a href="${path}${current}?no=4&&size=${size}">4</a></li>
				<li><a href="${path}${current}?no=5&&size=${size}">5</a></li>
				<li><a href="${path}${current}?no=${no+1}&&size=${size}"> &raquo;</a></li>
			</ul>
		</div>
	</c:if>

	<c:if test="${no-3>0}">
		<div class="bottomspan">
			<ul class="pagination pull-right">
				<li><a href="${path}${current}?no=${no-1}&&size=${size}"> &laquo;</a></li>
				<li><a href="${path}${current}?no=1&&size=${size}"> 首页</a></li>
				<li><a href="${path}${current}?no=${no-1}&&size=${size}">${no-2}</a></li>
				<li><a href="${path}${current}?no=${no-2}&&size=${size}">${no-1}</a></li>
				<li><a href="${path}${current}?no=${no}&&size=${size}">${no}</a></li>
				<li><a href="${path}${current}?no=${no+1}&&size=${size}">${no+1}</a></li>
				<li><a href="${path}${current}?no=${no+2}&&size=${size}">${no+2}</a></li>
				<li><a href="${path}${current}?no=${no+1}&&size=${size}"> &raquo;</a></li>
			</ul>
		</div>
	</c:if>
</body>
</html>
