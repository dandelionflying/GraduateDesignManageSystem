//分页获取当前教师可评阅的学生的成绩
function getGrades(index,size){
	$.ajax({
		type : "GET",
		url : "getGradesByGuider/"+index+"/"+size,
		success : function(result){
			showGrades(result,index,size);
		}
	});
}
//遍历成绩
function showGrades(result,index,size){
	if(result.total==0){
		$("#evaluation-body").html("没有记录。");
	}else{
		var rows = result.rows;
		var $tbody = $(".evaluation-body");
		$.each(rows,function(i,item){
			var $tr = $("<tr class='warning'>" +
					"<td id='grade-uId-"+item.uId+"'>"+item.uId+"</td>" +
					"<td id='grade-username'>"+item.username+"</td>" +
					"<td id='grade-className'>"+item.className+"</td>" +
					"<td id='grade-translate-"+item.id+"'>"+item.translate+"</td>" +
					"<td id='grade-evaluation-"+item.id+"'>"+item.evaluation+"</td>" +
					"<td id='grade-guider-"+item.id+"'>"+item.guider+"</td>" +
					"<td id='grade-answer'>"+item.answer+"</td>" +
					"<td id='grade-result'>"+item.result+"</td>" +
					"<td id='options-"+item.id+"'><button class='btn btn-default btn-xs' data-toggle='modal' onclick='changehiddenlabel("+item.uId+")' data-target='#upload-doc'>上传评价表</button> " +
					"<button class='btn btn-default btn-xs' id='btn-addgrade' onclick='showFrom("+item.id+")'>给定评阅成绩</button></td>" +
					"</tr>");
			$tbody.append($tr);
			if(item.state==2){
				$("#options-"+item.id).empty();
				$("#options-"+item.id).html("已确认");
			}
		});
		
	}
}
//设置一个隐藏的标签 保存当前点击的行的id
function changehiddenlabel(uid){
	$(".hidden-div").html(uid);
}
function showFrom(id){
	var $gradeGuiderTd = $("#grade-guider-"+id);
	var gradeGuider = $gradeGuiderTd.text();
	var $gradeTransTd = $("#grade-translate-"+id);
	var gradeTrans = $gradeTransTd.text();
	$("#btn-addgrade").hide();
	$gradeGuiderTd.html("<input type='text' id='new-grade-guider' class='form-control' placeholder='grade' value='"+gradeGuider+"'>");
	$gradeTransTd.html("<input type='text' id='new-grade-trans' class='form-control' placeholder='grade' value='"+gradeTrans+"'>");
	
	$("#options-"+id).append(" <button class='btn btn-success btn-xs' id='btn-submit' disabled='disabled'>提交</button> " +
			"<button class='btn btn-danger btn-xs' id='btn-cancel' onclick='cancel("+gradeGuider+","+gradeTrans+","+id+")'>取消</button>");
	
	$("#new-grade-guider").on('blur',function(){
		var grade = $(this).val();
		console.log(grade);
		checkFrom(grade);
	});
	$("#new-grade-trans").on('blur',function(){
		var grade = $(this).val();
		console.log(grade);
		checkFrom(grade);
	});
	
	$("#btn-submit").on('click',function(){
		openLoading();
		var guidergrade = $("#new-grade-guider").val();
		var transgrade = $("#new-grade-trans").val();
		console.log(guidergrade);
		
		$.ajax({
			type : "POST",
			url : "updateGTGrade",
			data : {
				"id" : id,
				"guider" : guidergrade,
				"translate" : transgrade
			},
			success : function(result){
				closeLoading();
				if(result.status){
					openMsgModal(result.message);
					cancel(gradeGuider,gradeTrans,id);
				}else{
					openMsgModal(result.message);
				}
			}
		});
	});
}
function cancel(gradeGuider,gradeTrans,id){
	$("#new-grade-guider").remove();
	$("#new-grade-trans").remove();
	$("#grade-guider-"+id).html(gradeGuider);
	$("#grade-translate-"+id).html(gradeTrans);
	$("#btn-addgrade").show();
	$("#btn-cancel").remove();
	$("#btn-submit").remove();
}
function checkFrom(grade){
	if(grade>=0 && grade<=100){
		$("#btn-submit").removeAttr("disabled","disabled");
		$("#new-grade").css("border-color","#ccc");
	}else{
		$("#new-grade").css("border-color","red");
		$("#btn-submit").attr("disabled","disabled");
		openMsgModal("成绩范围在0-100之间");
	}
}
window.onload = function(){
	getGrades(0,10);
	
	$('#upload-file').fileinput({//初始化上传文件框
		//showUpload : false,
		//showRemove : false,
		uploadAsync : true,
		//uploadLabel : "上传",//设置上传按钮的汉字
		//uploadClass : "btn btn-primary",//设置上传按钮样式
		//showCaption : false,//是否显示标题
		language : "zh",//配置语言
		uploadUrl : "uploadfileEvaluation",
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
			var uid = $(".hidden-div").text();
			return {uid:uid};
		},//外带数据
		//showBrowse : true,
		browseOnZoneClick : true,
		slugCallback : function(filename) {
			return filename.replace('(', '_').replace(']', '_');
		}
	});
}