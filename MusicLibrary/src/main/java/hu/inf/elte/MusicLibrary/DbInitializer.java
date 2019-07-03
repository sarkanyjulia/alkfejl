package hu.inf.elte.musiclibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.core.Ordered;

import hu.inf.elte.musiclibrary.model.Score;
import hu.inf.elte.musiclibrary.model.Text;
import hu.inf.elte.musiclibrary.model.Translation;
import hu.inf.elte.musiclibrary.model.User;
import hu.inf.elte.musiclibrary.model.User.Role;
import hu.inf.elte.musiclibrary.repository.ScoreRepository;
import hu.inf.elte.musiclibrary.repository.TextRepository;
import hu.inf.elte.musiclibrary.repository.TranslationRepository;
import hu.inf.elte.musiclibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DbInitializer implements ApplicationListener<ApplicationReadyEvent> {

	private static final Logger LOGGER = Logger.getLogger("DbInitializer");

	@Autowired
	private ScoreRepository scoreRepository;

	@Autowired
	private TextRepository textRepository;

	@Autowired
	private TranslationRepository translationRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		LOGGER.info("Initializing database");
		if (databaseHasData()) {
			return;
		}
		seedUsers();			
		seedTranslations();
		seedTexts();
		seedScores();
	}

	private void seedTexts() {
		textRepository.save(new Text(1,"latin", "Magnificat anima mea Dominum",
				"Magnificat anima mea Dominum, et exultavit spiritus meus in Deo salutari meo. Quia respexit humilitatem ancillae suae, ecce enim ex hoc beata me dicent omnes generationes.",
				"Lukács evangéliuma", translationRepository.findById(1).orElse(null), null));
		LOGGER.info("text saved");
		
		textRepository.save(new Text(2,"angol", "My soul doth magnify the Lord",
				"My soul doth magnify the Lord : and my spirit hath rejoiced in God my Saviour.\r\n" + 
				"For he hath regarded : the lowliness of his handmaiden.\r\n" + 
				"For behold, from henceforth : all generations shall call me blessed.\r\n" + 
				"...",
				"Lukács evangéliuma", translationRepository.findById(1).orElse(null), null));
		LOGGER.info("text saved");
		
		textRepository.save(new Text(3,"magyar", "Oly árvák ők mind",
				"Oly árvák ők mind, az öregek.\r\n" + 
				"Az ablakból néha elnézem őket,\r\n" + 
				"hogy vacogó szélben, gallyal hátukon\r\n" + 
				"mint cipekednek hazafelé",
				"Weöres Sándor", null, null));
		LOGGER.info("text saved");
		
		textRepository.save(new Text(4,"latin", "Kyrie eleison",
				"Kyrie eleison. Christe eleison. Kyrie eleison.",
				"mise ordinárium", translationRepository.findById(2).orElse(null), null));
		LOGGER.info("text saved");
		
		textRepository.save(new Text(5,"angol", "Lord, now lettest thou thy servant",
				"Lord, now lettest thou thy servant depart in peace, according to thy word.",
				"evangélium", null, null));
		LOGGER.info("text saved");
	}

	private void seedScores() {
		
		List<Text> textsToAdd = new ArrayList<>();
		textsToAdd.add(textRepository.findById(2).orElse(null));
		textsToAdd.add(textRepository.findById(5).orElse(null));
		scoreRepository.save(new Score(1, "Henry", "Purcell", "Magnificat and Nunc Dimittis in g", "b3", textsToAdd));
		LOGGER.info("score saved");
				
		scoreRepository.save(new Score(2, "Heinrich", "Schütz", "Canticum Simeonis", "j3", null));
		LOGGER.info("score saved");
		
		scoreRepository.save(new Score(3, "Henry", "Purcell", "Funeral Sentences", "b3", null));
		LOGGER.info("score saved");
		
		textsToAdd = new ArrayList<>();
		textsToAdd.add(textRepository.findById(1).orElse(null));
		scoreRepository.save(new Score(4, "Johann Sebastian", "Bach", "Magnificat", "b1", textsToAdd));
		LOGGER.info("score saved");
		
		textsToAdd = new ArrayList<>();
		textsToAdd.add(textRepository.findById(3).orElse(null));
		scoreRepository.save(new Score(5, "Zoltán", "Kodály", "Öregek", "j2", textsToAdd));
		LOGGER.info("score saved");
		
		textsToAdd = new ArrayList<>();
		textsToAdd.add(textRepository.findById(4).orElse(null));
		scoreRepository.save(new Score(6, "Thomas", "Stoltzer", "Kyrie", "j3", textsToAdd));
		LOGGER.info("score saved");
		
		textsToAdd = new ArrayList<>();
		textsToAdd.add(textRepository.findById(4).orElse(null));
		scoreRepository.save(new Score(7, "Cipriano de", "Rore", "Kyrie", "j3", textsToAdd));
		LOGGER.info("score saved");
	}

	private void seedTranslations() {
		translationRepository.save(new Translation(1, "Magasztalja lelkem az Urat",
				"Magasztalja lelkem az Urat, és ujjong az én szívem üdvözítő Istenemben. Mert tekintetre méltatta alázatos szolgálóleányát: íme, mostantól fogva boldognak mondanak engem minden nemzetek.",
				null));
		LOGGER.info("translation saved");
		translationRepository.save(
				new Translation(2, "Uram irgalmazz", "Uram irgalmazz! Krisztus kegyelmezz! Uram irgalmazz!", null));
		LOGGER.info("translation saved");
	}

	private void seedUsers() {
		userRepository.save(
				new User(1, "admin", "$2a$10$b2KUBuo5r0ReQqTOEFttkeIvx2PnBxariDTDxRK/Y9Xpui2/tMHs2", Role.ROLE_ADMIN));
		LOGGER.info("user saved");
		userRepository.save(
				new User(2, "user", "$2a$10$b2KUBuo5r0ReQqTOEFttkeIvx2PnBxariDTDxRK/Y9Xpui2/tMHs2", Role.ROLE_USER));
		LOGGER.info("user saved");
		userRepository.save(
				new User(3, "guest", "$2a$10$b2KUBuo5r0ReQqTOEFttkeIvx2PnBxariDTDxRK/Y9Xpui2/tMHs2", Role.ROLE_GUEST));
		LOGGER.info("user saved");
	}

	private boolean databaseHasData() {
		return userRepository.count() > 0 || scoreRepository.count() > 0 || textRepository.count() > 0
				|| translationRepository.count() > 0;
	}

}
