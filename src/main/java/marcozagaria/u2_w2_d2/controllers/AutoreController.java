package marcozagaria.u2_w2_d2.controllers;

import marcozagaria.u2_w2_d2.entities.Autore;
import marcozagaria.u2_w2_d2.payloads.AutorePayload;
import marcozagaria.u2_w2_d2.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Autore> getAutori() {
        return autoreService.getAllAutoreList();
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
