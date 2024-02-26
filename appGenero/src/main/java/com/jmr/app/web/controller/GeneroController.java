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

import com.jmr.app.domain.Genero;
import com.jmr.app.service.GeneroService;

@Controller
@RequestMapping("generos")
public class GeneroController {

	@Autowired
	private GeneroService service;

	@GetMapping({ "", "/" })
	public String abrir(Genero genero) {

		return "genero/generoCad";
	}

	@PostMapping("/salvar")
	public String salvar(Genero genero, RedirectAttributes attr) {
		try {
			service.salvar(genero);
			attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		} catch (Exception e) {

			attr.addFlashAttribute("aviso", "ATENÇÂO! Operação não realizada! Essa GENERO já está cadastrada!");
			return "redirect:/generos";
		}

		return "redirect:/generos";
	}

	@GetMapping("/datatables/server")
	public ResponseEntity<?> getGeneros(HttpServletRequest request) {

		return ResponseEntity.ok(service.buscarGeneros(request));
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("genero", service.buscarPorId(id));
		return "genero/generoCad";
	}

	@GetMapping("/excluir/{id}")
	public String abrir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/generos";
	}
}
