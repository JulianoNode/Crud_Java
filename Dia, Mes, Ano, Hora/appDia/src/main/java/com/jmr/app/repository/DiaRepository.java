package com.jmr.app.repository;

//import java.util.List;

//import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jmr.app.domain.Dia;


public interface DiaRepository extends JpaRepository<Dia, Long>{
	
	//List<Dia> findByNomeContainingIgnoreCase(String diaProduto, Sort sort);

	@Query("select e from Dia e where e.dia like :search%")
	Page<Dia> findAllByDia(String search, Pageable pageable);

	
}
