package com.algaworks.comercial.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.repository.OrcamentosRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoOrcamentos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OrcamentosRepository orcamentos;
	
	@Transacional
	public void salvar(Orcamento orcamento) {
		orcamentos.guardar(orcamento);
	}
	
}