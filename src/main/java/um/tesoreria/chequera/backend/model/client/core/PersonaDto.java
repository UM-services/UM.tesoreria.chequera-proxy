package um.tesoreria.chequera.backend.model.client.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {

    private Long personaId;
    private Long documentoId;
    private String apellido;
    private String nombre;

} 