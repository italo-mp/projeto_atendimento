function buscarClienteEditar(id) {
	var url = window.location.pathname.toString();
	$.ajax({
		method : 'GET',
		url : url+'/buscarParaEditar/' + id
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

$('#btnCadastroCliente').on('click', function() {
	document.getElementById("formCliente").reset();

});