
window.onload = function() {
	gettopics(0,10);
	
	$("#leftli1").on('click',function(){
		gettopics(0,10);
	});
	$("#leftli2").on('click',function(){
		getmytopics(0,10);
	});
	
	$("#classify1").click(function() {
		$(".type-label").text($("#classify1").text());
	});
	$("#classify2").click(function() {
		$(".type-label").text($("#classify2").text());
	});
	$("#classify3").click(function() {
		$(".type-label").text($("#classify3").text());
	});
	$("#classify4").click(function() {
		$(".type-label").text($("#classify4").text());
	});
	
	$("#update-classify1").click(function() {
		$(".update-type-label").text($("#update-classify1").text());
	});
	$("#update-classify2").click(function() {
		$(".update-type-label").text($("#update-classify2").text());
	});
	$("#update-classify3").click(function() {
		$(".update-type-label").text($("#update-classify3").text());
	});
	$("#update-classify4").click(function() {
		$(".update-type-label").text($("#update-classify4").text());
	});
	
	
}
//发送请求获取当前教师创建的所有课题信息
function getmytopics(index,size){
	$.ajax({
		type : "GET",
		url : "getmytopic/"+index+"/"+size,
		success : function(result){
			showmytopics(result,index,size);
		}
	});
}
//显示当前教师创建的所有课题信息
function showmytopics(result,index,size){
	var rows = result.rows;
	var pages = result.total;
	var $table = $("#topic-table"); 
	var $tbody = $("#topics");
	$table.empty();
	$table.append("<thead><tr class='active'><th>课题编号</th><th>课题名称</th><th>课题类型</th><th>课题状态</th><th>操作</th></tr></thead>");
	$table.append($tbody);
	$tbody.empty();
	$("#teacherName").append(rows[0].teacherName);
	$.each(rows,function(i,item){
		var $tr = $("<tr>" +
				"<td>"+item.id+"</td>" +
				"<td>"+item.topicName+"</td>" +
				"<td>"+item.topicType+"</td>" +
				"<td>"+(item.tag==2?"<label class='label label-success'>已通过</label>":(item.tag==1?"<label class='label label-danger'>已驳回</label>":"<label class='label label-info'>待审核</label>"))+"</td>" +
				"<td id='options'><button class='btn btn-xs btn-success' id='btn-edit-"+i+"' data-toggle='modal' data-target='#update-modal'>编辑</button>" +
				"<button class='btn btn-xs btn-danger' id='btn-delete-"+i+"' onclick='deleteTopic("+item.id+")'>撤销</button>" +
				"</td></tr>");
		$tbody.append($tr);
		$("#btn-edit-"+i).on("click",function(){
			$("#update-topic-id").attr("value",item.id);
			$("#update-topic-teacherName").text(item.teacherName);
			$("#update-topic-name").val(item.topicName);
			$("#update-topic-content").text(item.content);
			$("#update-topic-demand").text(item.demand);
		});
		if(item.tag==2){
			$("#btn-edit-"+i).attr("disabled","disabled");
			$("#btn-delete-"+i).attr("disabled","disabled");
		}
		
	});
	$(".topicmsg").append($table);
	
	var $ul = $("#topic-pagination");
	$ul.empty();
	var $leftli;
	if(index==0)
		$leftli = $("<li class='disabled'>" +
				"<a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
	else
		$leftli = $("<li onclick='getmytopics("+(index-1)+","+size+")'><a href='javascript:;' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
	$ul.append($leftli);
	for(var i = 1; i<=pages; i++){
		var $li ;
		if((index+1)==i)
			$li =  $("<li class='active'><a href='javascript:;'>"+i+"</a></li>");
		else
			$li =  $("<li onclick='getmytopics("+(i-1)+","+size+")'><a href='javascript:;'>"+i+"</a></li>");
		$ul.append($li);
	}
	var $rightli;
	if(index==(pages-1))
		$rightli = $("<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
	else
		$rightli = $("<li onclick='getmytopics("+(index+1)+","+size+")'><a href='javascript:;' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
	$ul.append($rightli);
}
//根据id获取课题详情信息
function contents(topicId) {
	console.log(topicId);
	$.post("topicContent.action", {
		topicId : topicId,
	}, function(data) {
		console.log(data);
		$("#modal-body-content").text(data);
	});
}
//以表单的形式发送要更新的课题信息
function sendUpdateForm(){
	openLoading();
	var topicid = $("#update-topic-id").val();
	var topicname = $("#update-topic-name").val();
	var teachername = $("#update-topic-teacherName").text();
	var content = $("#update-topic-content").val();
	var demand = $("#update-topic-demand").val();
	var topicType = $(".update-type-label").text();
	/* console.log(topicname,teachername,content,demand,topicType); */
	$.post("addNewTopic.action", {
		id : topicid,
		topicName : topicname,
		teacherName : teachername,
		content : content,
		demand : demand,
		topicType : topicType
	}, function(result) {
		closeLoading();
		if(result.status){
			openMsgModal(result.message);
			$("#apply-modal").modal('hide');
			getmytopics(0,10);
			//window.location.reload();
		}else{
			openMsgModal(result.message);
		}
		
	});
}
//以表单的形式发送要创建的课题信息
function sendForm(topicid) {
	openLoading();
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
	}, function(result) {
		closeLoading();
		if(result.status){
			openMsgModal(result.message);
			$("#apply-modal").modal('hide');
			getmytopics(0,10);
			//window.location.reload();
		}else{
			openMsgModal(result.message);
		}
		
	});
}
//获取课题列表
function gettopics(index,size){
	$.ajax({
		type : "GET",
		url : "getTopics/2/"+index+"/"+size,
		success : function(result) {
			changepage(result,index,size)
		}
	});
}
//分页显示课题列表
function changepage(result,index,size){
	var rows = result.rows;
	var pages = result.total;
	console.log(rows);
	var $table = $("#topic-table"); 
	var $tbody = $("#topics");
	$tbody.empty();
	$table.empty();
	$table.append("<thead><tr class='active'><th>课题编号</th><th>课题名称</th><th>出题老师</th><th>课题类型</th><th>操作</th></tr></thead>");
	$tbody.empty();
	$.each(rows,function(i,item){
		var $tr = $("<tr>" +
				"<td>"+item.id+"</td>" +
				"<td>"+item.topicName+"</td>" +
				"<td>"+item.teacherName+"</td>" +
				"<td>"+item.topicType+"</td>" +
				"<td><button onclick='contents("+item.id+")' class='btn btn-xs btn-primary content-btn' data-toggle='modal' data-target='#topic-details'>详情</button></td>" +
						"</tr>");
		$tbody.append($tr);
	})
	$($table).append($tbody);
	$(".topicmsg").append($table);
	
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

//撤销课题
function deleteTopic(topicId){
	openLoading();
	$.ajax({
		type : "POST",
		url : "deleteTopic",
		data : {
			"topicId" : topicId
		},
		success : function(result){
			closeLoading();
			if(result.status){
				openMsgModal(result.message);
				getmytopics(0,10);
			}else{
				openMsgModal(result.message);
			}
		}
	});
}