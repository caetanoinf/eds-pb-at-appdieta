package br.edu.infnet.appdieta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppDietaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppDietaApplication.class, args);
    }

}
