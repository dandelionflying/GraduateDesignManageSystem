//根据分类搜索
function search(){
	var options = $("#selectorclassify option:selected");
	var classify = [];
	$.each(options,function(i,item){
		classify[i] = $(item).text(); 
	})
	
	console.log(classify.length);
	if(classify.length>0){
		openLoading();
//		console.log(JSON.stringify(uids));
		$.ajax({
			type : "POST",
			url : "searchdocbyclassify",
			data : {
				"classify" : classify
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
		url : "getstudocslist2",
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
			if(item.classify=="评阅老师评阅表"){
				$options.append("<button class='btn btn-xs btn-success' id='pass"+i+"'> 确认成绩</button>");
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
	/*$("#li-process").css("display","none");
	$("#li-topic").hide();
	$("#li-stu-document").hide();
	$("#header-nav").append("");*/
	getdocs();
	getclassify();
}