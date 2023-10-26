package com.autocom.helpdesk.controllers;

import com.autocom.helpdesk.enums.Perfil;
import com.autocom.helpdesk.model.Chamado;
import com.autocom.helpdesk.model.Cliente;
import com.autocom.helpdesk.repository.ChamadoRepository;
import com.autocom.helpdesk.repository.ClienteRepository;
import com.autocom.helpdesk.util.PasswordUtil;
import com.autocom.helpdesk.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @GetMapping("/cadastro")
    public ModelAndView cadastro(Cliente cliente){
        ModelAndView mv = new ModelAndView("cliente/cadastro");
        mv.addObject("usuario", new Cliente());
        Perfil[] perfilCliente = {Perfil.CLIENTE};
        mv.addObject("perfils", perfilCliente);
        return mv;
    }


    @PostMapping("/cadastro-cliente")
    public ModelAndView cadastro(@ModelAttribute @Valid Cliente cliente, BindingResult bindingResult, @RequestParam("file") MultipartFile imagem) {
        ModelAndView mv = new ModelAndView("cliente/cadastro");

        if (bindingResult.hasErrors()) {
            // Se houver erros de validação, retorne a página de cadastro com mensagens de erro
            mv.addObject("usuario", cliente);
            return mv;
        }

        // Criptografia de senha
        String hasSenha = PasswordUtil.encoder(cliente.getSenha());
        cliente.setSenha(hasSenha);

        try {
            if (UploadUtil.fazerUploadImagem(imagem)) {
                cliente.setImagem(imagem.getOriginalFilename()); // Armazenando o caminho da imagem, e não a imagem
            }
            cliente.setNome(cliente.getNome().toUpperCase());
            clienteRepository.save(cliente);
            System.out.println("Salvo com sucesso: " + cliente.getNome() + cliente.getImagem());
            return home(1);
        } catch (Exception e) {
            mv.addObject("msgErro", e.getMessage());
            System.out.println("Erro ao salvar: " + e.getMessage());
            return mv;
        }
    }

    @GetMapping("/list-clientes")
    public ModelAndView clientesList(){
        ModelAndView mv = new ModelAndView("cliente/lista-cliente");
        mv.addObject("clientes", clienteRepository.findAll());
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluirCliente(@PathVariable("id") Integer id){
        clienteRepository.deleteById(id);
        return home(1);
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView("cliente/editar");
        mv.addObject("perfils", Perfil.values());
        mv.addObject("usuario", clienteRepository.findById(id));
        return mv;
    }

    @PostMapping("/editar-cliente")
    public ModelAndView editar(Cliente cliente){
        ModelAndView mv = new ModelAndView("cliente/editar");
        clienteRepository.save(cliente);
        return clientesList();
    }

    @GetMapping("/inicio-cliente")
    public ModelAndView home(@RequestParam(defaultValue = "1") int page){
        ModelAndView mv = new ModelAndView("home/index");
        Pageable pageReq = PageRequest.of((page -1),2);
        Page<Chamado> resultPages = chamadoRepository.findAll(pageReq);
        mv.addObject("chamadosList", resultPages);
        return mv;
    }
}
