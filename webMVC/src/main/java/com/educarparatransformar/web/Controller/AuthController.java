package com.educarparatransformar.web.Controller;

import com.educarparatransformar.web.DTO.ComentarioDto;
import com.educarparatransformar.web.DTO.UsuarioDto;
import com.educarparatransformar.web.Service.ComentarioService;
import com.educarparatransformar.web.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    UsuarioService usuarioService;
    ComentarioService comentarioService;

    @Autowired
    public AuthController(UsuarioService usuarioService, ComentarioService comentarioService) {
        this.usuarioService = usuarioService;
        this.comentarioService = comentarioService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("comentarios", comentarioService.obtenerComentarios());
        return "index";
    }

    @PostMapping("/")
    public String crearComentario(@ModelAttribute ComentarioDto comentarioDto) {
        comentarioService.agregarComentario(comentarioDto);
        return "redirect:/#comm-card";
    }

    @GetMapping("/signup")
    public String registro() {
        return "signup";
    }

    @PostMapping("/signup")
    public String crearUsuario(@ModelAttribute UsuarioDto usuarioDto) {
        usuarioService.agregar(usuarioDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/usuarios")
    public String perfil() {
        return "profile";
    }

}
