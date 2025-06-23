package um.tesoreria.chequera.backend.controller.client.core;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import um.tesoreria.chequera.backend.model.client.core.ChequeraDetailDto;
import um.tesoreria.chequera.backend.service.client.core.ChequeraService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/chequera/backend/chequera")
public class ChequeraController {

    private final ChequeraService service;

    public ChequeraController(ChequeraService service) {
        this.service = service;
    }

    @GetMapping("/status/{personaId}/facultad/{facultadId}")
    public ResponseEntity<ChequeraDetailDto> constructStatusFromChequera(@PathVariable BigDecimal personaId, @PathVariable Integer facultadId) {
        return ResponseEntity.ok(service.constructStatusFromChequera(personaId, facultadId));
    }

}
