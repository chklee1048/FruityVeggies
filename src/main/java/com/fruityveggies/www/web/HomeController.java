package com.fruityveggies.www.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fruityveggies.www.repository.test.Test;
import com.fruityveggies.www.service.TestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
    
    @Autowired
    private TestService testService;
    
    @GetMapping("/")
    public String home(Model model) {
        log.info("home()");
        
        List<Test> list = testService.read(); 
        
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("now", now);
        model.addAttribute("lists", list);
        
        return "/main/index"; // View의 이름.
    }
}
