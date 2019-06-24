function login() {
	$.ajax({
		type : "POST",
		url : "teacher/login",
		data : $("#loginform").serialize(),
		success : function(result) {
			if (result.status) {
				console.log(result.data);
				openLoading();
				var role = result.data;
				if (role == "指导教师") {
					$(location).attr('href', 'teacher/teachercenter');
				} else if (role == "评阅教师") {
					$(location).attr('href', 'teacher/teachercenter2');
				} else if (role == "答辩小组成员") {
					$(location).attr('href', 'teacher/teachercenter3');
				} else {
					$("#errorlabel").html("出现未知错误");
				}
			} else {
				$("#errorlabel").html(result.message);
			}
		}
	});
	
}
function sendMail(){
	openLoading();
	$.ajax({
		type : "post",
		url : "mail/send",
		data : {
			uid : $("#uid").val()
		},
		success : function(result){
			closeLoading();
			openMsgModal(result.message);
		}
	})
}