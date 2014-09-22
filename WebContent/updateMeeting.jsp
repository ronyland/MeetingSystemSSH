<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" type="image/x-icon" href="${path}/images/favicon.ico" />
<title>修改会议</title>
<link href="${path}/common/bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${path}/css/user.css" rel="stylesheet" type="text/css">
<link href="${path}/css/subscribe.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${path}/common/jquery.js"></script>
<!--jquery要放在最前边-->
<script type="text/javascript" src="${path}/common/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<!--bootstrap-datetimepicker.min.js不能和jquery-datetimepicker.js重复，会冲突-->
<script type="text/javascript" src="${path}/common/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/common/jquery-dateFormat/jquery.dateFormat.js"></script>
<script type="text/javascript" src="${path}/js/updateMeeting.js"></script>
<script type="text/javascript" src="${path}/common/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${path}/common/jquery-ui.js"></script>


<link href="${path}/common/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">
<link href="${path}/common/Font-Awesome-3.2.1/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${path}/common/jquery-ui.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
	employeeIds = [ ${employeeIds} ];
	deviceIds = [ ${deviceIds} ];
	employeeNames = [ ${employeeNames} ];
	deviceNames = [ ${deviceNames} ];
	rentCounts = [ ${rentCounts} ];
	
	$(function() {
		$(".inputTime").datetimepicker({
			format : 'yyyy-mm-dd',
			language : 'zh-CN',
			minView : 'month',
			maxView : 'year',
			todayBtn : true,
			todayHighlight : true,
			forceParse : true,
			autoclose : true,
		});
		restore();
	});
</script>
</head>

<body>

	<c:import url="navBar.jsp"></c:import>
	<c:import url="navLeft2.jsp"></c:import>
	<div class="bodyright">

		<div style="padding-left: 40px; font-size: 30px; font-weight: bold; margin-bottom: 10px;">修改会议</div>
		<div class="spliter"></div>

		<div style="margin-top: 10px;">
			<form class="form-horizontal" role="form">

				<input type="hidden" class="form-control" name="id" id="id" placeholder="会议名称" value="${meeting.id}">

				<div class="form-group">
					<label class="col-sm-2 control-label">会议主题</label>
					<div class=" col-sm-6">
						<input class="form-control" name="topic" id="topic" placeholder="会议名称" value="${meeting.topic}">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">会议详细信息</label>
					<div class="col-sm-6">
						<textarea class="form-control" id="info" name="info">${meeting.info}
						</textarea>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">会议日期</label>
					<div class="col-sm-6">
						<input value="${meeting.date}" type="text" class="form-control inputTime" readonly id="date" style="cursor: pointer; text-align: center;" name="date" onchange="dateChange('${path}');">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">会议时间段</label>
					<div class="col-sm-6 ">
						<select class="form-control" style="text-align: center;" onclick="dateChange('${path}');" id="time" name="time">
							<option value="" style="text-align: center;">选择时间段</option>
							<option value="Morning" <c:if test="${meeting.time==Morning}">selected</c:if>>上午8:00-11:30</option>
							<option value="Noon" <c:if test="${meeting.time==Noon}">selected</c:if>>中午11:30-14:30</option>
							<option value="Afternoon" <c:if test="${meeting.time==Afternoon}">selected</c:if>>下午14:30-17:00</option>
							<option value="Dusk" <c:if test="${meeting.time==Dusk}">selected</c:if>>傍晚17:00-19:30</option>
							<option value="Night" <c:if test="${meeting.time==Night}">selected</c:if>>晚上19:30-22:00</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">会议室</label>
					<div class="col-sm-6">
						<select class="form-control" style="text-align: center;" id="meetingRoom" name="meetingRoom">
							<option value="${meetingRoom.id}">${meetingRoom.address}</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">邀请员工</label>
					<div class="col-lg-6">
						<select class="form-control" onchange="departmentChange('${path}');" id="department" style="text-align: center;">
							<option value="">选择部门</option>
							<c:forEach items="${departments}" var="department">
								<option value="${department.id}">${department.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
					<div class="col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <input type="button" class="btn btn-small " value=" + " style="padding: 0px; margin: -1px" onclick="insertEmployee()">
							</span> <select class="form-control" id="employee" style="text-align: center;">
								<option value="">选择员工</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
					<div class="col-lg-6">
						<div id="employeeDiv" style="border: 2px solid #ccc; min-height: 120px; overflow: auto;"></div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">借用设备</label>
					<div class="col-sm-6">
						<div class="input-group">
							<span class="input-group-addon"> <input type="button" class="btn btn-small " value=" + " style="padding: 0px; margin: -1px" onclick="insertDevice()">
							</span><select class="form-control" id="device" style="text-align: center;" onclick="deviceChange();">
								<option value="">选择设备</option>
								<c:forEach items="${devices}" var="device" varStatus="i">
									<option id="device_${device.id}" value="${device.id}" count="${device.leisure}">${device.name}(剩余：${device.leisure})</option>
								</c:forEach>
							</select> <select class="form-control" id="deviceCount" style="text-align: center;">
								<option value="">选择数量</option>
							</select>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
					<div class="col-lg-6">
						<div style="border: 2px solid #ccc; min-height: 120px; overflow: auto;" id="deviceDiv"></div>
					</div>
				</div>

				<input type="hidden" name="employees" id="employees"> <input type="hidden" name="departments" id="departments">

				<div class="alert alert-danger" role="alert" style="display: none;" id="error"></div>
				<div class="alert alert-success" role="alert" style="display: none;" id="success"></div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<a class="btn btn-default" onclick="submit('${path}');">确认修改</a>
					</div>
				</div>

			</form>
		</div>
	</div>

</body>
</html>
