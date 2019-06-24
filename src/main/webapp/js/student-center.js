//获取新通知 
function getNewNotice(uid,count){
	 $.ajax({
		 type : "POST",
		 url : "getNewNotice",
		 data : {
			 "uid" : uid,
			 "count" : count
		 },
		 success : function(result){
			 
			 appendNotices(uid,result);
		 }
	 });
 }
//重新加载局部页面
 function appendNotices(uid,result){
	 if(result.status){
		 $("#count-of-new").html(result.data.length);
		 var $group = $("#new-notice-group");
		 if(result.code==20000){
			 $.each(result.data,function(i,item){
				 $group.append("<li class='list-group-item' >" +
				 		"<a class='notice-li-a' role='button' onclick='show("+uid+","+item.id+","+i+")'>"+item.content+"</a>" +
				 		"</li>" +
				 		"<div class='alert alert-info alert-dismissible' role='alert' id='alert-"+i+"' hidden>" +
				 		"<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>" +
				 		"<strong>详情</strong> " + item.content + 
				 		"</div>");
				 
			 });
		 }else if(result.code==20006){
			 $group.append("没有新通知")
		 }
	 }else{
		 //出错
	 }
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
	    //url:"http://device.qq.com/cgi-bin/device_cgi/remote_bind_get_Verify",
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
	        
	        getNewNotice(uid,5);
	    }
	});
}