package es.davidrico.jakarta.autenticacionjdbc.servicios;

import es.davidrico.jakarta.autenticacionjdbc.modelos.Usuario;
import es.davidrico.jakarta.autenticacionjdbc.repositorios.UsuarioRepository;
import es.davidrico.jakarta.autenticacionjdbc.repositorios.UsuarioRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioService{
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(Connection connection) {
        this.usuarioRepository = new UsuarioRepositoryImpl(connection);
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
