package um.tesoreria.chequera.proxy.service.client.core;

import org.springframework.stereotype.Service;
import um.tesoreria.chequera.proxy.client.core.UsuarioChequeraFacultadClient;
import um.tesoreria.chequera.proxy.model.client.core.UsuarioChequeraFacultadDto;

import java.util.List;

@Service
public class UsuarioChequeraFacultadService {

    private final UsuarioChequeraFacultadClient client;

    public UsuarioChequeraFacultadService(UsuarioChequeraFacultadClient client) {
        this.client = client;
    }

    public List<UsuarioChequeraFacultadDto> findAllByUserId(Long userId) {
        return client.findAllByUserId(userId);
    }

}
