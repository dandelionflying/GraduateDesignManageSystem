function getProcess(){
	$.ajax({
		type : "GET",
		url : "getprocess",
		success : function(result){
			showProcess(result);
		}
	});
}
function showProcess(result){
	if(result.status){
		var $body = $(".students-process");
		$.each(result.data,function(i,item){
			
			var $process = $("<tr>" +
				"<td class='col-xs-1 col-md-1 col-lg-1'>"+item.sId+"</td>" +
				"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.taskBook==2?"<label class='label label-success'>已完成</label>":(item.taskBook==1?"<label class='label label-info'>进行中</label>":""))+"</td>" +
				"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.openningReport==2?"<label class='label label-success'>已完成</label>":(item.openningReport==1?"<label class='label label-info'>进行中</label>":""))+"</td>" +
				"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.midTermCheck==2?"<label class='label label-success'>已完成</label>":(item.midTermCheck==1?"<label class='label label-info'>进行中</label>":""))+"</td>" +
				"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.paper==2?"<label class='label label-success'>已完成</label>":(item.paper==1?"<label class='label label-info'>进行中</label>":""))+"</td>" +
				"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.evaluation1==2?"<label class='label label-success'>已完成</label>":(item.evaluation1==1?"<label class='label label-info'>进行中</label>":""))+"</td>" +
				"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.evaluation2==2?"<label class='label label-success'>已完成</label>":(item.evaluation2==1?"<label class='label label-info'>进行中</label>":""))+"</td>" +
				"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.checkRepetition==2?"<label class='label label-success'>已完成</label>":(item.checkRepetition==1?"<label class='label label-info'>进行中</label>":""))+"</td>" +
				"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.answerApplication==2?"<label class='label label-success'>已完成</label>":(item.answerApplication==1?"<label class='label label-info'>进行中</label>":""))+"</td>" +
				"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.answerRecord==2?"<label class='label label-success'>已完成</label>":(item.answerRecord==1?"<label class='label label-info'>进行中</label>":""))+"</td>" +
				"<td class='col-xs-1 col-md-1 col-lg-1'></td>" +
				"</tr>");
			$body.append($process);
			/*var $process = $("<tr>" +
					"<td class='col-xs-1 col-md-1 col-lg-1'>"+item.sId+"</td>" +
					"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.taskBook==3?"<label class='label label-success'>已完成</label>":(item.taskBook==2?"<label class='label label-primary'>已提交</label>":(item.taskBook==1?"<label class='label label-info'>进行中</label>":"")))+"</td>" +
					"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.openningReport==3?"<label class='label label-success'>已完成</label>":(item.openningReport==2?"<label class='label label-primary'>已提交</label>":(item.openningReport==1?"<label class='label label-info'>进行中</label>":"")))+"</td>" +
					"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.midTermCheck==3?"<label class='label label-success'>已完成</label>":(item.midTermCheck==2?"<label class='label label-primary'>已提交</label>":(item.midTermCheck==1?"<label class='label label-info'>进行中</label>":"")))+"</td>" +
					"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.paper==3?"<label class='label label-success'>已完成</label>":(item.paper==2?"<label class='label label-primary'>已提交</label>":(item.paper==1?"<label class='label label-info'>进行中</label>":"")))+"</td>" +
					"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.evaluation1==3?"<label class='label label-success'>已完成</label>":(item.evaluation1==2?"<label class='label label-primary'>已提交</label>":(item.evaluation1==1?"<label class='label label-info'>进行中</label>":"")))+"</td>" +
					"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.evaluation2==3?"<label class='label label-success'>已完成</label>":(item.evaluation2==2?"<label class='label label-primary'>已提交</label>":(item.evaluation2==1?"<label class='label label-info'>进行中</label>":"")))+"</td>" +
					"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.checkRepetition==3?"<label class='label label-success'>已完成</label>":(item.checkRepetition==2?"<label class='label label-primary'>已提交</label>":(item.checkRepetition==1?"<label class='label label-info'>进行中</label>":"")))+"</td>" +
					"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.answerApplication==3?"<label class='label label-success'>已完成</label>":(item.answerApplication==2?"<label class='label label-primary'>已提交</label>":(item.answerApplication==1?"<label class='label label-info'>进行中</label>":"")))+"</td>" +
					"<td class='col-xs-1 col-md-1 col-lg-1'>"+(item.answerRecord==3?"<label class='label label-success'>已完成</label>":(item.answerRecord==2?"<label class='label label-primary'>已提交</label>":(item.answerRecord==1?"<label class='label label-info'>进行中</label>":"")))+"</td>" +
					"<td class='col-xs-1 col-md-1 col-lg-1'></td>" +
					"</tr>");*/
		})
	}else{
		
	}
}

window.onload = function(){
	var len=($("#progress1").css("width")+$("#progress2").css("width")+$("#progress3").css("width")+$("#progress4").css("width")+$("#progress5").css("width")+$("#progress6").css("width"))/6;
	$(".whole-progress").css("width",len);
	
	
	
	getProcess();
}

