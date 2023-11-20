package ar.com.educacionit.bootcamp;

import ar.com.educacionit.bootcamp.connectors.covid.CovidApiService;
import ar.com.educacionit.bootcamp.dto.Covid;
import ar.com.educacionit.bootcamp.service.ServiceLocator;
import ar.com.educacionit.bootcamp.service.covid.CovidService;

public class CovidMain {
	public static void main(String[] args) {
		CovidService serviceDB = (CovidService) ServiceLocator.getService(CovidService.class);
		
		System.out.println("---Buscar por fecha 15/02/2020 en DB---");
		String newDate = "2020-02-15".replaceAll("-", "");
		Covid covidDB = serviceDB.buscarPorCampo("date", newDate);

		if(covidDB !=null) {
			System.out.println("Se encontro en db" + covidDB);
		}else {
			CovidApiService serviceAPI = (CovidApiService) ServiceLocator.getService(CovidApiService.class);
			Covid covidAPI = serviceAPI.buscarPorCampo("date", newDate);
			
			serviceDB.guardar(covidAPI);
			covidDB = serviceDB.buscarPorCampo("date", newDate);
			System.out.println("Se guardo en db" + covidDB);
			
		}
		
	}
}
