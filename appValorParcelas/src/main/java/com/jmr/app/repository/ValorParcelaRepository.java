package com.jmr.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jmr.app.domain.ValorParcela;

public interface ValorParcelaRepository extends JpaRepository<ValorParcela, Long>{
	
	@Query("select e from ValorParcela e where e.valor like :search%")
	Page<ValorParcela> findAllByTitulo(String search, Pageable pageable);

	
}
