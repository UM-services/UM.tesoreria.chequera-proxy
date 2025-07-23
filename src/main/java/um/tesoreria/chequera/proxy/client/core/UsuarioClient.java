package um.tesoreria.chequera.proxy.client.core;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import um.tesoreria.chequera.proxy.model.client.core.UsuarioDto;

@FeignClient(name = "tesoreria-core-service/api/tesoreria/core/usuario")
public interface UsuarioClient {

    @GetMapping("/google/mail/{googleMail}")
    UsuarioDto findByGoogleMail(@PathVariable String googleMail);

}
