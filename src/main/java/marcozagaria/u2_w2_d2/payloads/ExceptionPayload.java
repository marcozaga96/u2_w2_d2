package marcozagaria.u2_w2_d2.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionPayload {
    private String message;
    private LocalDateTime timestamp;
}
