package um.tesoreria.chequera.proxy.client.core;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import um.tesoreria.chequera.proxy.model.client.core.ChequeraDetailDto;

import java.math.BigDecimal;

@FeignClient(name = "tesoreria-core-service/api/tesoreria/core/chequera")
public interface ChequeraClient {

    @GetMapping("/status/{personaId}/facultad/{facultadId}")
    ChequeraDetailDto constructStatusFromChequera(@PathVariable BigDecimal personaId, @PathVariable Integer facultadId);

}
