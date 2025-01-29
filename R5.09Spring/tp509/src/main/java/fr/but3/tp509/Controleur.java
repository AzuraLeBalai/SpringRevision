package fr.but3.tp509;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class Controleur {

    @GetMapping("/")
    public String acceuil(){
        return "private/v2";
    }

    @GetMapping("/public")
    public String accessV1(HttpServletRequest request, Principal principal){
        request.setAttribute("username", principal.getName());
        return "public/v1";
    }

    @GetMapping("/private")
    @RequestMapping(value = { "/private" }, method = RequestMethod.GET)
    public String accessV2(HttpServletRequest request, Principal principal) {
        request.setAttribute("username", principal.getName());
        return "private/v2";

    }
}
