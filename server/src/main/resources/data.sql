INSERT INTO
    produto (id, nome, preco, codigo)
VALUES
    (1, 'Tomate', 4.50, 1001),
    (2, 'Iogurte', 3.99, 1002),
    (3, 'Pão Frances', 0.60, 1003),
    (4, 'Centrifuga', 999.89, 1004),
    (5, 'Televisão 59" FullHD', 4699.89, 1005),
    (6, 'Panela de pressão', 289.0, 1006),
    (7, 'Guarda chuva', 10.68, 1007),
    (8, 'Limpador de janela', 2.89, 1008),
    (9, 'Sofá', 129.50, 1009),
    (10, 'Maquina de lavar roupas', 1599.99, 1010),
    (11, 'Ventilador', 360.89, 1011),
    (12, 'Conjunto de talheres', 499.80, 1012),
    (13, 'Caderno', 20.00, 1013),
    (14, 'Caneta', 2.50, 1014),
    (15, 'Borracha', 0.89, 1015),
    (16, 'Monitor', 500.0, 1016),
    (17, 'Notebook', 2000.00, 1017),
    (18, 'Cadeira de plastico', 60.89, 1018),
    (19, 'Mouse logitech', 200.88, 1019),
    (20, 'Teclado gamer que brilha no escuro', 599.99, 1020),
    (21, 'Estante', 600.00, 1021),
    (22, 'Telefone celular', 800.00, 1022),
    (23, 'Mousepad', 1.40, 1023),
    (24, 'Chinelo havaianas', 20.00, 1024),
    (25, 'SSD', 280.50, 1025),
    (26, 'Pen Drive', 60.89, 1026),
    (27, 'Cadeira Gamer', 899.00, 1027),
    (28, 'Butijão', 50.16, 1028),
    (29, 'Cama box', 1299.40, 1029),
    (30, 'Ar Condicionado', 1649.99, 1030),
    (31, 'Biringelas', 2.89, 1031),
    (32, 'WEB CAN', 349.63, 1032),
    (34, 'Luva de silicone', 1.60, 1034),
    (35, 'Guarda roupas', 1000.00, 1035),
    (36, 'Banana', 0.45, 1036),
    (37, 'Maça', 1.80, 1037),
    (38, 'Churrasqueira eletrica', 179.90, 1038),
    (39, 'Ventilador ventisol', 49.90, 1039),
    (40, 'Head set', 200.89, 1040),
    (41, 'Mesa', 600.89, 1041),
    (42, 'Armario jandaya', 2.89, 1042),
    (43, 'Micro ondas', 266.89, 1043),
    (44, 'Liquidificador', 278.89, 1044),
    (45, 'Abajur', 5762.89, 1045),
    (46, 'Lampada', 2.89, 1046),
    (47, 'Piso', 2.89, 1047),
    (48, 'Torneira', 22.89, 1048),
    (49, 'Vaso sanitario', 2798.89, 1049),
    (50, 'Lixeira', 26.89, 1050);

INSERT INTO
    cliente_pj (id, cnpj, nome_fantasia, razao_social, codigo)
VALUES
    (1, '06.356.927/0001-45', 'Mário e Letícia Pizzaria', 'Mário e Letícia Pizzaria ME', 1001),
    (2, '62.893.067/0001-50', 'Restaurante do Jorge', 'Jorge Restaurante ME', 1002);

INSERT INTO
    cliente_pf (id, rg, nome, cpf, codigo)
VALUES
    (3, '069.178.373-00', 'Valentina Nair Cardoso', '35.214.381-2', 1003),
    (4, '480.231.001-30', 'Augusto Isaac Renan Drumond', '19.519.684-3', 1004),
    (5, '245.191.903-55', 'Luna Aparecida Novaes', '43.156.043-2', 1005),
    (6, '701.493.057-53', 'Renato Henrique', '24.754.116-3', 1006);

INSERT INTO
    funcionario (id, nome, codigo)
VALUES
    (1, 'Stephane', 1);

INSERT INTO
    permissao (id, nome, descricao)
VALUES
    (1, 'ADM', 'Administrador do sistema.');

INSERT INTO
    usuario (id, nome, email, senha, ativo, permissao_id)
VALUES
    (1, 'Renatinho', 'renato.henrique_98@hotmail.com', '$2a$10$JOv3iyB4Vgq5ZothGDicju6hMhctG0OyFGVi2AmuNTw.t3wnhv2V2', 1, 1);