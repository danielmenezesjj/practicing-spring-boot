create table usuarios(
                         id_usuario INT AUTO_INCREMENT PRIMARY KEY,
                         email varchar(255) not null,
                         senha varchar(255) not null,
                         id_tipoUsuario int,
                         FOREIGN KEY (id_tipoUsuario) REFERENCES tipoUsuario(id_tipoUsuario)
);