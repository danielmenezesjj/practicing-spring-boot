create table medicos(
                        id_medico INT AUTO_INCREMENT PRIMARY KEY,
                        nome VARCHAR (255) NOT NULL,
                        especialidade varchar(255) not null,
                        cpf varchar(255) not null,
                        dt_nascimento varchar(255) not null,
                        rg varchar(255) not null,
                        naturalidade varchar(255) not null,
                        celular varchar(255) not null,
                        email varchar(255) not null,
                        endereco varchar(255) not null
);