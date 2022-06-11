package br.unitins.locadora.converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.model.Carro;
import br.unitins.locadora.repository.CarroRepository;

@Named
@FacesConverter(forClass = Carro.class)
public class CarroConverter implements Converter<Carro> {

	@Override
	public Carro getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isBlank())
			return null;
		CarroRepository repo = new CarroRepository();
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
	public String getAsString(FacesContext context, UIComponent component, Carro carro) {
		if (carro == null || carro.getId() == null)
			return null;
		return carro.getId().toString();
	}

}
