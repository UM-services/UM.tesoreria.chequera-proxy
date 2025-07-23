package um.tesoreria.chequera.proxy.model.client.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChequeraCuotaDto {

    private Long chequeraCuotaId;
    private Integer cuotaId;
    private Integer mes;
    private Integer anho;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime vencimiento1;
    private BigDecimal importe1;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime vencimiento2;
    private BigDecimal importe2;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime vencimiento3;
    private BigDecimal importe3;
    private Byte pagado;
    private ProductoDto producto;
    private List<ChequeraPagoDto> chequeraPagos;
    private MercadoPagoContextDto mercadoPagoContext;

} 