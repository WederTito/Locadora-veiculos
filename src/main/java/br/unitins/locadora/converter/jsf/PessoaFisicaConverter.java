package br.unitins.locadora.converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.model.PessoaFisica;
import br.unitins.locadora.repository.PessoaFisicaRepository;

@Named
@FacesConverter(forClass = PessoaFisica.class)
public class PessoaFisicaConverter implements Converter<PessoaFisica> {

	@Override
	public PessoaFisica getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isBlank())
			return null;
		PessoaFisicaRepository repo = new PessoaFisicaRepository();
		try {
			return repo.findById(Integer.parseInt(value));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, PessoaFisica pessoafisica) {
		if (pessoafisica == null || pessoafisica.getId() == null)
			return null;
		return pessoafisica.getId().toString();
	}

}
