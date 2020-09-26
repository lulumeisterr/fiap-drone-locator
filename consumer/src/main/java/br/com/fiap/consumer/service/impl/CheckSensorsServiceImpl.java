package br.com.fiap.consumer.service.impl;

import br.com.fiap.consumer.dto.Message;
import br.com.fiap.consumer.service.CheckSensorsService;
import br.com.fiap.consumer.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CheckSensorsServiceImpl implements CheckSensorsService {

    Logger logger= LoggerFactory.getLogger(CheckSensorsServiceImpl.class);

    private MailService mailService;

    CheckSensorsServiceImpl(MailService mailService){
        this.mailService = mailService;
    }

    @Override
    public void checkSensors() {
        logger.info("checking sensors");
        // TODO fazer busca na base de dados dos sensores, lendo o ultimo minuto e validando a regra
    }

    // teste
    private void regra(Message message) throws InterruptedException {
        if(message.getText().getTemperatura() >= 35 || message.getText().getTemperatura() <= 0
                || message.getText().getUmidade() <= 15){

            StringBuilder msgEmail = new StringBuilder()
                    .append(" ID DO DRONE : " + message.getText().getIdDrone()).append("\n")
                    .append(" Temperatura : " + message.getText().getTemperatura()).append("\n")
                    .append(" Umidade : " + message.getText().getUmidade());

            System.out.println("Aguardando 1m para encaminhar o email");
            TimeUnit.MINUTES.sleep(1);

            System.out.println("Encaminhando Email");
            mailService.sendEmail(msgEmail.toString());
        } else {
            System.out.println("Sem Emails para encaminhar");
        }
    }

}
