package pl.mmprogr.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mmprogr.Services.NoteService;

/**
 * Created by ggere on 14.03.2017.
 */
@Controller
public class HomeController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("notes", noteService.findAll());

        return "home";
    }
}
