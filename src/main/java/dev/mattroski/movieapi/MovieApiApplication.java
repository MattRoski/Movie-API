package dev.mattroski.movieapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class MovieApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApiApplication.class, args);
	}


}


//annotations in java are used to let the compiler know what this class does
//tomcat is the web server for the app, port 8080
//whitelabel error page, app working but no endpoint to hit
//Will divide that app in separate layers: Service layer, Data Access Layer, API Layer

//collections are like tables for Relation DBs

//IDE could not resolve @RestController, until I wrote @GetMapping("")
  //import org.springframework.web.bind.annotation.RestController;