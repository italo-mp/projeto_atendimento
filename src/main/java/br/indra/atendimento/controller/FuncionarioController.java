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

import br.indra.atendimento.model.Funcionario;
import br.indra.atendimento.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping
	public ModelAndView funcionario() {
		ModelAndView mv = new ModelAndView("/funcionarios");
		mv.addObject("listaFuncionarios",funcionarioService.buscarFuncionarios());
		mv.addObject(new Funcionario());
		return mv;
	}
	
	@PostMapping
	public String salvarFuncionarios(Funcionario funcionario, BindingResult br, RedirectAttributes ra) {
		
		if(funcionarioService.salvarFuncionario(funcionario)){
			ra.addFlashAttribute("mensagemSucesso", "Funcionário adicionado com sucesso!");
		} else {
			ra.addFlashAttribute("mensagemErro", "Não foi possível adicionar funcionário");
		}
		
		return "redirect:/clientes";
		
	}
	
	@GetMapping(value = "/excluir/{id}")
	public String excluirFuncionarios(@PathVariable Long id, RedirectAttributes ra) {
		
		if(funcionarioService.excluirFuncionario(id)){
			ra.addFlashAttribute("mensagemSucesso", "Funcionário excluído com sucesso!");
		} else {
			ra.addFlashAttribute("mensagemErro", "Não foi possível excluir funcionário");
		}
		
		return "redirect:/clientes";
		
	}
	
}
