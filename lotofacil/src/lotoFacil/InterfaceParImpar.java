package lotoFacil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class InterfaceParImpar {

    private static int numeroSorteado;

    public static void jogar() {
        Random random = new Random();
        numeroSorteado = random.nextInt();

        JFrame frame = new JFrame("Adivinhação Par ou Ímpar");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Digite um número inteiro:");
        label.setBounds(20, 30, 200, 20);
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(220, 30, 30, 20);
        panel.add(textField);

        JButton button = new JButton("Apostar");
        button.setBounds(100, 80, 100, 30);
        panel.add(button);

        button.addActionListener(e -> {
            String input = textField.getText();
            try {
                int numero = Integer.parseInt(input);
                verificarAposta(numero);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número inteiro válido.");
            }
        });
    }

    private static void verificarAposta(int numero) {
        boolean randomPar = numeroSorteado % 2 == 0;
        boolean escolhaPar = numero % 2 == 0;

        if (randomPar == escolhaPar) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena! O número sorteado era " +
                    (randomPar ? "par" : "ímpar") + " e a premiação foi para números " +
                    (randomPar ? "pares" : "ímpares") + ".");
        }
    }

}
