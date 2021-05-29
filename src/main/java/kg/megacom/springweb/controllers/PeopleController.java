package kg.megacom.springweb.controllers;

import kg.megacom.springweb.dao.PersonDAO;
import kg.megacom.springweb.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        // Получим всех людей из Dao и передадим на отображение
        model.addAttribute("people", personDAO.index());
        return "index";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model ){
//        // Получим одного человека по id из Dao и отобразим
//        model.addAttribute("person", personDAO.show(id));
//        return "show";
//    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println("пароль");
            return "new";
        }
        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bind,
                         @PathVariable("id") int id) {
        if (bind.hasErrors()){
            return "edit";
        }
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }
}
