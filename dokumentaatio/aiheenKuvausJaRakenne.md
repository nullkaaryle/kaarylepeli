![Puolukka](https://github.com/nullkaaryle/kaarylepeli/blob/master/kaarylepeli/src/main/resources/kaarylepelikuvat/puolukka.png)

###Aihe:###
Käärylepeli


###Käyttäjät:###
Yksi pelaaja


###Käyttäjän toiminnot:###
Pelaaja liikuttaa pelihahmoa pelikentällä pystysuunnassa. Pelaajan tavoitteena on pisteiden kerääminen. Peli päättyy kuolemaan.

Pelihahmon täytyy varoa vihollisia, jotka tulevat kentällä vastaan. Pelaajan pitää osata oikein ajoitettuna hypätä vihollisten eli esteiden yli, muuta liikkumista ei tarvita, sillä pelihahmo "juoksee" koko ajan itse eteenpäin. Peli loppuu jos pelihahmo osuu viholliseen.

Pelihahmona on kaalikääryle ja vihollisia ovat puolukat. Pelikenttänä toimii perunamuusi.


![Puolukka](https://github.com/nullkaaryle/kaarylepeli/blob/master/kaarylepeli/src/main/resources/kaarylepelikuvat/puolukka.png)


###Pelin toiminnallisuus 5. viikon palautuksessa:###
Peliä voi pelata. Kääryle hyppää SPACE-painikkeella tai YLÖS-nuolinäppäimellä. Uuden pelin voi aloittaa osuman jälkeen ENTER-painikkeella. Peliruutu täytyy itse sulkea. Huippupisteet tallentuvat pelisessioittain.

####Demossa 21.2.2017 esiintulleita korjaus- ja kehitysehdotuksia:####
* pisteiden ja lopputekstin näkymistä voisi parantaa (esim. tekstin väriä vaihtamalla tai varjostuksilla)
* vaikeusaste voisi kasvaa tai vaihtelevuutta lisätä jotenkin (erilaisia vihollisia ja vaikka eri nopeuksia)
* oma huomio: pelianimaatiot voisivat olla sujuvampia

####Arvio peliin kurssin loppupalautukseen mennessä lisättävistä ominaisuuksista:####
- [ ] lisätään perunamuusin ja kaalikääryleen elävöittävät liikkeet, jotta pelin alkuperäinen idea toteutuu (eli pelissä kaalikääryle juoksee, ja puolukat pysyvät paikallaan)
- [ ] tarkennetaan hahmojen osuminen toisiinsa (määritellään hahmojen Osa-listat hahmon uusia grafiikkoja tukeviksi)
- [ ] lisätään parallax-pilvet

####Pelin mahdollisia laajennuksia jatkossa:####
- [ ] historia: tiedostoon kirjoitus ja kaikkien aikojen huippupisteiden tallentaminen l. HiScore-listan ylläpito
- [ ] logiikka: lisätään vaikeusasteet (toteutus esim. vauhdin lisäyksellä ja/tai tihenevillä puolukan väleillä
- [ ] äänitehosteet: hyppy, puolukan ylitys, kuolema, tasa- ja huippupisteet
- [ ] logiikka, grafiikka: aloitusnäyttö
- [ ] grafiikka: osuman sattuessa puolukan litistyminen, kääryleen kaatuminen
- [ ] logiikka: pistelaskun tarkennus, ylitetyistä puolukoista lisäpisteitä
- [ ] logiikka: kääryleelle mahdollisuus tehdä tuplahyppy, eli korkeampi hyppy
- [ ] logiikka, grafiikka: muutama erikokoinen Puolukka-olio peliin
- [ ] logiikka: mahdollisuus elämiin, eli peli ei loppuisi ensimmäiseen osumaan


![Puolukka](https://github.com/nullkaaryle/kaarylepeli/blob/master/kaarylepeli/src/main/resources/kaarylepelikuvat/puolukka.png)


###Luokkakaavio:###
![Luokkakaavio](https://github.com/nullkaaryle/kaarylepeli/blob/master/dokumentaatio/kaaviot/luokkakaavio_vaaka_20170221.png)

* * *

###Sekvenssikaavio pelin käynnistyksestä:###
![Sekvenssikaavio1](https://github.com/nullkaaryle/kaarylepeli/blob/master/dokumentaatio/kaaviot/sekvenssikaavio_pelinKaynnistys.png)

* * *

###Sekvenssikaavio pelisilmukasta:###
![Sekvenssikaavio2](https://github.com/nullkaaryle/kaarylepeli/blob/master/dokumentaatio/kaaviot/sekvenssikaavio_kaynnistys_20170221.png)

* * *

![Puolukka](https://github.com/nullkaaryle/kaarylepeli/blob/master/kaarylepeli/src/main/resources/kaarylepelikuvat/puolukka.png)
