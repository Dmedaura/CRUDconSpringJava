package com.prueba.pruebaCRUD.repository;

import com.prueba.pruebaCRUD.entities.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculasRepository extends JpaRepository <Peliculas, Long> {
}
