package crud.crud.spring.controller;

import crud.crud.spring.domain.Article;
import crud.crud.spring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles/new")
    public String createForm(){
        return "articles/createArticleForm";
    }

    @PostMapping("/articles/new")
    public String create(ArticleForm form){
        Article article = new Article();
        article.setTitle(form.getTitle());
        article.setWriter(form.getWriter());
        article.setContent(form.getContent());

        articleService.create(article);

        return "redirect:/";
    }

    // 조회
    @GetMapping("/articles")
    public String list(Model model){
        List<Article> articles = articleService.findArticles();
        model.addAttribute("articles", articles);

        return "articles/articleList";
    }

    // 상세페이지
    @GetMapping("/articles/{id}")
    public String detail(@PathVariable Long id, Model model){
        Optional<Article> article = articleService.findOne(id);
        model.addAttribute("article", article.orElse(null));

        return "articles/articleDetail";
    }

    @GetMapping("/articles/update/{id}")
    public String updateForm(@PathVariable Long id, Model model){
        Article article = articleService.findOne(id).get();
        model.addAttribute("article", article);

        return "articles/updateArticle";
    }

    @PostMapping("/articles/update/{id}")
    public String update(@PathVariable Long id, Article newArticle){
        articleService.update(id, newArticle);

        return "redirect:/articles";
    }

    @GetMapping("/articles/delete/{id}")
    public String delete(@PathVariable Long id){
        articleService.delete(id);

        return "redirect:/articles";
    }
}
