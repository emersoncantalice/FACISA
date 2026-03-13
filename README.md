Report de Passagem de Contexto — Férias
Responsável

Emerson Cantalice

Squads sob responsabilidade

Motores de Decisão

Crédito – Gen IA

Durante minha ausência

Renata Maffei ficará responsável pelas minhas aprovações.

Junto com o time de Motores, o Sumensa ficará mais próximo do time de IA durante o período.

1. Squad Motores de Decisão
1.1 Migração Blaze x PDEC

Ponto focal: Auth

Os alicerces da migração foram concluídos.

Ontem foi subida a última frente mapeada até então: Risco Global PJ.

O produto Motos já está 100% em PDEC.

O Robson possui o planejamento de rollouts, com execução prevista até a primeira semana de julho.

Com isso, o prazo para descomissionamento do Blaze no servidor vai até 01/10/2026.

Houve alinhamento com negócio no início do ano para que esse rollout seguisse para o segundo trimestre, inclusive com ajuste do apontamento para 15/08.

Porém, a BE permaneceu com finalização em 30/03, o que gerou desconforto por aparentar um atraso injustificado.

Edvaldo está tratando esse ponto.

Atenção: existe sensibilidade na comunicação de prazo versus o combinado com negócio.

1.2 Modernização Serasa

Ponto focal: Thais

Existe negociação com os birôs para obtenção de desconto no primeiro mês de uso das novas APIs, evitando a necessidade de criação de um “baldão” do nosso lado e reconstrução a partir de novas consultas.

Serasa PF já está habilitada para uso.

Serasa PJ está prevista para a próxima semana.

O principal enrosco hoje está nos faróis do PTA, que utilizam Serasa e exigiriam tráfego desse dado para a Julgamental.

O mapeamento das regras dos faróis e a forma de integração do PTA com a parte modernizada na Julgamental têm se mostrado complexos.

Em paralelo, existe discussão sobre uma nova mesa com Argos, junto à Accenture.

Caso essa alternativa avance, o esforço de reescrita dos faróis pode perder sentido.

Uma possibilidade em avaliação é remover os faróis do PTA para eliminar a chamada à Serasa, com retomada posterior no Argos.

Isso ainda depende de negociação com a mesa.

A Thais também já vem atuando nas próximas migrações: QUOD e BVS.

Ela também atua como engenheira federada.

Risco: definição da estratégia com Argos pode mudar a direção do trabalho atual.

1.3 CNPJ Alfanumérico

Ponto focal: Lucas Maciel

Estamos com alterações em CRED, PTA e EJB.

A frente do EJB, após grande esforço para viabilizar o bypass, já está em UAT.

Rodas está conduzindo os testes integrados.

As alterações no PTA seguem em andamento, com previsão de subida para UAT na segunda-feira.

1.4 Evolução GLIT

Ponto focal: Ygor

Passamos a consumir um conjunto de eventos de OPF.

Nossa entrega está pendente apenas do teste NFT para seguir para PRD.

Porém, é necessário alterar a política de cartões para consumir os novos dados.

Essa priorização ainda não ocorreu.

Sem isso, não conseguimos subir para produção.

Bloqueio: dependência externa de priorização da política de cartões.

1.5 Desenho da nova esteira de propostas

Pontos focais: Vitor e Frank

O desenho da nova esteira está em evolução.

Já existe uma visão inicial com o Argus acoplado.

O trabalho está sendo conduzido em fases:

fase inicial: convivência entre as esteiras e mecanismo de rollout;

próximo trimestre: evolução do miolo da solução.

1.6 Apontamento do Pré-Aprovado

Ponto focal: Aine

Existe GMUD prevista para a próxima semana para desabilitar os componentes do PREA.

1.7 Apontamento do Crédito Intranet (Login)

Ponto focal: Aine

Apontamento previsto para o mês 6.

O tema já está em andamento.

1.8 Gerenciador de Domínios

Ponto focal: Vitor

Foi construída uma visão inicial da solução.

O Vitor está evoluindo o desenho de arquitetura.

2. Squad Crédito – Gen IA
2.1 Guardião
Situação atual

Foi realizado o discovery da solução.

Também foi feita uma POC.

Houve um desenho inicial de arquitetura com RAG + Mongo.

Depois, a solução evoluiu para um desenho com uso da Ilha de Dados.

Pontos focais do desenho da solução: Guilherme Mafra e Frank Thadeu

Entregas realizadas

Foram entregues as tabelas intermediárias, que servem de insumo para a tabela cubo final.

Ponto focal: Guilherme Mafra

Ambiente e desenvolvimento

Foi criado o ambiente no padrão da esteira Titan para o agente de leves:

frontend

bff

geniagke (agente)

Ponto focal: Erikles José

O desenvolvimento foi iniciado localmente enquanto aguardávamos a finalização do desenho de arquitetura para solicitar os componentes finais.

Agora estamos fazendo a transição desse desenvolvimento local para os componentes definitivos.

Principal atenção

A codificação da tabela cubo já foi concluída.

Essa tabela possui 111 colunas e 2 anos de dados de leves.

Estamos enfrentando problema de performance para carga no BigQuery, o que está travando a esteira.

O time está atuando em conjunto com o time de dados para resolver esse ponto.

Ponto focal: Tainã

Alerta: ponto sensível pela cobrança, especialmente do Piovessana.

Próximos passos

Com o desenho da Ilha já defendido, precisamos construir:

a Ilha de Dados em Databricks SQL;

a transição dos dados do BQ para o Databricks SQL via Dataflow;

o Atômico que acessará o Databricks SQL;

a comunicação do geniagke com o Atômico.

2.2 Monitoramento de Mídias

O projeto consiste em um BI que acessa uma tabela no BigQuery.

Essa tabela é construída a partir de:

scraping de dados em Google Sites;

carga manual de arquivo;

consolidação em tabela no BQ.

O time do Atacado entregou um pré-desenho, porém com problemas arquiteturais importantes:

acesso direto ao BigQuery, o que não pode ser feito;

acesso à internet, o que também não pode ser feito.

Foi necessário realizar um rediscovery para identificar uma solução viável.

Estamos nessa etapa atualmente, enquanto o desenho da solução segue sendo construído.

Esse tema veio inicialmente como apontamento, mas o apontamento foi baixado.

Ainda assim, existe cobrança do Wendel pela entrega.

Há bastante trabalho ainda a ser feito.

Expectativa: entrega mais realista no segundo trimestre.

2.3 Alencar

O projeto é um analisador e documentador de políticas da PDEC.

Existe apontamento para o projeto, porém ele só existia no SGEN (ambiente antigo de IA, já desativado).

O funcionamento anterior consistia em:

baixar todo o código da política;

empacotar em um docker;

executar um agente que lia e respondia sobre o código.

Foi necessário fazer rediscovery e engenharia reversa, já que não havia documentação do projeto.

Até o momento, o desenho de solução ainda não foi iniciado.

Expectativa: entrega também mais aderente ao segundo trimestre.

3. Pessoas e Capacidade
Estrutura do time

O time conta com 2 chapters de IA:

Thayliny Moura (thayliny.moura)

Luiz Herculiani / Luiz Milare (luiz.herculiani)

Esses chapters não debitam da nossa LO.

Na LO do time, está alocada a Karen (PMO).

Os engenheiros de IA estão sob coordenação da Mariana Bueno (Time de Aceleração IA).

Vagas

Temos uma vaga em aberto para Engenheiro de IA:

VAG0030164

tratar com Mariana Bueno, responsável pela contratação.

Temos também uma vaga em aprovação para Full Stack:

VAG0030851

Evson Custodio

já trabalhou no banco;

teve ótimo feedback do Gondo;

perfil considerado especialista.

Precisamos renovar as vagas para o restante do ano.

Pessoas do time

Erikles — Engenheiro de IA
Vem performando bem, correndo atrás e se desdobrando como engenheiro.

Tainã — Engenheiro de Dados
Tem boa experiência com dados, mas requer atenção em temas de performance.

Douglas — Engenheiro de IA
Tem bom currículo, porém ainda está em fase de aterrissagem no ambiente BV e nos processos de entrega.

Guilherme — Engenheiro de Dados / Arquiteto federado
Vem conduzindo os desenhos de solução e entregou as primeiras tabelas do Guardião. Está indo bem.

Andrezza — Full Stack
Saiu em 11/03.
A vaga está com agendamento de cancelamento para 31/03.
Atenção ao timecard.

4. Temas Extras / Pontos de Atenção
Material da Bain

Tema em aberto para acompanhamento.

Erros EJB do Crédito

Ponto focal: Lucas Maciel

Tema segue com o Lucas à frente.

Migração do PEP

O time responsável pela base Sybase DBPEP está atuando para remover a chamada ao serviço deles da PDEC e direcionar o consumo para o CADU.

Com isso, poderão descontinuar a base Sybase.

Desativação do Cebola

Precisamos atuar no crédito-contra-oferta para eliminar a chamada atual.

Após isso, será possível prosseguir com a descontinuação da base associada.

Plano de desativação do Sybase

Ponto focal: Ygor

Existe uma recorrência semanal para acompanhamento desse tema.

Troca da DXC para a Pixmo

O Frank chamou atenção para essa troca.

Temos processos que alimentam as bases da PDED com dados de cartão oriundos da DXC.

Precisamos avaliar se existe impacto nessa mudança.

Renovação das vagas

Precisamos garantir a renovação das vagas para o restante do ano.

5. Principais alertas na minha ausência
Motores de Decisão

Migração Blaze x PDEC: atenção à narrativa de prazo versus alinhamento com negócio.

Modernização Serasa: definição sobre PTA, faróis e Argos pode redirecionar a solução.

GLIT: dependência externa impede subida para PRD.

CNPJ Alfanumérico: acompanhar UAT do PTA e testes integrados do EJB.

Sybase / PEP / Cebola: seguir acompanhando o plano de desativação.

Crédito – Gen IA

Guardião: principal atenção em performance e subida da tabela cubo no BQ.

Monitoramento de Mídias: ainda em rediscovery, com expectativa mais realista para segundo trimestre.

Alencar: ainda sem desenho de solução iniciado.

Capacidade do time: atenção à recomposição e renovação das vagas.

6. Resumo executivo

No time de Motores de Decisão, a frente mais madura é a migração Blaze x PDEC, com alicerces concluídos, rollout planejado e prazo claro para descomissionamento, embora exista sensibilidade na comunicação de prazo com negócio. Em paralelo, a Modernização Serasa avança bem, mas ainda depende de definição estratégica para PTA/faróis/Argos. Também seguem em andamento temas relevantes como CNPJ Alfanumérico, GLIT, nova esteira de propostas, Gerenciador de Domínios e frentes ligadas à desativação do Sybase.

No time de Crédito – Gen IA, o projeto mais avançado é o Guardião, que já passou por discovery, POC, desenho inicial e entregas intermediárias, mas hoje tem como principal gargalo a performance da tabela cubo no BigQuery. Já os projetos Monitoramento de Mídias e Alencar ainda estão em estágio de rediscovery e amadurecimento da solução, com expectativa mais adequada para o segundo trimestre. Em termos de pessoas, o time requer atenção à renovação e recomposição de vagas, além do acompanhamento da transição operacional durante minha ausência.

