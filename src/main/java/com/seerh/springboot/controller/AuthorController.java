package com.seerh.springboot.controller;

import com.seerh.springboot.config.AuthorSettings;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("author")
public class AuthorController {

    private Log log = LogFactory.getLog(AuthorController.class);

    @Value("${book.author}")
    private String bookAuthor;

    @Value("book.name")
    private String bookName;

    @Autowired
    private AuthorSettings authorSettings;

    /**
     * loadAuthor
     * @return
     */
    @RequestMapping("loadAuthor")
    public Map<?, ?> loadAuthor() {
        Map<String, Object> map = new HashMap<>();
        map.put("bookAuthor", bookAuthor);
        map.put("bookName", bookName);
        map.put("authorName", authorSettings.getName());
        map.put("authorAge", authorSettings.getAge());
        log.info(map.toString());
        return map;
    }

}
