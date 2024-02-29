package com.jmr.app.repository;

//import java.util.List;

//import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jmr.app.domain.Ano;


public interface AnoRepository extends JpaRepository<Ano, Long>{
	
	//List<Ano> findByNomeContainingIgnoreCase(String anoProduto, Sort sort);

	@Query("select e from Ano e where e.ano like :search%")
	Page<Ano> findAllByTitulo(String search, Pageable pageable);

	
}
