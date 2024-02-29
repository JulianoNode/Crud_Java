package com.jmr.app.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmr.app.datatables.Datatables;
import com.jmr.app.datatables.DatatablesColunas;
import com.jmr.app.domain.TempoHora;
import com.jmr.app.repository.TempoHoraRepository;

@Service
public class TempoHoraService {

	@Autowired
	private TempoHoraRepository repository;
	@Autowired
	private Datatables datatables;

	@Transactional(readOnly = false)
	public void salvar(TempoHora tempoHora) {
		
		repository.save(tempoHora);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> buscarTempoHoras(HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.TEMPO_HORA);
		Page<?> page = datatables.getSearch().isEmpty()
				? repository.findAll(datatables.getPageable())
				: repository.findAllByTitulo(datatables.getSearch(), datatables.getPageable());
		return datatables.getResponse(page);
	}

	@Transactional(readOnly = true)
	public TempoHora buscarPorId(Long id) {
		
		return repository.findById(id).get();
	}

	@Transactional(readOnly = false)
	public void remover(Long id) {
		
		repository.deleteById(id);
	}
	
	
}
