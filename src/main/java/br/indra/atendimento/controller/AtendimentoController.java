package br.indra.atendimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.indra.atendimento.service.AtendimentoService;

@Controller
@RequestMapping("/atendimento")
public class AtendimentoController {

	@Autowired
	private AtendimentoService atendimentoService;

	@RequestMapping
	public ModelAndView atendimento() {
		ModelAndView mv = new ModelAndView("/atendimento");
		if (atendimentoService.buscarAtendimentos() && !atendimentoService.getListaAtendimento().isEmpty()) {
			mv.addObject("listaAtendimentoCompleta", atendimentoService.getListaAtendimento());
			mv.addObject("listaAtendimentoNormal", atendimentoService.getListaAtendimentoNormal());
			mv.addObject("listaAtendimentoPreferencial", atendimentoService.getListaAtendimentoPreferencial());
			mv.addObject("cliente", !atendimentoService.getListaAtendimentoNormal().isEmpty()
					? atendimentoService.getListaAtendimentoNormal().get(0) : "");
			mv.addObject("clientePreferencial", !atendimentoService.getListaAtendimentoPreferencial().isEmpty()
					? atendimentoService.getListaAtendimentoPreferencial().get(0) : "");
		}
		return mv;
	}

	@GetMapping(value = "/excluir/{id}")
	public String exlcluirAtendimento(@PathVariable("id") Long id, RedirectAttributes ra) {
		if (atendimentoService.excluirAtendimento(id)) {
			ra.addFlashAttribute("mensagemSucesso", "Atendimento excluído com sucesso!");
		} else {
			ra.addFlashAttribute("mensagemErro", "Erro ao excluir atendimento!");
		}
		return "redirect:/atendimento";
	}

	@GetMapping(value = "/finalizar/{id}")
	public String finalizarAtendimento(@PathVariable(value = "id") Long id, RedirectAttributes ra) {
		System.out.println("akii");
		if (atendimentoService.finalizarAtendimento('F', id)) {
			ra.addFlashAttribute("mensagemSucesso", "Atendimento finalizado com sucesso!");
		} else {
			ra.addFlashAttribute("mensagemErro", "Erro ao finalizar atendimento!");
		}
		return "redirect:/atendimento";
	}
}
