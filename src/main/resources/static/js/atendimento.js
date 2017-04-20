$(document).ready(function() {
	$('#btnFinalizarPref').hide();
	$('#btnFinalizarNormal').hide();

});


function finalizarAtendimento(id) {
	var url = window.location.pathname.toString();
	$.ajax({
		method : 'GET',
		url : url + '/finalizar/' + id
	});
}

function buscarClienteEditar(id) {
	Materialize.updateTextFields();
	var url = window.location.pathname.toString();
	$.ajax({
		method : 'GET',
		url : url + '/buscarParaEditar/' + id
	}).then(function(result) {
		$('#clienteNome').val(result.nome);
		$('#clienteId').val(result.id);
		$('#clienteCpf').val(result.cpf);
		$('#clienteRg').val(result.rg);
		$('#clienteCidade').val(result.cidade);
		$('#clienteBairro').val(result.bairro);
		$('#clienteEstado').val(result.estado);
		$('#clienteCep').val(result.cep);
		$('#clienteEndereco').val(result.endereco);
		$('#modalCliente').modal('open');
	});

}

function atender(id) {
	var url = window.location.pathname.toString();
	$.ajax({
		method : 'GET',
		url : url + '/atender/' + id
	}).then(function() {
		$('#btnFinalizarNormal').show();
		$('#btnAtenderNormal').hide();
	});
}

function atenderPreferencial(id) {
	var url = window.location.pathname.toString();
	$.ajax({
		method : 'GET',
		url : url + '/atender/' + id
	}).then(function() {
		$('#btnFinalizarPref').show();
		$('#btnAtenderPref').hide();
	});
}
