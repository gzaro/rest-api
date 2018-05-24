package github.gzaro.rest.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "github.gzaro.rest")
@SpringBootApplication
public class SpringBootApp {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(SpringBootApp.class, args);
	}
}
