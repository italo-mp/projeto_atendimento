function buscarFuncionarioEditar(id) {
	Materialize.updateTextFields();
	var url = window.location.pathname.toString();
	$.ajax({
		method : 'GET',
		url : url + '/buscarParaEditar/' + id
	}).then(function(result) {
		$('#funcionarioNome').val(result.nome);
		$('#funcionarioId').val(result.id);
		$('#funcionarioCpf').val(result.cpf);
		$('#funcionarioRg').val(result.rg);
		$('#funcionarioEmail').val(result.email);
		$('#funcionarioSenha').val(result.senha);
		$('#funcionarioCargo').val(result.cargo.nome);

		$('#modalFuncionarios').modal('open');
	});

}

$('#btnCadastroFuncionario').on('click', function() {
	Materialize.updateTextFields();
	document.getElementById("formFuncionario").reset();

});
