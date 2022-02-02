

-- Inserção de produtos
Insert into produto (nome, descricao) values ('Maça', 'Maça fresca');
Insert into produto (nome, descricao) values ('Banana', 'Banana fresca');
Insert into produto (nome, descricao) values ('Iogurte', 'Iogurte bebida láctea');
Insert into produto (nome, descricao) values ('Manteiga', 'Manteiga de origem animal');
Insert into produto (nome, descricao) values ('Sorvete', 'Sorvete napolitano');
Insert into produto (nome, descricao) values ('Asas de Frango', 'Asas de frango j[a temperadas');

-- Inserção de vendedores
Insert into vendedor (nome) values ('Julio');
Insert into vendedor (nome) values ('Manuel');
Insert into vendedor (nome) values ('Clara');
Insert into vendedor (nome) values ('Zoe');

-- Inserção de anuncios
Insert into anuncio (vendedor_id, produto_id, preco, volume, temperatura_maxima, temperatura_minima, tipo) values (1, 1, 5, 0.0001, 25, 10, 0);
Insert into anuncio (vendedor_id, produto_id, preco, volume, temperatura_maxima, temperatura_minima, tipo) values (1, 3, 12, 0.001, 18, 5, 1);
Insert into anuncio (vendedor_id, produto_id, preco, volume, temperatura_maxima, temperatura_minima, tipo) values (2, 2, 6, 0.0002, 25, 15, 0);
Insert into anuncio (vendedor_id, produto_id, preco, volume, temperatura_maxima, temperatura_minima, tipo) values (2, 6, 5, 0.002, 5, -15, 2);
Insert into anuncio (vendedor_id, produto_id, preco, volume, temperatura_maxima, temperatura_minima, tipo) values (3, 4, 7, 0.0001, 15, 2, 1);
Insert into anuncio (vendedor_id, produto_id, preco, volume, temperatura_maxima, temperatura_minima, tipo) values (3, 2, 6.5, 0.0002, 25, 15, 0);
Insert into anuncio (vendedor_id, produto_id, preco, volume, temperatura_maxima, temperatura_minima, tipo) values (4, 5, 23, 0.0015, 5, -15, 2);
Insert into anuncio (vendedor_id, produto_id, preco, volume, temperatura_maxima, temperatura_minima, tipo) values (4, 3, 13, 0.001, 18, 5, 1);

-- Inserção de armazem
Insert into armazem (nome, CEP) values ('CD_Louveira', '00100-100');

-- Inserção de representantes
Insert into representante (armazem_id, nome) values (1, 'Ismael');

-- Inserção de setor
Insert into setor (armazem_id, nome, volume) values (1, 'Fresco', 1000);
Insert into setor (armazem_id, nome, volume) values (1, 'Refrigerado', 1000);
Insert into setor (armazem_id, nome, volume) values (1, 'Congelado', 1000);

-- Inserção de ordem_entrada
Insert into ordem_entrada (setor_id, data_criacao) values (1, '2022-01-27 11:00:00');
Insert into ordem_entrada (setor_id, data_criacao) values (2, '2022-01-27 12:00:00');
Insert into ordem_entrada (setor_id, data_criacao) values (1, '2022-01-28 08:00:00');
Insert into ordem_entrada (setor_id, data_criacao) values (3, '2022-01-29 07:00:00');
Insert into ordem_entrada (setor_id, data_criacao) values (2, '2022-01-30 10:00:00');
Insert into ordem_entrada (setor_id, data_criacao) values (1, '2022-02-01 17:00:00');
Insert into ordem_entrada (setor_id, data_criacao) values (3, '2022-02-02 16:00:00');
Insert into ordem_entrada (setor_id, data_criacao) values (2, '2022-02-03 14:00:00');

-- Inserção de estoques
Insert into estoque (anuncio_id, ordem_entrada_id, quantidade_inicial, quantidade_atual, temperatura_atual, data_validade, data_producao) values (1, 1, 1000, 1000, 20, '2022-02-15', '2022-01-27 11:00:00');
Insert into estoque (anuncio_id, ordem_entrada_id, quantidade_inicial, quantidade_atual, temperatura_atual, data_validade, data_producao) values (2, 2, 100, 100, 10, '2022-10-27', '2022-01-25 12:10:00');
Insert into estoque (anuncio_id, ordem_entrada_id, quantidade_inicial, quantidade_atual, temperatura_atual, data_validade, data_producao) values (3, 3, 800, 800, 18, '2022-02-20', '2022-01-24 08:03:00');
Insert into estoque (anuncio_id, ordem_entrada_id, quantidade_inicial, quantidade_atual, temperatura_atual, data_validade, data_producao) values (4, 4, 500, 500, -3, '2022-10-20', '2022-01-25 15:55:00');
Insert into estoque (anuncio_id, ordem_entrada_id, quantidade_inicial, quantidade_atual, temperatura_atual, data_validade, data_producao) values (5, 5, 1500, 1500, 3, '2022-07-05', '2022-01-20 07:34:00');
Insert into estoque (anuncio_id, ordem_entrada_id, quantidade_inicial, quantidade_atual, temperatura_atual, data_validade, data_producao) values (6, 6, 3000, 3000, 17, '2022-02-23', '2022-01-28 14:14:00');
Insert into estoque (anuncio_id, ordem_entrada_id, quantidade_inicial, quantidade_atual, temperatura_atual, data_validade, data_producao) values (7, 7, 350, 350, -5, '2022-11-17', '2022-01-25 22:15:00');
Insert into estoque (anuncio_id, ordem_entrada_id, quantidade_inicial, quantidade_atual, temperatura_atual, data_validade, data_producao) values (8, 8, 500, 500, 7, '2022-12-10', '2022-01-27 16:44:00');

--Inserção de comprador
Insert into comprador (nome, usernome, senha) values ('Fernado ventura', 'fernado', '123456');
Insert into comprador (nome, usernome, senha) values ('Marcos algusto', 'marcos', '123456');
Insert into comprador (nome, usernome, senha) values ('Maria ferreira', 'maria', '123456');
Insert into comprador (nome, usernome, senha) values ('Carlos henrique', 'carlos', '123456');
Insert into comprador (nome, usernome, senha) values ('Constatino algunsto', 'constatino', '123456');
Insert into comprador (nome, usernome, senha) values ('Camila pitanga', 'fernado', '123456');
Insert into comprador (nome, usernome, senha) values ('Toni ferreira', 'toni', '123456');
Insert into comprador (nome, usernome, senha) values ('Algunsto ventura', 'algusto', '123456');
Insert into comprador (nome, usernome, senha) values ('ventura ferreira', 'ventura', '123456');

--Inserção de Carrinho_comprador
Insert into carrinho (comprador_id, localdate) values (1, '2022-01-15');
Insert into carrinho (comprador_id, localdate) values (1, '2022-01-25');
Insert into carrinho (comprador_id, localdate) values (1, '2022-01-30');
Insert into carrinho (comprador_id, localdate) values (2, '2021-01-10');
Insert into carrinho (comprador_id, localdate) values (2, '2022-01-15');
Insert into carrinho (comprador_id, localdate) values (3, '2021-02-15');
Insert into carrinho (comprador_id, localdate) values (3, '2022-01-10');
Insert into carrinho (comprador_id, localdate) values (4, '2021-02-15');
Insert into carrinho (comprador_id, localdate) values (5, '2021-02-25');
Insert into carrinho (comprador_id, localdate) values (6, '2021-02-15');


--Inserção de Item_carrinho
Insert into itemcarrinho (anuncio_id, carrinho_id, quantidade, preco) values (1, 1, 10, 5);
Insert into itemcarrinho (anuncio_id, carrinho_id, quantidade, preco) values (1, 1, 12, 12);
Insert into itemcarrinho (anuncio_id, carrinho_id, quantidade, preco) values (2, 1, 10, 12);
Insert into itemcarrinho (anuncio_id, carrinho_id, quantidade, preco) values (2, 1, 4, 12);
Insert into itemcarrinho (anuncio_id, carrinho_id, quantidade, preco) values (3, 1, 15, 7);
Insert into itemcarrinho (anuncio_id, carrinho_id, quantidade, preco) values (3, 1, 10, 7);
Insert into itemcarrinho (anuncio_id, carrinho_id, quantidade, preco) values (3, 1, 22, 7);
Insert into itemcarrinho (anuncio_id, carrinho_id, quantidade, preco) values (3, 1, 11, 7);
Insert into itemcarrinho (anuncio_id, carrinho_id, quantidade, preco) values (4, 1, 12, 23);
Insert into itemcarrinho (anuncio_id, carrinho_id, quantidade, preco) values (4, 1, 12, 23);

