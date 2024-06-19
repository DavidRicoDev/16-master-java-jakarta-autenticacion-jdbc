package es.davidrico.jakarta.autenticacionjdbc.servicios;

import es.davidrico.jakarta.autenticacionjdbc.modelos.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}
