function st(topicid) {
	openLoading();
	$.post("selectTopic.action", {
		id : topicid
	}, function(result) {
		console.log(result);
		closeLoading();
		openMsgModal(result.message);
		if(result.status)
			gettopics(0,10);
	});
}
function contents(topicId) {
	
	console.log(topicId);
	$.post("topicContent.action", {
		id : topicId,
	}, function(result) {
		console.log(result);
		
		if(result.status)
			$("#modal-body-content").text(result.data);
	});
}
function gettopics(index,size){
	$.ajax({
		type : "GET",
		url : "getTopics/2/"+index+"/"+size,
		success : function(result) {
			changepage(result,index,size)
		}
	});
}
function changepage(result,index,size){
	var rows = result.rows;
	var pages = result.total;
	var topicBody = $("#all-topics");
	console.log(rows);
	var tbody = $("#all-topics");
	tbody.empty();
	$.each(rows,function(i,item){
		var newTr = $("<tr class='success'></tr>");
		var td1 = $("<td>" + item.id + "</td>");
		var td2 = $("<td>" + item.topicName + "</td>");
		var td3 = $("<td>" + item.topicType + "</td>");
		var td4 = $("<td>" + item.demand + "</td>");
		var td5 = $("<td>" + item.teacherName + "</td>");
		var td6 = $("<td></td>");
		var btn1;
		if (item.state == '可选') {
			btn1 = $("<button class='btn btn-info btn-xs st-btn' id=" + item.id + " onclick='st(" + item.id +")'>"
					+ item.state
					+ "</button>");
		} else {
			btn1 = $("<button class='btn btn-info btn-xs' disabled id="
					+ item.id
					+ " onclick='st("
					+ item.id
					+ ")'>"
					+ item.state
					+ "</button>");
		}
		var btn2 = $("<button class='btn btn-info btn-xs content-btn' onclick='contents("+item.id+")' data-toggle='modal' data-target='#topic-details'>详情</button>");
		
		td6.append(btn1);
		td6.append(btn2);
		newTr.append(td1);
		newTr.append(td2);
		newTr.append(td3);
		newTr.append(td4);
		newTr.append(td5);
		newTr.append(td6);
		tbody.append(newTr);
	})
	
	var $ul = $("#topic-pagination");
	$ul.empty();
	var $leftli;
	if(index==0)
		$leftli = $("<li class='disabled'>" +
				"<a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
	else
		$leftli = $("<li onclick='gettopics("+(index-1)+","+size+")'><a href='javascript:;' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
	$ul.append($leftli);
	for(var i = 1; i<=pages; i++){
		var $li ;
		if((index+1)==i)
			$li =  $("<li class='active'><a href='javascript:;'>"+i+"</a></li>");
		else
			$li =  $("<li onclick='gettopics("+(i-1)+","+size+")'><a href='javascript:;'>"+i+"</a></li>");
		$ul.append($li);
	}
	var $rightli;
	if(index==(pages-1))
		$rightli = $("<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
	else
		$rightli = $("<li onclick='gettopics("+(index+1)+","+size+")'><a href='javascript:;' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
	$ul.append($rightli);
}
function search(index,size){
	openLoading();
	var word = $("#searchWord").val();
	console.log(word);
	$.ajax({
		type : "post",
		url : "searchTopic",
		data: {
			keyWord:word,
			tag : 2,
			index : index,
			page : size
		},
		datatype : "json",
		conentType : "application/json",
		success : function(result) {
			closeLoading();
			searchChange(result,index,size);
		}
	});
}
function searchChange(result,index,size){
	var rows = result.rows;
	var pages = result.total;
	var topicBody = $("#all-topics");
	console.log(rows);
	var tbody = $("#all-topics");
	tbody.empty();
	$.each(rows,function(i,item){
		var newTr = $("<tr class='success'></tr>");
		var td1 = $("<td>" + item.id + "</td>");
		var td2 = $("<td>" + item.topicName + "</td>");
		var td3 = $("<td>" + item.topicType + "</td>");
		var td4 = $("<td>" + item.demand + "</td>");
		var td5 = $("<td>" + item.teacherName + "</td>");
		var td6 = $("<td></td>");
		var btn1;
		if (item.state == '可选') {
			btn1 = $("<button class='btn btn-info btn-xs st-btn' id=" + item.id + " onclick='st(" + item.id +")'>"
					+ item.state
					+ "</button>");
		} else {
			btn1 = $("<button class='btn btn-info btn-xs' disabled id="
					+ item.id
					+ " onclick='st("
					+ item.id
					+ ")'>"
					+ item.state
					+ "</button>");
		}
		var btn2 = $("<button class='btn btn-info btn-xs content-btn' onclick='contents("+item.id+")' data-toggle='modal' data-target='#topic-details'>详情</button>");
		
		td6.append(btn1);
		td6.append(btn2);
		newTr.append(td1);
		newTr.append(td2);
		newTr.append(td3);
		newTr.append(td4);
		newTr.append(td5);
		newTr.append(td6);
		tbody.append(newTr);
	})
	
	var $ul = $("#topic-pagination");
	$ul.empty();
	var $leftli;
	if(index==0)
		$leftli = $("<li class='disabled'>" +
				"<a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
	else
		$leftli = $("<li onclick='search("+(index-1)+","+size+")'><a href='javascript:;' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
	$ul.append($leftli);
	for(var i = 1; i<=pages; i++){
		var $li ;
		if((index+1)==i)
			$li =  $("<li class='active'><a href='javascript:;'>"+i+"</a></li>");
		else
			$li =  $("<li onclick='search("+(i-1)+","+size+")'><a href='javascript:;'>"+i+"</a></li>");
		$ul.append($li);
	}
	var $rightli;
	if(index==(pages-1))
		$rightli = $("<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
	else
		$rightli = $("<li onclick='search("+(index+1)+","+size+")'><a href='javascript:;' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
	$ul.append($rightli);
	
	
	//每次搜索完刷新热门搜索
	$.ajax({
		type:"get",
		url:"hotkey.action?temp="+new Date(),
		datatype:"json",
		contentType:"application/json",
		success:function(result){
			var data = result.data;
			console.log(data);
			var keyList = $("#hot-keys-list");
			keyList.empty();
			for(var i = 0; i < data.length; i++){
				var li = $("<li style='display:block'>"+data[i]+"</li>");
				keyList.append(li);
			}
		}
	});
}
window.onload = function() {
	$.ajax({
		type:"get",
		url:"hotkey.action?temp="+new Date(),
		datatype:"json",
		contentType:"application/json",
		success:function(result){
			var data = result.data;
			console.log(data);
			var keyList = $("#hot-keys-list");
			keyList.empty();
			for(var i = 0; i < data.length; i++){
				var li = $("<li style='display:block'>"+data[i]+"</li>");
				keyList.append(li);
			}
		}
	});
	
	gettopics(0,10);
	
	$(".search").click(function(){
		
		search(0,10);
	});
}
