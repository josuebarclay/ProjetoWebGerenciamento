package com.autocom.helpdesk.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class UploadUtil {

    public static boolean fazerUploadImagem(MultipartFile imagem) {

        boolean sucessoUpload = false;

        if (!imagem.isEmpty()) {
            String nomeArquivo = imagem.getOriginalFilename();
            try {
                // Criando diretório para armazenar imagem
                String pastaUploadImagem = "C:\\springdesk-curso-start\\src\\main\\resources\\static\\images\\img-uploads";
                File dir = new File(pastaUploadImagem);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // Criando o arquivo no diretório
                File serverFile = new File(dir.getAbsolutePath() + File.separator + nomeArquivo);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

                stream.write(imagem.getBytes());
                stream.close();

                System.out.println("Armazenado em: " + serverFile.getAbsolutePath());
                System.out.println("Você fez o upload do arquivo: " + nomeArquivo + " com sucesso.");
                sucessoUpload = true; // Definindo como verdadeiro após o upload bem-sucedido
            } catch (Exception e) {
                System.out.println("Você falhou em carregar o arquivo: " + nomeArquivo + " => " + e.getMessage());
            }
        } else {
            System.out.println("Você falhou em carregar a imagem porque ele está vazio");
        }
        return sucessoUpload;
    }
}

