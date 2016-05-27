package com.mariusiliescu.com.mariusiliescu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.log4j.Logger;

/**
 * Created by Marius on 25.05.2016.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    static String home(){
        return "index";
    }
}
