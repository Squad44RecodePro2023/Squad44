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

/**
 * Controlador para lidar com operações relacionadas aos serviços.
 * Responsável por listar, cadastrar, editar e excluir serviços.
 */

@Controller
@RequestMapping("/servicos")
public class ServicosController {

    @Autowired
    private ServicosRepository servicosRepository;

    /**
     * Lista todos os serviços existentes.
     * 
     * @return ModelAndView contendo a página de listagem dos serviços.
     */
    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("servicos/listar.html");

        List<Servicos> servicoss = servicosRepository.findAll();
        modelAndView.addObject("servicoss", servicoss);
        return modelAndView;
    }

    /**
     * Exibe o formulário para cadastrar um novo serviço.
     * 
     * @return ModelAndView contendo o formulário de cadastro.
     */
    @GetMapping("/cadastrar")
    public ModelAndView exibirFormularioCadastro() {
        ModelAndView modelAndView = new ModelAndView("servicos/cadastrar");
        modelAndView.addObject("servicos", new Servicos());
        return modelAndView;
    }

    /**
     * Cadastra um novo serviço.
     * 
     * @param servicos O serviço a ser cadastrado.
     * @return ModelAndView redirecionando para a lista de serviços após o cadastro.
     */
    @PostMapping("/cadastrar")
    public ModelAndView cadastrarNovoservicos(@ModelAttribute("servicos") Servicos servicos) {
        ModelAndView modelAndView = new ModelAndView();
        servicosRepository.save(servicos);
        modelAndView.setViewName("redirect:/servicos");
        return modelAndView;
    }

    /**
     * Exibe o formulário para editar um serviço existente.
     * 
     * @param id O ID do serviço a ser editado.
     * @return ModelAndView contendo o formulário de edição.
     */
    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("servicos/editar.html");
        Servicos servicos = servicosRepository.getReferenceById(id);
        modelAndView.addObject("servicos", servicos);
        return modelAndView;
    }

    /**
     * Salva as alterações feitas em um serviço existente.
     * 
     * @param servicos O serviço com as alterações feitas.
     * @return ModelAndView redirecionando para a lista de serviços após a edição.
     */
    @PostMapping("/{id}/editar")
    public ModelAndView editar(Servicos servicos) {
        servicosRepository.save(servicos);
        ModelAndView modelAndView = new ModelAndView("redirect:/servicos");

        return modelAndView;
    }

    /**
     * Exclui um serviço existente.
     * 
     * @param id O ID do serviço a ser excluído.
     * @return ModelAndView redirecionando para a lista de serviços após a exclusão.
     */
    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/servicos");
        servicosRepository.deleteById(id);
        return modelAndView;
    }
}
