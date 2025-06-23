package um.tesoreria.chequera.backend.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "um.tesoreria.chequera.backend.client")
public class ChequeraClientConfiguration {
}
