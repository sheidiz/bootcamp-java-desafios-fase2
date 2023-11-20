package ar.com.educacionit.bootcamp.service.covid;

import ar.com.educacionit.bootcamp.dto.Covid;
import ar.com.educacionit.bootcamp.repository.covid.CovidRepositoryImpl;
import ar.com.educacionit.bootcamp.service.AbstractEntidadBaseService;

public class CovidServiceImpl extends AbstractEntidadBaseService<Covid> implements CovidService {

	public CovidServiceImpl() {
		super(new CovidRepositoryImpl());
	}

}
