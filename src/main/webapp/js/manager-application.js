function getDocs(index,size){
	$.ajax({
		type : "GET",
		url : "getByClassifys/"+index+"/"+size,
		success : function(result){
			changepages(result.rows,index,result.total,size);
		}
	});
}
function download(id){
	$.ajax({
		type : "GET",
		url :  "downloadDoc/"+id,
		success : function(result){
			if(result==null){
				alert("文件不存在");
			}
		}
	});
}
function deleteDoc(id){
	$.ajax({
		type : "POST",
		url :  "deleteDoc",
		data : {
			"id" : id
		},
		success : function(result){
			if(result.status){
				alert(result.message);
				getDocs(0,10);
			}else{
				alert(result.message);
			}
		}
	});
}
function changepages(data,index,pages,size){
	if(data!=null && pages!=null){
		var $studentDocUl = $("#student-doc-ul");
		$studentDocUl.empty();
		var time;
		$.each(data,function(i,item){
			time = timeFormatter(item.createTime);
			var $li = $("<li>" +
					"<div class='task-checkbox'>" +
					"<input type='hidden' value='1' name='test'>" +
					"<input type='checkbox' class='liChild' value='2' name='test'>" +
					"</div>" +
					"<div class='am-g task-title'>" +
					"<span class='am-u-sm-3 task-title-sp'> "+item.docName+" </span>" +
					"<span class='am-u-sm-2'>"+item.classify+"</span>" +
					"<span class='am-u-sm-2'>"+item.uid+"</span>" +
					"<span class='am-u-sm-2'>"+time+"</span>" +
					"<span class='am-u-sm-2'>"+(item.state==2?"已完成":"已提交")+"</span>" +
					"</div>" +
					"<div class='task-config'>" +
					"<div class='am-dropdown tpl-task-list-dropdown am-active' data-am-dropdown=''>" +
					"<a href='###' class='am-dropdown-toggle tpl-task-list-hover ' data-am-dropdown-toggle=''>" +
					"<i class='am-icon-cog'></i> <span class='am-icon-caret-down'></span></a>" +
					"<ul class='am-dropdown-content tpl-task-list-dropdown-ul' id='dropdown-options-"+i+"'>" +
					
					"<li id='item-"+item.id+"'><a href='downloadDoc/"+item.id+"'><i class='am-icon-check'></i> 查看 </a></li>" +
					
					"</ul>" +
					"</div>" +
					"</div>" +
				"</li>");
			$studentDocUl.append($li);
			if(item.state!=2){
				$newli = $("<li id='pass-"+item.id+"'><a href='javascript:;'><i class='am-icon-check'></i> 通过 </a></li>");
				$("#dropdown-options-"+i).append($newli);
				$newli.attr("onclick","pass("+item.id+",'"+item.uid+"','"+item.classify+"')");
			}
			
		});
		
		var pageul = $("#student-docs-page");
		pageul.empty();
		if(index==0){
			var lileft = $("<li class='am-disabled'><a href='#'>«</a></li>");
		}else{
			var lileft = $("<li onclick='getDocs("+(index-1)+","+(size)+")'><a href='javascript:;'>«</a></li>");
		}
		pageul.append(lileft);
		
		
			for(var i = 1; i <= pages; i++){
				if((index+1)==i){
					pageul.append($("<li class='am-active am-disabled'><a href='#'>"+i+"</a></li>"));
				}else{
					pageul.append($("<li onclick='getDocs("+(i-1)+","+(size)+")'><a href='javascript:;'>"+i+"</a></li>"));
				}
			}
			
			
		if(index==(pages-1))
			var liright = $("<li class='am-disabled'><a href='#'>»</a></li>");
		else
			var liright = $("<li onclick='getDocs("+(index+1)+","+(size)+")'><a href='javascript:;'>»</a></li>");
		pageul.append(liright);
		
	}else{
		$studentDocUl.append("没有文件");
	}
}
function pass(docId,uid,classify){
//	openLoading();
	$.ajax({
		type : "POST",
		url : "changestate",
		data : {
			"docid" : docId,
			"uid" : uid,
			"classify" : classify
		},
		success : function(result){
//			closeLoading();
			if(result.status){
				alert(result.message);
				getDocs(0,10);
			}else
				alert(result.message);
		}
	})
}
window.onload = function(){
	getDocs(0,10);
}