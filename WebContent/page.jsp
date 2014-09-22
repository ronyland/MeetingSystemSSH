<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<c:if test="${no-3<=0}">
	<div class="bottomspan">
		<ul class="pagination pull-right">
			<li><a href="${path}/${current}?no=${no-1}&&size=${size}"> &laquo;</a></li>
			<li><a href="${path}/${current}?no=1&&size=${size}">1</a></li>
			<li><a href="${path}/${current}?no=2&&size=${size}">2</a></li>
			<li><a href="${path}/${current}?no=3&&size=${size}">3</a></li>
			<li><a href="${path}/${current}?no=4&&size=${size}">4</a></li>
			<li><a href="${path}/${current}?no=5&&size=${size}">5</a></li>
			<li><a href="${path}/${current}?no=${no+1}&&size=${size}"> &raquo;</a></li>
		</ul>
	</div>
</c:if>

<c:if test="${no-3>0}">
	<div class="bottomspan">
		<ul class="pagination pull-right">
			<li><a href="${path}/${current}?no=${no-1}&&size=${size}"> &laquo;</a></li>
			<li><a href="${path}/${current}?no=1&&size=${size}"> 首页</a></li>
			<li><a href="${path}/${current}?no=${no-1}&&size=${size}">${no-2}</a></li>
			<li><a href="${path}/${current}?no=${no-2}&&size=${size}">${no-1}</a></li>
			<li><a href="${path}/${current}?no=${no}&&size=${size}">${no}</a></li>
			<li><a href="${path}/${current}?no=${no+1}&&size=${size}">${no+1}</a></li>
			<li><a href="${path}/${current}?no=${no+2}&&size=${size}">${no+2}</a></li>
			<li><a href="${path}/${current}?no=${no+1}&&size=${size}"> &raquo;</a></li>
		</ul>
	</div>
</c:if>

