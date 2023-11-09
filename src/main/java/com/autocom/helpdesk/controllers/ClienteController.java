package com.autocom.helpdesk.controllers;

import com.autocom.helpdesk.TratamentoExep.EmailDuplicadoException;
import com.autocom.helpdesk.TratamentoExep.NomeDuplicadoException;
import com.autocom.helpdesk.enums.Perfil;
import com.autocom.helpdesk.model.Cliente;
import com.autocom.helpdesk.repository.ChamadoRepository;
import com.autocom.helpdesk.repository.ClienteRepository;
import com.autocom.helpdesk.service.ClienteService;
import com.autocom.helpdesk.util.PasswordUtil;
import com.autocom.helpdesk.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

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
    public ModelAndView cadastroCliente(@ModelAttribute @Valid Cliente cliente, BindingResult bindingResult, @RequestParam("file") MultipartFile imagem) {
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
            clienteService.saveCliente(cliente);
            System.out.println("Salvo com sucesso: " + cliente.getNome() + cliente.getImagem());
            // Redirecione para a página de sucesso ou outra página apropriada
            return clientesList(1);
        } catch (NomeDuplicadoException e) {
            mv.addObject("msgErro", "Nome já em uso. Escolha um nome diferente.");
            return mv;
        } catch (EmailDuplicadoException e) {
            mv.addObject("msgErro", "E-mail já em uso. Use um e-mail diferente.");
            return mv;
        } catch (Exception e) {
            mv.addObject("msgErro", "Ocorreu um erro ao salvar o cliente. Tente novamente mais tarde.");
            return mv;
        }
    }

    @GetMapping("/list-clientes")
    public ModelAndView clientesList(@RequestParam(defaultValue = "1") int page) {
        ModelAndView mv = new ModelAndView("cliente/lista-cliente");

        // Defina a ordenação por nome do cliente em ordem crescente
        Pageable pageReq = PageRequest.of((page - 1), 10, Sort.by(Sort.Order.asc("nome")));

        Page<Cliente> resultPages = clienteRepository.findAllCliente(pageReq);
        List<Cliente> clientes = resultPages.getContent();

        mv.addObject("clientesList", resultPages);
        mv.addObject("clientes", clientes);

        return mv;
    }


    @GetMapping("/excluir/{id}")
    public ModelAndView excluirCliente(@PathVariable("id") Integer id){
        clienteRepository.deleteById(id);
        return clientesList(1);
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView("cliente/editar");
        Perfil[] perfilCliente = {Perfil.CLIENTE};
        mv.addObject("perfils", perfilCliente);
        mv.addObject("usuario", clienteRepository.findById(id));
        return mv;
    }

    @PostMapping("/editar-cliente")
    public ModelAndView editar(Cliente cliente){
        ModelAndView mv = new ModelAndView("cliente/editar");
        // Criptografia de senha
        String hasSenha = PasswordUtil.encoder(cliente.getSenha());
        cliente.setSenha(hasSenha);
        cliente.setNome(cliente.getNome().toUpperCase());
        clienteRepository.save(cliente);
        return clientesList(1);
    }

    @GetMapping("/pesquisar-cliente")
    public ModelAndView pesquisarCliente(@RequestParam(required = false) String nome) {
        ModelAndView mv = new ModelAndView("cliente/pesquisa-resultado");

        List<Cliente> listaCliente;
        if (nome == null || nome.trim().isEmpty()) {
            listaCliente = clienteRepository.findAllCliente(PageRequest.of(0, 10)).getContent();
        } else {
            listaCliente = clienteRepository.findByNomeContainingIgnoreCase(nome);
        }
        mv.addObject("ListaDeClientes", listaCliente);
        mv.addObject("termoPesquisa", nome); // Passa o termo de pesquisa para exibi-lo na visualização
        return mv;
    }


    @PostMapping("/pesquisar-cliente")
    public ModelAndView pesquisarClientePost(@RequestParam(required = false) String nome) {
        ModelAndView mv = pesquisarCliente(nome); // Reutilize a lógica de pesquisa do método GET
        return mv;
    }











}
