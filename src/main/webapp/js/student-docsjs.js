function downloadFile(docId){
	$.get("download.action",{
		id : docId
	},function(data){
		
	});
}
function show_or_hide(id){
	$(".docdiv").hide(1000);
	$("#docdiv"+id).show(1000);
}
function changelabel(li){
	$(".type-label").text(li);
}
window.onload = function() {
	
	$.ajax({
		type : "get",
		url : "fileclassify/fileclassify.action",
		conentType : "application/json",
		success : function(data){
			var parent = $("#file-classify-menu");
			var dropdown = $(".dropdown-menu");
			$.each(data,function(i,item){
				parent.append($("<li class='leftli' id='leftli"+item.id+"' onclick='show_or_hide("+item.id+")'><a href='javascript:void(0)'>"+item.name+"</a></li>"));
				dropdown.append($("<li role='presentation' id='classify"
						+item.id+"'><a id='classify-a"
						+item.id
						+"' role='menuitem' tabindex='-1' href='javascript:void(0)'>"
						+item.name+"</a></li>"));
			});
		}
	});
	$.ajax({
		type :"get",
		url : "file/mydocument",
		contentType : "application/json",
		success : function(data){
			console.log(data);
			var parent = $(".docdivs");
			$.each(data,function(i,item){
				
				
				
			});
		}
	});
	$("#classify1").click(function(){
		console.log($("#classify-a1").text());
		$(".type-label").text($("#classify-a1").text());
	});
	
	$("#classify2").click(function(){
		$(".type-label").text($("#classify-a2").text());
	});
	$("#classify3").click(function(){
		$(".type-label").text($("#classify-a3").text());
	});
	$("#classify4").click(function(){
		$(".type-label").text($("#classify-a4").text());
	});
	$("#classify5").click(function(){
		$(".type-label").text($("#classify-a5").text());
	});
	$("#classify6").click(function(){
		$(".type-label").text($("#classify-a6").text());
	});
	$("#classify7").click(function(){
		$(".type-label").text($("#classify-a7").text());
	});
	$("#open-upload-modal").click(function(){
		docType=$("#doc-type").text();
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