package br.com.fiap.consumer.configuration;

import br.com.fiap.consumer.service.CheckSensorsService;
import br.com.fiap.consumer.service.impl.JavaMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

@EnableAsync
@Configuration
public class ScheduleCheckSensorsConfig {

    Logger logger = LoggerFactory.getLogger(JavaMailService.class);
    private CheckSensorsService checkSensorsService;

    ScheduleCheckSensorsConfig(CheckSensorsService checkSensorsService) {
        this.checkSensorsService = checkSensorsService;
    }

    // verifica sensores a cada x segundos, mas espera 10s antes de iniciar o schedule
    @Async
    @Scheduled(fixedRateString = "${checksensors.fixedRate}", initialDelay = 10000)
    public void scheduleFixedRateWithInitialDelayTask() {
        checkSensorsService.checkSensors();
    }

}
