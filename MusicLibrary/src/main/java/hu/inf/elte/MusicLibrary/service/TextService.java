package hu.inf.elte.musiclibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import hu.inf.elte.musiclibrary.repository.TextRepository;
import hu.inf.elte.musiclibrary.model.Text;

@Service
public class TextService {

    @Autowired
    private TextRepository textRepository;

    public List<Text> findAll() {
        return textRepository.findAll();
    }

    public Optional<Text> findById(int id) {
        return textRepository.findById(id);
    }

    public List<Text> findByBeginning(String begining) {
        return textRepository.findByBeginningIgnoreCaseStartingWithOrderByBeginningAsc(begining);
    }

    public List<Text> findByLang(String lang) {
        return textRepository.findByLangIgnoreCaseStartingWithOrderByBeginningAsc(lang);
    }

	public Text save(Text text) {
		return textRepository.save(text);
	}

	public void delete(Text text) {
        textRepository.delete(text);
	}
}