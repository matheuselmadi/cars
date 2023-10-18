INSERT INTO marca (nome_marca) VALUES ('Marca1');
INSERT INTO marca (nome_marca) VALUES ('Marca2');
INSERT INTO marca (nome_marca) VALUES ('Marca3');

-- Suponhamos que as marcas com IDs 1, 2 e 3 existam na tabela de marca.
INSERT INTO modelo (nome, valor_fipe, marca_id) VALUES ('Modelo1', 25000.00, 1);
INSERT INTO modelo (nome, valor_fipe, marca_id) VALUES ('Modelo2', 30000.00, 2);
INSERT INTO modelo (nome, valor_fipe, marca_id) VALUES ('Modelo3', 28000.00, 3);

-- Suponhamos que os modelos com IDs 1, 2 e 3 existam na tabela de modelo.
INSERT INTO carro (timestamp_cadastro, modelo_id, ano, combustivel, num_portas, cor) VALUES ('2023-10-18 12:00:00', 1, 2022, 'Gasolina', 4, 'Azul');
INSERT INTO carro (timestamp_cadastro, modelo_id, ano, combustivel, num_portas, cor) VALUES ('2023-10-18 14:30:00', 2, 2021, 'Álcool', 2, 'Vermelho');
INSERT INTO carro (timestamp_cadastro, modelo_id, ano, combustivel, num_portas, cor) VALUES ('2023-10-18 15:45:00', 3, 2023, 'Diesel', 5, 'Prata');
