package com.alejo.redsocial.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alejo.redsocial.entidades.Imagen;

@Repository
public interface ImagenRepositorio extends JpaRepository<Imagen, Long>{
    
}
