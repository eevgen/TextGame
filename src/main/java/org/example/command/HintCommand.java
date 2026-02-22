package org.example.command;

import org.example.model.Player;

public class HintCommand implements Command {

    private Player player;

    public HintCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        String locationName = player.getCurrentLocation().getName();

        String hint = switch (locationName) {
            case "Půda" ->
                "Podívej se po předmětech na půdě. Mapa by se ti mohla hodit!";
            case "Dům babičky" ->
                "Babička je tu s tebou. Chvíli si s ní povězení... nebo se jdi podívat na jih.";
            case "Vesnice" ->
                "Meč je tvůj nejlepší kamarád na cestě do neznáma. Vezmi si jej!";
            case "Začarovaný les" ->
                "Les je nebezpečný. Na východě čekají šelmy - bez meče se tam jít nemůžeš!\nJih vede do tábora goblinů...";
            case "Doupě šelem" ->
                "Šelmy jsou agresivní! Máš meč? Použij ho a pusť se dál!";
            case "Tábor goblinů" ->
                "Goblini tě mohou pustit dál, pokud si vezmeš jejich klíč! Podívej se kolem...";
            case "Zlatá brána" ->
                "Zlatá brána je zamčená! Máš zlatý klíč? Použij jej!";
            case "Komnata harfy" ->
                "Krásná hudba Víly tě vede dál... jdi na jih!";
            case "Trůnní sál" ->
                "BRAVOOO! Dosáhl jsi cíle! Tvoje cesta byla úspěšná! 🎉";
            default ->
                "Tady neznám žádnou zvláštní radu...";
        };

        System.out.println("\n💡 NÁPOVĚDA: " + hint + "\n");
    }

    @Override
    public void undo() {
    }
}
