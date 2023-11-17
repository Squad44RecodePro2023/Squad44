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

import com.example.iformal.model.Usuario;
import com.example.iformal.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("usuario/listar.html");

        List<Usuario> usuarios = usuarioRepository.findAll();
        modelAndView.addObject("usuarios", usuarios);
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView exibirFormularioCadastro() {
        ModelAndView modelAndView = new ModelAndView("usuario/cadastrar");
        modelAndView.addObject("usuario", new Usuario());
        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrarNovoUsuario(@ModelAttribute("usuario") Usuario usuario) {
        ModelAndView modelAndView = new ModelAndView();
        usuarioRepository.save(usuario);
        modelAndView.setViewName("redirect:/usuario");
        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("usuario/editar.html");
        Usuario usuario = usuarioRepository.getReferenceById(id);
        modelAndView.addObject("usuario", usuario);
        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public ModelAndView editar(Usuario usuario) {
        usuarioRepository.save(usuario);
        ModelAndView modelAndView = new ModelAndView("redirect:/usuario");

        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/usuario");
        usuarioRepository.deleteById(id);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("usuraio/detalhar.html");

        Usuario usuario = usuarioRepository.getReferenceById(id);
        modelAndView.addObject("usuario", usuario);
        return modelAndView;
    }
}
