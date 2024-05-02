package br.com.joaovl.gamestory.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.joaovl.gamestory.Model.Game;
import br.com.joaovl.gamestory.Repository.GameRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class GameController {
    @Autowired
    GameRepository gr;
    
    @GetMapping("/list")
    public ModelAndView getListGame() {
        ModelAndView mv = new ModelAndView("game-list");
        mv.addObject("games",gr.findAll());

        return mv;
    }

    @GetMapping("/addgame")
    public String getGameAdd() {
        return "game-add";
    }

    @PostMapping("/addgame")
    public String postGameAdd(Game game) {
        gr.save(game);
        return "redirect:list";

    }
    
    
}
