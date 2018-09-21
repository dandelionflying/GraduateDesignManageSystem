window.onload = function() {
	$(".show-detail").click(function() {
		window.location.href = "studentschedule.jsp";
	});
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
			$("#stu-topic-msg-1").text(msg.sId);
			$("#stu-topic-msg-2").text(msg.studentName);
			$("#stu-topic-msg-3").text(msg.className);
			$("#stu-topic-msg-4").text(msg.sMayor);
			$("#stu-topic-msg-5").text(msg.topicName);
			$(".detail-table").hide();
			$("#detail1").show(500);
		}
	});
}