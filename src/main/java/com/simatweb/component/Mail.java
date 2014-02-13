package com.simatweb.component;

import org.apache.log4j.Logger;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class Mail {
	private static final Logger logger = Logger.getLogger(Mail.class);
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * Envia un correo.
	 * 
	 * @param from De quien es enviado el correo
	 * @param to Para quien es el correo
	 * @param subject Asunto del correo
	 * @param msg Mensaje del correo
	 * */
	public void sendMail(String from, String to, String subject, String msg) {
		logger.debug("enviando correo... " + to);
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
	}
}
