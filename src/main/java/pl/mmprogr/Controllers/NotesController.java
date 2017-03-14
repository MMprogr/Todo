package pl.mmprogr.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mmprogr.Models.Note;
import pl.mmprogr.Services.NoteService;

import javax.validation.Valid;

/**
 * Created by ggere on 14.03.2017.
 */
@Controller
@RequestMapping(value = "/note")
public class NotesController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("notes", noteService.findAll());

        return "listNotes";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Note note) {
        return "createNote";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid Note note, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "createNote";
        } else {
            noteService.create(note);
            return "redirect:list";
        }

    }
}
