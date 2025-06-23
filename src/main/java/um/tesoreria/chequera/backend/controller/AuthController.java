package um.tesoreria.chequera.backend.controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import um.tesoreria.chequera.backend.service.AuthService;
import um.tesoreria.chequera.backend.model.client.core.UsuarioDto;

@RestController
@RequestMapping("/api/chequera/backend/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService service;

    @RateLimiter(name = "auth-verify", fallbackMethod = "verifyAccountFallback")
    @GetMapping("/verify/{googleMail}")
    public ResponseEntity<UsuarioDto> verifyAccount(@PathVariable String googleMail) {
        try {
            log.info("Verificando cuenta: {}", googleMail);
            UsuarioDto usuario = service.verifyAccount(googleMail);
            log.info("Resultado verificación para {}: {}", googleMail, usuario != null ? "usuario encontrado" : "usuario no encontrado");
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            log.error("Error verificando cuenta {}: {}", googleMail, e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<UsuarioDto> verifyAccountFallback(String googleMail, Exception e) {
        log.warn("Rate limit excedido para: {}", googleMail);
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(null);
    }
    
}