package marcozagaria.u2_w2_d2.services;

import marcozagaria.u2_w2_d2.entities.BlogPost;
import marcozagaria.u2_w2_d2.exeption.NotFoundException;
import marcozagaria.u2_w2_d2.payloads.BlogPostPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> blogPostListList = new ArrayList<>();

    public List<BlogPost> getAllBlogPostList() {
        return blogPostListList;
    }

    public BlogPost saveBlogPost(BlogPostPayload body) {
        Random rndm = new Random();
        BlogPost newBlogPost = new BlogPost(body.getTitolo(), body.getCategoria(), body.getContenuto(), body.getTempoDiLettura());
        newBlogPost.setCover("https://picsum.photos/200/300");
        blogPostListList.add(newBlogPost);
        return newBlogPost;
    }

    public BlogPost cercaId(int id) {
        BlogPost cerca = null;
        for (BlogPost blogPost : this.blogPostListList) {
            if (blogPost.getId() == id) cerca = blogPost;
        }
        if (cerca == null) throw new NotFoundException(id);
        return cerca;
    }

    public BlogPost cercaBlogPostEModifica(int id, BlogPostPayload body) {
        BlogPost cerca = null;
        for (BlogPost blogPost : this.blogPostListList) {
            if (blogPost.getId() == id) {
                cerca = blogPost;
                cerca.setTitolo(body.getTitolo());
                cerca.setCategoria(body.getCategoria());
                cerca.setContenuto(body.getContenuto());
                cerca.setTempoDiLettura(body.getTempoDiLettura());
            }
        }
        if (cerca == null) throw new NotFoundException(id);
        return cerca;
    }

    public void cercaBlogPostECancella(int id) {
        BlogPost cerca = null;
        for (BlogPost blogPost : this.blogPostListList) {
            if (blogPost.getId() == id) cerca = blogPost;
        }
        if (cerca == null) throw new NotFoundException(id);
        this.blogPostListList.remove(cerca);
    }
}
