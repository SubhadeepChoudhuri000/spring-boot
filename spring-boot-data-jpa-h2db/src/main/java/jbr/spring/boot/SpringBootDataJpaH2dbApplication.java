package jbr.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jbr.spring.boot.service.ProductService;

@SpringBootApplication
public class SpringBootDataJpaH2dbApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(SpringBootDataJpaH2dbApplication.class);

	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaH2dbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("inside main run");
	}

	@Bean
	CommandLineRunner runMe(ProductService productService) {
		log.info("Inside runMe");
		return output -> {
			log.info("ADD PRODUCTS");
			// productService.addProduct();

			log.info("GET ALL PRODUCTS");
			productService.getAllProducts().forEach(e -> log.info(e.toString()));

			log.info("CUSTOM PRODUCTS");
			//productService.getCustomProd("sh").forEach(e -> log.info(e.toString()));
		};
	}
}
