package marcozagaria.u2_w2_d2.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AutorePayload {
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
}
