package um.tesoreria.chequera.backend.model.client.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChequeraDetailDto {

    private PersonaDto persona;
    private LectivoDto lectivo;
    private FacultadDto facultad;
    private List<ChequeraSerieDto> chequeraSeries;
    
}
