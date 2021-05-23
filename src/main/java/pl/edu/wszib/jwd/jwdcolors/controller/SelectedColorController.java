package pl.edu.wszib.jwd.jwdcolors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.wszib.jwd.jwdcolors.dao.SelectedColorDao;
import pl.edu.wszib.jwd.jwdcolors.model.SelectedColor;

import java.util.Date;

@Controller
public class SelectedColorController {

    @Autowired
    SelectedColorDao selectedColorDao;

    public static final String SELECT_COLOR_TITLE = "Wybierz kolor";
    public static final String DATA_TITLE = "Dane";
    public static final String STAT_TITLE = "Statystyki";

    @GetMapping({"/select/{color}", "/select"})
    public String selectColorPage(@PathVariable(required = false) String color, Model model) {

        if(color != null) {
            selectedColorDao.save(new SelectedColor(color, new Date()));
        }


        String[][] colors = {
                {"red", "blue", "purple", "teal"},
                {"black", "orange", "yellow", "green"},
                {"gray", "silver", "olive", "lime"},
                {"navy", "white", "aqua", "fuchsia"}

        };

        model.addAttribute("title", SELECT_COLOR_TITLE);
        model.addAttribute("colors", colors);
        return "select";
    }
}
