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

import com.jmr.app.domain.TempoHora;
import com.jmr.app.service.TempoHoraService;

@Controller
@RequestMapping("tempoHoras")
public class TempoHoraController {

    @Autowired
    private TempoHoraService service;

    @GetMapping({"", "/"})
    public String abrir(TempoHora tempoHora) {

        return "tempoHora/tempoHoraCad";
    }

    @PostMapping("/salvar")
    public String salvar(TempoHora tempoHora, RedirectAttributes attr) {
        try {
            service.salvar(tempoHora);
        attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
        } catch (Exception e) {
            attr.addFlashAttribute("aviso", "ATENÇÂO! Operação vão realizada, Essa HORA já está cadastrada!");
            return "redirect:/tempoHoras";
        }
        

        return "redirect:/tempoHoras";
    }

    @GetMapping("/datatables/server")
    public ResponseEntity<?> getTempoHoras(HttpServletRequest request) {

        return ResponseEntity.ok(service.buscarTempoHoras(request));
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("tempoHora", service.buscarPorId(id));
        return "tempoHora/tempoHoraCad";
    }

    @GetMapping("/excluir/{id}")
    public String abrir(@PathVariable("id") Long id, RedirectAttributes attr) {
        service.remover(id);
        attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
        return "redirect:/tempoHoras";
    }
}
