function restore() {
	for (var i = 0; i < employeeIds.length; ++i) {
		$('#employeeDiv').append('<span class="label label-warning" style="display: inline-block; margin: 1px; padding: 1px; font-size:12px;" id="employee_span_' + employeeIds[i] + '" content="' + employeeIds[i] + '">' + employeeNames[i] + '<a class="icon-remove" onclick="delEmployee(\'' + employeeIds[i] + '\')"></a></span>');
	}
	for (var i = 0; i < deviceIds.length; ++i) {
		$('#deviceDiv').append('<span class="label label-warning" style="display: inline-block; margin: 1px; padding: 1px; font-size:12px;" id="device_span_' + deviceIds[i] + '" content="' + deviceIds[i] + "*" + rentCounts[i] + '">' + deviceNames[i] + "*" + rentCounts[i] + '<a class="icon-remove" onclick="delDevice(\'' + deviceIds[i] + '\')"></a></span>');
	}
}

function isENU(o) {
	s = $.trim(o);
	if (s == null || s == undefined || s == "" || s === "") {
		return true;
	} else {
		return false;
	}
}

function departmentChange(path) {
	$.ajax({
		url : path + "/department/employee",
		type : 'GET',
		data : {
			id : $('#department').val()
		},
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(data, status) {
			if (status = '200') {
				$('#error').attr('style', 'display:none');
				$('#employee').html(data);
			} else {
				$('#error').attr('style', 'display:block');
				$('#error').text('获取部门员工信息失败,请稍后再试');
			}
		},
		dataType : 'text'
	});
}

function dateChange(path) {
	if (isENU($('#date').val())) {
		return false;
	} else if (isENU($('#time').val())) {
		return false;
	}
	$.ajax({
		url : path + "/meeting_room/leisure",
		type : 'GET',
		data : {
			date : $('#date').val(),
			time : $('#time').val()
		},
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(data, status) {
			if (status = '200') {
				$('#error').attr('style', 'display:none');
				$('#meetingRoom').html(data);
			} else {
				$('#error').attr('style', 'display:block');
				$('#error').text('获取会议室信息失败,请稍后再试');
			}
		},
		dataType : 'text'
	});
}

function insertEmployee() {
	if (isENU($('#employee').val())) {
		return;
	}
	var employeeId = $('#employee').val();
	var employeeName = $('#employee_' + employeeId).html();
	var contains = false;
	for (var i = 0; i < employeeIds.length; ++i) {
		if (employeeId === employeeIds[i]) {
			contains = true;
		}
	}
	if (contains == false) {
		$('#employeeDiv').append('<span class="label label-warning" style="display: inline-block; margin: 1px; padding: 1px; font-size:12px;" id="employee_span_' + employeeId + '" content="' + employeeId + '">' + employeeName + '<a class="icon-remove" onclick="delEmployee(\'' + employeeId + '\')"></a></span>');
		employeeIds.push(employeeId);
	}
}

function delEmployee(employeeId) {
	$('#employee_span_' + employeeId).html("");
	$('#employee_span_' + employeeId).remove();
	for (var i = 0; i < employeeIds.length; ++i) {
		if (employeeId === employeeIds[i]) {
			employeeIds.splice(i, 1);
			break;
		}
	}
}

function insertDevice() {
	if (isENU($('#device').val())) {
		return;
	}
	if (isENU($('#deviceCount').val())) {
		return;
	}

	var deviceId = $('#device').val();
	var deviceName = $('#device_' + deviceId).html();
	var contains = false;
	for (var i = 0; i < deviceIds.length; ++i) {
		if (deviceId === deviceIds[i]) {
			contains = true;
		}
	}
	if (contains == false) {
		$('#deviceDiv').append('<span class="label label-warning" style="display: inline-block; margin: 1px; padding: 1px; font-size:12px;" id="device_span_' + deviceId + '" content="' + deviceId + '*' + $('#deviceCount').val() + '">' + deviceName.split("(剩余：")[0] + "*" + $('#deviceCount').val() + '<a class="icon-remove" onclick="delDevice(\'' + deviceId + '\')"></a></span>');
		deviceIds.push(deviceId);
	}
}

function delDevice(deviceId) {
	$('#device_span_' + deviceId).html("");
	$('#device_span_' + deviceId).remove();
	for (var i = 0; i < deviceIds.length; ++i) {
		if (deviceId === deviceIds[i]) {
			deviceIds.splice(i, 1);
			break;
		}
	}
}

function deviceChange() {
	var count = $('#device_' + $('#device').val()).attr('count');
	$('#deviceCount').html("");
	for (var i = 1; i <= count; ++i) {
		$('#deviceCount').append('<option>' + i + '</option>');
	}
}

function submit(path) {
	if (isENU($('#topic').val())) {
		return false;
	}
	if (isENU($('#info').val())) {
		return false;
	}
	if (isENU($('#date').val())) {
		return false;
	}
	if (isENU($('#time').val())) {
		return false;
	}
	if (isENU($('#meetingRoom').val())) {
		return false;
	}

	var employee_data = "";
	for (var i = 0; i < employeeIds.length; ++i) {
		employee_data += $('#employee_span_' + employeeIds[i]).attr('content');
		if (i < employeeIds.length - 1) {
			employee_data += ",";
		}
	}
	if (isENU(employee_data)) {
		return false;
	}

	var device_data = "";
	for (var i = 0; i < deviceIds.length; ++i) {
		device_data += $('#device_span_' + deviceIds[i]).attr('content');
		if (i < deviceIds.length - 1) {
			device_data += ",";
		}
	}
	if (isENU(device_data)) {
		return false;
	}

	$.ajax({
		url : path + "/meeting/update",
		type : 'POST',
		data : {
			id : $.trim($('#id').val()),
			topic : $.trim($('#topic').val()),
			info : $.trim($('#info').val()),
			date : $('#date').val(),
			time : $('#time').val(),
			meetingRoomId : $('#meetingRoom').val(),
			employeeData : employee_data,
			deviceData : device_data
		},
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(data, status) {
			if (status = '200') {
				$('#error').attr('style', 'display:none');
				$('#success').attr('style', 'display:block');
				$('#success').text('预约成功');
				setTimeout('location.href = "' + path + '/meeting/my_meeting"', 1000);
			} else {
				$('#error').attr('style', 'display:block');
				$('#error').text('预约失败,请稍后再试');
			}
		},
		dataType : 'text'
	});
}