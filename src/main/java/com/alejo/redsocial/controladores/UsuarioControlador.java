package com.alejo.redsocial.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alejo.redsocial.entidades.Imagen;
import com.alejo.redsocial.entidades.Usuario;
import com.alejo.redsocial.excepciones.Excepciones;
import com.alejo.redsocial.servicios.ImagenServicio;
import com.alejo.redsocial.servicios.UsuarioServicio;

@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    ImagenServicio imagenServicio;
    
    @GetMapping("/lista")
    public List<Usuario> listaUsuarios() {
        return usuarioServicio.listarUsuarios();
    }

    @PostMapping("/agregar")
    public Usuario agregarUsuario(@RequestParam String name,
                                @RequestParam String apellido,
                                @RequestParam String mail,
                                @RequestParam String password,
                                @RequestParam MultipartFile archivo) 
    {
        try {
            Imagen imagen = imagenServicio.guardar(archivo);
            return usuarioServicio.agregar(name, apellido, mail, password, password, imagen);
        } catch (Excepciones e) {
            System.out.println("No se pudo agregar el usuario");
        }
        return null;
    }

}
