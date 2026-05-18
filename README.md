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

# Projeto EcoTaggy — Plataforma de Sustentabilidade

Repositório oficial do projeto **EcoTaggy** (também referenciado como CleanTaggy), uma Aplicação Web Orientada a Objetos desenvolvida em Java para mensurar, simular e reportar o impacto ambiental positivo gerado pela substituição de métodos de pagamento físicos (tickets de papel, paradas em cabines) por soluções digitais de passagem automática (*Taggy*) em pedágios e estacionamentos.

---

## Equipe e Responsabilidades

| Integrante | Papel Principal | Atribuições Principais |
| :--- | :--- | :--- |
| **Matheus Paulo dos Santos Silva** | DevOps / Líder | Arquitetura, Integração e Gerenciamento de Merge |
| **Gabriel Lucas Soares da Silva** | Backend Core | Modelagem de Entidades e Repositórios |
| **David Guilherme Souza Alves** | Backend Core | Modelagem de Entidades e Repositórios |
| **Pedro Pessoa Bastos** | Serviço Backend | Regras de Negócio e Controladores |
| **João Gabriel de Souza Neri** | Serviço Backend | Regras de Negócio e Controladores |
| **Rafael de Andrade Arruda** | Frontend UI | Desenvolvimento de telas dinâmicas e reativas com Thymeleaf |
| **Diego José Arroxelas** | QA e Documentação | Issue Tracker, Validação de Bugs e Screencasts |

---

## Como Executar a Aplicação Localmente (Montando o Ambiente)

Siga as instruções abaixo para configurar e executar o ecossistema EcoTaggy in sua máquina local.

### Pré-requisitos
* **Java 21 LTS** (ou superior) instalado e devidamente configurado nas variáveis de ambiente do sistema.
* **Maven 3.9+** instalado (Opcional, caso prefira usar o wrapper incluso `.mvnw`).
* **Diretório Local (Windows):** Certifique-se de que o diretório `C:/temp/` existe no seu sistema, pois ele é estritamente necessário para a persistência do banco de dados H2 em modo arquivo.

### Passo a Passo para Inicialização

1. **Clonar o Repositório:**
   Abra o terminal no diretório de sua preferência e execute:
   ```bash
   git clone [https://github.com/gabriellucasknp/Grupo-2--Projeto-POO-EcoTaggy-.git](https://github.com/gabriellucasknp/Grupo-2--Projeto-POO-EcoTaggy-.git)
Navegar até a Pasta do Backend:
Acesse a pasta raiz do código Java:

Bash
cd Grupo-2--Projeto-POO-EcoTaggy-/ecoTaggy-backend
Executar a Aplicação (Maven):

Se você possui o Maven instalado globalmente (Windows/Linux/Mac):

Bash
mvn spring-boot:run
Se for utilizar o Maven Wrapper incluso no projeto (Windows):

DOS
mvnw.cmd spring-boot:run
Se for utilizar o Maven Wrapper incluso no projeto (Linux/macOS):

Bash
./mvnw spring-boot:run
Acesso ao Sistema no Navegador:
A aplicação subirá por padrão na porta 8081. Uma vez iniciado o servidor, utilize os endereços abaixo para navegar pelas funcionalidades:

Página Inicial / Landing Page: http://localhost:8081/

Registro de Transações/Passagens: http://localhost:8081/transacao

Dashboard de Controle ESG: http://localhost:8081/dashboard

Simulador de Cenários: http://localhost:8081/simulador

Calculadora GHG: http://localhost:8081/calculadora

Liga Sustentável (Ranking): http://localhost:8081/ranking

Jornada & Metas: http://localhost:8081/metas

Relatório Corporativo: http://localhost:8081/relatorio-ghg

Stack Tecnológica & Diferenciais Técnicos
Backend Core: Java 21, Spring Boot 3.5.x, Spring Data JPA.

Interface do Usuário (UI): Templates dinâmicos renderizados via Thymeleaf, estilizados com Tailwind CSS, ícones vetoriais da biblioteca Lucide e gráficos analíticos reativos gerados com Chart.js.

Banco de Dados: H2 Database configurado em modo arquivo, garantindo a retenção e persistência dos dados simulados entre reinicializações do servidor.

Conformidade Arquitetural (Sem Lombok): Atendendo rigidamente às diretrizes pedagógicas de modelagem da disciplina, a biblioteca Lombok não foi utilizada. Todas as estruturas essenciais (construtores, métodos getters, setters e encapsulamentos) foram codificadas de forma manual e explícita pelo time.

Persistência Avançada (LOB): Armazenamento de fotos de perfil direto no banco de dados utilizando mapeamento @Lob e tipos LONGTEXT convertidos nativamente em Base64.

Arquitetura Reativa de Serviços: O componente central ImpactoService realiza o cálculo imediato de emissões poluentes aplicando coeficientes de conversão para categorias veiculares distintas (Carro, Caminhão e Moto), em total conformidade com as diretrizes metodológicas internacionais do GHG Protocol e nacionais da CETESB.

Histórico de Entregas e Evolução do Projeto
🔸 Entrega 01: Planejamento e Prototipação
Definição e mapeamento de Histórias de Usuário utilizando a sintaxe BDD.

Criação do documento oficial do BDD no Google Docs.

Desenvolvimento do Protótipo de Baixa Fidelidade através da ferramenta Figma.

Gravação e publicação do Screencast de Apresentação do Protótipo Lo-Fi (YouTube Shorts). (https://www.youtube.com/shorts/w2Ib_-uEIPA)

🔸 Entrega 02: Desenvolvimento e Integration Base
Estruturação inicial do ambiente de desenvolvimento Spring Boot integrado ao banco de dados em memória.

História 01 (Dashboard): Tela de visualização de Indicadores Ambientais voltada para Empresas.

História 04 (Simulador): Desenvolvimento do algoritmo de Simulação de Impacto Ambiental baseada na taxa de adoção de frotas logísticas.

Gravação e publicação do Screencast de Demonstração das funcionalidades da Entrega 02 (YouTube). (https://www.youtube.com/watch?v=ODd1CU9ADQA)

🔸 Entrega 03: Consolidação, Persistência Avançada e Relatórios
História 03 (Perfil e Identidade): Módulo de gerenciamento de perfil com upload e codificação de imagens via Base64.

História 05 (Transação Real): Módulo de registro de passagens e pedágios com recálculo instantâneo baseado no tipo do veículo selecionado.

História 06 (Relatórios ESG): Desenvolvimento do motor de exportação de dados consolidados em formato PDF para fins de marketing institucional e compliance ambiental.

Gravação e publicação do Screencast de Demonstração de ponta a ponta da Entrega 03 (YouTube). (https://www.youtube.com/watch?v=JHOLz4y82IM)

🔸 Entrega 04: Implementação Final e Fechamento de Ciclo
Finalização das Histórias Restantes: Implementação de refinamentos de segurança da aplicação, fluxo visual reativo de carregamento (loading states) nos formulários e tratamento rigoroso para concorrência e controle de sessões ativas utilizando HttpSession.

Resolução de Débitos Técnicos: Correção do problema crítico de concorrência e bloqueio do banco de dados aplicando o parâmetro ;AUTO_SERVER=TRUE na URL de conexão do arquivo application.properties, mitigando em definitivo os travamentos durante a reinicialização da aplicação.

Sincronização e Ajuste Fino de Layout: Unificação visual da interface com suporte nativo ao recurso de Dark Mode. Substituição completa de dados estáticos (mocks) por dados dinâmicos recuperados do banco através do Thymeleaf na tela de perfil e configurações.

(Filtrar/inserir link do novo Screencast se disponível)

Gestão de Tarefas & Versionamento (Issue / Bug Tracker)
O fluxo de gerenciamento de tarefas, controle de bugs e refinamento de código foi centralizado e rastreado semanalmente através de commits frequentes e reuniões de alinhamento. O quadro de desenvolvimento atual reflete 100% das histórias de usuário e demandas técnicas movidas para o status de Concluído.

Link para o Quadro de Gerenciamento do Projeto: Quadro EcoTaggy - Trello (https://trello.com/b/vIVQ4Sob/ecotaggy-poo)




