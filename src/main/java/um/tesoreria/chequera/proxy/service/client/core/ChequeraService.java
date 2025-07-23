package um.tesoreria.chequera.proxy.service.client.core;

import org.springframework.stereotype.Service;
import um.tesoreria.chequera.proxy.client.core.ChequeraClient;
import um.tesoreria.chequera.proxy.model.client.core.ChequeraDetailDto;

import java.math.BigDecimal;

@Service
public class ChequeraService {

    private final ChequeraClient client;

    public ChequeraService(ChequeraClient client) {
        this.client = client;
    }

    public ChequeraDetailDto constructStatusFromChequera(BigDecimal personaId, Integer facultadId) {
        return client.constructStatusFromChequera(personaId, facultadId);
    }

}
