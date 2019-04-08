function st(topicid) {
	$.post("selectTopic.action", {
		id : topicid
	}, function(result) {
		alert(result);
		window.location.reload();
	});
}
function contents(topicId) {
	console.log(topicId);
	$.post("topicContent.action", {
		id : topicId,
	}, function(data) {
		console.log(data);
		$("#modal-body-content").text(data);
	});
}
window.onload = function() {
	$.ajax({
		type:"get",
		url:"topic/hotkey.action?temp="+new Date(),
		datatype:"json",
		contentType:"application/json",
		success:function(data){
			console.log(data);
			var html = "";
			var keyList = $("#hot-keys-list");
			keyList.empty();
			for(var i = 0; i < data.length; i++){
				var li = $("<li style='display:block'>"+data[i]+"</li>");
				keyList.append(li);
			}
		}
	});
	$.ajax({
		type : "GET",
		url : "topic/getTopics",
		data : {
			"tag" : 2
		},
		datatype : "json",
		conentType : "application/json",
		success : function(data) {
			var html = "";
			var topicBody = $("#all-topics");
			console.log(data);
			for (var i = 0; i < data.length; i++) {
				var newTr = $("<tr class='success'></tr>");
				var td1 = $("<td>" + data[i].id + "</td>");
				var td2 = $("<td>" + data[i].topicName + "</td>");
				var td3 = $("<td>" + data[i].topicType + "</td>");
				var td4 = $("<td>" + data[i].demand + "</td>");
				var td5 = $("<td>" + data[i].teacherName + "</td>");
				var td6 = $("<td></td>");
				var btn1;
				if (data[i].state == '可选') {
					btn1 = $("<button class='btn btn-info btn-xs st-btn' id="
							+ data[i].id
							+ " onclick='st("
							+ data[i].id
							+ ")'>"
							+ data[i].state
							+ "</button>");
				} else {
					btn1 = $("<button class='btn btn-info btn-xs' disabled id="
							+ data[i].id
							+ " onclick='st("
							+ data[i].id
							+ ")'>"
							+ data[i].state
							+ "</button>");
				}
				var btn2 = $("<button class='btn btn-info btn-xs content-btn' onclick='contents("+data[i].id+")' data-toggle='modal' data-target='#topic-details'>详情</button>");
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
					var btn2 = $("<button class='btn btn-info btn-xs content-btn' onclick='contents("+data[i].topicId+")' data-toggle='modal' data-target='#topic-details'>详情</button>");
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
				//每次搜索完刷新热门搜索
				$.ajax({
					type:"get",
					url:"hotkey.action?temp="+new Date(),
					datatype:"json",
					contentType:"application/json",
					success:function(data){
						console.log(data);
						var html = "";
						var keyList = $("#hot-keys-list");
						keyList.empty();
						for(var i = 0; i < data.length; i++){
							var li = $("<li style='display:block'>"+data[i]+"</li>");
							keyList.append(li);
						}
					}
				});
			}
		});
	});
}
