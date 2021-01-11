package com.vms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VmsController {

   @RequestMapping(value = "login",method = RequestMethod.GET)
    public String index(Model model){
       model.addAttribute("msg","Enter login Details");
       return "signup.html";
   }

}
