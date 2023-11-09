package com.autocom.helpdesk.service;

import com.autocom.helpdesk.enums.Perfil;
import com.autocom.helpdesk.model.Cliente;
import com.autocom.helpdesk.model.Tecnico;
import com.autocom.helpdesk.repository.BairroRepository;
import com.autocom.helpdesk.repository.ClienteRepository;
import com.autocom.helpdesk.repository.TecnicoRepository;
import com.autocom.helpdesk.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InjectDB {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    BairroRepository bairroRepository;


    public void injectDB() {
        Tecnico tecnico1 = new Tecnico(null, "SUPERVISOR",
                "supervisor@gmail.com", PasswordUtil.encoder("123"), null, Perfil.TECNICO, null);
        Cliente cliente1 = new Cliente(null, "MERC PORTO ALEGRENSE",
                "portoalegrense2@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente2 = new Cliente(null, "ANDREA CAMISETARIA",
                "amp97224@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente3 = new Cliente(null, "SANDIM",
                "lessandramoura@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente4 = new Cliente(null, "AD VIDROS",
                "ademarnantes27@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente5 = new Cliente(null, "SHOPPING HAVAIANA",
                "alifarias@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente6 = new Cliente(null, "ADEGA PANAMA",
                "adegapanamaconveniencia@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente7 = new Cliente(null, "ANA LU CONVENIENCIA",
                "analuciavieira292@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente8 = new Cliente(null, "caça e pesca",
                "nauticaepesca@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente9 = new Cliente(null, "oficina de julio",
                "of.juliodecastilho@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente10 = new Cliente(null, "BEM BOLADO",
                "jtnakamura1@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente11 = new Cliente(null, "HAMURABI",
                "financeirohamurabi@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente12= new Cliente(null, "VILLA DO TRIGO",
                "villadotrigo@villadotrigo.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente13 = new Cliente(null, "PANIFICADAORA REAL",
                "pmlibano@pmlibano.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente14 = new Cliente(null, "PANIFICADORA SÃO FRANCISCO",
                "ersonantoniobrandao1@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente15 = new Cliente(null, "CARLOS OKAMA",
                "tchuckyokama1@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente16 = new Cliente(null, "OTICA CARLOS RODRIGUES",
                "oticariocg@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente17 = new Cliente(null, "CELSO IWASHITA",
                "celsosadao@yahoo.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente18 = new Cliente(null, "CHEN FENG",
                "brunahuangc@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente19 = new Cliente(null, "CHURRASCARIA ANTUNES E ANTUNES LTDA",
                "churrascariarotasul@outlook.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente20 = new Cliente(null, "CLODOALDO ÓPTICA",
                "opticaclodoaldo@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente21 = new Cliente(null, "COISAS DELA BIJUTERIAS LTDA",
                "financeiro@tudook.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente22 = new Cliente(null, "NISHI CERIOLI",
                "eliandrocerioli@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente23 = new Cliente(null, "FIO DE OURO",
                "comercial_fiodeouro@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente24 = new Cliente(null, "MERCADO SOUZA",
                "souza.depaula@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente25 = new Cliente(null, "CHURRASCARIA caravagio",
                "restaurantecaravagio@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente26 = new Cliente(null, "DELMONDES & CRISPIM LTDA",
                "crispimdelmondes@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente27 = new Cliente(null, "SAKAMOTO",
                "sakamotoautoeletrica@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente28 = new Cliente(null, "OTICA ROYAL",
                "edgard_neves@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente29 = new Cliente(null, "MERCADO SANTA FELICIDADE",
                "edevaldoaraujo2010@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente30 = new Cliente(null, "ELETRO NEW",
                "eletroneww@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente31 = new Cliente(null, "DISCAMARA",
                "gerencia@discamara.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente32 = new Cliente(null, "TOYKO",
                "miyashirox@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente33 = new Cliente(null, "ESCAPAMENTOS BRILHANTES LTDA.",
                "escapebrilhante@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente34 = new Cliente(null, "ADRIANO GAS",
                "sandra.gomes.santana@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente35 = new Cliente(null, "PANIFICADORA DA FAMILIA",
                "cristovaorodrigues65@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente36 = new Cliente(null, "OTICA DI VISAO",
                "ezequiasmelo46@gmail.com@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente37 = new Cliente(null, "FERRO VELHO DO PAULISTA EIRELI",
                "fabiosobrinho_@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente38 = new Cliente(null, "GT MIYAZATO - FRUTARIA ME",
                "frutariadajuliogt@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente39 = new Cliente(null, "PIZZARIA FONTE NOVA",
                "napoleaoantonio.silva@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente40 = new Cliente(null, "CONVENIENCIA DA LIBERDADE",
                "geovanilimas_engcivil@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente41 = new Cliente(null, "PREMIATO",
                "ale.mar2006@yahoo.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente42 = new Cliente(null, "MERCADO BANDEIRAS",
                "mercadobandeira@bol.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente43 = new Cliente(null, "MERCADO BOM PRECO",
                "aral.gotthilf@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente44 = new Cliente(null, "PEDRA SUL",
                "financeiropedrasul@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente45 = new Cliente(null, "DOCE CUPCKAKE",
                "cbdcupcake@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente46 = new Cliente(null, "MANURA",
                "manura@saad.srv.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente47 = new Cliente(null, "DEPOSITO ITATIAI",
                "depositoitatiaia@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente48 = new Cliente(null, "CONVENIENCIA AVENIDA CARLOS",
                "mazzeocampo@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente49 = new Cliente(null, "J. F. A. V. MARINHO ÓTICA",
                "fernandaalmeida29@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente50 = new Cliente(null, "J. L. L. LANCHES",
                "jrgralha@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente51 = new Cliente(null, "CASA JOSE ABRAAO",
                "casajoseabrao@terra.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente52 = new Cliente(null, "OTICA D´LUIX",
                "jnesteche@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente53 = new Cliente(null, "CASA DE CARNE DA MARQUES",
                "gi_balt@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente54 = new Cliente(null, "PANIFICADORA VILAGE",
                "josemario67570@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente55 = new Cliente(null, "JOANA CERVO",
                "jovanacervo@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente56 = new Cliente(null, "KAMPAI",
                "le_streetbreaks@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente57 = new Cliente(null, "SABOR E SAUDE",
                "gindrigo@uol.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente58 = new Cliente(null, "TERRITORIO / SENHOR EXERCITOS",
                "sdemilitar@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente59 = new Cliente(null, "FERNANDA GÁS",
                "rosana_karina2010@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente60 = new Cliente(null, "JEAN FERRO VELHO",
                "lanteri33@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente61 = new Cliente(null, "CONVENIENCIA DIA SIM DIA NÃO",
                "cgfilial02@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente62 = new Cliente(null, "LE CHANT /LE CISEAUX  /LE COINLTDA /LE MOULIN",
                "admlemoulin@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente63 = new Cliente(null, "NOBRE PAINOS",
                "nobre_pianos@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente64 = new Cliente(null, "TATA",
                "andrelanteri@icloud.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente65 = new Cliente(null, "vem pet",
                "clinicavempet@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente66 = new Cliente(null, "LIRA E LIRA COMÉRCIO VAREJISTA DE BEBIDAS LTDA ME",
                "dhu_lima@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente67 = new Cliente(null, "LOJAS DUARTE EIRELI - EPP",
                "lojasduarte@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente68 = new Cliente(null, "A PAULISTANA",
                "ddmmachadotransportes@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente69 = new Cliente(null, "PAULO ESPORTES",
                "paulosportmp@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente70 = new Cliente(null, "REI DAS MAQUINAS",
                "reidasmaquinasms@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente71 = new Cliente(null, "TOGO",
                "fernanda_pusebon@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente72 = new Cliente(null, "MARCOS SHINZATO",
                "contatomarcosshinzato@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente73 = new Cliente(null, "INSTALADORA",
                "instaladorasato@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente74 = new Cliente(null, "MANU UTILIDADES",
                "marquesdasilva305@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente75 = new Cliente(null, "MARY MODAS",
                "marymodas2003@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente76 = new Cliente(null, "BALAIO PAPELARIA",
                "balaiopapelaria@uol.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente77 = new Cliente(null, "OFICINA MARINGA",
                "maringacentro1@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente78 = new Cliente(null, "conveniencia guaicurus",
                "patriciaoviedodasilva@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente79 = new Cliente(null, "MERC BOLANDO",
                "mercadobolando@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente80 = new Cliente(null, "CASA DE CARNE SÃO MARCOS BETHE",
                "elizabethe1250@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente81 = new Cliente(null, "AUTO TEC",
                "mecanco@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente82 = new Cliente(null, "CONV MILENA",
                "milenaconveniencia@outlook.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente83 = new Cliente(null, "FLORESTAL",
                "florestal_hortifruti@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente84 = new Cliente(null, "MORENA ESTRUTURA",
                "morenaservfestas@yahoo.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente85 = new Cliente(null, "CHURRACARIA NILSON",
                "sguasso@bol.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente86 = new Cliente(null, "AUTO ELETRICA PIONEIRA",
                "autoeletricapioneira@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente87 = new Cliente(null, "FUJI SOBARIA",
                "fabio_srx@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente88 = new Cliente(null, "PADARIA LEONARDA",
                "physkal@uol.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente89 = new Cliente(null, "ARTE EM TUDO",
                "artemtudoms@outlook.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente90 = new Cliente(null, "PAULO BUCATO",
                "paulobucatto72@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente91 = new Cliente(null, "PAULO BARROS MACEDO",
                "paulobarros1986@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente92 = new Cliente(null, "PEDAGGIO SORVETES LTDA ME",
                "pc.roese@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente93 = new Cliente(null, "TRADIÇÃO FERRAMENTAS",
                "tradicaoferramentas@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente94 = new Cliente(null, "LAS MINAS",
                "adriano@matparcg.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente95 = new Cliente(null, "R. L. ALIMENTOS LTDA",
                "r.l.alimentos@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente96 = new Cliente(null, "MERCADO ESTRELA",
                "mercadoestrelan@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente97 = new Cliente(null, "VIVVA VIDA PARQUE",
                "vivaavidaparque@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente98 = new Cliente(null, "RESTAURANTE VIVA VIDA LTDA.",
                "engelsouza@uol.com.br", PasswordUtil.encoder("123"),
                null, Perfil.CLIENTE, null);
        Cliente cliente99 = new Cliente(null, "UBALDO DE SÁ CARNELOS",
                "carnelos30@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente100 = new Cliente(null, "TUTTU IN FIOER",
                "hosanacristina@bol.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente101 = new Cliente(null, "TRAQPARTS PEÇAS PARA TRATORES LTDA",
                "pedro@traqparts.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente102 = new Cliente(null, "RICART COMÉRCIO DO VESTUÁRIO LTDA",
                "contato@amotantolingerie.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente103 = new Cliente(null, "ROLUX",
                "contato@opticarolux.com.br", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente104 = new Cliente(null, "RONG XINHUI /RONG XINPENG /RONG ZIWEN",
                "nicolas167@163.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente105 = new Cliente(null, "MD GAS",
                "samuel_monteiro08@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente106 = new Cliente(null, "PIZZARIA GARIBALDE",
                "garibaldipdelivery@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente107 = new Cliente(null, "FEIJAO COM ARROZ",
                "feijaocomarrozms@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente108 = new Cliente(null, "SUL COLCHOES LTDA",
                "sulcolchoes@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente109 = new Cliente(null, "SUPERMERCADO ALVORADA",
                "sm.alvoradaband@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente110 = new Cliente(null, "CONECSOM",
                "tcmfranco@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente111 = new Cliente(null, "TOYS SKATE SHOP ESPORTIVO EIRELI",
                "helmut_dente@hotmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);
        Cliente cliente112 = new Cliente(null, "TRADIÇÃO GÁS LTDA",
                "domgeraldoarena@gmail.com", PasswordUtil.encoder("123"), null, Perfil.CLIENTE, null);







        tecnicoRepository.saveAll(Arrays.asList(tecnico1));
        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3, cliente4, cliente5, cliente6, cliente7, cliente8, cliente9,
                cliente10, cliente11, cliente12, cliente13, cliente14, cliente15, cliente16, cliente17, cliente18, cliente19,
                cliente20, cliente21, cliente22, cliente23, cliente24, cliente25, cliente26, cliente27, cliente28, cliente29,
                cliente30, cliente31, cliente32, cliente33, cliente34, cliente35, cliente36, cliente37, cliente38, cliente39,
                cliente40, cliente41, cliente42, cliente43, cliente44, cliente45, cliente46, cliente47, cliente48, cliente49,
                cliente50, cliente51, cliente52, cliente53, cliente54, cliente55, cliente56, cliente57, cliente58, cliente59,
                cliente60, cliente61, cliente62, cliente63, cliente64, cliente65, cliente66, cliente67, cliente68, cliente69,
                cliente70, cliente71, cliente72, cliente73, cliente74, cliente75, cliente76, cliente77, cliente78, cliente79,
                cliente80, cliente81, cliente82, cliente83, cliente84, cliente85, cliente86, cliente87, cliente88, cliente89,
                cliente90, cliente91, cliente92, cliente93, cliente94, cliente95, cliente96, cliente97, cliente98, cliente99,
                cliente100, cliente101, cliente102, cliente103, cliente104, cliente105, cliente106, cliente107, cliente108, cliente109,cliente110,cliente111,cliente112));
    }
}
