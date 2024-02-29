package com.jmr.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jmr.app.domain.Privacidade;



public interface PrivacidadeRepository extends JpaRepository<Privacidade, Long>{

	@Query("select e from Privacidade e where e.titulo like :search%")
	Page<Privacidade> findAllByTitulo(String search, Pageable pageable);

	
}
