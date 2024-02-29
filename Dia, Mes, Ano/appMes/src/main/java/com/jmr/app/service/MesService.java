package com.jmr.app.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmr.app.datatables.Datatables;
import com.jmr.app.datatables.DatatablesColunas;
import com.jmr.app.domain.Mes;
import com.jmr.app.repository.MesRepository;

@Service
public class MesService {

	@Autowired
	private MesRepository repository;
	@Autowired
	private Datatables datatables;

	@Transactional(readOnly = false)
	public void salvar(Mes mes) {
		
		repository.save(mes);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> buscarMess(HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.MESES);
		Page<?> page = datatables.getSearch().isEmpty()
				? repository.findAll(datatables.getPageable())
				: repository.findAllByMes(datatables.getSearch(), datatables.getPageable());
		return datatables.getResponse(page);
	}

	@Transactional(readOnly = true)
	public Mes buscarPorId(Long id) {
		
		return repository.findById(id).get();
	}

	@Transactional(readOnly = false)
	public void remover(Long id) {
		
		repository.deleteById(id);
	}
	
	
}
