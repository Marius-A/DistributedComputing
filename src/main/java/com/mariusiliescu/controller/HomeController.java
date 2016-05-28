package com.mariusiliescu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Marius on 25.05.2016.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    static String home() {
        return "home";
    }
    @RequestMapping(value = "/start", method = RequestMethod.POST)
    static String start() {
        return "home";
    }
}
