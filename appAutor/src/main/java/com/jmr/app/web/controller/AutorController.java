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

import com.jmr.app.domain.Autor;
import com.jmr.app.service.AutorService;


@Controller
@RequestMapping("autores")
public class AutorController {
	
	@Autowired
	private AutorService service;

	@GetMapping({"", "/"})
	public String abrir(Autor autor) {

		return "autor/autorCad";
	}
	
	@PostMapping("/salvar")
	public String salvar(Autor autor, RedirectAttributes attr) {
		service.salvar(autor);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		return "redirect:/autores";
	}
	
	@GetMapping("/datatables/server")
	public ResponseEntity<?> getAutors(HttpServletRequest request) {

		return ResponseEntity.ok(service.buscarAutors(request));
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("autor", service.buscarPorId(id));
		return "autor/autorCad";
	}
	
	@GetMapping("/excluir/{id}")
	public String abrir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/autores";
	}
}
