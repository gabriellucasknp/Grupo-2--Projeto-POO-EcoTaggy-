ECO TAGGY

Integrantes: 
David Guilherme Souza Alves, 
Diego José Arroxelas, 
João Gabriel de Souza Neri, 
Rafael de Andrade Arruda. 
Matheus Paulo dos Santos Silva, 
Pedro Pessoa Bastos, 
Gabriel Lucas Soares da Silva.


Projeto: Plataforma de Cálculo e Visualização de Impacto Ambiental
Programação Orientada a Objetos 

1. Introdução
A sustentabilidade tem se tornado um fator cada vez mais relevante para empresas e consumidores, especialmente no contexto das transformações digitais. Soluções tecnológicas que substituem processos físicos podem gerar impactos ambientais positivos, como a redução de emissões de gases de efeito estufa (GEE), menor consumo de recursos naturais e diminuição de resíduos.
No setor de mobilidade e pagamentos digitais, diversas tecnologias têm contribuído para tornar processos mais eficientes e sustentáveis. No entanto, muitas vezes esses benefícios ambientais não são mensurados ou comunicados de forma clara aos usuários e às organizações.
Diante desse cenário, surge a necessidade de ferramentas que permitam quantificar e apresentar de forma transparente os impactos ambientais evitados por soluções digitais.
Este projeto propõe o desenvolvimento de uma plataforma capaz de calcular e visualizar o impacto ambiental gerado pela utilização da solução Taggy, permitindo que usuários e empresas acompanhem suas contribuições para a sustentabilidade.

2. Contextualização do Problema
A Taggy oferece soluções que permitem a realização de pagamentos automáticos em pedágios e estacionamentos, eliminando a necessidade de processos tradicionais como pagamento manual ou emissão de tickets físicos.
Essas soluções podem gerar benefícios ambientais relevantes, como:
redução de emissões de CO₂ devido à diminuição de frenagens e acelerações em pedágios;


redução do consumo de combustível causado por congestionamentos ou marcha lenta;


eliminação do uso de papel em tickets de estacionamento.


Apesar desses benefícios, atualmente não existe uma forma clara e padronizada para medir e comunicar o impacto ambiental evitado pela utilização desses serviços.
Isso dificulta que clientes e empresas compreendam o valor ambiental gerado pela solução.

3. Descrição do Desafio
O desafio consiste em desenvolver uma ferramenta capaz de calcular as emissões de gases de efeito estufa (GEE) associadas às operações digitais e compará-las com métodos tradicionais.
A ferramenta deve permitir a estimativa das emissões evitadas a partir da utilização da solução Taggy, considerando fatores como:
número de passagens em pedágios


número de usos de estacionamentos


fatores de emissão associados ao consumo de combustível


produção de papel e outros recursos


A metodologia utilizada deve ser clara, replicável e baseada em dados confiáveis, permitindo que diferentes clientes utilizem a ferramenta para compreender seu impacto ambiental.

4. Objetivos do Projeto
4.1 Objetivo Geral
Desenvolver uma plataforma digital capaz de calcular e apresentar o impacto ambiental evitado pelo uso da solução Taggy, permitindo que usuários e empresas visualizem indicadores de sustentabilidade associados às suas operações.
4.2 Objetivos Específicos
Criar uma metodologia de cálculo baseada em fatores de emissão reconhecidos.


Desenvolver uma calculadora de emissões evitadas.


Apresentar os resultados de forma visual e acessível.


Permitir simulações de cenários de uso.


Gerar relatórios ambientais e indicadores de sustentabilidade.



5. Solução Proposta
Uma possível solução para o problema apresentado é a criação de uma plataforma de cálculo e visualização de impacto ambiental da Taggy.
O sistema permitiria que os clientes acompanhassem, de forma clara, as emissões de CO₂ evitadas ao utilizar a Taggy em pedágios e estacionamentos, comparando com os métodos tradicionais.
A partir de dados como número de passagens em pedágios e usos de estacionamento, a plataforma aplicaria fatores de emissão para calcular indicadores como:
CO₂ evitado


redução no consumo de combustível


economia de papel


Além da calculadora, o sistema apresentaria um dashboard com gráficos e histórico de impacto ambiental, permitindo que os usuários acompanhem sua evolução ao longo do tempo.
Também seria possível utilizar um simulador de cenários, onde o cliente visualiza o impacto ambiental que pode evitar ao continuar utilizando a Taggy.
A plataforma ainda poderia gerar relatórios ambientais e métricas de sustentabilidade, facilitando a compreensão dos benefícios ambientais do serviço e ajudando empresas e usuários a comunicarem seus resultados de forma clara.

6. Escopo da Ferramenta de Cálculo
A ferramenta deve considerar as emissões de gases de efeito estufa por transação, separadas entre:
operações realizadas com cartões físicos


operações realizadas por meios digitais


O sistema deve incluir:
emissões diretas e indiretas relevantes


emissões associadas à cadeia de valor (Escopo 3)



7. Metodologia de Cálculo de Emissões
A metodologia deve calcular emissões de gases de efeito estufa por transação individual.
A unidade de cálculo será:
kg de CO₂ equivalente por transação.
As etapas consideradas no cálculo podem incluir:
produção de materiais


consumo de energia


processamento de transações


uso e descarte de materiais


Os cálculos devem considerar um horizonte temporal definido, normalmente baseado em inventários anuais de emissões.

8. Premissas do Projeto
8.1 Escopo das Emissões
A ferramenta deve considerar emissões associadas a:
cartões físicos


pagamentos digitais (NFC, QR Code, PIX, wallets digitais)



8.2 Unidades Funcionais
A unidade funcional utilizada será:
emissões por transação individual (kg CO₂e).
Também deve ser considerado:
horizonte temporal anual


fronteiras do sistema analisado



8.3 Premissas Técnicas para Cartões Físicos
Para calcular emissões relacionadas ao uso de cartões físicos, devem ser consideradas:
material do cartão (PVC, PVC reciclado ou metal)


massa média do cartão


emissões da produção do material


emissões associadas ao chip e antena NFC


emissões logísticas de distribuição


Também devem ser consideradas premissas relacionadas ao ciclo de vida do cartão, incluindo:
número médio de transações ao longo da vida útil


descarte do material



8.4 Premissas Técnicas para Pagamentos Digitais
Para operações digitais devem ser consideradas emissões relacionadas a:
consumo de energia em servidores e data centers


uso de redes de telecomunicação


processamento de transações


uso de dispositivos do usuário


Premissas importantes incluem:
consumo médio de energia por transação


fator de emissão da matriz elétrica


número médio de transações por dispositivo



8.5 Premissas de Dados e Fatores de Emissão
Os fatores de emissão utilizados devem ser provenientes de fontes confiáveis, como:
GHG Protocol


IPCC


bases públicas nacionais


bases internacionais de inventário ambiental


Também deve ser considerado o ano de referência dos fatores utilizados.

8.6 Premissas Operacionais
Entre as premissas operacionais consideradas estão:
taxa média de substituição de cartões


modelo de distribuição logística


localização de fábricas e centros de produção



9. Padronização do Cálculo
A metodologia de cálculo deve ser padronizada para garantir replicabilidade e consistência.
Isso inclui:
utilização de fórmulas claras


definição de limites para variáveis


atualização periódica de fatores de emissão


definição do escopo de aplicação da metodologia



10. Comparabilidade entre Operações Físicas e Digitais
Para permitir uma comparação justa entre métodos físicos e digitais, é necessário garantir:
utilização da mesma unidade funcional


definição clara das fronteiras do sistema


aplicação de metodologias equivalentes de análise de ciclo de vida



11. Premissas de Governança
Para garantir transparência e confiabilidade, a ferramenta deve documentar:
fonte dos dados utilizados


versão dos fatores de emissão


data das atualizações


Também é recomendada a atualização periódica dos dados e a possibilidade de auditoria metodológica.

12. Estrutura da Plataforma
A plataforma proposta pode incluir os seguintes módulos:
Calculadora de Impacto Ambiental
Responsável por realizar os cálculos de emissões evitadas.
Dashboard de Sustentabilidade
Apresenta visualmente indicadores ambientais e histórico de impacto.
Simulador de Cenários
Permite que usuários simulem o impacto ambiental de diferentes níveis de utilização da Taggy.
Relatórios Ambientais
Geração de relatórios que podem ser utilizados por empresas em estratégias de sustentabilidade e ESG.

13. Benefícios da Solução
A implementação dessa plataforma pode gerar diversos benefícios:
maior transparência sobre impactos ambientais


melhor comunicação do valor sustentável da solução


apoio a relatórios ESG


maior engajamento dos usuários com práticas sustentáveis


fortalecimento da estratégia de sustentabilidade da empresa



14. Conclusão
A criação de uma plataforma de cálculo e visualização de impacto ambiental representa uma solução eficaz para mensurar e comunicar os benefícios ambientais gerados pela utilização da solução Taggy.
Ao transformar dados operacionais em indicadores ambientais claros e acessíveis, a ferramenta permite que usuários e empresas compreendam melhor sua contribuição para a redução de emissões de gases de efeito estufa.
Além disso, a plataforma pode contribuir para fortalecer estratégias de sustentabilidade, melhorar a comunicação com clientes e apoiar iniciativas relacionadas à responsabilidade ambiental.

# Projeto Eco Taggy - Plataforma de Sustentabilidade

Repositório oficial do projeto **Eco Taggy**, uma Aplicação WEB Orientada a Objetos desenvolvida para a resolução de problemas ambientais, calculando e simulando impactos evitados por meio de soluções de pagamento digital em pedágios e estacionamentos.

## Equipe e Responsabilidades (Kickoff)

| Integrante | Função |
| :--- | :--- |
| **Matheus Paulo** | DevOps / Líder (Arquitetura, Integração e Merge) |
| **Gabriel Lucas e David Alves** | Backend Core (Modelagem de Entidades e Repositórios) |
| **Pedro Pessoa e João Neri** | Backend Service (Regras de Negócio e Controllers) |
| **Rafael** | Frontend UI (Telas dinâmicas com Thymeleaf) |
| **Diego Jose** | QA & Documentação (Issue Tracker, Validação e Screencasts) |

---

## Entrega 01: Planejamento e Prototipação

Esta seção contempla os artefatos iniciais de definição do produto:

* **Histórias de Usuário (BDD):** BDD - https://docs.google.com/document/d/1sdJkV6rNWwF7iKfVUFjboWM1kaCtoc9ELlnbYbxGx44/edit?usp=sharing
* **Protótipo de Baixa Fidelidade (Figma):** https://www.figma.com/design/TGD8z07FFK2N8NXbb2GH8j/EcoTaggy?node-id=0-1&p=f&t=Z0rBfxvdiPGCsXii-0
* **Screencast do Protótipo (Apresentação Lo-Fi):** https://youtube.com/shorts/w2Ib_-uEIPA?si=N3eJL1VYIspQOFWI

---

##  Entrega 02: Desenvolvimento e Integração Base

Esta seção detalha o ambiente de desenvolvimento e as duas primeiras histórias de usuário integradas e funcionais, com leitura e escrita em banco de dados.

### Diretrizes e Stack Tecnológica
* **Linguagem:** Java 21 | **Framework:** Spring Boot 3.5.x
* **Persistência e Banco:** Spring Data JPA / H2 Database (In-Memory)
* **Visualização:** Thymeleaf (HTML/CSS), Tailwind CSS e Chart.js
* **Nota de Conformidade:** Cumprindo a regra do projeto, **a biblioteca Lombok NÃO foi utilizada**. Todos os códigos boilerplate (construtores, getters, setters) foram desenvolvidos manualmente.

### Histórias de Usuário Implementadas
1. **História 01 (Dashboard):** Visualização de Indicadores Ambientais para Empresas.
2. **História 04 (Simulador):** Simulação de Impacto Ambiental baseada na taxa de adoção e tamanho da frota.

###  Gestão de Tarefas (Issue Tracker)
Ambiente de versionamento atuante com acompanhamento contínuo de tarefas:

https://trello.com/invite/b/69d52e14a4a61f00aeb5d663/ATTIfda8e02c55713876f1d01cc014ba168b9F5534AB/ecotaggy-poo

###  Screencast do Sistema (Entrega 02)
Demonstração do sistema em uso (com áudio/narração explicativa), comprovando o funcionamento da API Rest e Frontend:
https://youtu.be/ODd1CU9ADQA

###  Como Executar a Aplicação Localmente

1. Clone este repositório:
   https://github.com/gabriellucasknp/Grupo-2--Projeto-POO-EcoTaggy-
2. Acesse a pasta do backend:
   `cd ecoTaggy-backend`
3. Execute a aplicação Spring Boot:
   `mvn spring-boot:run`

   Alternativa sem Maven instalado globalmente:
   - Windows: `mvnw.cmd spring-boot:run`
   - Linux/macOS: `./mvnw spring-boot:run`
4. Acesse as páginas no navegador usando a porta configurada.
   - Localmente, o padrão é `8081`
   - Em deploy, a aplicação usa a variável de ambiente `PORT` da plataforma
   - Rotas principais:
     - **Início:** `http://localhost:8081/`
     - **Landing:** `http://localhost:8081/landing`
     - **Dashboard:** `http://localhost:8081/dashboard`
     - **Simulador:** `http://localhost:8081/simulador`

Entrega 03: Consolidação, Persistência Avançada e Relatórios
Esta seção detalha a finalização do ecossistema EcoTaggy, apresentando a integração completa entre o perfil do usuário, o registro de transações reais e a saída de dados via relatórios profissionais.

Histórias de Usuário Implementadas (Novas)
História 03 (Perfil e Identidade): Gestão de perfil com upload de imagem e persistência em Base64, utilizando mapeamento de grandes objetos.

História 05 (Transação Real): Módulo de registro de passagens por tipo de veículo (Carro, Caminhão, Moto) com atualização imediata do banco de dados e recálculo de indicadores.

História 06 (Relatórios ESG): Geração de relatórios consolidados em PDF com os indicadores acumulados de impacto ambiental do usuário.

Diferenciais Técnicos desta Entrega
Persistência LOB (Large Object): Armazenamento de fotos de perfil diretamente no banco de dados H2 através de mapeamento @Lob e tipos LONGTEXT, garantindo a integridade da identidade visual sem dependências externas.

Arquitetura de Serviços: Refatoração do ImpactoService para suportar coeficientes de emissão diferenciados por categoria veicular, baseando-se em metodologias do GHG Protocol e CETESB.

UX/UI Reativa: Implementação de Dashboard reativo com Chart.js, suporte a Dark Mode nativo e formulários de transação com feedback visual de processamento (loading states).

Segurança e Integridade: Tratamento de persistência e garantia de integridade referencial entre as tabelas de Usuário e seus respectivos registros de Impacto Ambiental.

Gestão de Tarefas (Status Final)
O board de desenvolvimento foi atualizado para o status de "Concluído", refletindo o encerramento do ciclo de desenvolvimento da Entrega 03:
https://trello.com/b/vIVQ4Sob/ecotaggy-poo

Screencast do Sistema (Entrega 03)
Demonstração completa do fluxo de ponta a ponta: Cadastro -> Perfil -> Registro de Passagem Real -> Dashboard Reativo -> Geração de Relatório PDF:
https://www.youtube.com/watch?v=JHOLz4y82IM

Como Executar a Aplicação (Atualizado)
Clone o repositório atualizado.

Acesse a pasta do backend: cd ecoTaggy-backend

A aplicação usa a porta `8081` localmente e, em deploy, respeita a variável `PORT`.

O banco H2 local agora usa um caminho relativo (`./data/ecotaggydb`), sem depender de `C:/temp/`.

Execute a aplicação: mvn spring-boot:run

Acesse as rotas principais (Porta 8081):

Início: http://localhost:8081/

Registro de Passagem: http://localhost:8081/transacao

Dashboard ESG: http://localhost:8081/dashboard

Tecnologias Utilizadas (Revisado)
Backend: Java 21, Spring Boot 3.5.x, Spring Data JPA.

Frontend: Thymeleaf (Templates dinâmicos), Tailwind CSS, Chart.js (Gráficos), JavaScript ES6.

Banco de Dados: H2 Database (Modo Arquivo para persistência de dados).

Documentação/Saída: html2pdf.js / iText para exportação de relatórios corporativos.
