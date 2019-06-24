function submitForm() {
//	openLoading();
	$.ajax({
		type : "POST",
		url : "manager/login",
		data : $("#loginform").serialize(),
		success : function(result) {
//			closeLoading();
			if (result.status) {

//				openMsgModal(result.message);
				alert("登录成功");
				$(location).attr('href', 'manager/edumanagercenter');
			} else {
				$("#errorlabel").html(result.message);
			}
		}
	});
}
