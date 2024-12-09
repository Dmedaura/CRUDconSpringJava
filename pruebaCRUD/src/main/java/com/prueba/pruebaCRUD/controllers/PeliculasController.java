package com.prueba.pruebaCRUD.controllers;

import com.prueba.pruebaCRUD.entities.Peliculas;
import com.prueba.pruebaCRUD.services.PelicuasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/peliculas") //localhost:8080/peliculas
public class PeliculasController {
    @Autowired
    private PelicuasService pelicuasService;

    // C (Create - Crear)
    @PostMapping("/crear")
    public ResponseEntity<?> crearPelicula(@RequestBody Peliculas pelicula){
        pelicuasService.crear(pelicula);
        return ResponseEntity.ok("La pelicula fue creada exitosamente");
    }

    // R (Read - Leer/Mostrar)
    @GetMapping("/mostrar")
    public ResponseEntity<?> mostrarPeliculas(){
        ArrayList<Peliculas> peliculas = pelicuasService.mostrar();
        return ResponseEntity.ok(peliculas);
    }

    // U (Update - Acualizar)
    @PutMapping("/actualizar/{id}") // localhost:8080/pelicula/actualizar/{id}
    public ResponseEntity<?> actulizarPelicula(@PathVariable Long id, @RequestBody Peliculas pelicula) {
        boolean actualizado = pelicuasService.editar(id, pelicula);
        if (actualizado) {
            return ResponseEntity.ok("La pelicula se actualizo exitosamente");
        } else {
            return ResponseEntity.badRequest().body("No se editó correctamente la pelicula");
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPelicula(@PathVariable Long id){
        pelicuasService.eliminar(id);
        return ResponseEntity.ok("Pelicula eliminada exitosamente");
    }
}
