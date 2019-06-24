function changepage(currentpage,size){
	$.ajax({
		type:"get",
		url:"getall/"+currentpage+"/"+size,
		success:function(data){
			console.log(data);
			var result = data.result;
			var index = data.index;
			var pages = data.pages;
			var tbody = $(".st-tbody");
			tbody.empty();
			$.each(result,function(i,item){
				var tr = $("<tr></tr>");
				var td1 = $("<td>"+item.id+"</td>");
				var td2 = $("<td>"+item.topicId+"</td>");
				var td3 = $("<td>"+item.topicName+"</td>");
				var td4 = $("<td>"+item.sId+"</td>");
				var td5 = $("<td>"+item.studentName+"</td>");
				var td6 = $("<td>"+item.teacherName+"</td>");
				tr.append(td1);
				tr.append(td2);
				tr.append(td3);
				tr.append(td4);
				tr.append(td5);
				tr.append(td6);
				tbody.append(tr);
			});
			var pageul = $("#st-ul");
			pageul.empty();
			if(index==0){
				var lileft = $("<li class='am-disabled'><a href='#'>«</a></li>");
			}else{
				var lileft = $("<li onclick='changepage("+(index-1)+","+size+")'><a href='javascript:;'>«</a></li>");
			}
			pageul.append(lileft);
			for(var i = 1; i <= pages; i++){
				if((index+1)==i){
					pageul.append($("<li class='am-active am-disabled'><a href='#'>"+i+"</a></li>"));
				}else{
					pageul.append($("<li onclick='changepage("+(i-1)+","+size+")'><a href='javascript:;'>"+i+"</a></li>"));
				}
			}
			if(index==(pages-1))
				var liright = $("<li class='am-disabled'><a href='#'>»</a></li>");
			else
				var liright = $("<li onclick='changepage("+(index+1)+","+size+")'><a href='javascript:;'>»</a></li>");
			pageul.append(liright);
		}
	});
}
window.onload = function(){
	//获取学生选题信息
	changepage(0,10);
	$("#goback").hide();
	
	$("#searchst").on("click",function(){
		var key = $("#key").val();
		$.ajax({
			type : "POST",
			url : "searchst",
			data : {
				"key" : key
			},
			success : function(data){
				$("#goback").show();
				$("#st-ul").empty();
				
				var tbody = $(".st-tbody");
				tbody.empty();
				$.each(data,function(i,item){
					var tr = $("<tr></tr>");
					var td1 = $("<td>"+data[i].id+"</td>");
					var td2 = $("<td>"+data[i].topicId+"</td>");
					var td3 = $("<td>"+data[i].topicName+"</td>");
					var td4 = $("<td>"+data[i].sId+"</td>");
					var td5 = $("<td>"+data[i].studentName+"</td>");
					var td6 = $("<td>"+data[i].teacherName+"</td>");
					tr.append(td1);
					tr.append(td2);
					tr.append(td3);
					tr.append(td4);
					tr.append(td5);
					tr.append(td6);
					tbody.append(tr);
				});
			}
		});
	})
	
	$("#goback").on('click',function(){
		changepage(0,10);
		$(this).hide();
	})
};