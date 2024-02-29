package com.jmr.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jmr.app.domain.Mes;



public interface MesRepository extends JpaRepository<Mes, Long>{

	@Query("select e from Mes e where e.nome like :search%")
	Page<Mes> findAllByMes(String search, Pageable pageable);

	
}
