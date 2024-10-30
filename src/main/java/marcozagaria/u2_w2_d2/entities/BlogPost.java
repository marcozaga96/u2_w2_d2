package marcozagaria.u2_w2_d2.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "blogPost")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BlogPost {
    @Id
    @GeneratedValue()
    @Setter(AccessLevel.NONE)
    private int id;
    private String categoria;
    private String titolo;
    private String contenuto;
    private String tempoDiLettura;
    private String cover;
    @ManyToOne
    @JoinColumn(name = "autore_id")
    private Autore autore;

    public BlogPost(String categoria, String titolo, String contenuto, String tempoDiLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
    }

}
