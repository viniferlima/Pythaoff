<div align="center">
      ![PythaOff](/Documentos/Logo_PythaOff.png)
</div>

[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.io/#https://gitlab.com/gurst6/pythaoff-ness)


<div align="center">
      <h2>Menu</h2>
      <p>
            :small_blue_diamond:<a href="#introducao">Introdução</a>
            :small_blue_diamond:<a href="#bd">Modelo do Banco de Dados</a>
            :small_blue_diamond:<a href="#estrutura">Estrutura do projeto</a>
            :small_blue_diamond:<a href="#tecnologia">Tecnologias</a>
            :small_blue_diamond:<a href="#equipe">Equipe</a>
      </p>
</div>


# <h1>Projeto Integrador 5º Semestre BD - Grupo PythaOff :no_mobile_phones:</h1>

GitLab para desenvolvimento do Projeto Integrador do 5º Semestre - Banco de dados FATEC SJC


<a name="introducao"></a>
# 1 - Introdução
## 1.2 - Quem somos :question:
Olá! Muito prazer! 
Nós somos o grupo PythaOff, um time de alunos do 5° semestre do curso de Banco de Dados da FATEC de São José dos Campos. Esse grupo tem como objetivo desenvolver um projeto (PI) para solucionar um problema proposto por um cliente parceiro da instituição.

## 1.3 - O problema :exclamation:
Desenvolver uma solução de dados voltada ao ensino a distância para a gestão e oferta do conhecimento, sendo apto a prover suporte às mais 
variadas arquiteturas de aprendizagem, alinhado com os objetivos estratégicos a serem alcançados pelas organizações que atendermos 
como clientes. Precisamos ajustar o banco de dados, pensando em um grande processamento de dados com ganho de escalabilidade e 
integração contínua entre os ambientes. Adicionar na solução atual um banco de dados não relacional para armazenar os chats e os logs. 
Deve ser desenvolvido um pipeline de dados e analytics, a fim de manter um DW e um modelo OLAP para visualização e análise de dados.

## 1.4 - Cronograma :calendar:
* 16/08/2021 até 22/08/2021 - Kick Off do Projeto
* 30/08/2021 até 19/09/2021 - Sprint 1
* 20/09/2021 até 10/10/2021 - Sprint 2
* 18/10/2021 até 07/10/2021 - Sprint 3
* 08/11/2021 até 28/11/2021 - Sprint 4
* 29/11/2021 até xx/12/2021 - Sprint Apresentação Final
* xx/xx/2021 até xx/xx/2021 - Sprint Feira de Soluções

## 1.5 - Requisitos Funcionais

| Requisitos não funcionais             |  Código |                                                                                                                                    
| ----------------------------------|---------|
|Rotina de Logs             |RF01     |
|Rotina de Chat                |RF02     |
|CI/CD        |RF03     | 
|Dashboards        |RF04     | 
## 1.6 - Requisitos Não Funcionais

| Requisitos não funcionais             |  Código |                                                                                                                                    
| ----------------------------------|---------|
|Documentação bem estruturada             |RF01     |
|Facilidade de uso                |RF02     |
|Escalabilidade        |RF03     |

## 1.7 - Apresentação da Evolução do Projeto :camera:
| Sprint 1  | Sprint 2 | Sprint 3 | Sprint 4 |
|--------- |--------- |--------- |--------- |
|<p>:white_check_mark:<a href="#sprint01">Done! </a></p>|<p>:white_check_mark:<a href="#sprint02">Done! </a></p>|<p>:white_check_mark:<a href="#sprint03">Done!</a></p>|<p>:warning:<a href="#sprint04">Loading...</a></p>|

<a name="bd"></a>
# 2 - Modelo do Banco de Dados
## 2.1 - M.E.R (Modelo Entidade Relacionamento):
<div align="center">
      ![BD](/Documentos/new_oltp.png)
</div>

## 2.2 - Modelagem do Data Warehouse:
<div align="center">
      ![DW](/Documentos/new_dw.png)
</div>

## 2.2 - Tabela Fato acesso após transformação:
<div align="center">
      ![DW](/Documentos/factAccess.png)
</div>

<a name="ETL"></a>
# 3. - Estrutura do projeto

## 3.1 - CI/CD
CI/CD, continuous integration/continuous delivery, é um método para entregar aplicações com frequência aos clientes. Para isso, é aplicada a automação nas etapas do desenvolvimento de aplicações. Os principais conceitos atribuídos a esse método são integração, entrega e implantação contínuas. Com o CI/CD, é possível solucionar os problemas que a integração de novos códigos pode causar para as equipes de operações e desenvolvimento. Diante dessa perspectiva, nesse projeto foi utilizado conceito de conteinerização do Docker, que nada mais é que uma plataforma aberta para criação, execução e publicação (deploy) de containers. Um Container é a forma de empacotar sua aplicação e suas dependências (bibliotecas) de forma padronizada. Veja na imagem abaixo o script de configuração do CI/CD, definindo os stages, jobs e outras dependencias que fazem parte da pipeline:

<div align="center">
      ![ETL](/Documentos/cicd.png)
</div>


## 3.2 - Processo de ETL finalizado:
<div align="center">
      ![ETL](/Documentos/etl_finalizado.png)
</div>

## 4 - Backlog do Projeto:

<a name="sprint01"></a>
### Sprint :one: : MVP(Relatório parcial, CI parcial, DW parcial)
* Modelagem e criação da DW para a primeira entrega;
* Utilização do projeto do 3º;
* Tratamento dos dados coletados;
* Criar interação da aplicação com o banco para salvar logs de login;
* Criação do front-end com o primeiro dashboard;
* Configuração inicial de CI.

<a name="sprint02"></a>
### Sprint :two: : MVP(Escalabilidade e processamento de dados, relatório parcial)
* Modelagem DW incremental;
* Melhorar desempenho para recebimento de dados e escalabilidade do DW;
* Criar os dashboards;
  * Engajamento: quais alunos/colaboradores estão fazendo o curso no qual está matriculado;
  * Desempenho: qual o aproveitamento - nota atingida - no curso no qual está matriculado;
* Teste de desempenho;
* Configuração de CI.

<a name="sprint03"></a>
### Sprint :three: : MVP(Permissões, relatórios parciais, chat, desempenho)
* Criar login e níveis de acesso;
* Criação dos dashboards:
  * Participação x taxas de conclusão x desempenho dos alunos/colaboradores;
  * Avaliação de reação: qualificação do conteúdo apresentado, experiência do aluno/colaborador durante o curso;
* Captura dos logs do chat;
* Configuração de CI.


<a name="sprint04"></a>
### Sprint :four: : (Relatórios, desempenho)
* Criação do dashboard:
  * Registro do tempo de participação no curso: tempo online executando as atividades;
* Teste de desempenho.

<a name="tecnologia"></a>
## 5 - Tecnologias Utilizadas:
<div align="center">
      ![Tecnologias](/Documentos/tecnologias_utilizadas.png)
</div>


<a name="equipe"></a>
# 6 - INTEGRANTES

 * GABRIEL DE QUEIROZ CORDEIRO **| Product Owner |**
 * SABRINA RAFAELA CALADO MARIANO **| Dev Team |**
 * GUSTAVO RIBEIRO DOS SANTOS **| Master |**
 * ARTHUR CARDOSO RINALDI DA SILVA **| Dev Team |**
 * PERILO CARVALHO DE OLIVEIRA JUNIOR **| Dev Team |**
 * VINICIUS FERNANDES DE LIMA **| Dev Team |**

