package com.alejo.redsocial.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejo.redsocial.entidades.Usuario;
import com.alejo.redsocial.servicios.UsuarioServicio;

@RestController
@Controller
@RequestMapping("/")
public class PortalControlador {

    private UsuarioServicio usuarioServicio;

    @GetMapping("/usuarios")
    public List<Usuario> Usuarios() {
        return usuarioServicio.listarUsuarios();
    }
    
}
