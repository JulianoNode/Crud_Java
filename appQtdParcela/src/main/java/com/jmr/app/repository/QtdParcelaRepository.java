package com.jmr.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jmr.app.domain.QtdParcela;

public interface QtdParcelaRepository extends JpaRepository<QtdParcela, Long>{

	@Query("select e from QtdParcela e where e.parcelamento like :search%")
	Page<QtdParcela> findAllByParcelamento(String search, Pageable pageable);

	
}
