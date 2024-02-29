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

import com.jmr.app.domain.Dia;

import com.jmr.app.service.DiaService;


@Controller
@RequestMapping("dias")
public class DiaController {
	
	@Autowired
	private DiaService service;

	@GetMapping({"", "/"})
	public String abrir(Dia dia) {

		return "dia/diaCad";
	}
	
	@PostMapping("/salvar")
	public String salvar(Dia dia, RedirectAttributes attr) {
		service.salvar(dia);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		return "redirect:/dias";
	}
	
	@GetMapping("/datatables/server")
	public ResponseEntity<?> getDias(HttpServletRequest request, ModelMap model) {
		
		return ResponseEntity.ok(service.buscarDias(request));
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("dia", service.buscarPorId(id));
		return "dia/diaCad";
	}

	
}
