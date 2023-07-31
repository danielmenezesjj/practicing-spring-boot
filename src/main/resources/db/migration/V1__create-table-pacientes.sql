create table pacientes(
id_paciente INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR (255) NOT NULL,
cpf varchar(255) not null,
dt_nascimento varchar(255) not null,
rg varchar(255) not null,
naturalidade varchar(255) not null,
celular varchar(255) not null,
email varchar(255) not null
);