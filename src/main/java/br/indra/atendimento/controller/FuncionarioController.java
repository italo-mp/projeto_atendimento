package br.indra.atendimento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.indra.atendimento.model.Cargo;
import br.indra.atendimento.model.Funcionario;
import br.indra.atendimento.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@RequestMapping
	public ModelAndView funcionario(@RequestParam(value = "nomeBusca", required = false) String nomeBusca) {
		ModelAndView mv = new ModelAndView("/funcionarios");
		if (nomeBusca == null || nomeBusca.isEmpty()) {
			mv.addObject("listaFuncionarios", funcionarioService.buscarFuncionarios());
		} else {
			mv.addObject("listaFuncionarios", funcionarioService.buscarFuncionarioPorNome(nomeBusca));
		}
		mv.addObject(new Funcionario());
		return mv;
	}

	@PostMapping
	public String salvarFuncionarios(Funcionario funcionario, BindingResult br, RedirectAttributes ra) {
		if (funcionarioService.salvarFuncionario(funcionario)) {
			ra.addFlashAttribute("mensagemSucesso", "Funcionário salvo com sucesso!");
		} else {
			ra.addFlashAttribute("mensagemErro", "Não foi possível salvar funcionário");
		}

		return "redirect:/funcionarios";
	}

	@GetMapping(value = "/excluir/{id}")
	public String excluirFuncionarios(@PathVariable Long id, RedirectAttributes ra) {
		if (funcionarioService.excluirFuncionario(id)) {
			ra.addFlashAttribute("mensagemSucesso", "Funcionário excluído com sucesso!");
		} else {
			ra.addFlashAttribute("mensagemErro", "Não foi possível excluir funcionário");
		}

		return "redirect:/funcionarios";
	}

	@GetMapping(value = "/buscarParaEditar/{id}")
	@ResponseBody
	public Funcionario funcionario(@PathVariable(value = "id") Long id) {
		return funcionarioService.buscarParaEditar(id);
	}

	@ModelAttribute(name = "listaCargos")
	public List<Cargo> buscarCargos() {
		return funcionarioService.buscarCargos();
	}
}
