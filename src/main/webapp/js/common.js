function openLoading(){
	$("#loading-modal").modal("show");
}
function closeLoading(){
	$("#loading-modal").modal('hide');
}
function openMsgModal(msg){
	$("#msg-content").html(msg);
	$("#msg-modal").modal("show");
}
function closeMsgModal(){
	$("#msg-modal").modal('hide');
}
function timeFormatter(value) {
    if(value){
    	var da = new Date(parseInt((value.toString()).replace("/Date(", "").replace(")/" , "").split( "+")[0]));
    	return da.getFullYear() + "-" + (da.getMonth() + 1) + "-" + da.getDate() + " " + da.getHours() + ":" + da.getMinutes() + ":" + da.getSeconds();
    }
}