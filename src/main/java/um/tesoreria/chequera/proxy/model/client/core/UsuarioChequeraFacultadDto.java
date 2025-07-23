package um.tesoreria.chequera.proxy.model.client.core;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioChequeraFacultadDto {

    private Long usuarioChequeraFacultadId;
    private Long userId;
    private Integer facultadId;
    private UsuarioDto usuario;
    private FacultadDto facultad;

}
