$(document).ready(function() {
	$("#enter").click(function(){
		sessionStorage.login = $("#login").val();
		sessionStorage.passw = $("#password").val();
		console.log(sessionStorage.login+"  "+sessionStorage.passw);
		
		var url = window.location.pathname.toString();
		$.ajax({
			method : 'GET',
			url : url + '/buscarPorNome/' + sessionStorage.login
		}).then(function(result) {
			if(result.nome == sessionStorage.login &&
			   result.senha == sessionStorage.passw){
				window.location.replace('/clientes');
				console.log("passou");
			}
		});
		
	});
});