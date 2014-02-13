package com.simatweb.component;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import com.simatweb.exception.ComponentException;

@Component
public class Simat {
	private static final Logger logger = Logger.getLogger(Simat.class);
	private static final String URL = "http://www.calidadaire.df.gob.mx/calidadaire/index.php";
	
	/**
	 * Obtiene el valor de SIMAT.
	 * */
	public String getSimatVal() throws ComponentException{
		logger.debug("exec getSimatVal()");
		logger.debug("Conectandose a: " + URL);
		String imeca = "";
		try {
			Document doc = Jsoup.connect(URL).timeout(10*1000).get();
			imeca = doc.getElementById("textoimeca").text();			
		} catch (Exception e) {
			logger.error("Error al obtener el valor IMECA.", e);
			throw new ComponentException(e.getMessage());
		}
		return imeca;
	}
}
