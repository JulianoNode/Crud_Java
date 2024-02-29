package com.jmr.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jmr.app.domain.TempoHora;



public interface TempoHoraRepository extends JpaRepository<TempoHora, Long>{

	@Query("select e from TempoHora e where e.titulo like :search%")
	Page<TempoHora> findAllByTitulo(String search, Pageable pageable);

	
}
