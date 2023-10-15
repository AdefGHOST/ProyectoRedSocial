package com.alejo.redsocial.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alejo.redsocial.entidades.Imagen;
import com.alejo.redsocial.excepciones.Excepciones;
import com.alejo.redsocial.repositorios.ImagenRepositorio;

@Service
public class ImagenServicio {

    @Autowired
    private ImagenRepositorio imagenRepositorio;
    
    public Imagen guardar(MultipartFile archivo) throws Excepciones {
        if(archivo != null) {
            try {
                Imagen imagen = new Imagen();

                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());

                

                return imagenRepositorio.save(imagen);

            } catch (Exception e) {
                System.err.println(e.getLocalizedMessage() + "  Puede ser que haya un problema con el autogenerado de las imagenes");
            }
        }
        return new Imagen();
    }

    public Imagen actualizar(MultipartFile archivo, Long idImagen) throws Excepciones {
        if(archivo != null) {
            try {
                Imagen imagen = new Imagen();

                if(idImagen != null) {
                    Optional<Imagen> respuesta = imagenRepositorio.findById(idImagen);

                    if(respuesta.isPresent()) {
                        imagen = respuesta.get();
                    }
                }

                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());

                return imagenRepositorio.save(imagen);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
}
