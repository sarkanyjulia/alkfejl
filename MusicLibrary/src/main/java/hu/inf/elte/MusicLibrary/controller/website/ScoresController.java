package hu.inf.elte.musiclibrary.controller.website;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hu.inf.elte.musiclibrary.data.ScoreFormData;
import hu.inf.elte.musiclibrary.data.TextFormData;
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
	public String scoreDetails(@RequestParam("scoreId") int scoreId, Model model) {
		Optional<Score> optionalScore = scoreService.findById(scoreId);
		if (optionalScore.isPresent()) {
			model.addAttribute("selectedScore", optionalScore.get());
			return "score";
		} else {
			model.addAttribute("message", "A keresett kotta nem található.");
			return "error";
		}

	}

	@GetMapping("/score/new")
	public String newScore(Model model) {
		model.addAttribute("newScore", new ScoreFormData());
		model.addAttribute("pageTitle", "Új kotta felvétele");
		model.addAttribute("route", "/score/save");
		return "newscore";
	}
	
	@GetMapping("/score/edit")
	public String editScore(@RequestParam("scoreId") int scoreId, Model model) {
		Score score = scoreService.findById(scoreId).orElseThrow();
		ScoreFormData scoreData = new ScoreFormData();
		scoreData.setId(score.getId());
		scoreData.setTitle(score.getTitle());
		scoreData.setFirstName(score.getFirstName());
		scoreData.setLastName(score.getLastName());
		scoreData.setPlace(score.getPlace());
//		for (Text text : score.getTexts()) {
//			TextFormData textData = new TextFormData();
//			textData.setId(text.getId());
//			textData.setLang(text.getLang());
//			textData.setAuthor(text.getAuthor());
//			textData.setBeginning(text.getBeginning());
//			textData.setFullText(text.getFullText());
//			if (text.getTranslation()!=null) {
//				textData.setTranslationId(text.getTranslation().getId());
//				textData.setTranslationBeginning(text.getTranslation().getBeginning());
//				textData.setTranslationFullText(text.getTranslation().getFullText());
//			}	
//			scoreData.addText(textData);
//		}
		model.addAttribute("newScore", scoreData);
		model.addAttribute("pageTitle", "Kotta adatainak szerkesztése");
		model.addAttribute("route", "/score/update/" + scoreId);
		return "newscore";
	}

	@PostMapping("/score/save")
	public String saveScore(ScoreFormData scoreData) {
		Score scoreToSave;
		if (scoreData.getId() != null) {
			scoreToSave = scoreService.findById(scoreData.getId()).orElseThrow();
		}
		else
		{
			scoreToSave = new Score();
		}
		scoreToSave.setTitle(scoreData.getTitle());
		scoreToSave.setFirstName(scoreData.getFirstName());
		scoreToSave.setLastName(scoreData.getLastName());
		scoreToSave.setPlace(scoreData.getPlace());
		scoreService.save(scoreToSave);
		return "redirect:/";
	}
	
	@PostMapping("/score/update/{scoreId}")
	public String updateScore(@PathVariable("scoreId") int scoreId, ScoreFormData scoreData) {
		Score scoreToSave = scoreService.findById(scoreId).orElseThrow();		
		scoreToSave.setTitle(scoreData.getTitle());
		scoreToSave.setFirstName(scoreData.getFirstName());
		scoreToSave.setLastName(scoreData.getLastName());
		scoreToSave.setPlace(scoreData.getPlace());
		scoreService.save(scoreToSave);
		return "redirect:/";
	}
	
	@GetMapping("/score/delete")
	public String deleteScore(@RequestParam("scoreId") int scoreId) {
		Score scoreToDelete = scoreService.findById(scoreId).orElseThrow();
		scoreService.delete(scoreToDelete);
		return "redirect:/";
	}
}
