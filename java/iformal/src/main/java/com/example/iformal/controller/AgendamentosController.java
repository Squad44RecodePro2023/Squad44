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

import com.example.iformal.model.Agendamentos;
import com.example.iformal.repository.AgendamentosRepository;

/**
 * Controlador para lidar com operações relacionadas aos agendamentos.
 * Responsável por listar, cadastrar, editar e excluir agendamentos.
 */

@Controller
@RequestMapping("/agendamentos")
public class AgendamentosController {

    @Autowired
    private AgendamentosRepository agendamentosRepository;

    /**
     * Lista todos os agendamentos existentes.
     * 
     * @return ModelAndView contendo a página de listagem dos agendamentos.
     */
    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("agendamentos/listar.html");

        List<Agendamentos> agendamentos = agendamentosRepository.findAll();
        modelAndView.addObject("agendamentos", agendamentos);
        return modelAndView;
    }

    /**
     * Exibe o formulário para cadastrar um novo serviço.
     * 
     * @return ModelAndView contendo o formulário de cadastro.
     */
    @GetMapping("/cadastrar")
    public ModelAndView exibirFormularioCadastro() {
        ModelAndView modelAndView = new ModelAndView("agendamentos/cadastrar.html");
        modelAndView.addObject("agendamentos", new Agendamentos());
        return modelAndView;
    }

    /**
     * Cadastra um novo serviço.
     * 
     * @param agendamentos O serviço a ser cadastrado.
     * @return ModelAndView redirecionando para a lista de agendamentos após o
     *         cadastro.
     */
    @PostMapping("/cadastrar")
    public ModelAndView cadastrarNovoagendamentos(@ModelAttribute("agendamentos") Agendamentos agendamentos) {
        ModelAndView modelAndView = new ModelAndView();
        agendamentosRepository.save(agendamentos);
        modelAndView.setViewName("redirect:/agendamentos");
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
        ModelAndView modelAndView = new ModelAndView("agendamentos/editar.html");
        Agendamentos agendamentos = agendamentosRepository.getReferenceById(id);
        modelAndView.addObject("agendamentos", agendamentos);
        return modelAndView;
    }

    /**
     * Salva as alterações feitas em um serviço existente.
     * 
     * @param agendamentos O serviço com as alterações feitas.
     * @return ModelAndView redirecionando para a lista de agendamentos após a
     *         edição.
     */
    @PostMapping("/{id}/editar")
    public ModelAndView editar(Agendamentos agendamentos) {
        agendamentosRepository.save(agendamentos);
        ModelAndView modelAndView = new ModelAndView("redirect:/agendamentos");

        return modelAndView;
    }

    /**
     * Exclui um serviço existente.
     * 
     * @param id O ID do serviço a ser excluído.
     * @return ModelAndView redirecionando para a lista de agendamentos após a
     *         exclusão.
     */
    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/agendamentos");
        agendamentosRepository.deleteById(id);
        return modelAndView;
    }
}
