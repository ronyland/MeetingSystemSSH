$(document).ready(function() {
	$('#Slide').hide();
	$("#SeniorSearch").click(function() {
		$("#Slide").slideToggle();
	});
});

function delMeetingRoom(path, delId) {
	$.ajax({
	url : path + "/meeting_room/delete", 
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

function meetingRoomSearch(path, no, size) {
	document.location.href = path + "/meeting_room/search?id=" + $('#id').val()
			+ "&address=" + $('#address').val() + "&maxCount="
			+ $('#maxCount').val() + "&no=" + no + "&size=" + size;
}

function alterMeetingRoom(i) {
	var address = $('#address_' + i).text();
	var maxCount = $('#maxCount_' + i).text();
	$('#alter_address').val(address);
	$('#alter_maxCount').val(maxCount);
}

function isENU(o) {
	s = $.trim(o);
	if (s == null || s == undefined || s == "" || s === "") {
		return true;
	} else {
		return false;
	}
}

function updateMeetingRoom(path,updateId){
if (isENU($('#alter_address').val())) {
	return false;
}
if (isENU($('#alter_maxCount').val())) {
	return false;
}

 $.ajax({
	url : path + "/meeting_room/update",
	type : 'POST',
	data : {
		id : altId,
		address : $('#alter_address').val(),
		maxCount : $('#alter_maxCount').val()
	},
	contentType : "application/x-www-form-urlencoded; charset=utf-8",
	 success : function(data, status){
		 if(status = '200'){
			 $('#success').text('修改成功');
			 location.reload();
		 }else{
			 $('#error').text('修改失败，请稍后再试');
		 }
	 },
	dataType : 'text'
});
}

function addMeetingRoom(path){
	if (isENU($('#add_address').val())){
		return false;
	}
	if (isENU($('#add_count').val())){
		return false;
	}
	
	 $.ajax({
		 url : path + "/meeting_room/add",
		 type : 'POST',
		 data : {
			 address : $('#add_address').val(),
			 maxCount : $('#add_count').val(),
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