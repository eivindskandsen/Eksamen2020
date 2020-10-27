# Mappeeksamen i Algoritmer og Datastrukturer Høst 2020

# Krav til innlevering

Se oblig-tekst for alle krav, og husk spesielt på følgende:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* git bundle er levert inn
* Hovedklassen ligger i denne path'en i git: src/no/oslomet/cs/algdat/Eksamen/EksamenSBinTre.java
* Ingen debug-utskrifter
* Alle testene i test-programmet kjører og gir null feil (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet


# Beskrivelse av oppgaveløsning (4-8 linjer/setninger per oppgave)

Jeg har brukt git til å dokumentere arbeidet mitt. Jeg har 16 commits totalt, og hver logg-melding beskriver det jeg har gjort av endringer.


* Oppgave 1: Ble løst ved å hente kode fra kompendiumet, men man må passe på å sette riktige foreldre noder, fordi dette menglet i den overførte koden
* Oppgave 2: Ble løst ved å opprete en deque(altså en kø). Jeg traverserer treet i nivå orden(altså per nivå fra venstre) og noden som jeg tar ut av dequen sjekker jeg om har 
verdien vi leter etter. Om den har det øker jeg antallTall. Til slutt returner jeg antallTall.
* Oppgave 3: Ble løst ved hente litt kode fra kompeniummet. Jeg prøvde litt selv men koden fra kompeniumet ble mer elegant. Her finner man første post orden ved å gå lengst til venstre og ned i binærtreet. For å finne nestePostOrden må vi håndtere spesialtilfellene. Om første postorden er node returner vi null. Om førstePostorden er en høyre node er 
foreldrenoden nestePostOrden. Også har vi to alternativer i en venstrenode.
* Oppgave 4: Ble løst ved å finne første postOrden. Deretter går vi inn i en while loop og skriver først ut og finner nestePostOrden. I postOrdeRecursiv burkte jeg kode fra en forelesningsvideo. Vi har et basistilfelle og kall på seg selv og vi skriver ut sist for å få postOrden
*Oppgave 5:
