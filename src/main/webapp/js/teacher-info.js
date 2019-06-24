function checkValidity1(){
	
}
function checkValidity2(){
	
}
function checkValidity3(){
	
}
function getInfo(uid){
	$.ajax({
		type : "GET",
		url : "getinfo",
		data : {
			"uid" : uid
		},
		success : function(result){
			appendinfos(result);
		}
	});
}
function appendinfos(result){
	if(result.status){
		var data = result.data;
		$("#t-name").html(data.username);
		$("#t-id").html(data.id);
		$("#t-sex").html(data.sex);
		$("#t-dept").html(data.deptId);
		$("#t-email").html(data.email);
		$("#t-tel").html(data.tel);
		$("#t-rank").html(data.rank);
		$("#t-identity").html(data.identity);
		$("#teacherName").append(data.username);
	}
}
// 取消按钮
function cancel(sex,email,tel){
	$("#t-sex").html(sex);
	$("#t-email").html(email);
	$("#t-tel").html(tel);
	$("#btn-modify-infos").show();
	$("#btn-cancel").remove();
	$("#btn-submit").remove();
}

function checkSex(sexObj){
	var sex = sexObj.val();
	console.log(sex);
	if(sex=="男" || sex=="女")
		return true;
	else
		return false;
}
function checkTel(telObj){
	var tel = telObj.val();
	var zhengze = /^0?(13|14|15|18|17)[0-9]{9}$/;
	
	if(zhengze.test(tel)){
		return true;
	}else{
		return false;
	}
	
}
function checkEmail(emailObj){
	var email = emailObj.val();
	var zhengze = /^\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}$/;
	console.log(email);
	if(zhengze.test(email)){
		return true;
	}else{
		return false;
	}
}
window.onload = function(){
	var uid;
	$.ajax({
	    type: 'HEAD', // 获取头信息，type=HEAD即可
	    url : window.location.href,
	    //url:"http://device.qq.com/cgi-bin/device_cgi/remote_bind_get_Verify",
	    complete: function( xhr,data ){
	        // 获取相关Http Response header
	        console.log(xhr.getAllResponseHeaders());
	        uid = xhr.getResponseHeader("uid");
	        
	        getInfo(uid);
	    }
	});
	var checkResult1 = true;
	var checkResult2 = true;
	var checkResult3 = true;
	/**
	 * 修改个人信息相关js
	 */	
	$("#btn-modify-infos").on('click',function(){
		var sex = $("#t-sex").text();
		var email = $("#t-email").text();
		var tel = $("#t-tel").text();
		console.log(sex);
		$("#t-sex").html("<input type='text' id='new-sex' class='form-control' placeholder='Gender' value='"+sex+"'>");
		$("#t-email").html("<input type='text' id='new-email' class='form-control' placeholder='E-mail' value='"+email+"'>");
		$("#t-tel").html("<input type='text' id='new-tel' class='form-control' placeholder='Tel' value='"+tel+"'>");
		console.log($("#new-sex").val());
		$("#btn-modify-infos").hide();
		$("#option-btns").append("<button class='btn btn-sm btn-danger' id='btn-cancel'>取消</button>");
		$("#option-btns").append("<button class='btn btn-sm btn-primary' id='btn-submit'>确定</button>");
		$("#btn-cancel").attr("onclick","cancel('"+sex+"','"+email+"','"+tel+"')");
		
		$("#new-sex").on("blur",function(){
			
			if(!checkSex($(this))){
				checkResult1 = false;
				$(this).css('border-color',"red");
				openMsgModal("性别只能在{'男','女'}中选择");
			}else{
				checkResult1 = true;
				$(this).css('border-color',"#ccc");
			}
		});
		$("#new-tel").on("blur",function(){
			
			if(!checkTel($(this))){
				checkResult2 = false;
				$(this).css('border-color',"red");
				openMsgModal("手机号格式不正确");
			}else{
				checkResult2 = true;
				$(this).css('border-color',"#ccc");
			}
		});
		$("#new-email").on("blur",function(){
			
			if(!checkEmail($(this))){
				checkResult3 = false;
				$(this).css('border-color',"red");
				openMsgModal("邮箱格式不正确");
			}else{
				checkResult3 = true;
				$(this).css('border-color',"#ccc");
			}
		});
		/*if(checkResult1 && checkResult2 &&checkResult3){
			$("#option-btns").append("<button class='btn btn-sm btn-primary' id='btn-submit'>确定</button>");
		}else{
			console.log("test");
			$("#btn-submit").remove();
		}*/
		$("#btn-submit").on('click',function(){
			console.log(checkResult1+checkResult2+checkResult3);
			if(checkResult1 && checkResult2 && checkResult3){
				openLoading();
				$.ajax({
					type : "POST",
					url : "modifyInfo",
					data : {
						sex : $("#new-sex").val(),
						email : $("#new-email").val(),
						tel : $("#new-tel").val()
					},
					success : function(result){
						closeLoading();
						if(result.status){
							openMsgModal(result.message);
							$("#t-sex").html(result.data.sex);
							$("#t-email").html(result.data.email);
							$("#t-tel").html(result.data.tel);
							$("#btn-modify-infos").show();
							$("#btn-cancel").remove();
							$("#btn-submit").remove();
						}else{
							openMsgModal(result.message);
						}
					}
				});
			}else{
				openMsgModal("请修改信息的格式");
			}
		});
	});
	
	
	
	/**
	 * 修改密码相关js
	 */	
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
					$("#psw-ok").removeAttr("disabled");
				}else{
					$("#p-old").show();
					$("#p-old").html(result.message);
					$("#old-password").css("border-color","red");
					$("#psw-ok").attr("disabled","disabled");
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
			$("#psw-ok").attr("disabled","disabled");
		}else{
			if(text.length>16||text.length<6){
				$("#new-password").css("border-color","red");
				$("#p-new").show();
				$("#p-new").html("密码长度的必须在6-15之间");
				$("#psw-ok").attr("disabled","disabled");
			}else{
				if(!zhengze.test(text)){
					$("#new-password").css("border-color","red");
					$("#p-new").show();
					$("#p-new").html("密码只能包含数字、字母和下划线");
					$("#psw-ok").attr("disabled","disabled");
				}else{
					$("#p-new").hide();
					$("#new-password").css("border-color","#ccc");
					$("#psw-ok").removeAttr("disabled");
				}
			}
		}
	});
	
	$("#new-password-check").on('blur',function(){
		var psw = $("#new-password").val();
		var old = $("#old-password").val();
		console.log(old.length);
		var check = $(this).val();
		
		if(check==psw){
			$("#p-new-check").hide();
			$("#new-password-check").css("border-color","#ccc");
			$("#psw-ok").removeAttr("disabled");
			if(old.length==0){
				$("#p-new-check").show();
				$("#psw-ok").attr("disabled","disabled");
				$("#old-password").css("border-color","red");
			}else{
				$("#old-password").css("border-color","#ccc");
				$("#psw-ok").removeAttr("disabled")
			}
		}else{
			$("#new-password-check").css("border-color","red");
			$("#p-new-check").html("密码不一致");
			$("#p-new-check").show();
			$("#psw-ok").attr("disabled","disabled");
		}
		
	});
	$("#psw-ok").on('click',function(){
		openLoading();
		var psw = $("#new-password").val();;
		$.ajax({
			type : "POST",
			url : "changePsw",
			data : {
				"new" : psw
			},
			success : function(result){
				closeLoading();
				if(result.status){
					openMsgModal(result.message+"。请重新登录！");
					$(location).attr('href', '../teacherEntry.html');
				}else{
					openMsgModal(result.message);
				}
			}
			
		})
	})
	
}