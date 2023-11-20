package ar.com.educacionit.bootcamp.service.placeholder;

import ar.com.educacionit.bootcamp.dto.Placeholder;
import ar.com.educacionit.bootcamp.repository.placeholder.PlaceholderRepositoryImpl;
import ar.com.educacionit.bootcamp.service.AbstractEntidadBaseService;

public class PlaceholderServiceImpl extends AbstractEntidadBaseService<Placeholder> implements PlaceholderService {

	public PlaceholderServiceImpl() {
		super(new PlaceholderRepositoryImpl());
	}

}
