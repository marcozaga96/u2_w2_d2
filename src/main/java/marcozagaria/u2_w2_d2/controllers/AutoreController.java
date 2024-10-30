package marcozagaria.u2_w2_d2.controllers;

import marcozagaria.u2_w2_d2.entities.Autore;
import marcozagaria.u2_w2_d2.payloads.AutorePayload;
import marcozagaria.u2_w2_d2.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/* *************************************************** USERS CRUD ****************************************************
1. GET http://localhost:3001/users
2. POST http://localhost:3001/users (+ payload)
3. GET http://localhost:3001/users/{userId}
4. PUT http://localhost:3001/users/{userId} (+ payload)
5. DELETE http://localhost:3001/users/{userId}
*/


@RestController
@RequestMapping("/autore")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @GetMapping
    public Page<Autore> getAutori(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size,
                                  @RequestParam(defaultValue = "id") String sortBy) {
        // Mettiamo dei valori di default per far si che non ci siano errori se il client non ci invia uno dei query parameters
        return autoreService.getAllAutoreList(page, size, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createAutore(@RequestBody AutorePayload body) {
        return autoreService.saveAutore(body);
    }

    @GetMapping("/{Id}")
    public Autore createAutoreId(@PathVariable int Id) {
        return autoreService.cercaId(Id);
    }

    @PutMapping("/{Id}")
    public Autore cercaEModifica(@PathVariable int Id, @RequestBody AutorePayload body) {
        return autoreService.cercaAutoreEModifica(Id, body);
    }

    @DeleteMapping("/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void cercaECancella(@PathVariable int Id) {
        autoreService.cercaAutoreECancella(Id);
    }
}
