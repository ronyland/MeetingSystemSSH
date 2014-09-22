function isENU(o) {
	s = $.trim(o);
	if (s == null || s == undefined || s == "" || s === "") {
		return true;
	} else {
		return false;
	}
}

function register(path) {
	if (!isENU($('#name').val())) {
		$('#info').attr('style', 'display:block');
		$('#info').text("名字不能为空");
	}
	if (!isENU($('#username').val())) {
		$('#info').attr('style', 'display:block');
		$('#info').text("用户名不能为空");
	}
	if (!isENU($('#phone').val())) {
		$('#info').attr('style', 'display:block');
		$('#info').text("电话不能为空");
	}
	if (!isENU($('#email').val())) {
		$('#info').attr('style', 'display:block');
		$('#info').text("注册提交成功");
	}
	if (!isENU($('#department').val())) {
		$('#info').attr('style', 'display:block');
		$('#info').text("部门不能为空");
	}
	if (!isENU($('#password').val())) {
		$('#info').attr('style', 'display:block');
		$('#info').text("密码不能为空");
	}
	if (!isENU($('#password2').val())) {
		$('#info').attr('style', 'display:block');
		$('#info').text('确认密码不能为空');
	}
	if ($('#password').val() != $('#password2').val()) {
		$('#info').attr('style', 'display:block');
		$('#info').text("两次密码不一致");
	}
	$.ajax({
		url : path + "/forget_pwd",
		type : 'GET',
		data : {
			id : $('#username').val(),
			name : $('#name').val(),
			password : $('#password').val(),
			password2 : $('#password2').val(),
			phone : $('#phone').val(),
			email : $('#email').val(),
			department : $('#department').val()
		},
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(data, status) {
			if (status = '200') {
				$('#info').attr('style', 'display:block');
				$('#info').text("注册提交成功");
				setTimeout('location.href="' + path + '/login' + '"', 1000);
			} else if (status = '500') {
				$('#info').attr('style', 'display:block');
				$('#info').text("用户名已被占用，请更改！");
			} else {
				$('#info').attr('style', 'display:block');
				$('#info').text('注册提交失败，请稍后再试');
			}
		},
		dataType : 'text'
	});
}