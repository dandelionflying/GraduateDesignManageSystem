function changepage(i){
	$.ajax({
		type 	: "GET",
		url 	: "getteacher/"+i+"/5",
		success : function(data){
			console.log(data);
			var index = data.index;
			var result = data.data;
			var pages = data.pages;
			var tbody = $(".teacher-tbody");
			tbody.empty();
			$.each(result,function(i,item){
				var tr = $("<tr></tr>");
				var td1 = $("<td>"+item.id+"</td>");
				var td2 = $("<td>"+item.username+"</td>");
				var td3 = $("<td class='am-hide-sm-only'>信息科学与工程学院</td>");
				var td4 = $("<td class='am-hide-sm-only'>"+item.rank+"</td>");
				var td5 = $("<td class='am-hide-sm-only'>"+item.tel+"</td>");
				var td6 = $("<td class='am-hide-sm-only'>"+item.email+"</td>");
				var td7 = $("<td id='item-role-"+i+"'>" +
						"<p id='item-role-p-"+i+"'>"+item.identity+"</p> <button id='modify-btn-"+i+"' class='am-btn am-btn-default am-text-success am-btn-round am-btn-xs'>修改</button>" +
								"<button id='item-role-ok-"+i+"' class='am-btn am-btn-default am-text-success am-btn-round am-btn-xs' style='display:none'>提交</button>" +
								"<button id='item-role-cancel-"+i+"' class='am-btn am-btn-default am-text-danger am-btn-round am-btn-xs' style='display:none'>取消</button>" +
								"</td>");
				tr.append(td1);
				tr.append(td2);
				tr.append(td3);
				tr.append(td4);
				tr.append(td5);
				tr.append(td6);
				tr.append(td7);
				tbody.append(tr);
				$("#modify-btn-"+i).attr('onclick',"showInput('"+item.id+"',"+i+",'"+item.identity+"')");
				
			});
			var pageul = $("#pagination-id");
			pageul.empty();
			if(index==0){
				var lileft = $("<li class='am-disabled'><a href='#'>«</a></li>");
			}else{
				var lileft = $("<li onclick='changepage("+(index-1)+")'><a href='javascript:;'>«</a></li>");
			}
			pageul.append(lileft);
			for(var i=1;i<=pages;i++){
				if((index+1)==i){
					pageul.append($("<li class='am-active am-disabled'><a href='#'>"+i+"</a></li>"));
				}else{
					pageul.append($("<li onclick='changepage("+(i-1)+")'><a href='javascript:;'>"+i+"</a></li>"));
				}
				
			}
			if(index==(pages-1))
				var liright = $("<li class='am-disabled'><a href='#'>»</a></li>");
			else
				var liright = $("<li onclick='changepage("+(index+1)+")'><a href='javascript:;'>»</a></li>");
			pageul.append(liright);
		}
		
	});
}
/* */
function cancel(identity,i,uid){
	var $roletd = $("#item-role-"+i);
	var $p = $("#item-role-p-"+i);
	$p.html(identity);
	$("#item-role-ok-"+i).hide();
	$("#item-role-cancel-"+i).hide();
	$("#new-role-"+i).hide();
	$("#modify-btn-"+i).show();
}
/*
 * 显示输入框*/
function showInput(uid,i,identity){
	var $roletd = $("#item-role-"+i);
	var p = $("#item-role-p-"+i);
	$("#modify-btn-"+i).hide();
	p.empty();
	p.html("<input type='text' id='new-role-"+i+"' class='form-control' placeholder='输入角色名' value='"+identity+"'>");
	
	var $btnsubmit = $("#item-role-ok-"+i);
	var $btncancel = $("#item-role-cancel-"+i);
	$btnsubmit.show();
	$btncancel.show();
	
	$("#new-role-"+i).on('blur',function(){
		if($(this).val()=="普通教师" || $(this).val()=="评阅教师" || $(this).val()=="答辩评审员"){
			$btnsubmit.removeAttr("disabled","disabled");
			$(this).css("border-color","#ccc");
			
		}else{
			$(this).css("border-color","red");
			$btnsubmit.attr("disabled","disabled");
			alert("教师角色只能在‘评阅教师’、‘指导教师’和‘答辩评审员’之中选择");
		}
	})
	$btncancel.on('click',function(){
		cancel(identity,i,uid);
	});
	$btnsubmit.on('click',function(){
		var role = $("#new-role-"+i).val();
		changeRole(uid,i,role);
	});
}
function changeRole(uid,i,role){
	$.ajax({
		type : "POST",
		url : "updateTeacherRole",
		data : {
			"uid" : uid,
			"rolename" : role
		},
		success : function(result){
			if(!result.status){
				alert(result.message);
			}else{
				alert(result.message);
				cancel(role,i,uid);
			}
		}
	})
}
window.onload = function(){
	
	changepage(0);
	$("#add-teacher-btn").on("click",function(){
		$("#add-teacher-modal").modal("open");
	});
	$("#commit-excel").on('click',function(){
		var fileDir = $("#newteachers").val();  
	    var suffix = fileDir.substr(fileDir.lastIndexOf("."));  
	    if("" == fileDir){  
	        $("#warning-msg").html("选择需要导入的Excel文件！");
	    }else if(".xls" != suffix && ".xlsx" != suffix ){  
	        $("#warning-msg").html("选择Excel格式的文件导入！");
	    }else{
	    	var formData = new FormData();
	    	formData.append("file",$("#newteachers")[0].files[0]);
	    	$.ajax({
	    		type : "POST",
	    		url : "add-teachers",
	    		data : formData,
	    		contentType: false,
	    		processData: false,
	    		success : function(result){
	    			if(result.status){
	    				alert(result.message);
	    				window.location.reload();
	    			}else{
	    				alert(result.message);
	    			}
	    		}
	    	});
	    }
		
	});
}