create database notelog;

-- drop database notelog;

use notelog;


	-- Criar tabela Empresa
	CREATE TABLE Empresa (
		id INT PRIMARY KEY AUTO_INCREMENT,
		nome VARCHAR(45),
		cnpj CHAR(18),
		email VARCHAR(45)
	);
    
INSERT INTO Empresa (nome,CNPJ, email) VALUES 
('Moveis S.A','08.540.322/0001-35','moveissa@gmail.com'),
('SolutionsBurn IT','65.719.677/0001-20','solutionsburnit@gmail.com'),
('InfraTech','26.897.566/0001-51','infratech@gmail.com');


	-- Criar tabela Funcionario
CREATE TABLE Funcionario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    cargo CHAR(45),
    email VARCHAR(45),
    fkEmpresa INT,
    CONSTRAINT FK_Funcionario_Empresa FOREIGN KEY (fkEmpresa)
        REFERENCES Empresa(id)
);

INSERT INTO Funcionario (nome, cargo, email, fkEmpresa) VALUES
('João', 'Gerente', 'joao@moveissa.com',1),
('Ana', 'Técnico', 'ana@solutionsburnit.com',2),
('Camila', 'Desenvolvedor', 'camila@infratech.com',3);

	-- Criar tabela Usuário
	CREATE TABLE Usuario (
		idUsuario INT PRIMARY KEY AUTO_INCREMENT,
		nome VARCHAR(45),
		senha VARCHAR(45),
		fkEmpresa INT,
        fkFuncionario INT,
		CONSTRAINT FK_Usuario_Empresa FOREIGN KEY (fkEmpresa)
			REFERENCES Empresa(id),
		CONSTRAINT fkFuncionario FOREIGN KEY (fkFuncionario)
			REFERENCES Funcionario (id)
	);
    
    ALTER TABLE Usuario RENAME COLUMN idUsuario TO id;
    
    -- Usuários para Moveis S.A
INSERT INTO Usuario (nome, senha, fkEmpresa, fkFuncionario) VALUES
('JoaoMoveis', 'senha123', 1, 1),
('AnaSolutions', 'solutions456', 2, 2),
('CamilaInfraTech', 'infra789', 3, 3);

	-- Criar tabela Endereco
	CREATE TABLE Endereco (
		id INT PRIMARY KEY AUTO_INCREMENT,
		bairro VARCHAR(45),
		rua VARCHAR(45),
		estado VARCHAR(45),
		numero VARCHAR(45),
		complemento VARCHAR(45),
		cep CHAR(8),
		fkEmpresa INT,
		CONSTRAINT FK_Endereco_Empresa FOREIGN KEY (fkEmpresa)
			REFERENCES Empresa(id)
	);

	-- Criar tabela Notebook
	CREATE TABLE Notebook (
	  id INT AUTO_INCREMENT PRIMARY KEY,
	  sistemaOperacional VARCHAR(45),
	  fabricante VARCHAR(45),
	  arquitetura VARCHAR(45),
	  fkFuncionario INT,
	  CONSTRAINT FK_Notebook_Funcionario FOREIGN KEY (fkFuncionario)
			REFERENCES Funcionario (id)
	);

	-- Criar tabela CPU
	CREATE TABLE `Cpu` (
	  id INT AUTO_INCREMENT PRIMARY KEY,
      fkNotebook INT,
	  nome VARCHAR(45),
	  numeroFisico VARCHAR(45),
	  numerologico VARCHAR(45),
	  idFisicoProcessador VARCHAR(45),
	  frequencia VARCHAR(45),
	  CONSTRAINT FK_Cpu_Notebook FOREIGN KEY (fkNotebook)
		REFERENCES Notebook (id)
	);

	-- Criar tabela LogCPU
	CREATE TABLE LogCpu (
	  id INT AUTO_INCREMENT PRIMARY KEY,
	  fkCpu INT,
	  porcentagemUso VARCHAR(45),
	  CONSTRAINT FK_LogCpu_Cpu FOREIGN KEY (fkCpu)
		REFERENCES `Cpu` (id)
	);
    
    -- Tabela: processos_bloqueados_no_setor
	create table processos_bloqueados (
    id_processos int PRIMARY KEY auto_increment,
    tituloProcesso varchar(45),
	fkEmpresa INT,
    CONSTRAINT FK_Funcionario_Empresa FOREIGN KEY (fkEmpresa)
	REFERENCES Empresa(id)
	) auto_increment = 1000;

	-- Criar tabela LogJanelas
	CREATE TABLE LogJanelas (
	  id INT AUTO_INCREMENT PRIMARY KEY,
	  idJanela VARCHAR(45),
	  fkNotebook INT,
	  CONSTRAINT FK_LogJanelas_Notebook FOREIGN KEY (fkNotebook)
		REFERENCES Notebook (id)
	);

	-- Criar tabela Disco
	CREATE TABLE DiscoRigido (
		id INT AUTO_INCREMENT PRIMARY KEY,
        fkNotebook INT,
		modelo VARCHAR(45),
		`serial` VARCHAR(45),
		tamanho VARCHAR(45),
	  CONSTRAINT FK_DiscoRigido_Notebook FOREIGN KEY (fkNotebook)
		REFERENCES Notebook (id)
	);

	-- Criar tabela LogDisco
	CREATE TABLE LogDisco (
		id INT AUTO_INCREMENT PRIMARY KEY,
		fkDiscoRigido int,
		leitura VARCHAR(45),
		bytesLeitura VARCHAR(45),
		escrita VARCHAR(45),
		bytesEscrita VARCHAR(45),
		CONSTRAINT FK_LogDisco_DiscoRigido FOREIGN KEY (fkDiscoRigido)
			REFERENCES DiscoRigido (id)
	);

	-- Criando tabela TempoDeAtividade
	CREATE TABLE TempoDeAtividade (
		id INT PRIMARY KEY AUTO_INCREMENT,
		fkNotebook INT,
		tempoDeAtividade VARCHAR(45),
		tempoInicializado VARCHAR(45),
		CONSTRAINT FK_TempoDeAtividade_Notebook FOREIGN KEY (fkNotebook)
			REFERENCES Notebook (id)
	);

	-- Criando tabela Ram
	CREATE TABLE Ram (
		id INT PRIMARY KEY AUTO_INCREMENT,
        fkNotebook INT,
		totalMemoria varchar(45),
	  CONSTRAINT FK_Ram_Notebook FOREIGN KEY (fkNotebook)
		REFERENCES Notebook (id)
	);

	-- Criando tabela LogRAM
	CREATE TABLE LogRam (
		id INT AUTO_INCREMENT PRIMARY KEY,
		fkRam INT,
		usoMemoria VARCHAR(45),
		memoriaDisponivel VARCHAR(45),
		CONSTRAINT FK_LogRam_Ram FOREIGN KEY (fkRam)
			REFERENCES Ram (id)
	);

	-- Criando tabela Geolocalizacao
	CREATE TABLE Geolocalizacao (
	  id INT AUTO_INCREMENT PRIMARY KEY,
	  fkNotebook INT,
	  enderecoIP VARCHAR(45),
	  pais VARCHAR(45),
	  cidade VARCHAR(45),
	  nomeRegiao VARCHAR(45),
	  latitude VARCHAR(45),
	  longitude VARCHAR(45),
	  timeZone VARCHAR(6),
	  companiaInternet VARCHAR(45),
	  CONSTRAINT FK_Geolocalizacao_Notebook FOREIGN KEY (fkNotebook)
			REFERENCES Notebook (id)
	);
    
    CREATE USER 'notelogUser'@'localhost' IDENTIFIED BY 'notelikeagod';
    
    GRANT SELECT, INSERT, UPDATE, DELETE ON notelog.* TO 'notelogUser'@'localhost';
    
    FLUSH PRIVILEGES;
    
select * from Geolocalizacao;
select * from Notebook;	
select * from TempoDeAtividade;
select * from Ram;
select * from DiscoRigido;
select * from `Cpu`;
select * from LogRam;
select * from LogDisco;
select * from LogJanelas;
select * from LogCpu;
select * from Ram join LogRam on Ram.id = fkRam;
select * from `Cpu` join LogCpu on `Cpu`.id = fkCpu;
select * from DiscoRigido;
SELECT LAST_INSERT_ID() from DiscoRigido;
select * from Funcionario;