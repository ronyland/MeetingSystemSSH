 $(document).ready(function(){
 $("#SeniorSearch").click(function(){
  $("#Slide").slideToggle('slow');
  });
  
  $("#1111").popover('toggle');
}); 

 
 
 function delEmployee(path, delId) {
	 $.ajax({
		 url : path + "/employee/delete", 
		 type : 'POST',
			data :{
			id : delId
		},
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(data, status){
			 alert('刪除成功');
			 location.reload();
	         },
	     error : function(data, status){
			 alert('刪除失败，请稍后再试');
	        },
	      dataType : 'text'
	    });
	}
 
function employeeSearch(path,no,size){
	document.location.href = path + "/employee/search?name=" + $('#name').val()
	        + "&username=" + $('#username').val()
	        + "&department=" + $('#department').val()
	        + "&phone=" + $('#phone').val()
	        + "&email=" + $('#email').val()
	        + "&no=" + no + "&size=" + size;
}

function isENU(o) {
	s = $.trim(o);
	if (s == null || s == undefined || s == "" || s === "") {
		return true;
	} else {
		return false;
	}
}

function alterEmployee(i) {
 	var name = $('#name_' + i).text();
 	var departmentId = $('#departmentname_' + i).text();
 	var password = $('#password_' + i).text();
 	var username = $('#username_' + i).text();
 	var phone = $('#phone_' + i).text();
 	var email = $('#email_' + i).text();
 	$('#alter_name').val(name);
 	$('#alter_departmentId').val(departmentId),
	$('#alter_password').val(password),
	$('#alter_username').val(username),
	$('#alter_phone').val(phone),
	$('#alter_email').val(email)
}

function updateEmployee(path,updateId){
	if (isENU($('#alter_name').val())){
		return false;
	}
	
	 $.ajax({
		 url : path + "/employee/update",
		 type : 'POST',
		 data : {
			 id : altId,
			 name : $('#alter_name').val(),
			 departmentId : $('#alter_departmentId').val(),
			 password : $('#alter_password').val(),
			 username : $('#alter_username').val(),
			 phone : $('#alter_phone').val(),
			 email : $('#alter_email').val(),
		},
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(data, status){
			 alert('修改成功');
			 location.reload();
	         },
	     error : function(data, status){
			 alert('修改失败，请稍后再试');
	        },
	      dataType : 'text'
	    });
}

function addEmployee(path){
	if (isENU($('#add_name').val())){
		return false;
	}
	if (isENU($('#add_department').val())){
		return false;
	}
	if (isENU($('#add_password').val())){
		return false;
	}
	if (isENU($('#add_username').val())){
		return false;
	}
	if (isENU($('#add_phone').val())){
		return false;
	}
	if (isENU($('#add_email').val())){
		return false;
	}
	
	 $.ajax({
		 url : path + "/employee/add",
		 type : 'POST',
		 data : {
			 name : $('#add_name').val(),
			 departmentId : $('#add_department').val(),
			 password : $('#add_password').val(),
			 username : $('#add_username').val(),
			 phone : $('#add_phone').val(),
			 email : $('#add_email').val(),
		 },
		 contentType : "application/x-www-form-urlencoded; charset=utf-8",
		 success : function(data, status){
			 alert('增加成功');
			 location.reload();
		 },
		 error : function(data, status){
			 alert('增加失败，请稍后再试');
		 },
		 dataType : 'text'
	 });
}
