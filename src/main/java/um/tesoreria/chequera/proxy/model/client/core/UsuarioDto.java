package um.tesoreria.chequera.proxy.model.client.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private Long userId;
    private String login;
    private String nombre;
    private Integer geograficaId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime lastLog;

    private String googleMail;
    private Byte activo = 1;

}
