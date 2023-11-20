package ar.com.educacionit.bootcamp;

import ar.com.educacionit.bootcamp.dto.Placeholder;
import ar.com.educacionit.bootcamp.service.ServiceLocator;
import ar.com.educacionit.bootcamp.service.placeholder.PlaceholderService;

public class PlaceholderMain {

	public static void main(String[] args) {
		PlaceholderService serviceDB = (PlaceholderService) ServiceLocator.getService(PlaceholderService.class);
		
		Placeholder phDB = serviceDB.buscarPorId(1);
		
		System.out.println(phDB);
	}

}
