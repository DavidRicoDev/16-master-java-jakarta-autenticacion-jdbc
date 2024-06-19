package es.davidrico.jakarta.autenticacionjdbc.repositorios;

import es.davidrico.jakarta.autenticacionjdbc.modelos.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends Repository<Usuario>{
    Usuario porUsername(String username) throws SQLException;
}
