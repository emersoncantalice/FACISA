create table quadras (
	FID varchar(100),
	codigo bigint,
	empreendimento varchar(300),
	subeixo varchar(50),
	tipo varchar(300),
	orgao_responsavel varchar(50),
	executor varchar(50),
	unidade_federativa varchar(2),
	municipio varchar(100),
	investimento_previsto varchar(300),
	observacao varchar(200),
	estagio varchar(100),
	data_de_referencia varchar(100),
	geometria varchar(100),
	count int
	
);

COPY quadras
(
	FID,
	codigo,
	empreendimento,
	subeixo,
	tipo,
	orgao_responsavel,
	executor,
	unidade_federativa,
	municipio,
	investimento_previsto,
	observacao,
	estagio,
	data_de_referencia,
	geometria,
	count
)
FROM 'C:\Users\Public\Documents\quadra.csv'
DELIMITER ','
CSV HEADER;

select * from quadras ;