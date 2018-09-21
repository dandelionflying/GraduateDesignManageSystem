function st(topicid) {
	$.post("selectTopic.action", {
		topicId : topicid
	}, function(result) {
		alert(result);
		window.location.reload();
	});
}

window.onload = function() {
	$.ajax({
		type : "post",
		url : "st.action",

		datatype : "json",
		conentType : "application/json",
		success : function(data) {
			var html = "";
			var topicBody = $("#all-topics");
			console.log(data);
			for (var i = 0; i < data.length; i++) {
				var newTr = $("<tr class='success'></tr>");
				var td1 = $("<td>" + data[i].topicId + "</td>");
				var td2 = $("<td>" + data[i].topicName + "</td>");
				var td3 = $("<td>" + data[i].topicType + "</td>");
				var td4 = $("<td>" + data[i].demand + "</td>");
				var td5 = $("<td>" + data[i].teacherName + "</td>");
				var td6 = $("<td></td>");
				var btn1;
				if (data[i].state == '可选') {
					btn1 = $("<button class='btn btn-info btn-xs st-btn' id="
							+ data[i].topicId
							+ " onclick='st("
							+ data[i].topicId
							+ ")'>"
							+ data[i].state
							+ "</button>");
				} else {
					btn1 = $("<button class='btn btn-info btn-xs' disabled id="
							+ data[i].topicId
							+ " onclick='st("
							+ data[i].topicId
							+ ")'>"
							+ data[i].state
							+ "</button>");
				}
				var btn2 = $("<button class='btn btn-info btn-xs'>详情</button>");
				var tbody = $("#all-topics");
				td6.append(btn1);
				td6.append(btn2);
				newTr.append(td1);
				newTr.append(td2);
				newTr.append(td3);
				newTr.append(td4);
				newTr.append(td5);
				newTr.append(td6);
				tbody.append(newTr);
			}
		}
	});
	$(".search").click(function(){
		var word = $("#searchWord").val();
		console.log(word);
		$.ajax({
			type : "post",
			url : "searchTopic.action",
			data:{keyWord:word},
			datatype : "json",
			conentType : "application/json",
			success : function(data) {
				$("#all-topics").empty();
				var html = "";
				var topicBody = $("#all-topics");
				console.log(data);
				for (var i = 0; i < data.length; i++) {
					var newTr = $("<tr class='success'></tr>");
					var td1 = $("<td>" + data[i].topicId + "</td>");
					var td2 = $("<td>" + data[i].topicName + "</td>");
					var td3 = $("<td>" + data[i].topicType + "</td>");
					var td4 = $("<td>" + data[i].demand + "</td>");
					var td5 = $("<td>" + data[i].teacherName + "</td>");
					var td6 = $("<td></td>");
					var btn1;
					if (data[i].state == '可选') {
						btn1 = $("<button class='btn btn-info btn-xs st-btn' id="
								+ data[i].topicId
								+ " onclick='st("
								+ data[i].topicId
								+ ")'>"
								+ data[i].state
								+ "</button>");
					} else {
						btn1 = $("<button class='btn btn-info btn-xs' disabled id="
								+ data[i].topicId
								+ " onclick='st("
								+ data[i].topicId
								+ ")'>"
								+ data[i].state
								+ "</button>");
					}
					var btn2 = $("<button class='btn btn-info btn-xs'>详情</button>");
					var tbody = $("#all-topics");
					td6.append(btn1);
					td6.append(btn2);
					newTr.append(td1);
					newTr.append(td2);
					newTr.append(td3);
					newTr.append(td4);
					newTr.append(td5);
					newTr.append(td6);
					tbody.append(newTr);
				}
			}
		});
	});
}
