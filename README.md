# OOP-pangarakendus
OOP kursuse projekt
Programmi autoriteks on Uku Ilves ja Mairi Dubik. Projektiks on lihtsam 

Programm küsib kasutajalt kasutaja nime ning kas tal on kontonumber,
kui tal ei ole siis see genereeritakse talle, kui tal on siis ta sisestab selle nagu ka oma nime,
järgmisena tervitab programm kasutajanime ja ütleb mis pangalehel ta on ning talle näidatakse valikuid mida ta oma
pangakontoga teha saab (ülekanne, kontojääk, raha väljavõtt, viimane tehing, välja logimine)

Klass Konto on baas konto loomisele ning konto annab võimaluse kontos asju teha (ülekanne, kontojääk, raha väljavõtt, viimane tehing, välja logimine)
Klass Main(Peaklass) luuakse konto kui kasutajalt küsitakse kasutajaNimi() ja kontonumber() meetoditega kasutajalt andmete sisestamist
samuti genereeritakse suvaline kontonumber kui kasutajal puudub kontonumber kontroNR() meetodiga
Klass Inimene on Konto superklass, kus on kontonumber ja kasutajanimi.

Klasside vaheline suhtlemine oli natukene keeruline alguses, aga see ei takistanud tööd
Hästi läksid panga funktsioonide loomine, aga arendamist vajab raha välja võtmine ja ülekandmine(negatiivset summat ei laseks läbi)
ning erindite kontrollimine ja nendega tegelemine et programm kinni ei jookseks vale sisestusega.
Programmi testimine toimus main klassis, kus testiti, kas klass konto loob konto õigesti ja kas kõik funktsioonid töötavad
samuti testiti kasutajadialoogi main klassis

Uku lõi klassi Konto ning sellega vajalikud asjad main klassi ning Mairi lõi Main klassi kasutaja dialoogid ja sellega kaasnevad meetodid ning Inimene klassi.
Circa kulus Ukul 4h tööle.

Mairi lõi klassi Inimene ja sidus selle Konto klassiga, et oleks arusaaadavam. MAiril kulus tööks umbes 5h, sest oli palju mõtlemist.


Palun "git checkout Projekt2", et rühmatöö nr 2 vaadata.
