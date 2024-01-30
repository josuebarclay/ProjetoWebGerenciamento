<h1 align="center">Sistema de Gerenciamento Empresarial</h1>

# Descrição

<p align="center justify">
O Sistema de Gerenciamento Empresarial é uma aplicação desenvolvida em Spring Boot, utilizando PostgreSQL como banco de dados, com um frontend em HTML, CSS e JavaScript. O objetivo principal do sistema é proporcionar uma solução abrangente para empresas, permitindo o gerenciamento eficiente de clientes, técnicos e vendas.
</p>

## Visão Geral

<p align="center justify">
O Sistema de Gerenciamento Empresarial oferece uma plataforma integrada que atende às necessidades de diferentes usuários dentro da empresa. A aplicação conta com duas principais interfaces: uma página inicial para clientes conhecerem a empresa e entrarem em contato, e um dashboard completo destinado a técnicos e vendedores.
</p>

## Funcionalidades Principais:

1 - **Cadastro e Gerenciamento de Clientes:**

- [X] Os clientes podem se cadastrar e explorar informações sobre a empresa.
Técnicos têm a capacidade de cadastrar novos clientes e gerenciar suas informações.

2 - **Chamados de Técnicos:**

- [X] Técnicos podem abrir chamados para descrever as atividades realizadas nos clientes.
Registro detalhado sobre o status de cada chamado, indicando se foi finalizado ou não.

3 - **Agendamento Automático para Vendedores:**

- [X] Vendedores têm acesso a uma interface que mostra quais clientes foram visitados recentemente.
Um sistema automático agenda visitas mensais para os vendedores, facilitando o acompanhamento das relações com os clientes.

## Tecnologias Utilizadas:

- [X] Spring Boot (Backend)
- [X] PostgreSQL (Banco de Dados)
- [X] HTML, CSS, JavaScript (Frontend)
- [X] Bootstrap-Thymealeaf (Template para o Dashboard)

## Estrutura do Projeto:

O projeto segue uma estrutura organizada, dividindo-se em módulos para cada funcionalidade principal. A arquitetura é orientada a serviços, proporcionando escalabilidade e fácil manutenção.

## Para ver o progeto em produção:

Site oficial da Empresa Autocom que o projeto se encontra em execução:
http://autocominfo.com:8080/

## Instruções de Instalação:

Antes de começar, certifique-se de ter os seguintes requisitos instalados:

- [x] Maven
- [x] Java 8
- [x] PostgreSQL

1. **Clonar o Repositório:**
   ```bash
   git clone https://github.com/josuebarclay/ProjetoWebGerenciamento

   cd ProjetoWebGerenciamento

2 - **Configurar o Banco de Dados:**

- [x] No PostgreSQL, crie um banco de dados chamado 'helpdesk':
CREATE DATABASE helpdesk;

3 - **Configurar as Propriedades do Banco de Dados:**

- [x] No diretório 'src/main/resources', configure as propriedades do banco de dados no arquivo 'application.properties'.

4 - **Executar o Projeto:**

- [x] Execute o seguinte comando na raiz do projeto: mvn spring-boot:run

5 - **Acessar a Aplicação:**

- [x] Abra o navegador e vá para http://localhost:8080.

6 - **Explorar a Aplicação:**

Explore as diferentes funcionalidades da aplicação conforme as instruções fornecidas na seção "Uso" do README.


Lembre-se de ajustar as configurações do banco de dados de acordo com suas preferências e certificar-se de que as portas necessárias estão disponíveis.

- [x] --port:8080

## Uso:

Explore as funcionalidades do Sistema de Gerenciamento Empresarial conforme a sua função:

**Clientes:** Entra em contato e conheça mais sobre a empresa, tela de consulta de boletos e status e futuramente o xml.
**Técnicos:** Gerencie chamados e registre suas atividades.
**Vendedores:** Acompanhe visitas agendadas e clientes recentes.

## Screenshots:
![image](https://github.com/josuebarclay/ProjetoWebGerenciamento/assets/66049385/d9596545-6bfa-4767-9e9c-2615f93bd6bd)
![image-1](https://github.com/josuebarclay/ProjetoWebGerenciamento/assets/66049385/d2daa4b5-b486-4f2f-a0b9-984070c8664a)

## License

This project is [MIT](https://choosealicense.com/licenses/mit/) licensed.
