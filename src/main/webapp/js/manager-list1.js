window.onload = function(){
	$.ajax({
		type:"get",
		url:"getNewTopics.action",
		datatype:"json",
		contentType:"application/json",
		success:function(data){
			console.log(data);
			var tbody = $(".new-topic-tbody");
			for(var i = 0; i < data.length; i++){
				var tr = $("<tr></tr>");
				var td1 = $("<td>"+data[i].topicId+"</td>");
				var td2 = $("<td>"+data[i].topicName+"</td>");
				var td3 = $("<td>"+data[i].topicType+"</td>");
				var td4 = $("<td>"+data[i].teacherName+"</td>");
				var td5 = $("<td>--</td>");
				var td6 = $("<td></td>");
				
				var btn1 = $("<button class='am-btn am-btn-default am-btn-xs am-text-success'><span class='am-icon-pencil-square-o'></span> 详情</button>");
				var btn2 = $("<button class='am-btn am-btn-default am-btn-xs am-hide-sm-only'><span class='am-icon-copy'></span> 通过</button>");
				var btn3 = $("<button class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only'><span class='am-icon-trash-o'></span> 驳回</button>");
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
			}
		}
	});
};