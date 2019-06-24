

$('#upload-file').fileinput({//初始化上传文件框
	showUpload : true,
	showRemove : false,
	uploadAsync : true,
	//uploadLabel : "上传",//设置上传按钮的汉字
	uploadClass : "btn btn-primary",//设置上传按钮样式
	showCaption : false,//是否显示标题
	language : "zh",//配置语言
	uploadUrl : "uploadfile",
	//maxFileSize : 0,
	//maxFileCount : 1,/*允许最大上传数，可以多个，当前设置单个*/
	enctype : 'multipart/form-data',
	//allowedPreviewTypes : [ 'image' ], //allowedFileTypes: ['image', 'video', 'flash'],
	allowedFileExtensions : [ "jpg", "png", "gif" ],/*上传文件格式*/
	//msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
	dropZoneTitle : "请通过拖拽图片文件放到这里",
	dropZoneClickTitle : "或者点击此区域添加图片",
	//dropZoneEnabled : false,
	//uploadExtraData: {"id": id},//这个是外带数据
	showBrowse : false,
	browseOnZoneClick : true,
	slugCallback : function(filename) {
		return filename.replace('(', '_').replace(']', '_');
	}
});
//上传文件成功，回调函数 
/*$('#upload-file').on("fileuploaded", function(event, data, previewId, index) {
	var result = data.response; //后台返回的json
	//console.log(result.status);
	//console.log(result.id);
	$('#picid').val(result.id);//拿到后台传回来的id，给图片的id赋值序列化表单用
	//如果是上传多张图
	
	//计数标记，用于确保全部图片都上传成功了，再提交表单信息
	var fileCount = $('#file-pic').fileinput('getFilesCount');
	if(fileCount==1){
	$.ajax({//上传文件成功后再保存图片信息
	    url:'BannerPicAction!savaForm.action',
	    data:$('#form1').serialize(),//form表单的值
	    success:function(data,status){
	        ...
	    },
	    cache:false,                    //不缓存
	});
	}
	 
	$.ajax({//上传文件成功后再保存图片信息
		url : 'BannerPicAction!savaForm.action',
		type : 'post',
		dataType : 'json',
		data : $('#form1').serialize(),//form表单的值
		success : function(data, status) {
			if (status == "success") {

				if (data.status == "success") {//提交成功

					//跳转回添加页面

				} else {
					alert("添加失败,编码的错误!");
				}

			} else {
				alert("添加失败,ajax请求返回失败!");
			}
		},
		cache : false, //不缓存
	});
});

$('#savePic').on('click', function() {// 提交图片信息 //
	//先上传文件，然后在回调函数提交表单
	$('#upload-file').fileinput('upload');

});*/