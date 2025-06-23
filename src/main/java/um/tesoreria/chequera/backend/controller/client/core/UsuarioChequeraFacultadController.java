package um.tesoreria.chequera.backend.controller.client.core;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import um.tesoreria.chequera.backend.model.client.core.UsuarioChequeraFacultadDto;
import um.tesoreria.chequera.backend.service.client.core.UsuarioChequeraFacultadService;

import java.util.List;

@RestController
@RequestMapping("/api/chequera/backend/usuarioChequeraFacultad")
public class UsuarioChequeraFacultadController {

    private final UsuarioChequeraFacultadService service;

    public UsuarioChequeraFacultadController(UsuarioChequeraFacultadService service) {
        this.service = service;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UsuarioChequeraFacultadDto>> findAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(service.findAllByUserId(userId));
    }

}
