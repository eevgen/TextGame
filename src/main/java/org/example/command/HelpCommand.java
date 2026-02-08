package org.example.command;

public class HelpCommand implements Command {

    public HelpCommand() {
    }

    @Override
    public void execute() {
        System.out.println("\n═══════════ PŘÍKAZY ═══════════");
        System.out.println("jdi [směr]        - pohyb mezi místnostmi");
        System.out.println("                    (sever, jih, vychod, zapad)");
        System.out.println("vezmi [předmět]   - sebrat předmět");
        System.out.println("poloz [předmět]   - položit předmět");
        System.out.println("batoh             - zobrazit inventář");
        System.out.println("prozkoumej [cíl]  - prozkoumat místnost/předmět/postavu");
        System.out.println("mluv [postava]    - mluvit s postavou");
        System.out.println("pouzij [předmět]  - použít předmět");
        System.out.println("napoveda          - dodatečná rada pro aktuální situaci");
        System.out.println("pomoc             - zobrazit tuto nápovědu");
        System.out.println("konec             - ukončit hru");
        System.out.println("═══════════════════════════════\n");
    }

    @Override
    public void undo() {
    }
}
