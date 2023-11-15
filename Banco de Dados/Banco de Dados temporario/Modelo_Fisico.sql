CREATE DATABASE iFormal;

USE iFormal;

CREATE TABLE Usuarios (
  id_usuario INTEGER PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(20),
  email VARCHAR(20) UNIQUE, -- Adicionando a restrição de unicidade
  cpf VARCHAR(20) UNIQUE,   -- Adicionando a restrição de unicidade
  contato VARCHAR(20),
  senha VARCHAR(255) -- Adicionando a coluna senha
);

CREATE TABLE Servicos (
  id_servico INTEGER PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(20),
  descricao VARCHAR(20)
);

CREATE TABLE Agendamentos (
  id_agendamento INTEGER PRIMARY KEY AUTO_INCREMENT,
  id_usuario INTEGER,
  id_servico INTEGER,
  data_servico DATE,
  observacoes TEXT,
  preco DECIMAL(10, 2),
  FOREIGN KEY(id_usuario) REFERENCES Usuarios (id_usuario),
  FOREIGN KEY(id_servico) REFERENCES Servicos (id_servico)
);

-- Adicionar mais entradas
insert into Usuarios (nome, email, cpf, contato, senha) values 
('Fernando', 'fernando@hotmail.com', '000.000.001-01', '0000.0001', 'senha123'),
('Gabriel', 'gabriel@hotmail.com', '000.000.001-02', '0000.0002', 'senha456'),
('Renato', 'renato@hotmail.com', '000.000.001-03', '0000.0003', 'senha789'),
('Maria', 'maria@hotmail.com', '000.000.001-04', '0000.0004', 'senha1011');

insert into Servicos (nome, descricao) values 
('Professor', 'Dar aula em escola'),
('Pintor', 'Pintar uma casa'),
('Motorista', 'Dirigir carro'),
('Eletricista', 'Reparo elétrico');

insert into Agendamentos (id_usuario, id_servico, data_servico, observacoes, preco) values 
(1, 1, '2023-10-22', 'Observações para o agendamento 1', 1200.00),
(2, 2, '2023-11-26', 'Observações para o agendamento 2', 1000.00),
(3, 3, '2023-12-28', 'Observações para o agendamento 3', 1100.00),
(4, 4, '2023-11-30', 'Observações para o agendamento 4', 800.00);

-- Consultar(Read)
select * from Usuarios;
select * from Servicos;
select * from Agendamentos;
select * 
from Agendamentos A, Servicos S, Usuarios U 
where A.id_servico = S.id_servico and A.id_usuario = U.id_usuario;

-- Atualizar(Update)
UPDATE Usuarios SET nome = 'Rui', email = 'rui@hotmail.com', cpf = '000.000.000-11', contato = '0000-0010', senha = 'novasenha' Where id_usuario = 1;
UPDATE Servicos SET nome = 'Gari', descricao = 'Limpar a cidade' Where id_servico = 1;
UPDATE Agendamentos SET id_usuario = 1, id_servico = 1, data_servico = '2023-11-30', observacoes = 'Observações atualizadas', preco = 1500.00 Where id_agendamento = 1;

-- Deletar(Delete)
DELETE FROM Usuarios Where id_usuario = 2;
DELETE FROM Servicos Where id_servico = 2;
DELETE FROM Agendamentos Where id_agendamento = 2;
