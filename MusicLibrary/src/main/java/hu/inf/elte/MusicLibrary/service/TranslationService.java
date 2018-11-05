package hu.inf.elte.musiclibrary.service;

import java.util.List;

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
}