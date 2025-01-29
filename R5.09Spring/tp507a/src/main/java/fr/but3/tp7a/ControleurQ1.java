package fr.but3.tp7a;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControleurQ1 {
    @RequestMapping("/hello")
    String home(@RequestParam(defaultValue="World", required=false) String name ,
                ModelMap modelmap)
    {
        modelmap.put("cle",name);
        return "mavue";
    }
}