package com.boot.controller;

import com.boot.bean.News;
import com.boot.bean.User;
import com.boot.bean.Book;
import com.boot.service.BookService;
import com.boot.service.NewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BookService bookService;

    @Autowired
    NewsService newsService;

    //@Autowired
    StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @GetMapping("/news")
    public News getNewsById(@RequestParam("id") Long id){

        return newsService.getById(id);
    }

    @ResponseBody
    @PostMapping("/news")
    public News saveNews(News news){
        newsService.saveNews(news);
        return news;
    }


    @ResponseBody
    @GetMapping("/book")
    public Book getById(@RequestParam("id") Long id){

        return bookService.getBookById(id);
    }


    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_user", long.class);
        return aLong.toString();
    }

    /**
     * 登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }


    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if(!StringUtils.isEmpty(user.getUserName()) && "123".equals(user.getPassword())){
                //把登录成功的用户保存起来
                session.setAttribute("loginUser",user);

            //登录成功重定向的main.html;重定向防止表单重复提交
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","账号密码错误");
            //回到登录页
            return "login";
        }

    }


    /**
     * 去首页
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){

        //ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        //String s = opsForValue.get("/main.html");
        //String sql = opsForValue.get("/sql");

        //model.addAttribute("mainCount",s);
        //model.addAttribute("sqlCount",sql);

        return "index";
    }
}
