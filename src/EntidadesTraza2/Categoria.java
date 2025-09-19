package EntidadesTraza2;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class Categoria {
    private Long id;
    private String denominacion;
    private boolean esInsumo;
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();
    @Builder.Default
    private Set<Categoria> subCategorias = new HashSet<>();
    private Categoria categoriaPadre;
}

