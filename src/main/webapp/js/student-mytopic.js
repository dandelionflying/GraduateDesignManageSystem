function getclassify(uid){
	$.ajax({
		type : "get",
		url : "proccess",
		data : {
			"uid" : uid
		},
		conentType : "application/json",
		success : function(result){
			console.log(result);
			if(result.status)
				appendtable(result.data);
			else{
				
			}
			
		}
	});
}
function appendhtml(result){
	if(result.status){
		var data = result.data;
		$("#topic-name").html(data.topicName);
		$("#topic-id").html(data.id);
		$("#teacher").html(data.teacherName);
		$("#topic-content").html(data.content);
	}else{
		$(".mytopic").html("<p>尚未选题。</p>");;
	}
}
function appendtable(data){
	var $body = $("#state-classify");
	$.each(data,function(i,item){
		var $tr = $("<tr><td>"+item.classify+"</td><td id='state-"+(i+1)+"'></td></tr>");
		$body.append($tr);
		if(item.state==2)
			$("#state-"+(i+1)).append($("<label class='label label-success'>已完成</label>"));
		else if(item.state==1)
			$("#state-"+(i+1)).append($("<label class='label label-info'>进行中</label>"));
		else
			$("#state-"+(i+1)).append("");
			
	});
}
//请求个人课题
function getMytopic(uid){
	$.ajax({
		type : "GET",
		url : "getMyTopic",
		data : {
			"uid" : uid
		},
		success : function(result){
			appendhtml(result);
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
	        
	        getMytopic(uid);
	        getclassify(uid);
	    }
	});
}