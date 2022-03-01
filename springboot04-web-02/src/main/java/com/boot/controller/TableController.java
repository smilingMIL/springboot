package com.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.bean.User;
import com.boot.exception.UserTooManyException;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;



    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";
    }


    //根据id删除一条记录
    @GetMapping("/user/delete{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes redirectAttributes){

        userService.removeById(id);

        //重定向带参数
        redirectAttributes.addAttribute("pn",pn);

        return "redirect:/dynamic_table";
    }


    //查询分页信息
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")Integer pn , Model model){
        //表格二内容的遍历
 /*       List<User> users = Arrays.asList(
                new User("张三", "123456"),
                new User("李四", "1234444"),
                new User("haha", "aaaaa"),
                new User("hehe", "bbbb"));

        model.addAttribute("users",users);*/


        List<User> list = userService.list();

        //model.addAttribute("users",list);

        //分页查询数据
        // 分页对象
        Page<User> userPage = new Page<>(pn, 2);
        //分页查询的结果
        Page<User> page = userService.page(userPage, null);
        //page.getCurrent();//当前第几页
        //page.getPages();//总页数
        //page.getTotal();//总记录数
        //List<User> records = page.getRecords();//查出的数据

        model.addAttribute("users",page);

        return "table/dynamic_table";
    }

    @GetMapping("responsive_table")
    public String responsive_table(){


        return "table/responsive_table";
    }

    @GetMapping("editable_table")
    public String editable_table(){

        return "table/editable_table";
    }
}
