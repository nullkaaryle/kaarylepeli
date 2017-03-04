![Puolukka](https://github.com/nullkaaryle/kaarylepeli/blob/master/kaarylepeli/src/main/resources/kaarylepelikuvat/puolukka.png)

##Aiheen kuvaus:##

###Aihe:###
Käärylepeli


###Käyttäjät:###
Yksi pelaaja


###Käyttäjän toiminnot:###
Pelissä pelaaja on kaalikääryle, joka juoksee lautasella perunamuusin päällä. Lautasella vastaan tulee vihaisia puolukoita. Pelin ideana on selvitä mahdollisimman kauan osumatta puolukkaan. Puolukoita väistetään hyppäämällä. Peli vaikeutuu hiljalleen siten, että vauhti kasvaa ja puolukat tulevat yhä tiheämmin. Peli koostuu yhdestä pelialueesta (pelikentästä). Pelaajalla ei ole mahdollisuutta muokata pelin ominaisuuksia. 

![Puolukka](https://github.com/nullkaaryle/kaarylepeli/blob/master/kaarylepeli/src/main/resources/kaarylepelikuvat/puolukka.png)

##Pelin toiminnallisuus loppupalautuksessa##

Peli on ohjelmoitu Javalla, graafinen käyttöliittymä on toteutettu Swingillä. Pelin kuvat ovat itse piirrettyjä, työkaluna on käytetty Pixelmator-ohjelmaa. 

Käyttäjän syötteet luetaan näppäimistön painalluksina. Luettuja syötteitä ovat välilyöntipainike ja nuolinäppäin ylöspäin, jotka molemmat saavat Kääryle-pelihahmon hyppäämään. Pelin päätyttyä uuden pelin voi aloittaa painamalla Enter-painiketta.

Pelin tulosteena käyttäjälle näytetään peliruutu. Ruutu piiretään kerran joka pelisilmukassa riippumatta käyttäjän syötteestä. Peliruutua päivitetään noin 50 millisekunnin välein. Peliruudulle tulostetaan hahmojen, eli kääryleen, puolukoiden muusien ja pilvien kuvat sijainnin mukaan. Lisäksi piirretään taustakuva, joka ei liiku. 

Peliruudun vasemmasta käyttäjä voi seurata pistetilannetta. Pisteet päivitetään ja piirretään kerran pelisilmukassa. Pelin päätytyttä kääryleen ja puolukan osumaan tulostetaan mahdollinen Uusi ennätys! -teksti ja tehostekuvat sekä ohjeet uuden pelin aloittamiseen. 

Pisteiden tallennuksessa on käytössä rajoite: huippupisteitä ei tallenneta pysyvästi. Jos ohjelman sammuttaa ja käynnistää kokonaan uudelleen on huippupistemäärä aina alussa nolla.

Peli voi antaa virheilmoituksia. Virheilmoitus voi tulla mm. siitä että piirtäjää ei ole asetettu (InterruptedException) tai kuvatiedostoa ei pystytä lukemaan (IOException).


![Puolukka](https://github.com/nullkaaryle/kaarylepeli/blob/master/kaarylepeli/src/main/resources/kaarylepelikuvat/puolukka.png)

##Käyttöohjeet:##

###[Katso kuvitettu käyttöohje!](https://github.com/nullkaaryle/kaarylepeli/blob/master/dokumentaatio/kuvallinenKayttoohje.md)####

Olet urhea kaalikääryle ja tehtävänäsi on edetä mahdollisimman pitkälle upottavassa perunamuussissa. Hyppää vastaantulevien äkäisten puolukoiden yli välilyönnillä tai ylöspäin-nuolinäppäimellä. Peli päättyy jos osut puolukkaan, mutta voit aloittaa aina uuden pelin painamalla Enter-näppäintä. Seuraa pisteitä vasemmasta yläkulmasta, jos pisteet muuttuvat keltaiseksi olet tekemässä oman ennätyksesi! 

![Puolukka](https://github.com/nullkaaryle/kaarylepeli/blob/master/kaarylepeli/src/main/resources/kaarylepelikuvat/puolukka.png)


##Pelin kehitysideat##

####Demossa 21.2.2017 esiintulleita korjaus- ja kehitysehdotuksia:####
- [x] pisteiden ja lopputekstin näkymistä voisi parantaa (esim. tekstin väriä vaihtamalla tai varjostuksilla)
- [x] vaikeusaste voisi kasvaa tai vaihtelevuutta lisätä jotenkin (erilaisia vihollisia ja vaikka eri nopeuksia)
- [x] oma huomio: pelianimaatiot voisivat olla sujuvampia _tutkittu_

####Pelin mahdollisia laajennuksia jatkossa:####
- [ ] historia: tiedostoon kirjoitus ja kaikkien aikojen huippupisteiden tallentaminen l. HiScore-listan ylläpito
- [ ] äänitehosteet: hyppy, puolukan ylitys, kuolema, tasa- ja huippupisteet
- [ ] logiikka, grafiikka: aloitusnäyttö
- [ ] grafiikka: osuman sattuessa puolukan litistyminen, kääryleen kaatuminen
- [ ] logiikka: kääryleelle mahdollisuus tehdä tuplahyppy, eli korkeampi hyppy
- [ ] logiikka, grafiikka: muutama erikokoinen Puolukka-olio peliin
- [ ] logiikka: mahdollisuus elämiin, eli peli ei loppuisi ensimmäiseen osumaan


![Puolukka](https://github.com/nullkaaryle/kaarylepeli/blob/master/kaarylepeli/src/main/resources/kaarylepelikuvat/puolukka.png)

##Rakennekuvaus ja kaaviot:##
Pelissä on yhteensä 15 luokkaa. Luokat on jaettu yhteenkuuluviin kokonaisuuksiin neljään pakettiin:

* **kaarylepeli**
Sisältää pelin pääohjelman, Main-luokan. Tässä luokassa luodaan uusi Kaarylepeli-olio ja Kayttoliittyma-olio sekä käynnistetään peli.

* **kaarylepeli.rakennusosat**
Rakennusosat- paketti sisältää pelihahmojen luokat Kaaryle, Puolukka, Muusi ja Pilvi sekä luokat Osa ja Hahmo. Lisäksi paketissa on luetellut tyypit (enum) Suunta ja Pilvityyppi. Kaaryle-, Puolukka-, Muusi- ja Pilvi-luokat perivät abstraktin luokan Hahmo. Hahmo-luokan oliot hyödyntävät Osa-luokkaa, eli hahmot koostuvat Osista. Hahmon sisältämät Osat tallennetaan ArrayList-listaan. Enum Suunta on apuna Hahmon suunnan vaihtamista varten ja Pilvityyppi määrittelee Pilvi-oliolle typpillisiä ominaisuuksia.

* **kaarylepeli.gui**
Paketti sisältää luokan Kayttoliittyma. Käyttöliittymä-luokassa luodaan kehys ja pelin komponentit. Lisäksi paketissa näppäimistönkuuntelijaluokka Kuuntelija, Piirtaja-piirtoalusta sekä rajapinta Paivitettava. Paivitettava-rajapintaa hyödynnetään Piirtaja-luokassa, joka piirtää pelin sisällön.

* **kaarylepeli.peli**
Paketissa on kaksi luokkaa: Kaarylepeli ja Pisteenlaskija. Kaarylepeli-luokka perii Timer-luokan ja toteuttaa sen myötä ActionListenerin. Luokka sisältää pelin logiikan ja pelisilmukan. Kaarylepeli-luokassa luodaan pelihahmot (kääryle ja puolukat sekä muusit ja pilvet). Pelisilmukka käynnistyy ajastettuna ja sen sisällä piirretään peliruutu, liikutetaan pelihahmoja sekä tarkistetaan pelin päättymisehdot sekä pistetilanne. Pisteenlaskija-luokka toimii Kaarylepeli-luokan apuna, ja ylläpitää pistetilannetta, huippupisteitä ja ennätystietoa.

* * *

###Luokkakaavio:###
![Luokkakaavio](https://github.com/nullkaaryle/kaarylepeli/blob/master/dokumentaatio/kaaviot/luokkakaavio_vaaka.png)

* * *

###Sekvenssikaavio pelin käynnistyksestä:###
![Sekvenssikaavio1](https://github.com/nullkaaryle/kaarylepeli/blob/master/dokumentaatio/kaaviot/sekvenssikaavio_pelinKaynnistys.png)

* * *

###Sekvenssikaavio pelisilmukasta:###
![Sekvenssikaavio2](https://github.com/nullkaaryle/kaarylepeli/blob/master/dokumentaatio/kaaviot/sekvenssikaavio_yksiPelisilmukka.png)

* * *

![Puolukka](https://github.com/nullkaaryle/kaarylepeli/blob/master/kaarylepeli/src/main/resources/kaarylepelikuvat/puolukka.png)
