package marcozagaria.u2_w2_d2.services;

import marcozagaria.u2_w2_d2.entities.Autore;
import marcozagaria.u2_w2_d2.exeption.NotFoundException;
import marcozagaria.u2_w2_d2.payloads.AutorePayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {
    private List<Autore> autoreList = new ArrayList<>();

    public List<Autore> getAllAutoreList() {
        return autoreList;
    }

    public Autore saveAutore(AutorePayload body) {
        Random rndm = new Random();
        Autore newAutore = new Autore(body.getNome(), body.getCognome(), body.getEmail(), body.getDataDiNascita());
        newAutore.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        autoreList.add(newAutore);
        return newAutore;
    }

    public Autore cercaId(int id) {
        Autore cerca = null;
        for (Autore autore : this.autoreList) {
            if (autore.getId() == id) cerca = autore;
        }
        if (cerca == null) throw new NotFoundException(id);
        return cerca;
    }

    public Autore cercaAutoreEModifica(int id, AutorePayload body) {
        Autore cerca = null;
        for (Autore autore : this.autoreList) {
            if (autore.getId() == id) {
                cerca = autore;
                cerca.setNome(body.getNome());
                cerca.setCognome(body.getCognome());
                cerca.setEmail(body.getEmail());
                cerca.setDataDiNascita(body.getDataDiNascita());
            }
        }
        if (cerca == null) throw new NotFoundException(id);
        return cerca;
    }

    public void cercaAutoreECancella(int id) {
        Autore cerca = null;
        for (Autore autore : this.autoreList) {
            if (autore.getId() == id) cerca = autore;
        }
        if (cerca == null) throw new NotFoundException(id);
        this.autoreList.remove(cerca);
    }
}
