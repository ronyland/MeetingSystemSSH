 $(document).ready(function(){
   $("#SeniorSearch").click(function(){
  $("#Slide").slideToggle('slow');
  });
}); 

 function alterDepartment(i) {
 	var name = $('#name_' + i).text();
 	$('#alter_name').val(name);
 }
 
 function isENU(o) {
		s = $.trim(o);
		if (s == null || s == undefined || s == "" || s === "") {
			return true;
		} else {
			return false;
		}
	}
 
function updateDepartment(path,updateId){
	if (isENU($('#alter_name').val())) {
		return false;
	}
	
     $.ajax({
		url : path + "/department/update",
		type : 'POST',
		data : {
			id : altId,
			name : $('#alter_name').val()
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

function addDepartment(path){
	if (isENU($('#add_name').val())){
		return false;
	}
	
	 $.ajax({
		 url : path + "/department/add",
		 type : 'POST',
		 data : {
			 name : $('#add_name').val(),
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

function delDepartment(path,delId){
	$.ajax({
		url : path + "/department/delete",
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
function departmentSearch(path,no,size){
	document.location.href = path + "/department/search?name="
	        + $('#name').val() 
	        + "&no=" + no + "&size=" + size;
}
