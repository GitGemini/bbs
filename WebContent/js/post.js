function checkText() {
	var len = $("#text_reply").val().trim().length;
	if(len==0){
		$("#btn_reply").attr("disabled", true); 
	}else{
		$("#btn_reply").attr("disabled", false);
	}
	if (len > 255) {
		var text = $("#text_reply").val().substr(0, 255);
		$("#text_reply").val(text);
		alert("超过字数限制，多出的字将被截断！");
	} else {
		$("#left_count").text(255 - len);
	}
}