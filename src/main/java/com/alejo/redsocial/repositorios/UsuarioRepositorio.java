package com.alejo.redsocial.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alejo.redsocial.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    
    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    public Usuario buscarPorId(@Param("id")Long name);

    @Query("SELECT u FROM Usuario u WHERE u.mail = :mail")
    public Usuario buscarPorEmail(@Param("mail") String email);

}