

--scores
INSERT INTO scores(id, composer_fname, composer_lname, title, place)
VALUES (1, 'Henry', 'Purcell', 'Magnificat and Nunc Dimittis in g', 'b3');
INSERT INTO scores(id, composer_fname, composer_lname, title, place)
VALUES (2, 'Heinrich', 'Schütz', 'Canticum Simeonis', 'j3');
INSERT INTO scores(id, composer_fname, composer_lname, title, place)
VALUES (3, 'Henry', 'Purcell', 'Funeral Sentences', 'b3');
INSERT INTO scores(id, composer_fname, composer_lname, title, place)
VALUES (4, 'Johann Sebastian', 'Bach', 'Magnificat', 'b1');
INSERT INTO scores(id, composer_fname, composer_lname, title, place)
VALUES (5, 'Zoltán', 'Kodály', 'Öregek', 'j2');
INSERT INTO scores(id, composer_fname, composer_lname, title, place)
VALUES (6, 'Thomas', 'Stoltzer', 'Kyrie', 'j3');
INSERT INTO scores(id, composer_fname, composer_lname, title, place)
VALUES (7, 'Cipriano de', 'Rore', 'Kyrie', 'j3');

--translations
INSERT INTO translations(id, beginning, full_text)
VALUES (1, 'Magasztalja lelkem az Urat', 'Magasztalja lelkem az Urat, és ujjong az én szívem üdvözítő Istenemben. ...');
INSERT INTO translations(id, beginning, full_text)
VALUES (2, 'Uram irgalmazz', 'Uram irgalmazz! Krisztus kegyelmezz! Uram irgalmazz!');

--texts
INSERT INTO texts(id, lang, beginning, full_text, author, translation_id)
VALUES (1, 'latin', 'Magnificat anima mea Dominum', 'Magnificat anima mea Dominum, et exultavit spiritus meus in Deo salutari meo. ...', 'Lukács evangéliuma', 1);
INSERT INTO texts(id, lang, beginning, full_text, author, translation_id)
VALUES (2, 'angol', 'My soul doth magnify the Lord', 'My soul doth magnify the Lord : and my spirit hath rejoiced in God my Saviour.
For he hath regarded : the lowliness of his handmaiden.
For behold, from henceforth : all generations shall call me blessed.
...', 'Lukács evangéliuma', 1);
INSERT INTO texts(id, lang, beginning, full_text, author, translation_id)
VALUES (3, 'magyar', 'Oly árvák ők mind', 'Oly árvák ők mind, az öregek.
Az ablakból néha elnézem őket,
hogy vacogó szélben, gallyal hátukon
mint cipekednek hazafelé', 'Weöres Sándor', null);
INSERT INTO texts(id, lang, beginning, full_text, author, translation_id)
VALUES (4, 'latin', 'Kyrie eleison', 'Kyrie eleison. Christe eleison. Kyrie eleison.', 'mise ordinárium', 2);


--scores_texts
INSERT INTO scores_texts(scores_id, texts_id) VALUES (1, 2);
INSERT INTO scores_texts(scores_id, texts_id) VALUES (4, 1);
INSERT INTO scores_texts(scores_id, texts_id) VALUES (6, 4);
INSERT INTO scores_texts(scores_id, texts_id) VALUES (7, 4);

--users
INSERT INTO users(username, pwd, user_role)
VALUES ('admin', '$2a$10$b2KUBuo5r0ReQqTOEFttkeIvx2PnBxariDTDxRK/Y9Xpui2/tMHs2', 'ROLE_ADMIN');
INSERT INTO users(username, pwd, user_role)
VALUES ('user', '$2a$10$b2KUBuo5r0ReQqTOEFttkeIvx2PnBxariDTDxRK/Y9Xpui2/tMHs2', 'ROLE_USER');
INSERT INTO users(username, pwd, user_role)
VALUES ('guest', '$2a$10$b2KUBuo5r0ReQqTOEFttkeIvx2PnBxariDTDxRK/Y9Xpui2/tMHs2', 'ROLE_GUEST');
-- pwd kódolás nélkül: 'password'