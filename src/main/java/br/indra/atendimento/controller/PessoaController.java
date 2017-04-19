package br.indra.atendimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String salvarClientes(Pessoa pessoa, BindingResult br, RedirectAttributes ra) {
		if (pessoaService.salvarPessoa(pessoa)) {
			ra.addFlashAttribute("mensagemSucesso", "Cliente excluído com sucesso!");
		} else {
			ra.addFlashAttribute("mensagemErro", "Não foi possível excluir cliente");
		}

		return "redirect:/clientes";
	}

	@GetMapping(value = "/excluir/{id}")
	public String excluirCliente(@PathVariable Long id, RedirectAttributes ra) {
		if (pessoaService.excluirPessoa(id)) {
			ra.addFlashAttribute("mensagemSucesso", "Cliente excluído com sucesso!");
		} else {
			ra.addFlashAttribute("mensagemErro", "Não foi possível excluir cliente");
		}
		return "redirect:/clientes";
	}

}
