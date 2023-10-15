package com.alejo.redsocial.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alejo.redsocial.entidades.Imagen;
import com.alejo.redsocial.entidades.Usuario;
import com.alejo.redsocial.excepciones.Excepciones;
import com.alejo.redsocial.repositorios.UsuarioRepositorio;

// @Service
// public class UsuarioServicio implements UserDetailsService{

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ImagenServicio imagenServicio;

    public Usuario agregar(String name, String apellido, String mail, String password, String password2, Imagen imagen) throws Excepciones {

        verificarCampos(name, apellido, mail, password, password2, imagen);

        Usuario usuario = new Usuario();

        usuario.setName(name);
        usuario.setApellido(apellido);
        usuario.setMail(mail);
        usuario.setPassword(password);
        usuario.setFecha_creacion(new Date());
        usuario.setImagen(imagen);

        return usuarioRepositorio.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Usuario getOne(Long id) {
        return usuarioRepositorio.buscarPorId(id);
    }

    private void verificarCampos(String name, String apellido, String mail, String password, String password2, Imagen archivo) throws Excepciones {
        if(name.trim().isEmpty() || name == null) {
            throw new Excepciones("El nombre no puede estar vacio o ser nulo");
        }

        if(apellido.trim().isEmpty() || apellido == null) {
            throw new Excepciones("El apellido no puede estar vacio o ser nulo");
        }

        if(mail.trim().isEmpty() || mail == null) {
            throw new Excepciones("El mail no puede estar vacio o ser nulo");
        }

        if(password.trim().isEmpty() || password == null) {
            throw new Excepciones("La contraseña no puede estar vacia o ser null");
        }

        if(password != password2) {
            throw new Excepciones("Las contraseñas no son iguales");
        }
    }

    // @Override
    // public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    //     Usuario usuario = usuarioRepositorio.buscarPorEmail(email);

    //     if(usuario != null) {
    //         List<GrantedAuthority> permisos = new ArrayList<>();

    //         GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol());

    //         permisos.add(p);

    //         return new User(usuario.getMail(), usuario.getPassword(), permisos);
    //     }else{
    //         return null;
    //     }
    // }
    
}
