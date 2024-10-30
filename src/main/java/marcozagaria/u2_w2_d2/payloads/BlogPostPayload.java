package marcozagaria.u2_w2_d2.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BlogPostPayload {
    private String categoria;
    private String titolo;
    private String contenuto;
    private String tempoDiLettura;
}
