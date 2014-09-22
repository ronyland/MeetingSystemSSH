 $(document).ready(function(){
	$("#SeniorSearch").click(function(){
  $("#Slide").slideToggle('slow');
  });
}); 

 function delDevice(path, delId) {
	 $.ajax({
		 url : path + "/device/delete", 
		 type : 'POST',
			data : {
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
function deviceSearch(path,no,size){
	document.location.href = path + "/device/search?name="
	        + $('#name').val()
	        + "&no=" + no + "&size=" + size;
}

function alterDevice(i) {
	var count = $('#count_' + i).text();
	var name = $('#name_' + i).text();
	var leisure = $('#leisure_' + i).text();
	$('#alter_name').val(name);
	$('#alter_count').val(count);
	$('#alter_leisure').val(leisure);
}

function isENU(o) {
	s = $.trim(o);
	if (s == null || s == undefined || s == "" || s === "") {
		return true;
	} else {
		return false;
	}
}

function updateDevice(path,updateId){
	if (isENU($('#alter_name').val())){
		return false;
	}
	
	 $.ajax({
		 url : path + "/device/update",
		 type : 'POST',
		 data : {
			 id : altId,
			 name : $('#alter_name').val(),
			 count : $('#alter_count').val(),
			 leisure : $('#alter_leisure').val(),
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

function addDevice(path){
	if (isENU($('#add_name').val())){
		return false;
	}
	if (isENU($('#add_count').val())){
		return false;
	}
	
	 $.ajax({
		 url : path + "/device/add",
		 type : 'POST',
		 data : {
			 name : $('#add_name').val(),
			 count : $('#add_count').val(),
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