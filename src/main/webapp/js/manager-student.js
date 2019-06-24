function changepage(currentpage){
	$.ajax({
		type : "GET",
		url	: "getstudent/"+currentpage+"/5",
		success : function(data){
			var index = data.index;
			var pages = data.pages;
			var result = data.data;
			var tbody = $(".student-tbody");
			tbody.empty();
			$.each(result,function(i,item){
				var tr = $("<tr></tr>");
				var td1 = $("<td>"+item.id+"</td>");
				var td2 = $("<td>"+item.username+"</td>");
				var td3 = $("<td class='am-hide-sm-only'>"+item.deptId+"</td>");
				var td4 = $("<td class='am-hide-sm-only'>"+item.enterYear+"</td>");
				var td5 = $("<td class='am-hide-sm-only'>"+item.className+"</td>");
				var td6 = $("<td class='am-hide-sm-only'>"+item.tel+"</td>");
				var td7 = $("<td class='am-hide-sm-only'>"+item.email+"</td>");
				var td8 = $("<td></td>");
				tr.append(td1);
				tr.append(td2);
				tr.append(td3);
				tr.append(td4);
				tr.append(td5);
				tr.append(td6);
				tr.append(td7);
				tr.append(td8);
				tbody.append(tr);
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
window.onload = function(){
	changepage(0);
	$("#add-student-btn").on("click",function(){
		$("#add-student-modal").modal("open");
	});
	$("#commit-excel").on('click',function(){
		var fileDir = $("#newstudents").val();  
	    var suffix = fileDir.substr(fileDir.lastIndexOf("."));  
	    if("" == fileDir){  
	        $("#warning-msg").html("选择需要导入的Excel文件！");
	    }else if(".xls" != suffix && ".xlsx" != suffix ){  
	        $("#warning-msg").html("选择Excel格式的文件导入！");
	    }else{
	    	var formData = new FormData();
	    	formData.append("file",$("#newstudents")[0].files[0]);
	    	$.ajax({
	    		type : "POST",
	    		url : "add-students",
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