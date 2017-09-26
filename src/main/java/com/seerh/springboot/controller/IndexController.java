package com.seerh.springboot.controller;

import com.seerh.springboot.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @RequestMapping("index")
    public String index(Model model) {
        Person single = new Person();
        single.setName("bb");
        single.setAge(11);

        List<Person> people = new ArrayList<>();
        Person p1 = new Person();
        p1.setName("xx");
        p1.setAge(11);
        Person p2 = new Person();
        p2.setName("yy");
        p2.setAge(22);
        Person p3 = new Person();
        p3.setName("zz");
        p3.setAge(33);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);

        return "index";
    }

}
