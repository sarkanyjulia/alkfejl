

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



--texts
INSERT INTO texts(id, lang, beginning, full_text, author)
VALUES (1, 'latin', 'Magnificat anima mea Dominum', 'Magnificat anima mea Dominum, et exultavit spiritus meus in Deo salutari meo. ...', 'Lukács evangéliuma');
INSERT INTO texts(id, lang, beginning, full_text, author)
VALUES (2, 'angol', 'My soul doth magnify the Lord', 'My soul doth magnify the Lord ...', 'Lukács evangéliuma');
INSERT INTO texts(id, lang, beginning, full_text, author)
VALUES (3, 'magyar', 'Oly árvák ők mind', 'Oly árvák ők mind, az öregek. Az ablakból néha elnézem őket...', 'Weöres Sándor');
INSERT INTO texts(id, lang, beginning, full_text, author)
VALUES (4, 'latin', 'Kyrie eleison', 'Kyrie eleison. Christe eleison. Kyrie eleison.', 'mise ordinárium');


--scores_texts
INSERT INTO scores_texts(scores_id, texts_id) VALUES (1, 2);
INSERT INTO scores_texts(scores_id, texts_id) VALUES (4, 1);
INSERT INTO scores_texts(scores_id, texts_id) VALUES (6, 4);
INSERT INTO scores_texts(scores_id, texts_id) VALUES (7, 4);

--translations
--INSERT INTO translations(id, beginning, full_text)
--VALUES (1, 'Magasztalja lelkem az Urat', 'Magasztalja lelkem az Urat, és ujjong az én szívem üdvözítő Istenemben. ...');
--INSERT INTO translations(id, beginning, full_text)
--VALUES (2, 'Uram irgalmazz', 'Uram irgalmazz! Krisztus kegyelmezz! Uram irgalmazz!');