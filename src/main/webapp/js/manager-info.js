function getInfo(){
	$.ajax({
		type : "POST",
		url : "getInfo",
		success : function(result){
			$("#m-sex").html(result.data.sex);
			$("#m-email").html(result.data.email);
			$("#m-tel").html(result.data.tel);
			$("#m-username").html(result.data.username);
			$("#m-id").html(result.data.id);
			$("#m-department").html(result.data.deptName);
		}
	});
}
function cancel(sex,email,tel){
	$("#m-sex").html(sex);
	$("#m-email").html(email);
	$("#m-tel").html(tel);
	$("#btn-modify-infos").show();
	$("#btn-cancel").remove();
	$("#btn-submit").remove();
}
window.onload = function(){
	getInfo();
	var flag1 = 0;
	var flag2 = 0;
	var flag3 = 0;
//	$(".form-div").hide();
	$("#btn-modify-infos").on('click',function(){
		var sex = $("#m-sex").text();
		var email = $("#m-email").text();
		var tel = $("#m-tel").text();
		console.log(sex);
		$("#m-sex").html("<input type='text' id='new-sex' class='form-control' placeholder='Gender' value='"+sex+"'>");
		$("#m-email").html("<input type='text' id='new-email' class='form-control' placeholder='E-mail' value='"+email+"'>");
		$("#m-tel").html("<input type='text' id='new-tel' class='form-control' placeholder='Tel' value='"+tel+"'>");
		console.log($("#new-sex").val());
		$("#btn-modify-infos").hide();
		$("#option-btns").append("<button class='am-btn am-btn-xs am-round am-btn-success ' id='btn-submit'>确定</button> ");
		$("#option-btns").append("<button class='am-btn am-btn-xs am-round am-btn-danger' id='btn-cancel'>取消</button>");
		$("#btn-cancel").attr("onclick","cancel('"+sex+"','"+email+"','"+tel+"')");
		
		$("#btn-submit").on('click',function(){
			$.ajax({
				type : "POST",
				url : "modifyInfo",
				data : {
					sex : $("#new-sex").val(),
					email : $("#new-email").val(),
					tel : $("#new-tel").val()
				},
				success : function(result){
					if(result.status){
						alert(result.message);
						$("#m-sex").html(result.data.sex);
						$("#m-email").html(result.data.email);
						$("#m-tel").html(result.data.tel);
						$("#btn-modify-infos").show();
						$("#btn-cancel").remove();
						$("#btn-submit").remove();
					}else{
						alert(result.message);
					}
				}
			});
		});
	});
	
	$("#old-password").on('blur',function(){
		var text = $(this).val();
		console.log(text);
		$.ajax({
			type : "POST",
			url : "checkPsw",
			data : {
				"old" : text
			},
			success : function(result){
				if(result.status){
					$("#old-password").css("border-color","#ccc");
					$("#p-old").hide();
					flag1 = 1;
//					$("#psw-ok").removeAttr("disabled");
				}else{
					$("#p-old").show();
					$("#p-old").html(result.message);
					$("#old-password").css("border-color","red");
//					$("#psw-ok").attr("disabled","disabled");
				}
			}
		});
	});
	$("#new-password").on('blur',function(){
		var zhengze = /^[a-zA-Z0-9\_]+$/;
		var text = $(this).val();
		console.log(text.length);
		if(text.length==0){
			//不能为空
			$("#new-password").css("border-color","red");
			$("#p-new").show();
			$("#p-new").html("请输入密码");
//			$("#psw-ok").attr("disabled","disabled");
		}else{
			if(text.length>16||text.length<6){
				$("#new-password").css("border-color","red");
				$("#p-new").show();
				$("#p-new").html("密码长度的必须在6-15之间");
//				$("#psw-ok").attr("disabled","disabled");
			}else{
				if(!zhengze.test(text)){
					$("#new-password").css("border-color","red");
					$("#p-new").show();
					$("#p-new").html("密码只能包含数字、字母和下划线");
//					$("#psw-ok").attr("disabled","disabled");
				}else{
					$("#p-new").hide();
					$("#new-password").css("border-color","#ccc");
					flag2 = 1;
//					$("#psw-ok").removeAttr("disabled");
				}
			}
		}
	});
	
	$("#new-password-check").on('blur',function(){
		var psw = $("#new-password").val();
		var check = $(this).val();
		if(check==psw){
			$("#p-new-check").hide();
			$("#new-password-check").css("border-color","#ccc");
			flag3 = 1;
//			$("#psw-ok").removeAttr("disabled");
		}else{
			$("#new-password-check").css("border-color","red");
			$("#p-new-check").html("密码不一致");
			$("#p-new-check").show();
//			$("#psw-ok").attr("disabled","disabled");
		}
	});
	$("#psw-ok").on('click',function(){
		if(flag1==1&&flag2==1&&flag3==1){
			var psw = $("#new-password").val();;
			$.ajax({
				type : "POST",
				url : "changePsw",
				data : {
					"new" : psw
				},
				success : function(result){
					if(result.status){
						alert(result.message+"。请重新登录！");
						$(location).attr('href', '../teacherEntry.html');
					}else{
						alert(result.message);
					}
				}
				
			})
		}else{
			alert("请根据提示填写正确信息");
		}
		
	});
	
	$("#btn-modify-password").on('click',function(){
		$(".form-div").show();
	})
	$("#psw-cancel").on('click',function(){
		$(".form-div").hide();
	});
	
}