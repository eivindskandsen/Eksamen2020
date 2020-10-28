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


* Oppgave 1: Ble løst ved å hente kode fra kompendiumet, men man må passe på å sette riktige foreldre noder, fordi dette manglet i den overførte koden.
Mer beskrivene gjør vi null sjekk sånn at vi ikke har null verdier, deretter setter vi p=roten og q lik null(q er foreldrenoden til p). Deretter traverserer vi treet
og ved hjelp av en compare. Vi har nå plassen til den nye noden og lager den med foreldre peker og ordner foreldre pekeren tilbake.

* Oppgave 2: Ble løst ved å opprete en deque(altså en kø). Jeg traverserer treet i nivå orden(altså per nivå fra venstre) og noden som jeg tar ut av dequen sjekker jeg om har 
verdien vi leter etter. Om den har det øker jeg antallTall. Til slutt returner jeg antallTall.

* Oppgave 3: Ble løst ved hente litt kode fra kompeniummet. Jeg prøvde litt selv men koden fra kompeniumet ble mer elegant. Her finner man første post orden ved å gå lengst til venstre og ned i binærtreet. For å finne nestePostOrden må vi håndtere spesialtilfellene. Om første postorden er node returner vi null. Om førstePostorden er en høyre node er 
foreldrenoden nestePostOrden. Også har vi to alternativer i en venstrenode.

* Oppgave 4: Ble løst ved å finne første postOrden. Deretter går vi inn i en while loop og skriver først ut og finner nestePostOrden. I postOrdeRecursiv burkte jeg kode fra en forelesningsvideo. Vi har et basistilfelle og kall på seg selv og vi skriver ut sist for å få postOrden

*Oppgave 5: Ble løst ved å opprette ett array som jeg skal returnere og en deque. Jeg traverserer i nivå orden og legger hvert element inn i arrayet som jeg returnerer. I deseralize oppretter jeg et objekt av type binærtre<k>. så bruker jeg en for løkke til å legge til dataene fra inputt arrayet inn i binærtreet. Dette går fordi den er generisk.
  
* Oppgave 6:Her har jeg kopiert kode fra kompendiumet. Jeg setter riktig foreldre node og passer på at jeg håndterer null tilfeller. Jeg gjenbruker fjern koden i de andre metodene i denne oppgaven.I fjernAlle traverserer vi nivåOrden og fjerner noden om verdien matcher. I fjern alle bruker jeg nivåTraversering igjen og gjenbruker koden fra de anre metodene og fjerner en og en node om gangen.

Mer beskrivende om den kopierte koden. Vi først sjekker om verdi er null(nullsjekk), Deretter setter vi P=rot og q som foreldrenoden. Deretter traverserer vi treet og breaker om 
vi finner en node med lik verdi. Om p er nå null har vi ikke funnet verdien. Nå håndterer vi tilfelle 1 og 2 hvor en av barna til noden vi skal fjerne er null. vi setter b som barnenoden til p. Nå kan vi fjerne node p, vi setter pekerne og p renses opp av garbage collector. 
I tilfelle 3 har p to barn. Vi kopierer koden r til p(neste inorden) og setter pekere. Dette løser problemet vårt


# Warnings

* Non ASCII characters in an adentifier: Her bruker vi æøå
* Privat field endringer is not used: Jeg bruker ikke endringer fordi oppgavene ikke spør om det
* Method inneholder(T verdi) is never used: Jeg har greid å løse oppgavene uten denne
* Duplicated code fragment: Jeg har kopiert kode. Det er spesifert med kommentarer og beskrivelse av oppgaveløsning

