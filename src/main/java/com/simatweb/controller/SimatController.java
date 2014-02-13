package com.simatweb.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.simatweb.component.Simat;
import com.simatweb.exception.JsonException;
import com.simatweb.exception.MAVException;
import com.simatweb.response.SimpleResponseJson;

@Controller
public class SimatController {
	
	private static final Logger logger = Logger.getLogger(SimatController.class);
	@Autowired
	private Simat simat;
	/**
	 * Request mappign para obtener el valor IMECA.
	 * @throws JsonException 
	 * 
	 * */
	@RequestMapping("json/getImeca")
	@ResponseBody
	public Object getImeca() throws JsonException{
		logger.info("exec getImeca() .:. RM= json/getImeca");
		SimpleResponseJson json = new SimpleResponseJson();
		try {
			String imeca = simat.getSimatVal();
			if(!imeca.equals("")){
				json.setDatos(imeca);
				json.setCodigo("1");
				json.setMensaje("Exito");
			}else{
				json.setDatos("");
				json.setCodigo("0");
				json.setMensaje("No se pudo obtener el valor IMECA, favor de volver a cargar.");
			}
			
		} catch (Exception e) {
			logger.error("Error al obtener el valor SIMAT", e);
			throw new JsonException(e.getMessage());
		}
		return json;
	}
	
	/**
	 * Obtiene el valor IMECA, y lo pinta en el jsp "imeca".
	 * */
	@RequestMapping("getImeca")
	@ResponseBody
	public ModelAndView getImevaMAV() throws MAVException{
		logger.info("exec getImevaMAV() .:. RM= /getImeca");
		ModelAndView model = new ModelAndView();
		try {
			String imeca = simat.getSimatVal();
			model.addObject("imeca", imeca);
		} catch (Exception e) {
			logger.error("Error al obtener el valor SIMAT", e);
			throw new MAVException(e.getMessage());
		}
		model.setViewName("simat");
		return model;
	}
	
	@ExceptionHandler(JsonException.class)
    public @ResponseBody
    SimpleResponseJson errorConRespJson(Exception ex) {
		SimpleResponseJson respuesta = new SimpleResponseJson();
        respuesta.setCodigo("0");
        respuesta.setMensaje(ex.getMessage() == null ? "Error app simatWeb" : "Error app simatWeb [" + ex.getMessage() + "]");
        return respuesta;
    }
	
	@ExceptionHandler(MAVException.class)
	public ModelAndView errorModelAndView(Exception ex){
		ModelAndView model = new ModelAndView();
		model.setViewName("error");
		return model;
	}
}
