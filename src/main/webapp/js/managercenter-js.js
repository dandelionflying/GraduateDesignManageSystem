
window.onload = function(){
	/*$(function() {
	  $('[name="my-checkbox"]').bootstrapSwitch();
	});*/
	
	$.ajax({
		type	: "POST",
		url		: "getstates",
		
		contentType:"application/json",//返回的数据的数据格式
		success	: function(data){
			console.log(data);
			var statebody = $(".statebody");
			var open = new String("开启");
			var close = new String("关闭");
			$.each(data,function(i,item){
				var state = item.state=='1'?open:close;
				var btnname = item.state=='1'?close:open;
				var btn = item.state=='0'?$("<button type='button' onclick='changeState("+item.id+","+1+")' class='am-btn am-round am-btn-success am-btn-xs'>"+btnname+"</button>")
						:$("<button type='button' onclick='changeState("+item.id+","+0+")'class='am-btn am-round am-btn-default am-btn-xs'>"+btnname+"</button>");
				statebody.append($("<tr><td class='statename' id='statename"+item.id+"'>"
						+item.statename
						+"</td><td class='state' id='state-"+item.id+"'>"
						+state
						+"</td><td class='state-btn' id='state-btn-"+item.id+"'></td></tr>"));
				$("#state-btn-"+item.id).append(btn);
			});
		}
	});
	
	//选题人数
	$.ajax({
		type : "GET",
		url : "countSt",
		success : function(result){
			if(result.status){
				$("#number-st").html(result.data);
			}else{
				$("#number-st").html(0);
			}
		}
	});
	//待审核数
	$.ajax({
		type : "GET",
		url : "countTopic/"+0,
		success : function(result){
			if(result.status){
				$("#number-topic").html(result.data);
			}else{
				$("#number-topic").html(0);
			}
		}
	});
	//通过数
	$.ajax({
		type : "GET",
		url : "countTopic/"+2,
		success : function(result){
			if(result.status){
				$("#number-pass").html(result.data);
			}else{
				$("#number-pass").html(0);
			}
		}
	});
	//待审阅文档数
	$.ajax({
		type : "GET",
		url : "countDoc",
		success : function(result){
			if(result.status){
				$("#number-apply").html(result.data);
			}else{
				$("#number-apply").html(0);
			}
		}
	});
	
}
function changeState(id,state){
	
	$.ajax({
		type	: "POST",
		url		: "changeState",
		data	: {
			"id" : id,
			"state" : state,
		},
		success	: function(data){
			alert(data);
			window.location.reload();
		}
	
	});
}