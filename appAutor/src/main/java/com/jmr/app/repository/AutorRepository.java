package com.jmr.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jmr.app.domain.Autor;



public interface AutorRepository extends JpaRepository<Autor, Long>{

	@Query("select e from Autor e where e.nome like :search%")
	Page<Autor> findAllByTitulo(String search, Pageable pageable);

	
}
