package br.unitins.locadora.converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.model.Categoria;
import br.unitins.locadora.repository.CategoriaRepository;

@Named
@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter<Categoria> {

	@Override
	public Categoria getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isBlank())
			return null;
		CategoriaRepository repo = new CategoriaRepository();
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
	public String getAsString(FacesContext context, UIComponent component, Categoria categoria) {
		if (categoria == null || categoria.getId() == null)
			return null;
		return categoria.getId().toString();
	}

}
