package com.autocom.helpdesk.controllers;

import com.autocom.helpdesk.enums.Perfil;
import com.autocom.helpdesk.enums.Prioridade;
import com.autocom.helpdesk.enums.StatusTicket;
import com.autocom.helpdesk.model.Chamado;
import com.autocom.helpdesk.model.Cliente;
import com.autocom.helpdesk.repository.ChamadoRepository;
import com.autocom.helpdesk.repository.ClienteRepository;
import com.autocom.helpdesk.repository.TecnicoRepository;
import com.autocom.helpdesk.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ticket")
public class Chamados {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("/autocom/")
    public ModelAndView chamadoHome(@RequestParam(defaultValue = "1") int page){
        ModelAndView mv = new ModelAndView("home/index");
        Pageable pageReq = PageRequest.of((page -1),5);
        Page<Chamado> resultPages = chamadoRepository.findAll(pageReq);
        mv.addObject("chamadosList", resultPages);
        return mv;
    }

    @GetMapping("/criar")
    public ModelAndView ticket(Chamado chamado) {
        ModelAndView mv = new ModelAndView("chamados/ticket");
        mv.addObject("statusChamados", StatusTicket.values());
        mv.addObject("prioridade", Prioridade.values());
        mv.addObject("tecnicos", tecnicoRepository.findAll());

        // Obtenha a lista de clientes e ordene-a em ordem alfabética pelo nome
        List<Cliente> listaClientes = clienteRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Cliente::getNome))
                .collect(Collectors.toList());

        mv.addObject("listaClientes", listaClientes);
        mv.addObject("tickets", chamado);
        return mv;
    }

    @PostMapping("/salvarTicket")
    public ModelAndView salvarTicket(@Valid Chamado chamado, BindingResult br) {
        ModelAndView mv = new ModelAndView();

        if (br.hasErrors()) {
            mv.setViewName(("chamados/ticket"));
            mv.addObject("tickets", chamado);
            mv.addObject("statusChamados", StatusTicket.values());
            mv.addObject("prioridade", Prioridade.values());
            mv.addObject("tecnicos", tecnicoRepository.findAll());
            mv.addObject("listaClientes", clienteRepository.findAll());
        } else {
            // Encontre o cliente com base no nome fornecido no formulário
            String nomeCliente = chamado.getCliente().getNome();
            Optional<Cliente> clienteOptional = clienteRepository.findByNome(nomeCliente);

            if (clienteOptional.isPresent()) {
                Cliente cliente = clienteOptional.get(); // Extrai o Cliente do Optional
                chamado.setCliente(cliente); // Associe o cliente ao chamado
                chamado.setObservacao(chamado.getObservacao().toUpperCase());
                chamado.setTitulo(chamado.getTitulo().toUpperCase());
                chamadoRepository.save(chamado);
                return chamadoHome(1);
            } else {
                // Cliente não encontrado - você pode tratar esse caso adequadamente
                // Por exemplo, mostrando uma mensagem de erro no formulário
            }
        }
        return chamadoHome(1);
    }

}




