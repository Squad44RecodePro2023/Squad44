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

/**
 * Controlador para lidar com operações relacionadas aos usuários.
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Lista todos os usuários.
     *
     * @return ModelAndView contendo a lista de usuários
     */
    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("usuario/listar.html");

        List<Usuario> usuarios = usuarioRepository.findAll();
        modelAndView.addObject("usuarios", usuarios);
        return modelAndView;
    }

    /**
     * Exibe o formulário de cadastro de usuário.
     *
     * @return ModelAndView para o formulário de cadastro
     */
    @GetMapping("/cadastrar")
    public ModelAndView exibirFormularioCadastro() {
        ModelAndView modelAndView = new ModelAndView("usuario/cadastrar");
        modelAndView.addObject("usuario", new Usuario());
        return modelAndView;
    }

    /**
     * Cadastra um novo usuário.
     *
     * @param usuario O usuário a ser cadastrado
     * @return ModelAndView redirecionando para a lista de usuários após o cadastro
     */
    @PostMapping("/cadastrar")
    public ModelAndView cadastrarNovoUsuario(@ModelAttribute("usuario") Usuario usuario) {
        ModelAndView modelAndView = new ModelAndView();
        usuarioRepository.save(usuario);
        modelAndView.setViewName("redirect:/usuario");
        return modelAndView;
    }

    /**
     * Exibe o formulário para editar um usuario existente.
     * 
     * @param id O ID do usuario a ser editado.
     * @return ModelAndView contendo o formulário de edição.
     */
    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("usuario/editar.html");
        Usuario usuario = usuarioRepository.getReferenceById(id);
        modelAndView.addObject("usuario", usuario);
        return modelAndView;
    }

    /**
     * Salva as alterações feitas em um usuario existente.
     * 
     * @param servicos O usuario com as alterações feitas.
     * @return ModelAndView redirecionando para a lista de usuario após a edição.
     */
    @PostMapping("/{id}/editar")
    public ModelAndView editar(Usuario usuario) {
        usuarioRepository.save(usuario);
        ModelAndView modelAndView = new ModelAndView("redirect:/usuario");

        return modelAndView;
    }

    /**
     * Exclui um serviço existente.
     * 
     * @param id O ID do usuario a ser excluído.
     * @return ModelAndView redirecionando para a lista de usuario após a exclusão.
     */
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
