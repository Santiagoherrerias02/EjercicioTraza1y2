package EntidadesTraza2;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder

public class ArticuloManufacturadoDetalle {
    private Long id;
    private Integer cantidad;
    private ArticuloInsumo articuloInsumo;
}
