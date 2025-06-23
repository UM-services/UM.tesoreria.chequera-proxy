package um.tesoreria.chequera.backend.model.client.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoPagoDto {

    private Integer tipoPagoId;
    private String nombre;

}