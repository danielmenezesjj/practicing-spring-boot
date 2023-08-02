create table usuarios(
                         id_usuario INT AUTO_INCREMENT PRIMARY KEY,
                         email varchar(255) not null,
                         senha varchar(255) not null,
                         tipo_usuario_id int,
                         FOREIGN KEY (tipo_usuario_id) REFERENCES tipoUsuario(id_tipo_usuario)
);