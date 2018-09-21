window.onload = function() {
	$("#leftli1").click(function(teacherName) {

		$(".topic").hide();
		$("#all-topics").show(800);
	});
	$("#leftli2").click(function() {
		$(".topic").hide();
		$("#my-topics").show(800);
	});
	$("#leftli3").click(function() {

	});

	$("#type1").click(function() {
		$(".type-label").text($("#type-a1").text());
	});
	$("#type2").click(function() {
		$(".type-label").text($("#type-a2").text());
	});
	$("#type3").click(function() {
		$(".type-label").text($("#type-a3").text());
	});
	$("#type4").click(function() {
		$(".type-label").text($("#type-a4").text());
	});

	/* $(".content-btn").click(function(){
		$("#modal-body-content").text("sas");
		var topicId = $("#topicID").val();
		var contentBtn = $(".content-btn");
		console.log(topicId);
	    $.post("topicContent.action", {  
	    	topicId : topicId,  
	    }, function(data) {  
	        
	        $("#modal-body-content").text(data);          
	    });
	}); */

}
function contents(topicId) {
	console.log(topicId);
	$.post("topicContent.action", {
		topicId : topicId,
	}, function(data) {
		console.log(data);
		$("#modal-body-content").text(data);
	});
}
function sendForm() {
	var topicname = $("#new_topic_name").val();
	var teachername = $("#teacherName").text();
	var content = $("#new_content").val();
	var demand = $("#new_demand").val();
	var topicType = $("#topic_type").text();
	/* console.log(topicname,teachername,content,demand,topicType); */
	$.post("addNewTopic.action", {
		topicName : topicname,
		teacherName : teachername,
		content : content,
		demand : demand,
		topicType : topicType,
	}, function(data) {
		alert("添加成功！");
		window.location.reload();
	});
}