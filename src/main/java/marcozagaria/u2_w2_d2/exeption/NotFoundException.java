package marcozagaria.u2_w2_d2.exeption;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("l'id: " + id + " no è stato trovato");
    }
}
