$(document).ready(function() {
	$("#SeniorSearch").click(function() {
		$("#Slide").slideToggle('slow');
	});
});

function delMeeting(path, delId) {
	$.post(path + "/meeting/delete", {
		id : delId
	}, function(result, status) {
		if (status = '200') {
			alert('删除成功');
			location.reload();
		} else {
			alert('删除失败');
		}
	});
}

function meetingSearch(path, no, size) {
	document.location.href = path + "/meeting/my_meeting?topic=" + $('#topic').val() + "&address=" + $('#address').val() + "&date=" + $('#date').val() + "&time=" + $('#time').val() + "&state=" + $('#state').val() + "&no=" + no + "&size=" + size;
}