package com.simatweb.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simatweb.component.Mail;
import com.simatweb.exception.JsonException;
import com.simatweb.response.SimpleResponseJson;

@Controller
public class MailController {
	private static final Logger logger = Logger.getLogger(MailController.class);
	@Autowired
	@Qualifier("mail")
	private Mail mail;

	/**
	 * Envia un correo cuando el valor SIMAT es alto.
	 * 
	 * @throws JsonException
	 * */
	@RequestMapping("json/sendMail")
	@ResponseBody
	public Object sendAlarm() throws JsonException {
		logger.debug("exec sendAlarm()");
		SimpleResponseJson json = new SimpleResponseJson();
		try {
			mail.sendMail("dequien@gmail.com", "paraquien@gmail.com", "Prueba", "Alarma SIMAT!!!");
			json.setCodigo("1");
			json.setMensaje("Se envio el correo con éxito!");
			return json;
		} catch (Exception e) {
			logger.error("Error al enviar el correo.", e);
			throw new JsonException(e.getMessage());
		}

	}

	@ExceptionHandler(JsonException.class)
	public @ResponseBody
	SimpleResponseJson errorConRespJson(Exception ex) {
		SimpleResponseJson respuesta = new SimpleResponseJson();
		respuesta.setCodigo("0");
		respuesta.setMensaje(ex.getMessage() == null ? "Error app simatWeb"
				: "Error app simatWeb [" + ex.getMessage() + "]");
		return respuesta;
	}
}
