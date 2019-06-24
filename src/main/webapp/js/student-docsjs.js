function downloadFile(docId){
	$.get("download.action",{
		id : docId
	},function(data){
		
	});
}
function changelabel(li){
	$(".type-label").text(li);
}
//发送请求获取文档
function getdocs(id,classify){
	$(".leftli").css("background-color","#303030");
	$("#leftli"+classify).css("background-color","#ffffff");
	$.ajax({
		type :"get",
		url : "mydocument/"+id+"/"+classify,
		contentType : "application/json",
		success : function(result){
			console.log(result);
			//显示文档信息
			appendDataToTable(result,classify);
			
		}
	});
}
//显示文档信息
function appendDataToTable(result,classifyid){
	var $parent = $("#doc-body");
	$parent.empty();
	if(result.status){
		var data = result.data;
		var classify = data.classify;
		var date = timeFormatter(data.createTime);
		var $inner = $("<tr class='success'>" +
				"<td>"+data.docName+"</td>" +
				"<td>"+date+"</td>" +
				"<td>"+classify+"</td>" +
				"<td>"+(data.state==2?'定稿':'已提交')+"</td>" +
				"<td><a class='btn btn-xs btn-info' href='downloadDoc?id="+data.id+"'>查看</a>" +
				"</td>" +
			"</tr>");
		$("#doc-type").html(classify);
		$parent.append($inner);
		if(data.state==2)
			$("#btn-delete").attr("disabled","disabled");
	}else{
		
		$("#doc-type").html(result.data);
		$parent.append("暂无文档");
	}
	
	//如果上一个文档还没审核通过就不能上传本文档
	checkStateString(classifyid);
	
}
//发送请求获取所有文档分类
function getclassify(uid){
	$.ajax({
		type : "get",
		url : "fileclassify.action",
		conentType : "application/json",
		success : function(result){
			//显示分类
			appendLeft(result,uid);
		}
	});
}
//显示分类
function appendLeft(result,uid){
	var parent = $("#file-classify-menu");
	var dropdown = $(".dropdown-menu");
	$.each(result.data,function(i,item){
		parent.append($("<li class='leftli' id='leftli"+item.id+"' onclick='getdocs("+uid+","+(i+1)+")'><a href='javascript:void(0)'>"+item.name+"</a></li>"));
		dropdown.append($("<li role='presentation' id='classify"
				+item.id+"'><a id='classify-a"
				+item.id
				+"' role='menuitem' tabindex='-1' href='javascript:void(0)'>"
				+item.name+"</a></li>"));
	});
}
//获取代表文档状态的数组
function checkStateString(classifyid){
	
	$.ajax({
		type : "GET",
		url : "getStates",
		success : function(result){
			console.log(classifyid);
			if(!result.status){
				$(".open-upload-modal").attr("disabled","disabled");
			}else{
				var states = result.data;
				if(classifyid>1){
					
					if(states[classifyid-2]!=2){
						$(".open-upload-modal").attr("disabled","disabled");
					}else{
						if(states[classifyid-1]!=2){
							$(".open-upload-modal").removeAttr("disabled");
						}
					}
				}else{
					if(states[0]==2){
						$(".open-upload-modal").attr("disabled","disabled");
					}else{
						
						$(".open-upload-modal").removeAttr("disabled");
					}
				}
			}
			
		}
	});
}

window.onload = function() {
	var uid;
	$.ajax({
	    type: 'HEAD', // 获取头信息，type=HEAD即可
	    url : window.location.href,
	    complete: function( xhr,data ){
	        // 获取相关Http Response header
	        console.log(xhr.getAllResponseHeaders());
	        uid = xhr.getResponseHeader("uid");
	        
	        getdocs(uid,1);
	        getclassify(uid);
	    }
	});
	
	
	$("#open-upload-modal").click(function(){
		docType=$("#doc-type").text();
		$("#upload-doc").on('hidden.bs.modal',function(){
			getdocs(uid,docType);
		});
	});
	
	
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
			var classify=$("#doc-type").text();
			return {classify:classify};
		},//外带数据
		//showBrowse : true,
		browseOnZoneClick : true,
		slugCallback : function(filename) {
			return filename.replace('(', '_').replace(']', '_');
		}
	});
}