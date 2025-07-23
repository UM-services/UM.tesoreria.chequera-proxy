package um.tesoreria.chequera.proxy.client.core;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import um.tesoreria.chequera.proxy.model.client.core.UsuarioChequeraFacultadDto;

import java.util.List;

@FeignClient(name = "tesoreria-core-service/api/tesoreria/core/usuarioChequeraFacultad")
public interface UsuarioChequeraFacultadClient {

    @GetMapping("/user/{userId}")
    List<UsuarioChequeraFacultadDto> findAllByUserId(@PathVariable Long userId);

}
