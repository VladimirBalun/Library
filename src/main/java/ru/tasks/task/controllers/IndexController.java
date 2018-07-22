package ru.tasks.task.controllers;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Log4j
@Controller
public class IndexController {

    @RequestMapping(value = "/library", method = RequestMethod.GET)
    public String getStartPage(){
        log.debug("Request[/library] on getting start page.");
        return "index";
    }

}