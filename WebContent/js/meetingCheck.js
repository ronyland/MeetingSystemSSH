function confirm(path,id) {
	$.post(path + "/meeting/allow", {
		id : id
	}, function(result, status) {
		if (status = '200') {
			alert('确认成功');
			location.reload();
		} else {
			alert('确认失败');
		}
	});
}

function reject(path,id) {
	$.post(path + "/meeting/disallow", {
		id : id
	}, function(result, status) {
		if (status = '200') {
			alert('拒绝成功');
			location.reload();
		} else {
			alert('拒绝失败');
		}
	});
}