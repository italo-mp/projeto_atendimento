package br.indra.atendimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.indra.atendimento.model.Pessoa;
import br.indra.atendimento.service.PessoaService;

@Controller
@RequestMapping("/clientes")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@RequestMapping
	public ModelAndView clientes() {
		ModelAndView mv = new ModelAndView("/clientes");
		mv.addObject("listaPessoas", pessoaService.buscarPessoas());
		mv.addObject(new Pessoa());
		return mv;
	}

	@PostMapping
	public ModelAndView salvarClientes(Pessoa pessoa) {
		pessoaService.salvarPessoa(pessoa);
		return clientes();
	}
}
