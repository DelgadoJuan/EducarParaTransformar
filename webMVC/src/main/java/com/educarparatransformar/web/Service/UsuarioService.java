package com.educarparatransformar.web.Service;

import com.educarparatransformar.web.DTO.UsuarioDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService {
    Boolean agregar(UsuarioDto usuarioDto);
    Boolean editarUsuario(UsuarioDto usuarioDto, String username);
    Boolean eliminarUsuario(String username);
}
