function getGrades(index,size){
	$.ajax({
		type : "get",
		url : "getGradePage/"+index+"/"+size,
		success : function(result){
			changePage(result,index,size);
		}
	});
}
function changePage(result,index,size){
	if(result.total==0){
		
	}else{
		var pages = result.total;
		var rows = result.rows;
		$(".grade-body").empty();
		$.each(rows,function(i,item){
			var $tr = $("<tr class=''>" +
					"<td class='' id=''>"+item.uId+"</td>" +
					"<td class='' id=''>"+item.username+"</td>" +
					"<td class='' id=''>"+item.className+"</td>" +
					"<td class='' id=''>"+item.translate+"</td>" +
					"<td class='' id=''>"+item.evaluation+"</td>" +
					"<td class='' id=''>"+item.guider+"</td>" +
					"<td class='' id=''>"+item.answer+"</td>" +
					"<td class='' id=''>"+item.result+"</td>" +
					"</tr>");
			$(".grade-body").append($tr);
		})
		
		var pageul = $("#grades-ul");
		pageul.empty();
		if(index==0){
			var lileft = $("<li class='am-disabled'><a href='#'>«</a></li>");
		}else{
			var lileft = $("<li onclick='getGrades("+(index-1)+","+size+")'><a href='javascript:;'>«</a></li>");
		}
		pageul.append(lileft);
		for(var i = 1; i <= pages; i++){
			if((index+1)==i){
				pageul.append($("<li class='am-active am-disabled'><a href='#'>"+i+"</a></li>"));
			}else{s
				pageul.append($("<li onclick='getGrades("+(i-1)+","+size+")'><a href='javascript:;'>"+i+"</a></li>"));
			}
		}
		if(index==(pages-1))
			var liright = $("<li class='am-disabled'><a href='#'>»</a></li>");
		else
			var liright = $("<li onclick='getGrades("+(index+1)+","+size+")'><a href='javascript:;'>»</a></li>");
		pageul.append(liright);
	}
}
window.onload = function(){
	getGrades(0,5);
}