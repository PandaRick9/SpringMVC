package by.danik.springMvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;


@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false) String name,
                            @RequestParam(value = "surname",required = false )String surname,
                            Model model ){


        //System.out.println("hi " + name +" "+ surname);
        model.addAttribute("message", "hi " + name +" "+ surname);

        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a",required = false) int a,
                             @RequestParam(value = "b",required = false) int b,
                             @RequestParam(value = "action",required = false) String action,
                             Model model){
        if(action.equals("multiplication"))
            model.addAttribute("calculator", a * b);
        else if(action.equals("sum"))
            model.addAttribute("calculator",a + b);
        else if(action.equals("subtraction"))
            model.addAttribute("calculator",a - b);
        else if(action.equals("division"))
            model.addAttribute("calculator",a / (double)b);
        return "first/calculator";
    }


    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

}
