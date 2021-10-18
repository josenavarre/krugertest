package com.kruger.vacunacion.app.services;

import com.kruger.vacunacion.app.entities.Usuario;

public interface UsuarioService {
    public Usuario DarDeAltaUsuario(String username, String password);
}
