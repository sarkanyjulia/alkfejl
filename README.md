# Alkalmazások fejlesztése tantárgy beadandó

## 1. Követelményelemzés

### 1.1. Projekt rövid leírása

A program egy kórus által használt kották nyilvántartását végzi. Minden műhöz rögzíteni kell annak szerzőjét, címét, és a kottatári helyét. A kórusvezető számára fontos lehet, hogy szöveg szerint is tudjon műveket válogatni, valamint könnyen elérje az idegen szövegű művek fordítását, ezért nyilvántartjuk a szövegeket, fordításokat is. Egy műhöz több szöveg is tartozhat (pl. több tételes műveknél), és egy adott szövegre több kórusmű is létezhet.

### 1.2. Funkcionális követelmények
- bejelentkezés, kijelentkezés
- kotta felvitele / módosítása / törlése
- szöveg felvitele / módosítása / törlése
- kottához szöveg hozzáadása / törlése
- idegen nyelvű szöveghez fordítás hozzáadása / törlése
- felhasználó felvétele / módosítása / törlése
- kotta keresése cím, szerző szöveg alapján, összes listázása
- szöveg keresése cím, nyelv alapján, összes listázása

### 1.3. Nem funkcionális követelmények:
- felhasználóbarát, átlátható felület

### 1.4. Szerepkörök:
- Vendég: megtekintheti az adatokat és kereshet bennük
- Könyvtáros (user): ezen kívül új adatokat  vihet fel, módosíthat, törölhet
- Admin: módosíthatja vagy törölheti a felhasználókat

## 2. Tervezés

### 2.1. Végpontok

- GET /score: összes kotta listázása
- GET /score/{id}: kotta keresése azonosító szerint
- GET /score/name/{name}: kották keresése a zeneszerző vezetékneve szerint
- GET /score/title/{title}: kották keresése cím szerint
- POST /score: új kotta felvétele
- PUT /score/{id}: adott azonosítójú kotta módosítása
- DELETE /score/{id}: adott azonosítójú kotta törlése

- GET /text: összes szöveg listázása
- GET /text/{id}: szöveg keresése azonosító szerint
- GET /text/beginning/{beginning}: szövegek keresése szövegkezdet szerint
- GET /text/lang/{lang}: szövegek keresése nyelv szerint
- POST /text: új szöveg felvétele
- PUT /text/{id}: adott azonosítójú szöveg módosítása
- DELETE /text/{id}: adott azonosítójú szöveg törlése

- GET /translation: összes fordítás listázása
- GET /translation/{id}: fordítás keresése azonosító szerint
- GET /translation/beginning/{beginning}: fordítások keresése szövegkezdet szerint
- POST /translation: új fordítás felvétele
- PUT /translation/{id}: adott azonosítójú fordítás módosítása
- DELETE /translation/{id}: adott azonosítójú fordítás törlése

- GET /user: felhasználók listázása
- PUT /user/{id}: felhasználó módosítása
- DELETE /user/{id}: felhasználó törlése

- POST /user: új felhasználó regisztrálása
- POST /user/sign-in: bejelentkezés

### 2.2. Adatbázis terv

![ER diagram](/images/database.png)

