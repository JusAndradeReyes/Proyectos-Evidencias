package com.planets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class AppConfig {
	/*Rest Template: ES UN CLIENT HTTP, PARA ACCEDER A
	 * RECURSOS QUE ESTÁN EN OTRAS APIS O MICROSERVICIOS
	 */
	
	@Bean("template")
	RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}
