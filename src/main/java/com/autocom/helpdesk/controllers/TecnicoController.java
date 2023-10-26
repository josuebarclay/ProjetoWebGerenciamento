package com.autocom.helpdesk.controllers;

import com.autocom.helpdesk.enums.Perfil;
import com.autocom.helpdesk.model.Chamado;
import com.autocom.helpdesk.model.Tecnico;
import com.autocom.helpdesk.repository.ChamadoRepository;
import com.autocom.helpdesk.repository.TecnicoRepository;
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
@RequestMapping("/tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @GetMapping("/cadastro")
    public ModelAndView cadastro(Tecnico tecnico){
        ModelAndView mv = new ModelAndView("tecnico/cadastro");
        mv.addObject("tecnico", new Tecnico());
        Perfil[] perfilTecnico = {Perfil.TECNICO, Perfil.ADMIN};
        mv.addObject("perfils", perfilTecnico);
        return mv;
    }

    @PostMapping("/cadastro-tecnico")
    public ModelAndView cadastro(@ModelAttribute @Valid Tecnico tecnico, BindingResult bindingResult, @RequestParam("file") MultipartFile imagem) {
        ModelAndView mv = new ModelAndView("tecnico/cadastro");

        if (bindingResult.hasErrors()) {
            // Se houver erros de validação, retorne a página de cadastro com mensagens de erro
            mv.addObject("tecnico", tecnico);
            return mv;
        }

        // Criptografia de senha
        String hashSenha = PasswordUtil.encoder(tecnico.getSenha());
        tecnico.setSenha(hashSenha);

        try {
            if (UploadUtil.fazerUploadImagem(imagem)) {
                tecnico.setImagem(imagem.getOriginalFilename()); // Armazenando o caminho da imagem, e não a imagem
            }
            tecnico.setNome(tecnico.getNome().toUpperCase());
            tecnicoRepository.save(tecnico);
            System.out.println("Salvo com sucesso: " + tecnico.getNome() + tecnico.getImagem());
            return home(1);
        } catch (Exception e) {
            mv.addObject("msgErro", e.getMessage());
            System.out.println("Erro ao salvar: " + e.getMessage());
            return mv;
        }
    }


    @GetMapping("/list-tecnico")
    public ModelAndView tecnicolist(){
        ModelAndView mv = new ModelAndView("tecnico/tecnico-list");
        mv.addObject("tecnico", tecnicoRepository.findAll());
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluirTecnico(@PathVariable("id") Integer id){
        tecnicoRepository.deleteById(id);
        return home(1);
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView("tecnico/editar");
        mv.addObject("perfils", Perfil.values());
        mv.addObject("tec", tecnicoRepository.findById(id));
        return mv;
    }

    @PostMapping("/editar-cliente")
    public ModelAndView editar(Tecnico tecnico){
        ModelAndView mv = new ModelAndView("tecnico/editar");
        tecnicoRepository.save(tecnico);
        return tecnicolist();
    }


    @GetMapping("/inicio-tecnico")
    public ModelAndView home(@RequestParam(defaultValue = "1") int page) {
        ModelAndView mv = new ModelAndView("home/index");
        Pageable pageReq = PageRequest.of((page -1),2);
        Page<Chamado> resultPages = chamadoRepository.findAll(pageReq);
        mv.addObject("chamadosList", resultPages);
        return mv;
    }

    @GetMapping("/editar-perfil")
    public ModelAndView editarPerfil(@RequestParam("id") Integer id){
        ModelAndView mv = new ModelAndView("tecnico/editProfile");
        mv.addObject("usuario", tecnicoRepository.findById(id));
        return mv;
    }

    @PostMapping("/editar-perfil")
    public ModelAndView editarPerfil(@ModelAttribute Tecnico tecnico, @RequestParam("file") MultipartFile imagem){
        ModelAndView mv = new ModelAndView("tecnico/editProfile");

        try {
            if (UploadUtil.fazerUploadImagem(imagem)) {
                tecnico.setImagem(imagem.getOriginalFilename()); //armazenando o caminho da imagem, e nao a imagem
            }
            tecnicoRepository.save(tecnico);
            System.out.println("Salvo com sucesso: " + tecnico.getNome() + tecnico.getImagem());
            return home(1);
        }catch (Exception e){
            mv.addObject("msgErro", e.getMessage());
            System.out.println("Erro ao salvar" + e.getMessage());
            return mv;
        }
    }
}




