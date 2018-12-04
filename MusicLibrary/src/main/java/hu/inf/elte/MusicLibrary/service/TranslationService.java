package hu.inf.elte.musiclibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import hu.inf.elte.musiclibrary.repository.TranslationRepository;
import hu.inf.elte.musiclibrary.model.Translation;

@Service
public class TranslationService {

    @Autowired
    private TranslationRepository translationRepository;

    public List<Translation> findAll() {
        return translationRepository.findAll();
    }

    
    public Optional<Translation> findById(int id) {
        return translationRepository.findById(id);
    }
    public List<Translation> findByBeginning(String beginning) {
        return translationRepository.findByBeginningIgnoreCaseStartsWithOrderByBeginningAsc(beginning);  
    }


	public void delete(Translation translation) {
        translationRepository.delete(translation);
	}


	public Translation save(Translation translation) {
		return translationRepository.save(translation);
	}  
    
}