package lotoFacil;

import java.util.Scanner;
import java.util.Random;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class InterfaceLetra {

    private static char letraEscolhida;
    private static char letraAposta;

    public static void jogar() {
        Random random = new Random();
        letraEscolhida = (char) (random.nextInt(26) + 'A');

        JFrame frame = new JFrame("Adivinhação de Letra");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);


        lugarComponents(panel);

        frame.setVisible(true);
    }

    private static void lugarComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Digite uma letra (A a Z):");
        label.setBounds(20, 30, 200, 20);
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(220, 30, 30, 20);
        panel.add(textField);

        JButton button = new JButton("Apostar");
        button.setBounds(100, 80, 100, 30);
        panel.add(button);

        button.addActionListener(e -> {
            String texto = textField.getText().toUpperCase();
            if (!texto.isEmpty()) {
                letraAposta = texto.charAt(0);
                verificarAposta();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, digite uma letra.");
            }
        });
    }

    private static void verificarAposta() {
        if (Character.isLetter(letraAposta)) {
            if (letraAposta == letraEscolhida) {
                JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais.");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraEscolhida + ".");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
        }
    }
}
