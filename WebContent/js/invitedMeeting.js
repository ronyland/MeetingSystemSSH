$(document).ready(function() {
	$("#SeniorSearch").click(function() {
		$("#Slide").slideToggle();
	});
});

function meetingSearch(path, no, size) {
	document.location.href = path + "/meeting/invited?topic=" + $('#topic').val() + "&address=" + $('#address').val() + "&date=" + $('#date').val() + "&time=" + $('#time').val() + "&hostEmployeeName=" + $('#hostEmployeeName').val() + "&no=" + no + "&size=" + size;
}