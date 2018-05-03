$(document).ready(function() {
	$(".title_text").keydown(function() {
		var len = $(".title_text").val().length + 1;
		if (len > 255) {
			var num = $(".title_text").val().substr(0, 80);
			$(".title_text").val(num);
			alert("超过字数限制，多出的字将被截断！");
		} else {
			$("#title_left").text(80 - len);
		}
	});

	$(".content_text").keydown(function() {
		var len = $(".content_text").val().length + 1;
		if (len > 255) {
			var num = $(".content_text").val().substr(0, 255);
			$(".content_text").val(num);
			alert("超过字数限制，多出的字将被截断！");
		} else {
			$("#content_left").text(255 - len);
		}
	});
});