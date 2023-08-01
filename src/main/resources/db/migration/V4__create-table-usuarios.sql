create table usuarios(
                         id_usuario INT AUTO_INCREMENT PRIMARY KEY,
                         email varchar(255) not null,
                         senha varchar(255) not null,
                         id_tipo_usuario int,
                         FOREIGN KEY (id_tipo_usuario) REFERENCES tipoUsuario(id_tipo_usuario)
);