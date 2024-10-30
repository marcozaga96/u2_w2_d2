package marcozagaria.u2_w2_d2.services;

import marcozagaria.u2_w2_d2.entities.Autore;
import marcozagaria.u2_w2_d2.entities.BlogPost;
import marcozagaria.u2_w2_d2.exeption.NotFoundException;
import marcozagaria.u2_w2_d2.payloads.BlogPostPayload;
import marcozagaria.u2_w2_d2.repositories.AutoreRepository;
import marcozagaria.u2_w2_d2.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BlogPostService {
    @Autowired
    BlogPostRepository blogPostRepository;
    @Autowired
    AutoreRepository autoreRepository;

    public List<BlogPost> getAllBlogPostList() {
        return blogPostRepository.findAll();
    }

    public BlogPost saveBlogPost(BlogPostPayload body) {
        Optional<Autore> autore = autoreRepository.findById(body.getAutore_id());
        if (!autore.isPresent()) {
            throw new RuntimeException("Autore non trovato con ID: " + body.getAutore_id());
        }
        Autore autore1 = autore.get();
        BlogPost newBlogPost = new BlogPost(body.getTitolo(), body.getCategoria(), body.getContenuto(), body.getTempoDiLettura());
        newBlogPost.setCover("https://picsum.photos/200/300");
        newBlogPost.setAutore(autore1);
        return blogPostRepository.save(newBlogPost);
    }


    public BlogPost cercaId(int id) {
        return blogPostRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost cercaBlogPostEModifica(int id, BlogPostPayload body) {
        BlogPost cerca = cercaId(id);
        cerca.setTitolo(body.getTitolo());
        cerca.setCategoria(body.getCategoria());
        cerca.setContenuto(body.getContenuto());
        cerca.setTempoDiLettura(body.getTempoDiLettura());
        if (cerca == null) throw new NotFoundException(id);
        return blogPostRepository.save(cerca);
    }

    public void cercaBlogPostECancella(int id) {
        BlogPost cerca = cercaId(id);
        if (cerca == null) throw new NotFoundException(id);
        blogPostRepository.delete(cerca);
    }
}
