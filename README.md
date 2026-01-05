# 1.9.1.Containers_and_JCF_library
# Pasūtījumu programma 

Programma apstrādā klientu pasūtījumus, glabājot datus vārdnīcā `pasutijumi`, kur atslēga ir klienta identifikators, bet vērtība — attiecīgā klienta preču saraksts. <br>

Komanda `add` nolasa klienta ID un preces nosaukumu, cenu un daudzumu, un saglabā šo informāciju klienta pasūtījumā. <br>

Komanda `print` izvada visu klientu un pasūtīto preču informāciju, bet `done` pabeidz programmas darbu. <br>

Programma ir jāpapildina ar komandu `sum`, kas pēc klienta ID ievades izvada pasūtījuma kopējo cenu, bet nezināmam klientam izvada “unknown client”. <br>

Jāpievieno arī komanda `inc`, kas palielina norādītās preces daudzumu par 1 (ja klients nav atrasts — “unknown client”, ja prece nav atrasta — “not found”). <br>

Visbeidzot jārealizē komanda `del`, kas dzēš norādīto preci no klienta pasūtījumiem, ar tiem pašiem kļūdu paziņojumiem (“unknown client” / “not found”). <br>
