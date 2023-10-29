-- Insere dados na tabela;
INSERT INTO marca (nome_marca) VALUES ('TOYOTA');
INSERT INTO marca (nome_marca) VALUES ('CHEVROLET');
INSERT INTO marca (nome_marca) VALUES ('VOLKSWAGEN');

INSERT INTO modelo (nome, valor_fipe, marca_id) VALUES ('ETIOS', 36000.00, 1);
INSERT INTO modelo (nome, valor_fipe, marca_id) VALUES ('COROLLA', 120000.00, 1);
INSERT INTO modelo (nome, valor_fipe, marca_id) VALUES ('HILLUX SW4', 47500.00, 1);
INSERT INTO modelo (nome, valor_fipe, marca_id) VALUES ('ONIX PLUS', 50000.00, 2);
INSERT INTO modelo (nome, valor_fipe, marca_id) VALUES ('JETTA', 49000.00, 3);

INSERT INTO carro (timestamp_cadastro, modelo_id, ano, combustivel, num_portas, cor) VALUES ('2023-10-05 20:44:48', 1, 2014, 'FLEX', 4, 'BRANCA');
INSERT INTO carro (timestamp_cadastro, modelo_id, ano, combustivel, num_portas, cor) VALUES ('2023-10-05 15:40:36', 2, 2014, 'FLEX', 4, 'PRETO');
INSERT INTO carro (timestamp_cadastro, modelo_id, ano, combustivel, num_portas, cor) VALUES ('2023-08-12 03:25:21', 3, 1993, 'Diesel', 4, 'AZUL');
INSERT INTO carro (timestamp_cadastro, modelo_id, ano, combustivel, num_portas, cor) VALUES ('2023-10-05 17:58:08', 4, 2015, 'FLEX', 4, 'BEGE');
INSERT INTO carro (timestamp_cadastro, modelo_id, ano, combustivel, num_portas, cor) VALUES ('2023-10-05 15:40:34', 5, 2014, 'FLEX', 4, 'AZUL');
