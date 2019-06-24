window.onload = function() {
	var uid;
	$.ajax({
	    type: 'HEAD', // 获取头信息，type=HEAD即可
	    url : window.location.href,
	    complete: function( xhr,data ){
	        // 获取相关Http Response header
	        var Info = {
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
	        
	        getAllStudents(uid);
	    }
	});
	
}
function jumpto(){
	window.location.href = "studentschedule";
}
function showdetail(i){
	$(".detail-table").hide();
	$("#detail"+i).show();
}
function getAllStudents(uid){
	$.ajax({
		type : "POST",
		url : "getStudents",
		data : {
			"uid" : uid
		},
		success : function(result){
			showStudents(result);
		}
	});
}
function showStudents(result){
	var $rows = $("#students");
	if(result.status){
		var data = result.data;
		var $detail = $(".detail");
		$.each(data,function(i,item){
			var $div = $("<div class='col-md-3 col-sm-6 col-xs-12'>" +
					"<div class='main-box stu-wheat3' onclick='showdetail("+i+")' >" +
					"<a href='javascript:void(0)'> <i class='fa fa-github-alt fa-5x'></i>" +
					"<h5>"+item.username+"</h5>" +
					"</a>" +
					"</div>" +
						"</div>");
			$rows.append($div);
			
			$table = $("<table class='table table-striped detail-table' id='detail"+i+"'>" +
					"<thead><tr class='active info'>" +
					"<th>学号</th><th>姓名</th><th>班级</th><th>专业</th><th>课题名称</th><th>进度</th><th>操作</th></tr>" +
					"</thead>" +
					"<tbody class='stu-msg-tbody'>" +
					"<tr><td id='stu-topic-msg-"+i+"'>"+item.id+"</td>" +
					"<td id=''>"+item.username+"</td>" +
					"<td id=''>"+item.className+"</td>" +
					"<td id=''>"+item.mayor+"</td>" +
					"<td id=''>"+item.topicName+"</td>" +
					"<td id=''></td>" +
					"<td><button class='btn btn-xs btn-default show-detail' onclick='jumpto()'>查看</button>" +
					"<button class='btn btn-xs btn-default addPingjiaBiao' id='addPingjiaBiao"+i+"' data-toggle='modal' data-target='#upload-doc'>上传评价表</button></td>" +
					"</tr>" +
					"</tbody>" +
					"</table>");
			$detail.append($table);
			$("#addPingjiaBiao"+i).attr('onclick',"btnaction('"+item.id+"')");
			
		});
	}else{
		$rows.append(result.message);
	}
}
function btnaction(stuid){
	$('#upload-file').fileinput({//初始化上传文件框
		//showUpload : false,
		//showRemove : false,
		uploadAsync : true,
		//uploadLabel : "上传",//设置上传按钮的汉字
		//uploadClass : "btn btn-primary",//设置上传按钮样式
		//showCaption : false,//是否显示标题
		language : "zh",//配置语言
		uploadUrl : "uploadfile",
		//maxFileSize : 0,
		maxFileCount : 1,/*允许最大上传数，可以多个，当前设置单个*/
		enctype : 'multipart/form-data',
		//allowedPreviewTypes : [ 'image' ], //allowedFileTypes: ['image', 'video', 'flash'],
		allowedFileExtensions : [ "doc","docx" ],/*上传文件格式*/
		//msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		dropZoneTitle : "请通过拖拽文件放到这里",
		dropZoneClickTitle : "或者点击此区域添加文件",
		//dropZoneEnabled : false,
		uploadExtraData: function(){
			var uid = stuid;
			return {uid:uid};
		},//外带数据
		//showBrowse : true,
		browseOnZoneClick : true,
		slugCallback : function(filename) {
			return filename.replace('(', '_').replace(']', '_');
		}
	});
}