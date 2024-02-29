package com.jmr.app.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.jmr.app.domain.Ano;
import com.jmr.app.repository.AnoRepository;
import com.jmr.app.service.AnoService;


@Controller
@RequestMapping("anos")
public class AnoController {

	@Autowired
	private AnoRepository anoRepository;
	
	@Autowired
	private AnoService service;

	@GetMapping({"", "/"})
	public String abrir(Ano ano) {

		return "ano/anoCad";
	}
	
	@PostMapping("/salvar")
	public String salvar(Ano ano, RedirectAttributes attr ) //Anotação para ano
	{
		service.salvar(ano);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		return "redirect:/anos";
	}
	
	@GetMapping("/datatables/server")
	public ResponseEntity<?> getAnos(HttpServletRequest request, ModelMap model) {

		model.addAttribute("lista", anoRepository.findAll(Sort.by("ano")));
		
		return ResponseEntity.ok(service.buscarAnos(request));
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("ano", service.buscarPorId(id));
		return "ano/anoCad";
	}
	
	@GetMapping("/excluir/{id}")
	public String abrir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/anos";
	}

	
}
