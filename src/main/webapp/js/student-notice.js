function getNotice(uid,index,size){
	$.ajax({
		type : "GET",
		url : "getNotices/1/"+index+"/"+size,
		success : function(result){
			changePage(uid,result,index,size);
		}
	
	})
}
function changePage(uid,result,index,size){
	var $group = $("#notice-group");
	$group.empty();
	if(result.total>0){
		$.each(result.rows,function(i,item){
			$item = $("<li class='list-group-item' >" +
					"<a class='notice-li-a' role='button' onclick='show("+uid+","+item.id+","+i+")'>"+item.content+"</a></li>" +
					"<div class='alert alert-info alert-dismissible' role='alert' id='alert-"+i+"' hidden>" +
					"<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>" +
					"<strong>详情</strong> " + item.content +
					"</div>");
			$group.append($item);
		});
		
		var $pagination = $("#notice-pagination");
		$pagination.empty();
		if(index==0){
			$leftli = $("<li class='disabled'><a href='#' aria-label='Previous' ><span aria-hidden='true'>&laquo;</span></a></li>");
		}else{
			$leftli = $("<li onclick='getNotice("+uid+","+(index-1)+","+size+")'><a href='#' aria-label='Previous' ><span aria-hidden='true'>&laquo;</span></a></li>");
		}
		$pagination.append($leftli);
		var pages = result.total;
		for(var i=1; i<=pages; i++){
			if(index==(i-1))
				$li = $("<li class='active'><a href='#'>"+i+"</a></li>");
			else
				$li = $("<li onclick='getNotice("+uid+","+(i-1)+","+size+")'><a href='#'>"+i+"</a></li>");
			$pagination.append($li);
		};
		var $rightli;
		if(index==(pages-1))
			$rightli = $("<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		else
			$rightli = $("<li onclick='getNotice("+uid+","+(i-1)+","+size+")'><a href='javascript:;' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		$pagination.append($rightli);		
			
		
	}else
		$group.append("没有通知");
}
//显示弹框（消息详情）
function show(uid,noticeid,i){
	$("#alert-"+i).show();
	//设为已读
	changeUserNoticeState(uid,noticeid);
}
//设为已读
function changeUserNoticeState(uid,noticeid){
	$.ajax({
		type : "POST",
		url : "changeUserNoticeState",
		data : {
			"uid" : uid,
			"noticeid" : noticeid
		},
		success : function(result){
			
		}
	});
}
window.onload = function(){
	var uid;
	$.ajax({
	    type: 'HEAD', // 获取头信息，type=HEAD即可
	    url : window.location.href,
	    complete: function( xhr,data ){
	        // 获取相关Http Response header
	        var wpoInfo = {
	            // 服务器端时间
	            "date" : xhr.getResponseHeader('Date'),
	            // 如果开启了gzip，会返回这个东西
	            "contentEncoding" : xhr.getResponseHeader('Content-Encoding'),
	            // keep-alive ？ close？
	            "connection" : xhr.getResponseHeader('Connection'),
	            // 响应长度
	            "contentLength" : xhr.getResponseHeader('content-length'),
	            // 服务器类型，apache？lighttpd？
	            "server" : xhr.getResponseHeader('Server'),
	            "vary" : xhr.getResponseHeader('Vary'),
	            "transferEncoding" : xhr.getResponseHeader('Transfer-Encoding'),
	            // text/html ? text/xml?
	            "contentType" : xhr.getResponseHeader('Content-Type'),
	            "cacheControl" : xhr.getResponseHeader('Cache-Control'),
	            // 生命周期？
	            "exprires" : xhr.getResponseHeader('Exprires'),
	            "lastModified" : xhr.getResponseHeader('Last-Modified')
	        };
	        console.log(xhr.getAllResponseHeaders());
	        uid = xhr.getResponseHeader("uid");
	        
	        getNotice(uid,0,10);
	    }
	});
	
}