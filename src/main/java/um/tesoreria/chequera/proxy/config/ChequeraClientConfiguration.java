package um.tesoreria.chequera.proxy.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "um.tesoreria.chequera.proxy.client")
public class ChequeraClientConfiguration {
}
