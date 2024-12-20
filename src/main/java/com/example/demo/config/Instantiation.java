package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.entities.Carro;
import com.example.demo.entities.Motorista;
import com.example.demo.entities.Registro;
import com.example.demo.enums.CarColor;
import com.example.demo.repositories.CarroRepository;
import com.example.demo.repositories.RegistroRepository;

@Configuration
public class Instantiation implements CommandLineRunner,WebMvcConfigurer {
	
	@Autowired
	private CarroRepository car_repo;
	
	@Autowired
	private RegistroRepository reg_repo;
	
//	@Autowired
//	private MotoristaRepository mot_repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Salva o carro pelo serviço do Motorista pois o mesmo é uma classe dependente de Motorista
		Carro car1 = new Carro(null, "Fiat UNO", 2010, "AB3312", CarColor.VERMELHO);
		Carro car2 = new Carro(null, "Fiat UNO", 2012, "BG4577", CarColor.BRANCO);
		Carro car3 = new Carro(null, "Ford Ka", 2015, "CH1256", CarColor.CINZA);
		car_repo.saveAll(Arrays.asList(car1, car2, car3));
		
		Motorista mot1 = new Motorista(null, "Alex Many", "alex@gmail.com", "42977778888", "00033344481", "45678912", "1100", 0, car1);
		Motorista mot2 = new Motorista(null, "Debora Manta", "debora@gmail.com", "41933334444", "99988834512", "32165455", "7958", 0, car3);
		car1.setMotorista(mot1);
		car3.setMotorista(mot2);
		car_repo.saveAll(Arrays.asList(car1, car3));
		
		Registro reg1 = new Registro(null, "102337", "Para casa", Instant.parse("2019-06-20T19:53:07Z"), "N/A",  car1, mot1);
		Registro reg2 = new Registro(null, "102380", "Para Maltaria", Instant.parse("2019-06-21T06:30:07Z"), "N/A", car1, mot1);
		reg_repo.saveAll(Arrays.asList(reg1, reg2));
		
		
	}
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Ou utilize *, mas não é seguro
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Authorization", "Content-Type");
    }
	
}
