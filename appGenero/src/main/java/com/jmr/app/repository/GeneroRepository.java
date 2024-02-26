package com.jmr.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jmr.app.domain.Genero;



public interface GeneroRepository extends JpaRepository<Genero, Long>{

	@Query("select e from Genero e where e.titulo like :search%")
	Page<Genero> findAllByTitulo(String search, Pageable pageable);

	
}
