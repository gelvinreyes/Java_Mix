package com.runtastic.level1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.runtastic.level1.domain.GPS;
import com.runtastic.level1.service.GpsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class GpsToDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpsToDbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(GpsService gpsService){
		return args-> {
			//read json and save to db
			ObjectMapper mapper = 	new ObjectMapper();
			TypeReference<List<GPS>> typeReference = new TypeReference<List<GPS>>() {			};
			InputStream inputStream = TypeReference.class.getResourceAsStream( "/json/gps1.json");
			try{
				List<GPS> gpss = mapper.readValue(inputStream,typeReference);
				//System.out.println(gpss);
				for(GPS g : gpss)
				{
					System.out.println("Lat:"+ g.getLatitude() + " Long:" + g.getLongitude());
				}

				System.out.println("------------Starting to save GPS data---------------");
					gpsService.saveAllGPS(gpss);


				System.out.println("-------GPS data saved---------------------");
			}
			catch(Exception e){
				System.out.println("************Unable to save GPS data" + e.getMessage());
			}

		};
	}

}
