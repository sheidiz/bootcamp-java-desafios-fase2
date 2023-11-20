package ar.com.educacionit.bootcamp;

import ar.com.educacionit.bootcamp.connectors.placeholder.PlaceholderApiService;
import ar.com.educacionit.bootcamp.dto.Placeholder;
import ar.com.educacionit.bootcamp.service.ServiceLocator;
import ar.com.educacionit.bootcamp.service.placeholder.PlaceholderService;

public class PlaceholderMain {

	public static void main(String[] args) {
		PlaceholderService serviceDB = (PlaceholderService) ServiceLocator.getService(PlaceholderService.class);
		
		Placeholder phDB = serviceDB.buscarPorId(1);
		
		if(phDB!=null) {
			System.out.println("Se encontro en db" + phDB);			
		}else {
			PlaceholderApiService serviceAPI = (PlaceholderApiService) ServiceLocator.getService(PlaceholderApiService.class);
			Placeholder phAPI = serviceAPI.buscarPorId(1);
			
			serviceDB.guardar(phAPI);

			phDB = serviceDB.buscarPorId(1);
			System.out.println("Se agrego a la db" + phDB);			
		}
		
		
		
		
	}

}
