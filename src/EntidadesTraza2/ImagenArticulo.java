package EntidadesTraza2;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class ImagenArticulo {
    private Long id;
    private String name;
    private String url;
}
