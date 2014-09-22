<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>


<div id="nav" class="navleft">
	<ul class="nav nav-tabs nav-stacked" role="tablist">
		<li><a href="${path}/employee/search">员工管理</a></li>
		<li><a href="${path}/department/search">部门管理</a></li>
		<li><a href="${path}/device/search">设备管理</a></li>
		<li><a href="${path}/meeting/note_verify">会议审核<span style="color: #FFFFFF; border: 1px solid #e74c3c; border-radius: 5px; background-color: #e74c3c; width: 20px;"><label style="width: 20px; display: inline-block; text-align: center">${verifyMeetingCount>0?verifyMeetingCount:0}</label></span></a></li>
		<li><a href="${path}/meeting_room/search">会议室管理</a></li>
	</ul>
</div>

