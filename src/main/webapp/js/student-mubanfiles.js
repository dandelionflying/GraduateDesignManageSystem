function timeFormatter(value) {
    if(value){
    	var da = new Date(parseInt((value.toString()).replace("/Date(", "").replace(")/" , "").split( "+")[0]));
    	return da.getFullYear() + "-" + (da.getMonth() + 1) + "-" + da.getDate() + " " + da.getHours() + ":" + da.getMinutes() + ":" + da.getSeconds();
    }
}

//发送模板文件分页请求
function getFilePage(index,size){
	$.ajax({
		type : "GET",
		url : "get-muban-file-student/"+index+"/"+size,
		success : function(result){
			changePage(result,index,size);
		}
	});
}
function changePage(result,index,size){
	if(result.total>0){
		var tbody = $("#muban-file-body");
		tbody.empty();
		$.each(result.rows,function(i,item){
			var time = timeFormatter(item.uploadTime);
			tbody.append($("<tr>" +
					"<td>"+item.name+"</td>" +
					"<td>"+time+"</td>" +
					"<td><a class='btn btn-info btn-xs' href='download?id="+item.id+"' role='button'><i class=''></i> 下载 </a></td></tr>"));
		});
	}
	var $ul = $("#mubanfile-pagination");
	$ul.empty();
	var $leftli;
	if(index==0)
		$leftli = $("<li class='disabled'>" +
				"<a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
	else
		$leftli = $("<li onclick='getFilePage("+(index-1)+","+size+")'><a href='javascript:;' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
	$ul.append($leftli);
	for(var i = 1; i<=result.total; i++){
		var $li ;
		if((index+1)==i)
			$li =  $("<li class='active'><a href='javascript:;'>"+i+"</a></li>");
		else
			$li =  $("<li onclick='getFilePage("+(i-1)+","+size+")'><a href='javascript:;'>"+i+"</a></li>");
		$ul.append($li);
	}
	var $rightli;
	if(index==(result.total-1))
		$rightli = $("<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
	else
		$rightli = $("<li onclick='getFilePage("+(index+1)+","+size+")'><a href='javascript:;' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
	$ul.append($rightli);
}
window.onload = function(){
	getFilePage(0,10);
}