$(document).ready(function() {
	$("#enter").click(function(){
		sessionStorage.login = $("#login").val();
		sessionStorage.passw = $("#password").val();
		console.log(sessionStorage.login+"  "+sessionStorage.passw);
	});
});