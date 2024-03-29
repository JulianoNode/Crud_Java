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

import com.jmr.app.domain.ValorProduto;
import com.jmr.app.service.ValorProdutoService;

@Controller
@RequestMapping("valorProdutos")
public class ValorProdutoController {

    @Autowired
    private ValorProdutoService service;

    @GetMapping({"", "/"})
    public String abrir(ValorProduto valorProduto) {

        return "valorProduto/valorProdutoCad";
    }

    @PostMapping("/salvar")
    public String salvar(ValorProduto valorProduto, RedirectAttributes attr) {
        try {
            service.salvar(valorProduto);
        attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
        } catch (Exception e) {
            attr.addFlashAttribute("aviso", "ATENÇÂO! Operação não realizada! "
            		+ "Essa VALOR DE PARCELA já está cadastrada!");
            return "redirect:/valorProdutos";
        }
        

        return "redirect:/valorProdutos";
    }

    @GetMapping("/datatables/server")
    public ResponseEntity<?> getValorProdutos(HttpServletRequest request) {

        return ResponseEntity.ok(service.buscarValorProdutos(request));
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("valorProduto", service.buscarPorId(id));
        return "valorProduto/valorProdutoCad";
    }

    @GetMapping("/excluir/{id}")
    public String abrir(@PathVariable("id") Long id, RedirectAttributes attr) {
        service.remover(id);
        attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
        return "redirect:/valorProdutos";
    }
}
