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
				var td3 = $("<td class='am-hide-sm-only'>"+item.deptId+"</td>");
				var td4 = $("<td class='am-hide-sm-only'>"+item.rank+"</td>");
				var td5 = $("<td class='am-hide-sm-only'>"+item.tel+"</td>");
				var td6 = $("<td class='am-hide-sm-only'>"+item.email+"</td>");
				var td7 = $("<td></td>");
				tr.append(td1);
				tr.append(td2);
				tr.append(td3);
				tr.append(td4);
				tr.append(td5);
				tr.append(td6);
				tr.append(td7);
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
}