package br.unip.aps.cc2;


import br.unip.aps.cc2.visao.DialogCalculaGEE;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class App {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Não foi possível carregar o GUI");
            System.exit(-1);
        }

        DialogCalculaGEE calculaGEE = new DialogCalculaGEE();
        calculaGEE.createAndShowGUI();
    }
}
