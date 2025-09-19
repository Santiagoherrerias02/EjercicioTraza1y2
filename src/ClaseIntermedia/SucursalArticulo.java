package ClaseIntermedia;

import EntidadesTraza1.Sucursal;
import EntidadesTraza2.Articulo;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class SucursalArticulo {
    private Long id;
    private Sucursal sucursal;
    private Articulo articulo;
    private Integer stock; // opcional: stock específico por sucursal
}

