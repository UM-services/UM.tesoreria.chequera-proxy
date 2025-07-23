package um.tesoreria.chequera.proxy.model.client.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChequeraSerieDto {

    private Long chequeraSerieId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fecha;
    private String observaciones;
    private Integer alternativaId;
    private FacultadDto facultad;
    private TipoChequeraDto tipoChequera;
    private PersonaDto persona;
    private DomicilioDto mails;
    private LectivoDto lectivo;
    private ArancelTipoDto arancelTipo;
    private GeograficaDto geografica;
    private List<ChequeraCuotaDto> chequeraCuotas;

} 