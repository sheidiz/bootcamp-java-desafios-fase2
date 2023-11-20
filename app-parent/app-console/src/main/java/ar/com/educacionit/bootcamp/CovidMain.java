package ar.com.educacionit.bootcamp;

import ar.com.educacionit.bootcamp.dto.Covid;
import ar.com.educacionit.bootcamp.service.ServiceLocator;
import ar.com.educacionit.bootcamp.service.covid.CovidService;

public class CovidMain {
	public static void main(String[] args) {
		CovidService serviceDB = (CovidService) ServiceLocator.getService(CovidService.class);
		
		String dateReceived = "2020-01-15";
		String newDate = dateReceived.replaceAll("-", "");
		System.out.println(newDate);

		Covid entry = serviceDB.buscarPorCampo("date", newDate);
		System.out.println(entry);
	}
}
