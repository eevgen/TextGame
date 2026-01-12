# **Herní návrh (Game Design)**

Autor: (Doplň své jméno)  
Třída: (Doplň svou třídu)  
Předmět: Informatika

## **1\. Název hry**

**Tajemství Království víl** (The Secret of the Fairy Kingdom)

## **2\. Popis výchozí situace**

Hlavním hrdinou je mladý chlapec **Jack**, který žije se svou babičkou, protože jeho rodiče tragicky zahynuli. Jack je smutný, ale odvážný a rád prozkoumává svět.  
Hra začíná na staré, zaprášené **půdě** v domě Jackovy babičky. Při prohledávání rodinných věcí Jack narazí na starou knihu v kůži, ze které vypadne tajemná **mapa**. Tato mapa ukazuje cestu do legendárního **Království víl**. Legenda praví, že ten, kdo usedne na trůn v tomto království, může vyslovit jedno přání, které se mu splní. Jackovou motivací je najít toto království a přát si, aby se jeho rodiče vrátili.

## **3\. Cíl hry**

Úkolem hráče je provést Jacka nebezpečnou cestou z jeho domova až do trůnního sálu v Království víl.  
Podmínka vítězství: Hráč vyhrává v okamžiku, kdy se dostane do lokace "Trůnní sál", promluví s královnou (nebo její asistentkou Ariou) a vysloví své přání.

## **4\. Postup k vítězství**

Aby hráč dosáhl cíle, musí:

1. **Najít mapu** na půdě, bez které se neodváží na cestu.  
2. **Získat vybavení** ve vesnici a domě (např. meč na obranu, klíč).  
3. **Najít společníky** (Iris a Rose), kteří mu pomohou překonat překážky (v herní mechanice reprezentováno získáním jejich "symbolů" nebo přímo interakcí).  
4. **Projít Začarovaným lesem**, kde musí vyřešit problém s gobliny nebo šelmami (použití předmětu).  
5. **Odemknout bránu** do Království víl pomocí získaného klíče nebo artefaktu.  
6. **Vstoupit do trůnního sálu.**

## **5\. Prostory/místnosti**

Hra se odehrává v 9 propojených lokacích.  
**Seznam lokací:**

1. **Půda** (Startovní místnost, je zde mapa)  
2. **Chodba** (Spojuje dům s venkem, je zde babička)  
3. **Před domem** (Cesta do vesnice)  
4. **Vesnice** (Možnost mluvit se starostou, získat úkoly)  
5. **Okraj lesa** (Setkání s Iris a Rose)  
6. **Temný hvozd** (Nebezpečná část, překážka v cestě)  
7. **Jeskyně** (Skrytá lokace s pokladem/klíčem)  
8. **Zlatá brána** (Vstup do království, zamčeno)  
9. **Trůnní sál** (Cíl hry)

**Grafický plánek:**  
      \[Půda\]  
        |  
    \[Chodba\]  
        |  
   \[Před domem\]  
        |  
    \[Vesnice\] \---- \[Okraj lesa\]  
                        |  
                   \[Temný hvozd\] \---- \[Jeskyně\]  
                        |  
                   \[Zlatá brána\]  
                        |  
                  \[Trůnní sál\]

## **6\. Důležité postavy**

* **Jack (hráč):** Hrdina příběhu.  
* **Babička:** Nachází se v domě (Chodba). Dává rady a varuje Jacka.  
* **Starosta:** Ve vesnici. Může dát Jackovi tip, kudy dál.  
* **Iris a Rose:** Spojenkyně na Okraji lesa. Představují moudrost a odvahu. Hráč s nimi musí promluvit, aby ho pustily dál nebo mu daly potřebný předmět.  
* **Aria:** Asistentka královny v Trůnním sále. Ukončuje hru.  
* **Goblin:** Nepřítel v Temném hvozdu (blokuje cestu, dokud hráč nepoužije meč nebo lest).

## **7\. Předměty a inventář**

Hráč má batoh s omezenou kapacitou.

* **Mapa:** Umožňuje hráči orientaci (ve hře může odemknout příkaz pro zobrazení nápovědy).  
* **Meč:** Nutný pro průchod přes Temný hvozd (zahnání šelem).  
* **Klíč:** Zlatý klíč ukrytý v Jeskyni, odemyká Zlatou bránu.  
* **Kniha:** Jen pro příběh, leží na půdě.

## **8\. Herní mechaniky**

* **Pohyb:** Přechod mezi místnostmi (sever, jih, východ, západ).  
* **Inventář:** Možnost sbírat (vezmi) a pokládat (poloz) věci.  
* **Interakce:** Hráč může mluvit s postavami. Některé postavy mohou hráči dát předmět až po rozhovoru.  
* **Locked Doors:** Místnost "Trůnní sál" je zamčená, dokud hráč nepoužije předmět "Klíč" v lokaci "Zlatá brána".

## **9\. Seznam příkazů**

Hra využívá návrhový vzor **Command** pro zpracování příkazů.  
**Formát:** \[příkaz\] \[parametr\]

* **jdi \[název východu\]** – Přesune hráče do sousední místnosti (např. jdi sever).  
* **vezmi \[předmět\]** – Sebere předmět z místnosti do batohu (např. vezmi mec).  
* **poloz \[předmět\]** – Vyhodí předmět z batohu (např. poloz mapa).  
* **batoh** – Vypíše obsah inventáře.  
* **prozkoumej \[cokoliv\]** – Vypíše detailní popis místnosti nebo předmětu.  
* **mluv \[postava\]** – Zahájí dialog s postavou (např. mluv babicka).  
* **pouzij \[předmět\]** – Použije předmět v dané situaci (např. pouzij klic pro odemčení brány).  
* **pomoc** – Zobrazí seznam příkazů.  
* **konec** – Ukončí hru.

*Tento dokument slouží jako základ pro implementaci hry v jazyce Java.*