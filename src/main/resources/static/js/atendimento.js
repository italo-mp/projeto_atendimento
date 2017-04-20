function teste() {
	console.log('testeee');
}

function finalizarAtendimento(id) {
	var url = window.location.pathname.toString();
	$.ajax({
		method : 'GET',
		url : url + '/finalizar/' + id
	});
}