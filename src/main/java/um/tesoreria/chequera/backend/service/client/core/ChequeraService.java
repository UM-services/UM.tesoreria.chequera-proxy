package um.tesoreria.chequera.backend.service.client.core;

import org.springframework.stereotype.Service;
import um.tesoreria.chequera.backend.client.core.ChequeraClient;
import um.tesoreria.chequera.backend.model.client.core.ChequeraDetailDto;

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
