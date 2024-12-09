package com.prueba.pruebaCRUD.services;

import com.prueba.pruebaCRUD.entities.Peliculas;
import com.prueba.pruebaCRUD.repository.PeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PelicuasService {

    @Autowired
    private PeliculasRepository peliculasRepository;

    public void crear (Peliculas pelicula){
        peliculasRepository.save(pelicula);
    }

    public  boolean editar (Long id, Peliculas peliculaNueva){
        Peliculas peliculaActualizada;
        //Busca el id en base de datos
        Optional<Peliculas> optPeliculaVieja = peliculasRepository.findById(id);
        // Si lo encuantra lo guarda en la variable optPeliculaVieja
        if (optPeliculaVieja.isPresent()){
            // Igualamos la pelicula vieja que encontramos y la igualamos a la pelicula a actualizar
            peliculaActualizada = optPeliculaVieja.get();
            // Asignamos lo valores que adquirimos
            peliculaActualizada.setNombre(peliculaNueva.getNombre());
            peliculaActualizada.setAnio(peliculaNueva.getAnio());
            //JPA entiende que es una actualizacion por que adquirimos una pelicula buscandola por id
            peliculasRepository.save(peliculaActualizada);
            return true;
        }
        return false;
    }

    public ArrayList<Peliculas> mostrar(){
        ArrayList<Peliculas> peliculas = (ArrayList<Peliculas>) peliculasRepository.findAll();
        return peliculas;
    }
    public void eliminar(Long id){
        peliculasRepository.deleteById(id);
    }
}
