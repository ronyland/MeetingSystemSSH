<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>


<div id="nav" class="navleft">
	<ul class="nav nav-tabs nav-stacked" role="tablist">
		<li><a href="${path}/meeting/note">会议通知<span style="color: #FFFFFF; border: 1px solid #e74c3c; border-radius: 5px; background-color: #e74c3c; width: 20px;"><label style="width: 20px; display: inline-block; text-align: center">${meetingCount>0?meetingCount:0}</label></span></a></li>
		<li><a href="${path}/meeting/my_meeting">我的会议</a></li>
		<li><a href="${path}/meeting/invited">参与会议</a></li>
		<li><a href="${path}/meeting/subscribe_prepare">预约会议</a></li>
	</ul>
</div>

