package com.example.iformal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.iformal.model.Servicos;
import com.example.iformal.repository.ServicosRepository;

@Controller
@RequestMapping("/servicos")
public class ServicosController {

    @Autowired
    private ServicosRepository servicosRepository;

    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("servicos/listar.html");

        List<Servicos> servicoss = servicosRepository.findAll();
        modelAndView.addObject("servicoss", servicoss);
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView exibirFormularioCadastro() {
        ModelAndView modelAndView = new ModelAndView("servicos/cadastrar");
        modelAndView.addObject("servicos", new Servicos());
        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrarNovoservicos(@ModelAttribute("servicos") Servicos servicos) {
        ModelAndView modelAndView = new ModelAndView();
        servicosRepository.save(servicos);
        modelAndView.setViewName("redirect:/servicos");
        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("servicos/editar.html");
        Servicos servicos = servicosRepository.getReferenceById(id);
        modelAndView.addObject("servicos", servicos);
        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public ModelAndView editar(Servicos servicos) {
        servicosRepository.save(servicos);
        ModelAndView modelAndView = new ModelAndView("redirect:/servicos");

        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/servicos");
        servicosRepository.deleteById(id);
        return modelAndView;
    }
}
