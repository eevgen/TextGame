# Textová adventura: Cesta do Království víl

## O hře

Textová adventura je interaktivní příběhová hra, v níž se hráč vydává na nebezpečnou cestu z domova babičky skrze lesní území do tajemného Království víl. Hra vás uvede do světa plného tajemství, postav a výzev, kde musíte sbírat předměty a řešit úkoly, abyste dosáhli finálního cíle – setkání s královnou.

## Příběh

Jack žije se svou babičkou a jednoho dne si na půdě všimne záhadné mapy vypadlé ze staré knihy. Tato mapa ukazuje cestu do mytického Království víl. Rozhodne se vydat se na dobrodružství. Na cestě musí procházet přes nebezpečný les, potkat se s gobliny a překonat zamčenou zlatou bránu. K dosažení cíle potřebuje meč na obranu před šelmami a zlatý klíč k otevření brány.

## Herní mechaniky

- **Sbírání předmětů** - Sbírejte předměty rozesté po jednotlivých místnostech a uchovávejte si je v batohu
- **Inventář** - Omezenou kapacitu batohu (10 předmětů)
- **Interakce s NPCs** - Mluvte s postavami v jednotlivých místnostech, abyste se dozvěděli více o příběhu
- **Používání předmětů** - Některé předměty mají zvláštní účel (klíč k otevření brány, meč na obranu atd.)
- **Průzkum** - Prozkoumávejte místnosti a předměty, abyste sbírali informace
- **Navigace** - Pohybujte se mezi 8 propojenými místnostmi světa hry

## Dostupné příkazy

| Příkaz | Syntaxe | Popis |
|--------|---------|-------|
| **jdi** | `jdi [směr]` | Pohyb mezi místnostmi (sever, jih, východ, západ) |
| **vezmi** | `vezmi [předmět]` | Sebrat předmět ze země |
| **polož** | `polož [předmět]` | Položit předmět na zem |
| **batoh** | `batoh` | Zobrazit obsah batohu (inventář) |
| **prozkoumej** | `prozkoumej [cíl]` | Prozkoumat místnost, předmět nebo postavu |
| **mluv** | `mluv [postava]` | Mluvit s postavou a poslouchat její dialog |
| **pouzij** | `pouzij [předmět]` | Použít předmět (např. klíč, meč, mapu) |
| **napoveda** | `napoveda` | Zobrazit nápovědu pro aktuální situaci |
| **pomoc** | `pomoc` | Zobrazit seznam všech dostupných příkazů |
| **konec** | `konec` | Ukončit hru |

## Průběh hry

Hra se skládá z 8 navzájem propojených místností:

1. **Půda** - Startovní místo s mapou a knihou
2. **Dům babičky** - Útulný domov, kde žije babička
3. **Vesnice** - Poklidná vesnice s mečem a některými pomocníky
4. **Začarovaný les** - Rozcestí vedoucí na více míst
5. **Doupě šelem** - Nebezpečné místo, kde číhají divoké šelmy
6. **Tábor goblinů** - Sídlo goblinů, kde se nachází zlatý klíč
7. **Zlatá brána** - Magickou silou zamčená brána do Království víl
8. **Komnata harfy** - Malá místnost s vílou a zlatou harfou
9. **Trůnní sál** - Finální místo, kde se setkáte s královnou

## Jak spustit hru

### Požadavky

- **Java 21** nebo vyšší
- **Maven 3.6** nebo vyšší

### Instalace a spuštění

1. Klonujte nebo stáhněte projekt:
```bash
cd TextGame
```

2. Kompilujte projekt pomocí Maven:
```bash
mvn clean compile
```

3. Spusťte hru:
```bash
mvn exec:java -Dexec.mainClass="org.example.Main"
```

Alternativně můžete vytvořit spustitelný JAR soubor:
```bash
mvn clean package
java -jar target/TextGame-1.0-SNAPSHOT.jar
```

## Technické informace

### Použité technologie

- **Java 21** - Programovací jazyk
- **Maven** - Build management a project management
- **Gson 2.10.1** - Knihovna pro práci s JSON soubory
- **Lombok 1.18.30** - Knihovna pro zjednodušení psaní kódu (code generation)

### Architektura

Projekt je strukturován na základě **design pattern Command**:

- **Model** (`src/main/java/org/example/model/`) - Entity jako Location, Player, Item, NPC
- **Service** (`src/main/java/org/example/service/`) - Služby pro správu herního světa a parsování příkazů
- **Command** (`src/main/java/org/example/command/`) - Implementace jednotlivých příkazů
- **Controller** (`src/main/java/org/example/controller/`) - Kontrola toku hry
- **Konfigurace** (`docs/json/`) - JSON soubory s definicí herního světa a předmětů

### Struktura souborů

```
TextGame/
├── pom.xml                          # Maven konfigurační soubor
├── README.md                        # Tento soubor
├── docs/
│   └── json/
│       ├── world.json              # Definice herního světa (místnosti)
│       ├── items.json              # Definice předmětů
│       └── characters.json         # Definice postav
└── src/
    └── main/java/org/example/
        ├── Main.java               # Vstupní bod aplikace
        ├── model/                  # Datové modely
        ├── service/                # Business logika
        ├── command/                # Implementace příkazů
        └── controller/             # Řídící logika
```

## Tipy pro hraní

- **Sbírejte vše** - Prozkoumávejte každou místnost a sbírejte všechny dostupné předměty
- **Mluví s postavami** - NPCs vám mohou dát cenné informace
- **Čtěte popisy** - Popisy míst obsahují důležité detaily
- **Pořádí pohybu** - Pečlivě plánujte svou cestu, abyste neminuli všechny předměty tam, kde je potřebujete
- **Klíč a meč** - Bez těchto dvou předmětů se nemůžete dostat do Království víl

## Cíl hry

Cílem je dosáhnout **Trůnního sálu** a setkat se s královnou. Hra skončí úspěchem, jakmile se dostanete do finální místnosti.

## Autor

Textová adventura - Jaká hra pro Python/Java.

---

**Užijte si Vaši cestu do Království víl!** ✨
