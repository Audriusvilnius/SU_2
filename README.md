## Pagal žemiau pateiktus nurodymus sudarykite klasę geografinių koordinačių saugojimui ir atstumų tarp jų skaičiavimui. Papildomų klasės laukų ir metodų aprašyti negalima, tačiau įvertinkite kurie iš nurodytų klasės narių turi būti statiniai (statiniais nariais gali būti tik tie, kuriems tai yra būtina).

Metode main nurodykite žemiau pateiktą kodą. Gautą rezultatą palyginkite su žemiau pateiktu laukiamu rezultatu atsižvelgdami į tai, kad programa generuos skirtingas koordinates.

Nurodymai:

1. Sudarykite klasę GeoLocation, kurioje būtų:
    * Du privatūs kintamieji double lat ir double lon vietovės geografinėms koordinatėms (platumai ir ilgumai) saugoti. Koordinates saugokite realiaisiais skaičiais (decimal formatu).
    * Privatus kintamasis int numLocations su nuline pradine reikšme, skirtas programoje aprašytų vietovių (klasės GeoLocation objektų) skaičiui saugoti.

2. Papildykite klasę trim konstruktoriais:
    * Konstruktoriumi be parametrų, kuris klasės nariams priskirtų atsitiktines koordinates iš intervalo [−90, 90] ir padidintų numLocations reikšmę vienetu. Koordinates suapvalinkite 6 ženklų po kablelio tikslumu.
    * Konstruktoriumi su dviem parametrais, klasės nariams lat ir lon priskirtų parametrais perduotas reikšmes, ir padidintų numLocations reikšmę vienetu.
      *Kopijavimo konstruktoriumi, kuris nukopijuotų jam perduotos vietovės koordinates ir pridėtų prie kiekvienos koordinatės atsitiktinį skaičių iš intervalo [−0.1, 0.1] (sugeneruotų atsitiktines koordinates netoli parametru perduotos vietovės).

3. Papildykite klasę iš išorės pasiekiamu metodu void print(), atspausdinančiu koordinates formatu [lat, lon].

4. Papildykite klasę iš išorės pasiekiamu metodu double distance(GeoLocation, GeoLocation), kuris paskaičiuotų atstumą kilometrais (vieno ženklo po kablelio tikslumu) tarp parametrais perduotų vietovių. Atstumo skaičiavimui naudokite Haversino formulę, kurios implementaciją Java kalba galite rasti internete. Atstumo skaičiavimo formulių (kodo) paaiškinti nereikės :)

Metodo main kodas:

GeoLocation someLocation = new GeoLocation();
GeoLocation vilnius = new GeoLocation(54.683333, 25.283333);
GeoLocation kaunas = new GeoLocation(54.897222, 23.886111);
GeoLocation nearVilnius = new GeoLocation(vilnius);

someLocation.print();
vilnius.print();
nearVilnius.print();

System.out.println("Number of locations: " + GeoLocation.getNumLocations());

System.out.println("From Vilnius to Kaunas: " + GeoLocation.distance(vilnius, kaunas));
System.out.println("From Vilnius to random location: " + GeoLocation.distance(vilnius, someLocation));
System.out.println("From Vilnius to random neighbour: " + GeoLocation.distance(vilnius, nearVilnius));

-----------------------------------------------

Laukiamas rezultatas (pirmo ir trečio taško koordinatės skirsis dėl atsitiktinumo, bet pirmas atstumas visada turi būti 92.6, antras atstumas − labai didelis, o trečias atstumas − labai mažas):

* [-10.96451, 52.679755]
* [54.683333, 25.283333]
* [54.770529, 25.254458]
* Number of locations: 4
* From Vilnius to Kaunas: 92.6
* From Vilnius to random location: 7738.3
* From Vilnius to random neighbour: 9.8
