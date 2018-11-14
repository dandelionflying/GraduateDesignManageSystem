window.onload = function(){
	$.ajax({
		type:"get",
		url:"getPassedTopics.action",
		datatype:"json",
		contentType:"application/json",
		success:function(data){
			console.log(data);
			var tbody = $(".passed-topic-tbody");
			for(var i = 0; i < data.length; i++){
				var tr = $("<tr></tr>");
				var td1 = $("<td>"+data[i].topicId+"</td>");
				var td2 = $("<td>"+data[i].topicName+"</td>");
				var td3 = $("<td>"+data[i].topicType+"</td>");
				var td4 = $("<td>"+data[i].teacherName+"</td>");
				var td5 = $("<td></td>");
				var td6 = $("<td><button class='am-btn am-btn-default am-btn-xs am-text-success'><span class='am-icon-pencil-square-o'></span> 详情</button></td>");
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