$(function() {
	
	$("#add-muban-file-btn").on("click",function(){
		$("#add-muban-modal").modal("open");
	});
	var upload=$('#event').AmazeuiUpload({
		url : 'add-muban-file', 
		downloadUrl :'get-muban-file', 
		maxFiles: 50, // 单次上传的数量 
		maxFileSize: 10, // 单个文件允许的大小 (M) 
		multiThreading: false, // true为同时上传false为队列上传 
		useDefTemplate: true, //是否使用表格模式 
		dropType: false, //是否允许拖拽 
		pasteType: false //是否允许粘贴 
	}); 
	/*upload.setResult(upload.selectResult());*/
	/*upload.destory(); //对象销毁 
	upload.init(); //对象初始化 
	upload.setResult(); //置入已上传的对象 
	upload.selectResult(); //获取当前已经完成上传的对象
*/	
	
});
function getFilePage(index,size){
	$.ajax({
		type : "GET",
		url : "get-muban-file-all/"+index+"/"+size,
		success : function(result){
			changePage(result,index,size);
		}
	});
}
function deletemubanfile(id){
	$.ajax({
		type : "POST",
		url : "deleteMubanFile",
		data : {
			"id" : id
		},
		success : function(result){
			if(result.status==true)
				getFilePage(0,5);
			else{
				alert("出现错误");
			}
		}
	})
}
function downloadById(id){
	var form = $("<form>");
	form.attr("enctype","multipart/form-data");
	form.attr("style","display:none");
	form.attr("method","get");
	form.attr("action","get-muban-file");
	var input1 = $("<input>");
	input1.attr("type","file");
	input1.attr("name","id");
	input1.attr("value","");
	$("body").append(form);
	form.append(input1);
	form.submit();
	form.remove();
	
}
function changePage(result,index,size){
	if(result.total>0){
		var fileul = $(".tpl-task-list");
		fileul.empty();
		$.each(result.rows,function(i,item){
			var li = $("<li id='file-item-"+i+"'><div class='task-checkbox'>"+
					"<input type='hidden' value='1' name='test'>"+
					"<input type='checkbox' class='liChild' value='2' name='test'> </div>"+
					"<div class='task-title' id='title-"+i+"'>"+
					"<span class='task-title-sp'>"+item.name+"</span>" +
					"<span style='float:right;font-style: italic;'>"+item.uploadTime+"</span>" +
					"</div>" +
			"</li>");
			var $span1 = item.receiver==0?$("<span class='label label-sm label-success'>全部</span>"):
				(item.receiver==1?$("<span class='label label-sm label-success'>学生</span>"):$("<span class='label label-sm label-success'>教师</span>"));
			fileul.append(li);
			$("#title-"+i).append($span1);
			$("#file-item-"+i).append("<div class='task-config'>" +
					"<div class='am-dropdown tpl-task-list-dropdown am-active' data-am-dropdown=''>" +
					"<a href='javascript:;' class='am-dropdown-toggle tpl-task-list-hover ' data-am-dropdown-toggle=''>" +
					"<i class='am-icon-cog'></i> <span class='am-icon-caret-down'></span>" +
					"</a>" +
					"<ul class='am-dropdown-content tpl-task-list-dropdown-ul am-dropdown-animation'>" +
					"<li id='item-download'><a href='get-muban-file?id="+item.id+"'><i class='am-icon-check'></i> 下载 </a></li>" +
					"<li id='item-delete'><a href='javascript:;'><i class='am-icon-trash-o'></i> 删除 </a></li>" +
					"</ul>" +
					"</div>" +
			"</div>");
			$("#item-delete").on('click',function(){
				alert("shanchu");
			});
			
			
		});
	}else{
		var fileul = $(".tpl-task-list");
		fileul.append("尚未上传文件");
	}
	
	var pageul = $("#muban-file-page");
	pageul.empty();
	if(index==0){
		var lileft = $("<li class='am-disabled'><a href='#'>«</a></li>");
	}else{
		var lileft = $("<li onclick='getFilePage("+(index-1)+","+(size)+")'><a href='javascript:;'>«</a></li>");
	}
	pageul.append(lileft);
	for(var i = 1; i <= result.total; i++){
		if((index+1)==i){
			pageul.append($("<li class='am-active am-disabled'><a href='#'>"+i+"</a></li>"));
		}else{
			pageul.append($("<li onclick='getFilePage("+(i-1)+","+(size)+")'><a href='javascript:;'>"+i+"</a></li>"));
		}
	}
	if(index==(result.total-1))
		var liright = $("<li class='am-disabled'><a href='#'>»</a></li>");
	else
		var liright = $("<li onclick='getFilePage("+(index+1)+","+(size)+")'><a href='javascript:;'>»</a></li>");
	pageul.append(liright);
	
	
}
window.onload = function(){
	getFilePage(0,5);
}