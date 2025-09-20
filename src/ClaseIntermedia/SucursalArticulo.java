package ClaseIntermedia;

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
    private Articulo articulo;
    private Integer stock;
}

