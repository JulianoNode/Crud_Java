package com.jmr.app.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmr.app.datatables.Datatables;
import com.jmr.app.datatables.DatatablesColunas;
import com.jmr.app.domain.ValorProduto;
import com.jmr.app.repository.ValorProdutoRepository;

@Service
public class ValorProdutoService {

	@Autowired
	private ValorProdutoRepository repository;
	@Autowired
	private Datatables datatables;

	@Transactional(readOnly = false)
	public void salvar(ValorProduto valorProduto) {
		
		repository.save(valorProduto);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> buscarValorProdutos(HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.VALOR_PRODUTOS);
		Page<?> page = datatables.getSearch().isEmpty()
				? repository.findAll(datatables.getPageable())
				: repository.findAllByValorProduto(datatables.getSearch(), datatables.getPageable());
		return datatables.getResponse(page);
	}

	@Transactional(readOnly = true)
	public ValorProduto buscarPorId(Long id) {
		
		return repository.findById(id).get();
	}

	@Transactional(readOnly = false)
	public void remover(Long id) {
		
		repository.deleteById(id);
	}
	
	
}
