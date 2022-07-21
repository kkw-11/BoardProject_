package com.example.boardproject.controller;

import com.example.boardproject.dto.ArticleForm;
import com.example.boardproject.entity.Article;
import com.example.boardproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j // Loggin Annotation
public class ArticleController {
    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결, 객체 주입
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("articles/create")
    public String createArticle(ArticleForm form){
        //0. Form데이터, DTO 제대로 왔는지 출력
//        System.out.println(form.toString()); //-> Loggin replacing
        log.info(form.toString());

        //1. DTO를 Entity로 변환
        Article article = form.toEntity();
//        System.out.println(article.toString());
        log.info((article.toString()));

        //2. Repository에게 Entity를 DB로 저장하게 함!
        Article savedArticle = articleRepository.save(article);
//        System.out.println(savedArticle.toString());
        log.info(savedArticle.toString());

        return "redirect:/articles/"+savedArticle.getId();
    }

    @GetMapping("/articles/{id}")
    public String showArticle(@PathVariable Long id, Model model){
        log.info("id = " + id);
        // 1: id로 데이터를 가져옴, Entity에 저장
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2: 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        // 3: 보여줄 페이지 설정
        return "articles/showArticle";
    }

    @GetMapping("/articles")
    public String index(Model model){
        // 1. 모든 Article을 가져온다!
        List<Article> articleEntityList = articleRepository.findAll();

        // 2: 가져온 Article 묶음을 뷰로 전달!
        model.addAttribute("articleList",articleEntityList);

        // 3. 뷰 페이지 설정!
        return "articles/index";
    }
    @GetMapping("/articles/{id}/edit")
    public String eidt(@PathVariable Long id, Model model){
        //수정할 데이터를 가져오기!
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 뷰 페이지 설정
        model.addAttribute("article",articleEntity);

        return "articles/edit";
    }
    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        log.info(form.toString());
        // 1: DTO: Entity로 변환
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        // 2: Entity를 DB로 저장
        // 2-1: DB에 기존 데이터를 가져온다.
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        //2-2 기존 데이터에 값을 갱신한다!
        if (target != null){
            articleRepository.save(articleEntity);// Entity가 DB로 갱신
        }
        
        // 3: 수정 결과 페이지로 리다이렉트 한다.
        return "redirect:/articles/" + articleEntity.getId();
    }
}
