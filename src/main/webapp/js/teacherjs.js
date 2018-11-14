window.onload = function() {
	$(".show-detail").click(function() {
		window.location.href = "studentschedule.jsp";
	});
	
	/*
	 * ajax 获取已选学生信息
	 * */
}
function show(sId){
	/*
	 * 隐藏所有table 显示sId的table
	 * */
}
function getStudentTopic(sId) {
	var jsonData = {
		"sId" : sId
	};
	console.log(jsonData);
	$.ajax({
		type : "POST",
		url : "studentTopicMsg.action",
		data : JSON.stringify(jsonData),
		datatype : "json",
		contentType : "application/json;charset=utf-8",
		success : function(data) {
			console.log(JSON.stringify(data));
			var msg = JSON.parse(JSON.stringify(data));
			/*var tbody = $(".stu-msg-tbody");
			for(var i = 0; i < data.length; i++){
				var newTr = $("<tr></tr>");
				var td1 = $("<td>"+msg[i].sId+"</td>");
				var td2 = $("<td>"+msg[i].studentName+"</td>");
				var td3 = $("<td>"+msg[i].className+"</td>");
				var td4 = $("<td>"+msg[i].sMayor+"</td>");
				var td5 = $("<td>"+msg[i].topicName+"</td>");
				var td6 = $("<td>"+"</td>");
				
			}*/
			
			
			
			
			$("#stu-topic-msg-1").text(msg.sId);
			$("#stu-topic-msg-2").text(msg.studentName);
			$("#stu-topic-msg-3").text(msg.className);
			$("#stu-topic-msg-4").text(msg.sMayor);
			$("#stu-topic-msg-5").text(msg.topicName);
			$(".detail-table").hide(500);
			$("#detail1").show(500);
			
		}
	});
}