package com.learning.controller;

import com.learning.model.Computer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("computer")
public class ComputerController {


    @GetMapping("/getComputer")
    public Computer getComputer(){
        return new Computer("Dell");
    }


    @GetMapping("/editComputer")
    public Computer editComputer(){
        return new Computer("Dell");
    }

}
