package marcozagaria.u2_w2_d2.services;

import marcozagaria.u2_w2_d2.entities.Autore;
import marcozagaria.u2_w2_d2.exeption.NotFoundException;
import marcozagaria.u2_w2_d2.payloads.AutorePayload;
import marcozagaria.u2_w2_d2.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepository;

    public Page<Autore> getAllAutoreList(int page, int size, String sortBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return autoreRepository.findAll(pageable);
    }

    public Autore saveAutore(AutorePayload body) {
        Autore newAutore = new Autore(body.getNome(), body.getCognome(), body.getEmail(), body.getDataDiNascita());
        newAutore.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        return autoreRepository.save(newAutore);
    }


    public Autore cercaId(int id) {

        return autoreRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Autore cercaAutoreEModifica(int id, AutorePayload body) {
        Autore cerca = cercaId(id);
        cerca.setNome(body.getNome());
        cerca.setCognome(body.getCognome());
        cerca.setEmail(body.getEmail());
        cerca.setDataDiNascita(body.getDataDiNascita());
        if (cerca == null) throw new NotFoundException(id);
        return autoreRepository.save(cerca);
    }

    public void cercaAutoreECancella(int id) {
        Autore cerca = cercaId(id);
        if (cerca == null) throw new NotFoundException(id);
        autoreRepository.delete(cerca);
    }
}
