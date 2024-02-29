package com.jmr.app.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jmr.app.domain.Mes;
import com.jmr.app.service.MesService;


@Controller
@RequestMapping("meses")
public class MesController {
	
	@Autowired
	private MesService service;

	@GetMapping({"", "/"})
	public String abrir(Mes mes) {

		return "mes/mesCad";
	}
	
	@PostMapping("/salvar")
	public String salvar(Mes mes, RedirectAttributes attr) {
		service.salvar(mes);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		return "redirect:/meses";
	}
	
	@GetMapping("/datatables/server")
	public ResponseEntity<?> getMess(HttpServletRequest request) {

		return ResponseEntity.ok(service.buscarMess(request));
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("mes", service.buscarPorId(id));
		return "mes/mesCad";
	}
	
	@GetMapping("/excluir/{id}")
	public String abrir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/meses";
	}
}
