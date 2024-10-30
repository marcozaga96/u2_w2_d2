package marcozagaria.u2_w2_d2.controllers;

import marcozagaria.u2_w2_d2.entities.BlogPost;
import marcozagaria.u2_w2_d2.payloads.BlogPostPayload;
import marcozagaria.u2_w2_d2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogPost")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public Page<BlogPost> getBlogPOst(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size,
                                      @RequestParam(defaultValue = "id") String sortBy) {
        return blogPostService.getAllBlogPostList(page, size, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost createBlogPOst(@RequestBody BlogPostPayload body) {
        return blogPostService.saveBlogPost(body);
    }

    @GetMapping("/{Id}")
    public BlogPost createBlogPostId(@PathVariable int Id) {
        return blogPostService.cercaId(Id);
    }

    @PutMapping("/{Id}")
    public BlogPost cercaEModifica(@PathVariable int Id, @RequestBody BlogPostPayload body) {
        return blogPostService.cercaBlogPostEModifica(Id, body);
    }

    @DeleteMapping("/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void cercaECancella(@PathVariable int Id) {
        blogPostService.cercaBlogPostECancella(Id);
    }
}
