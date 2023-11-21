package ar.com.educacionit.bootcamp.controllers;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.bootcamp.service.covid.CovidService;
import ar.com.educacionit.bootcamp.connectors.covid.CovidApiService;
import ar.com.educacionit.bootcamp.dto.Covid;
import ar.com.educacionit.bootcamp.service.ServiceLocator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/covid")
public class CovidController extends HttpServlet {

	private static final long serialVersionUID = 6809504131701973281L;
	private CovidService serviceDB = (CovidService) ServiceLocator.getService(CovidService.class);
	private CovidApiService serviceAPI = (CovidApiService) ServiceLocator.getService(CovidApiService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String date = req.getParameter("date");
		
		Covid covid = serviceDB.buscarPorCampo("date", date);
		
		if(covid == null) {
			Covid covidAPI = serviceAPI.buscarPorCampo("date", date);
			if(covidAPI != null) {
				serviceDB.guardar(covidAPI);
				covid = serviceDB.buscarPorCampo("date", date);
			}
		}
		
		if(covid!=null) {
			date = covid.getDate();
			String newDate = date.substring(0, 4) + " - " + date.substring(4, 6) + " - " + date.substring(6,8);
			covid.setDate(newDate);
			resp.setContentType("application/json");
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonCovid = objectMapper.writeValueAsString(covid);
			resp.getWriter().print(jsonCovid);
		}
		
	}
}
