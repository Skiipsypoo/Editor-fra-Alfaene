# Algoritmer og datastrukturer oppgave 1
Av Martin Ruud og Kristian Bjurholt Rein 

<h4> Keybindings </h4>

"A-Z|0-1|a-z|§-?|Å-Ø|å-ø|" = karakter innsetting

"Backspace/Delete" = sletting
 
"Enter" = linjeskifte

"Space" = mellomrom

"ALT" + "←" = beveg cursor til venstre

"ALT" + "→" = beveg cursor til høyre

"ALT" + "↑" = beveg cursor oppover

"ALT" + "↓" = beveg cursor nedover

Programmet støtter alle karakterer mellom kontrollkarakter for backspace til liten ø i unicode.
Hvis programmet ikke sletter når man presser backspace keyen, må man kommentere bort if statmentenen som sjekker for /b og tar bort kommentaren fra delete function begge er markert med kommentarer i editor koden. 




<h4> Beskrivelse av datastrukturer </h4> 
I denne oppgaven valgte vi å bruke Linked List som datastruktur i Document klassen. Grunnen til dette er at en Linked List består av noder som peker på hverandre. Om man da velger å slette en karakter, vil bare pekeren til neste node endres. Etter mye prøving og feiling har vi til slutt kommet frem til en Linked List som inneholder 20 Linked Lists (en for hver rad). Dette gjorde det enkelt å implementere navigasjon til pekeren og inserting av data i listene. Selve navigeringen oppfører seg i stor grad likt som i en 2d array som eksisterte i det vi begynte med oppgaven. 

I Document er det lagt til følgende funksjoner: innsetting, linjeskift, navigering, sletting og forskyvning av tekst om pekeren blir flyttet bakover. I tilleg har det blitt implementert logikk for å behandle outOfBoundsExceptions. Dette er tross alt det minste man forventer av en moderne teksteditor. 

<h4>TODO</h4>

 + Legge til lese funksjon
 
 + Fin tune lagrefunksjon

 + Smile og ha en god dag
