function dateParse(value){
//	var result = new Date(parseInt(value.replace("/Date(","").replace(")/","").split("+")[0]));
	if(value)
		return new Date(value.replace(/-/,"/"));
	
}
function timeFormatter(value) {
    if(value){
    	var da = new Date(parseInt((value.toString()).replace("/Date(", "").replace(")/" , "").split( "+")[0]));
    	return da.getFullYear() + "-" + (da.getMonth() + 1) + "-" + da.getDate() + " " + da.getHours() + ":" + da.getMinutes() + ":" + da.getSeconds();
    }
}
// 审核
function checktopic(id,tag){
	$.ajax({
		type : "POST",
		url : "changeTopicState",
		data :{
			"id" : id,
			"tag" : tag
		},
		success:function(data){
			alert(data);
			window.location.reload();
		}
	});
}
// 获取课题详情
function topicdetail(data){
	console.log(data);
//	data = eval('('+jsonstring+')');
//	data = JSON.parse(jsonstring);
	//这里不用转 直接用。。。。。。。
	$("#topic-id").text(data.id);
	$("#topic-teacher").text(data.teacherName);
	$("#topic-type").text(data.topicType);
	$("#topic-title").text(data.topicName);
	$("#topic-uploadtime").text(timeFormatter(data.uploadTime));
	$("#topic-content").text(data.content);
	$("#topic-demand").text(data.demand);
	switch(data.tag){
	case 0 :
		$("#topic-state").attr("class","label label-xs label-warning");
		$("#topic-state").text("待审核");
		break;
	case 1 :
		$("#topic-state").attr("class","label label-xs label-danger");
		$("#topic-state").text("已驳回");
		break;
	case 2 :
		$("#topic-state").attr("class","label label-xs label-success");
		$("#topic-state").text("已通过");
		break;
	}
//	$("#topic-state").text(data.tag==0?"未审核":(data.tag==1?"已驳回":"已通过"));
	$("#detail-modal-1").modal('open');
	
}
function changepage(data){
	console.log(data);
	var index = data.index;
	var result = data.result;
	var pages = data.pages;
	var tbody = $(".new-topic-tbody");
	tbody.empty();
	$.each(result,function(i,item){
		var time = timeFormatter(item.uploadTime);
		var tr = $("<tr></tr>");
		var td1 = $("<td>"+item.id+"</td>");
		var td2 = $("<td>"+"<span class='label label-xs label-warning'>待审核</span> "+item.topicName+"</td>");
		var td3 = $("<td>"+item.topicType+"</td>");
		var td4 = $("<td>"+item.teacherName+"</td>");
		var td5 = $("<td>"+time+"</td>");
		var td6 = $("<td></td>");
		var jsonstring = JSON.stringify(item);
		
		var btn1 = $("<button class='am-btn am-btn-default am-btn-xs am-text-success' onclick='topicdetail("+jsonstring+")'><span class='am-icon-pencil-square-o'></span> 详情</button>");
//		btn1.attr("data-am-modal","{target: '#detail-modal-1', closeViaDimmer: 0, width: 400, height: 225}");
//		btn1.attr("onclick","topicdetail("+data[i]+")");
		var btn2 = $("<button class='am-btn am-btn-default am-btn-xs am-hide-sm-only' onclick='checktopic("+item.id+",2)'><span class='am-icon-copy'></span> 通过</button>");
		var btn3 = $("<button class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only' onclick='checktopic("+item.id+",1)'><span class='am-icon-trash-o'></span> 驳回</button>");
		var divtoobar = $("<div class='am-btn-toolbar'></div>");
		var div2 = $("<div class='am-btn-group am-btn-group-xs'></div>");
		divtoobar.append(div2);
		div2.append(btn1);
		
		div2.append(btn2);
		div2.append(btn3);
		td6.append(divtoobar);
		tr.append(td1);
		tr.append(td2);
		tr.append(td3);
		tr.append(td4);
		tr.append(td5);
		tr.append(td6);
		tbody.append(tr);
	});
	var pageul = $("#st-page");
	pageul.empty();
	if(index==0){
		var lileft = $("<li class='am-disabled'><a href='#'>«</a></li>");
	}else{
		var lileft = $("<li onclick='gettopics("+(index-1)+")'><a href='javascript:;'>«</a></li>");
	}
	pageul.append(lileft);
	for(var i = 1; i <= pages; i++){
		if((index+1)==i){
			pageul.append($("<li class='am-active am-disabled'><a href='#'>"+i+"</a></li>"));
		}else{
			pageul.append($("<li onclick='gettopics("+(i-1)+")'><a href='javascript:;'>"+i+"</a></li>"));
		}
	}
	if(index==(pages-1))
		var liright = $("<li class='am-disabled'><a href='#'>»</a></li>");
	else
		var liright = $("<li onclick='gettopics("+(index+1)+")'><a href='javascript:;'>»</a></li>");
	pageul.append(liright);
	
}
function gettopics(currentpage){
	$.ajax({
		type:"get",
		url:"getTopics/0/"+currentpage+"/5",
		success:function(data){
			changepage(data);
		}
	});
}
window.onload = function(){
//	获取所有课题类型名
	$.ajax({
		type : "GET",
		url : "get-topicclassify-name",
		success : function(data){
			console.log(data);
			var selector = $("#classify-option");
			$.each(data,function(i,item){
				selector.append("<option value='option"+i+"'>"+item+"</option>");
			})
		}
	});
//	获取未审核列表
	gettopics(0);
//	搜索
	$("#topic-search").on("click",function(){
		console.log($(".am-selected-status").text()+$("#key").val());
		var classify = $(".am-selected-status").text();
		var key = $("#key").val();
		$.ajax({
			type : "POST",
			data : {
				"classify" : classify,
				"key" : key,
				"tag" : 0,
				"index" : 0,
				"page" : 5
			},
			url : "searchTopic",
			success : function(data){
				changepage(data);
			}
		});
	});
};