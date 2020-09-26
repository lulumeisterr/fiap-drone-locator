package br.com.fiap.consumer.sendEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Email {
	
	@Autowired
    private JavaMailSender javaMailSender;

	public void sendEmail(String msgBody) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("lucasrodriguesdonascimento@outlook.com");

        msg.setSubject("Email drone");
        msg.setText(msgBody);

        
        javaMailSender.send(msg);

    }
	

}
