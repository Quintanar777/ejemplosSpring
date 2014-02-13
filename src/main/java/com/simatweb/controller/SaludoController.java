package com.simatweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.simatweb.response.SimpleResponseJson;

@Controller
public class SaludoController {
	
	/**
	 * Request mapping Hola mundo.
	 * 
	 * */
	@RequestMapping("/saludo")
	@ResponseBody
	public Object saludo(){
		SimpleResponseJson json = new SimpleResponseJson();
		json.setCodigo("1");
		json.setMensaje("Hola mundo");
		return json;
	}
	
	/**
	 * Request mapping que pinta el saludo en un JSP.
	 * 
	 * */
	@RequestMapping(value = "saludoMV")
	public ModelAndView saludomv(){
		ModelAndView model = new ModelAndView("saludo");
		model.addObject("saludo", "Hola Mundo.");
		return model;
	}
}
