CREATE TABLE endereco(id INT NOT NULL PRIMARY KEY,
					  cep VARCHAR(15) NOT NULL,
					  rua VARCHAR(100),
					  numero INT,
					  complemento VARCHAR(50),
					  bairro VARCHAR(100) NOT NULL,
					  cidade VARCHAR(100) NOT NULL,
					  estado VARCHAR(2) NOT NULL);

CREATE TABLE pessoa(id INT NOT NULL PRIMARY KEY,
					nome VARCHAR(100) NOT NULL,
					endereco INT NOT NULL,
					cpf VARCHAR(15) NOT NULL,
					nascimento DATETIME,
					telefone VARCHAR(15),
					email VARCHAR(100),
					FOREIGN KEY FK_PESSOA_ENDERECO (endereco) REFERENCES endereco(id));

CREATE TABLE perfil(id INT NOT NULL PRIMARY KEY,
					nome VARCHAR(100) NOT NULL,
					descricao BLOB NOT NULL);

CREATE TABLE usuario(id INT NOT NULL PRIMARY KEY,
					 login VARCHAR(100) NOT NULL,
					 senha VARCHAR(100) NOT NULL,
					 pessoa INT NOT NULL,
					 perfil INT NOT NULL,
					 FOREIGN KEY FK_USUARIO_PESSOA (pessoa) REFERENCES pessoa(id),
					 FOREIGN KEY FK_USUARIO_PERFIL (perfil) REFERENCES perfil(id));