function timeFormatter(value) {
    if(value){
    	var da = new Date(parseInt((value.toString()).replace("/Date(", "").replace(")/" , "").split( "+")[0]));
    	return da.getFullYear() + "-" + (da.getMonth() + 1) + "-" + da.getDate() + " " + da.getHours() + ":" + da.getMinutes() + ":" + da.getSeconds();
    }
}
function getnotice(){
	$.ajax({
		type : "GET",
		url : "getnotice",
		success : function(result){
			var data = result.data;
			var $nocticeul = $("#notice-ul");
			$nocticeul.empty();
			$.each(data,function(i,item){
				var time = timeFormatter(item.publishTime)
				var $li = $("<li><div class='cosB'>"+time+"</div>"+
						"<div class='cosA'><span class='cosIco'><i class='am-icon-bell-o'></i></span>"+
						"<span>"+item.content+"</span></div></li>");
				$nocticeul.append($li);
			});
			
		}
	});
}
window.onload = function(){
	if (!$.AMUI.support.mutationobserver) {
	      $selected.trigger('changed.selected.amui');
	    }
	$("#btn-addnotice").on("click",function(){
		$("#addnotice-modal-1").modal("open");
	});
	getnotice();
	$("#submit-notice-btn").on("click",function(){
		var $selected = $("#to-who option:selected");
		var user;
		/*$selected.on('change',function(){
			user = $(this).find('option').eq(this.selectedIndex).text();
		});*/
		user = $selected.text();
		
		var content = $("#notice-content").val();
		var receiver ;
		switch(user){
		case "全部":
			receiver = 0;break;
		case "学生":
			receiver = 1;break;
		case "教师":
			receiver = 2;break;
		}
		console.log(user+content);
		console.log(receiver);
		$.ajax({
			type : "POST",
			url	: "addnotice",
			data : {
				"receiver" : receiver,
				"content" : content
			},
			success : function(data){
				console.log(data);
				if(data.flag==true){
					alert(data.message);
					getnotice();
					$("#addnotice-modal-1").modal("close");
				}else{
					$("#addnotice-modal-1").modal("close");
				}
//				window.location.reload();
			}
		});
	});
}