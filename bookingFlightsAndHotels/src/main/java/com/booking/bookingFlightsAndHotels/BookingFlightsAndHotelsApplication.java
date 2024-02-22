package com.booking.bookingFlightsAndHotels;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookingFlightsAndHotelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingFlightsAndHotelsApplication.class, args);
	}



	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("API F&H-Booking")
				.version("0.0.1")
				.description("Api Flights and Hotels for reservations"));
	}

}


