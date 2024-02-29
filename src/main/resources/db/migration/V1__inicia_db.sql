-- Cria a tabela de clientes
CREATE TABLE clientes (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	limite INTEGER NOT NULL,
    saldo INTEGER NOT NULL default 0
);

-- Cria a tabela de transações
CREATE TABLE transacoes (
	id SERIAL PRIMARY KEY,
	cliente_id INTEGER NOT NULL,
	valor INTEGER NOT NULL,
	tipo CHAR(1) NOT NULL,
	descricao VARCHAR(10) NOT NULL,
	realizada_em TIMESTAMP(6) NOT NULL,
		FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

-- Cria a tabela de saldos
CREATE TABLE saldos (
	id SERIAL PRIMARY KEY,
	cliente_id INTEGER NOT NULL,
	valor INTEGER NOT NULL,
	FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

-- Insere dados iniciais
INSERT INTO clientes (nome, limite)
VALUES
	('o barato sai caro', 1000 * 100),
	('zan corp ltda', 800 * 100),
	('les cruders', 10000 * 100),
	('padaria joia de cocaia', 100000 * 100),
	('kid mais', 5000 * 100);
