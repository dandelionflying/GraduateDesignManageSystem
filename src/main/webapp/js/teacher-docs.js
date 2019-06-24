//根据分类和学号搜索
function search(){
	var options = $("#selectorclassify option:selected");
	var optionsid = $("#selectorsid option:selected");
	var classify = [];
	var uids = [];
	$.each(options,function(i,item){
		classify[i] = $(item).text(); 
	})
	
	$.each(optionsid,function(i,item){
		uids[i] = $(item).text(); 
	})
	console.log(classify.length);
	console.log(uids.length);
	if(classify.length>0 && uids.length>0){
		openLoading();
//		console.log(JSON.stringify(uids));
		$.ajax({
			type : "POST",
			url : "searchdoc",
			data : {
				"classify" : classify,
				"uids" : uids
			},
			traditional: true,
			success : function(result){
				closeLoading();
				showDocs(result);
			}
		});
	}else{
		openMsgModal("请选择筛选项");
	}
}
//获取教师下学生id
function getSids(){
	$.ajax({
		type : "POST",
		url : "getSids",
		success : function(result){
			if(result.status){
				var $options = $("#selectorsid");
				$.each(result.data,function(i,item){
					var $option = $("<option>"+item+"</option>");
					$options.append($option);
				});
				//使用refresh方法更新UI以匹配新状态。
		        $('#selectorsid').selectpicker('refresh');
		        //render方法强制重新渲染引导程序 - 选择ui。
		        $('#selectorsid').selectpicker('render');
			}
		}
	});
}
//获取所有分类
function getclassify(){
	$.ajax({
		type : "get",
		url : "fileclassify.action",
		conentType : "application/json",
		success : function(result){
			if(result.status){
				var $options = $("#selectorclassify");
				$.each(result.data,function(i,item){
					var $option = $("<option>"+item.name+"</option>");
					$options.append($option);
				});
				//使用refresh方法更新UI以匹配新状态。
		        $('#selectorclassify').selectpicker('refresh');
		        //render方法强制重新渲染引导程序 - 选择ui。
		        $('#selectorclassify').selectpicker('render');
			}
		}
	});
}


//通过
function pass(docid,uid,classify){
	openLoading();
	$.ajax({
		type : "POST",
		url : "changestate",
		data : {
			"docid" : docid,
			"uid" : uid,
			"classify" : classify
		},
		success : function(result){
			closeLoading();
			if(result.status){
				openMsgModal(result.message);
				getdocs();
			}else
				openMsgModal(result.message);
		}
	})
}
//发送请求获取教师下学生所有文档
function getdocs(){
	$.ajax({
		type : "post",
		url : "getstudocslist",
		success : function(result){
			showDocs(result);
		}
	});
}
function showDocs(result){
	var $table = $(".docs");
	$table.empty();
	if(result.status){
		$.each(result.data,function(i,item){
			var $tr = $("<tr class='success'>" +
					"<td>"+item.uid+"</td>" +
					"<td>"+item.docName+"</td>" +
					"<td>"+item.classify+"</td>" +
					"<td>"+(item.state==2?"已完成":"已提交")+"</td>" +
					"<td id='options"+i+"'>" +
					"<a class='btn btn-xs btn-info' href='download?id="+item.id+"'>查看</a> " +
					"</td>" +
					"</tr>");
			$table.append($tr);
			var $options = $("#options"+i);
			if(item.classify=="任务书"||item.classify=="开题报告"||item.classify=="中期检查表"){
				$options.append("<button class='btn btn-xs btn-success' id='pass"+i+"'> 通过</button>");
				if(item.state==2){
					$("#pass"+i).attr("disabled","disabled");
				}
			}
			if(item.classify=="指导老师评阅表"){
				$options.append("<button class='btn btn-xs btn-success' id='pass"+i+"'> 确认</button>");
				if(item.state==2){
					$("#pass"+i).attr("disabled","disabled");
				}
			}
			
			$("#pass"+i).on('click',function(){
				pass(item.id,item.uid,item.classify);
			});
			
			
		});
	}else{
		$table.html(result.message);
	}
}
window.onload = function(){
	getdocs();
	getclassify();
	getSids();
}