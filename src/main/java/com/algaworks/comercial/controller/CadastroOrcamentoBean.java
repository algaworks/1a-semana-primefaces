package com.algaworks.comercial.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.model.OrcamentoItem;
import com.algaworks.comercial.service.GestaoOrcamentos;

@Named
@ViewScoped
public class CadastroOrcamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GestaoOrcamentos gestaoOrcamentos;
	
	private Orcamento orcamento = new Orcamento();
	
	private OrcamentoItem item;
	
	public void novoItem() {
		item = new OrcamentoItem();
	}
	
	public void adicionarItem() {
		orcamento.getItens().add(item);
		item.setOrcamento(orcamento);
	}
	
	public void salvar() {
		gestaoOrcamentos.salvar(orcamento);
		orcamento = new Orcamento();
		
		FacesMessage msg = new FacesMessage("Orçamento salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public Orcamento getOrcamento() {
		return orcamento;
	}

	public OrcamentoItem getItem() {
		return item;
	}
	
}