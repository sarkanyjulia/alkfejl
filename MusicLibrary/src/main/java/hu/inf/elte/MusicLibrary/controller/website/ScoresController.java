package hu.inf.elte.musiclibrary.controller.website;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hu.inf.elte.musiclibrary.model.Score;
import hu.inf.elte.musiclibrary.model.Text;
import hu.inf.elte.musiclibrary.service.ScoreService;

@Controller
//@RequestMapping(value="/")
public class ScoresController {
	
	@Autowired
	ScoreService scoreService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("scores", scoreService.findAll());		
		return "main";
	}
	
	@GetMapping("/score")
	public String scoreDetails(@RequestParam("scoreId") int scoreId,  Model model) {
		Optional<Score> optionalScore = scoreService.findById(scoreId);
		if (optionalScore.isPresent()) {
			model.addAttribute("selectedScore", optionalScore.get());			
			return "score";
		}
		else
		{
			model.addAttribute("message", "A keresett kotta nem található.");
			return "error";
		}
		
	}
	
	@RequestMapping("/score/new")
	public String newScore(Model model) {		
		model.addAttribute("newScore", new Score());
		return "newscore";
	}
	
	@RequestMapping("/score/save")
	public String saveScore(Model model) {		
		
		return "newscore";
	}
}
