window.onload = function() {
		
		$("#leftli1").click(function() {
			$(".docdiv").hide(1000);
			$("#docdiv1").show(1000);
		});
		$("#leftli2").click(function() {
			$(".docdiv").hide(1000);
			$("#docdiv2").show(1000);
		});
		$("#leftli3").click(function() {
			$(".docdiv").hide(1000);
			$("#docdiv3").show(1000);
		});
		$("#leftli4").click(function() {
			$(".docdiv").hide(1000);
			$("#docdiv4").show(1000);
		});

		$("#leftli5").click(function() {
			$(".docdiv").hide(1000);
			$("#docdiv5").show(1000);
		});

		$("#leftli6").click(function() {
			$(".docdiv").hide(1000);
			$("#docdiv6").show(1000);
		});

		$("#type0").click(function(){
			$(".type-label").text($("#type-a0").text());
		});
		
		$("#type2").click(function(){
			$(".type-label").text($("#type-a2").text());
		});
		$("#type3").click(function(){
			$(".type-label").text($("#type-a3").text());
		});
		$("#type4").click(function(){
			$(".type-label").text($("#type-a4").text());
		});
		$("#type5").click(function(){
			$(".type-label").text($("#type-a5").text());
		});
		$("#type6").click(function(){
			$(".type-label").text($("#type-a6").text());
		});
		$("#type7").click(function(){
			$(".type-label").text($("#type-a7").text());
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