package fr.but3.tp7a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControleurFormulaire {
    @Autowired
    private EtudiantRepository etudiants;

    @GetMapping
    @RequestMapping(value = { "/etudiantForm" }, method = RequestMethod.GET)
    public String studentForm(){
        return "etudiantForm";
    }

    @PostMapping
    @RequestMapping(value = { "/addStudent" }, method = RequestMethod.POST)
    public String processAddStudentForm(Etudiant etudiant, Model model) {
            etudiants.save(etudiant);
            model.addAttribute("etudiants", etudiants);
            return "studentListe";

    }
}
