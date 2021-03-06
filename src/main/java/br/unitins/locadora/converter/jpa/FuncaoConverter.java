package br.unitins.locadora.converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unitins.locadora.model.Funcao;

@Converter(autoApply = true)
public class FuncaoConverter implements AttributeConverter<Funcao, Integer>{

	@Override
	public Integer convertToDatabaseColumn(Funcao funcao) {
		return funcao == null ? null : funcao.getId();
	}

	@Override
	public Funcao convertToEntityAttribute(Integer id) {
		return Funcao.valueOf(id);
	}

}
