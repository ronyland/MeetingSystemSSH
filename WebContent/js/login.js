$(document).ready(function() {

	$("#login").click(function() {
		$('#form').submit();

	});
});

function forgetPwd(path) {
	$.ajax({
		url : path + "/forget_pwd",
		type : 'GET',
		data : {
			username : $('#username').val()
		},
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(data, status) {
			if (status = '200') {
				$('#success').attr('style', 'display:block');
				$('#error').attr('style', 'display:none');
				$('#success').text('已发送邮件至您的邮箱，请注意查收！');
			} else {
				$('#error').attr('style', 'display:block');
				$('#error').text('发送失败');
			}
		},
		dataType : 'text'
	});
}