package um.tesoreria.chequera.proxy.service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import um.tesoreria.chequera.proxy.client.core.UsuarioClient;
import um.tesoreria.chequera.proxy.model.client.core.UsuarioDto;

@Service
@Slf4j
public class AuthService {

    private final UsuarioClient usuarioClient;

    public AuthService(UsuarioClient usuarioClient) {
        this.usuarioClient = usuarioClient;
    }

    /**
     * Verifica si una cuenta de Google está autorizada para acceder al sistema
     * @param googleMail Email de la cuenta de Google a verificar
     * @return UsuarioDto si está autorizada, null en caso contrario
     */
    public UsuarioDto verifyAccount(String googleMail) {
        log.debug("Processing AuthService.verifyAccount() for: {}", googleMail);
        
        if (!isValidEmailFormat(googleMail)) {
            log.warn("Formato de email inválido: {}", googleMail);
            return null;
        }
        
        try {
            var usuario = usuarioClient.findByGoogleMail(googleMail);
            logUsuario(usuario);
            
            // Verificar que el usuario esté activo
            if (usuario != null && usuario.getActivo() != null && usuario.getActivo() == 1) {
                log.info("Verificación de cuenta: {} - Autorizada: true", googleMail);
                return usuario;
            } else {
                log.warn("Usuario inactivo o no encontrado: {}", googleMail);
                return null;
            }
        } catch (Exception e) {
            log.error("Error verificando cuenta {}: {}", googleMail, e.getMessage(), e);
            return null;
        }
    }

    /**
     * Valida el formato básico de un email
     * @param email Email a validar
     * @return true si el formato es válido, false en caso contrario
     */
    private boolean isValidEmailFormat(String email) {
        if (email == null || email.trim().isEmpty()) {
            log.warn("Email nulo o vacío recibido");
            return false;
        }
        
        String normalizedEmail = email.toLowerCase().trim();
        return normalizedEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    private void logUsuario(UsuarioDto usuario) {
        try {
            log.debug("Usuario -> {}", JsonMapper
                    .builder()
                    .findAndAddModules()
                    .build()
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(usuario));
        } catch (Exception e) {
            log.debug("Usuario error -> {}", e.getMessage());
        }
    }

}
