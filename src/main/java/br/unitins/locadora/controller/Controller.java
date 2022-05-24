package br.unitins.locadora.controller;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.model.DefaultEntity;
import br.unitins.locadora.repository.Repository;


public abstract class Controller <T extends DefaultEntity> {
	
	private Repository<T> repository;
	protected T entity;
	
	public Controller(Repository<T> repository) {
		super();
		this.repository = repository;
	}

	public void incluir() {
		try {
			getRepository().save(getEntity());
			Util.addInfoMessage("Inclus�o realizada com sucesso.");
			limpar();
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
	}

	public void alterar() {
		try {
			getRepository().save(getEntity());
			Util.addInfoMessage("Altera��o realizada com sucesso.");
			limpar();
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			getRepository().remove(getEntity());
			Util.addInfoMessage("Exclus�o realizada com sucesso.");
			limpar();
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
	}

	
	public void limpar() {
		entity = null;
	}
	
	public Repository<T> getRepository() {
		return repository;
	}
	
	public abstract T getEntity();
	
	public void setEntity(T entity) {
		this.entity = entity;
	}

	protected void limparRelacionamentosNaoObrigatorios() {
		// TODO Auto-generated method stub
		
	}
}
