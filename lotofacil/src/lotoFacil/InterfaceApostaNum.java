package lotoFacil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;


public class InterfaceApostaNum {
    private JTextField userNumberField;
    private JButton playButton;
    private JTextArea resultArea;
    private Random random;
    private Scanner scanner;

    private JFrame frame;


    public InterfaceApostaNum() {
        random = new Random();
        scanner = new Scanner(System.in);

        frame = new JFrame("Aposta Num");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        JLabel label = new JLabel("Escolha um número de 0 a 100:");
        label.setBounds(10, 20, 200, 20);
        frame.add(label);

        userNumberField = new JTextField();
        userNumberField.setBounds(220, 20, 50, 20);
        frame.add(userNumberField);

        playButton = new JButton("Jogar");
        playButton.setBounds(10, 50, 100, 30);
        frame.add(playButton);

        resultArea = new JTextArea();
        resultArea.setBounds(10, 90, 260, 60);
        resultArea.setEditable(false);
        frame.add(resultArea);


        playButton.addActionListener(e -> jogar());

        frame.setVisible(true);
    }

    public void jogar() {
        int userNumber;
        int randomNumber;
        boolean decider = false;

        try {
            userNumber = Integer.parseInt(userNumberField.getText());

            if (userNumber < 0 || userNumber > 100) {
                resultArea.setText("Valor inválido! Digite o valor novamente.");
                return;
            }

            randomNumber = random.nextInt(101);

            if (userNumber == 0) {
                resultArea.setText("Obrigado por participar");
                scanner.close();
                frame.setVisible(false);

            }

            if (randomNumber == userNumber) {
                JOptionPane.showMessageDialog(null, "Você venceu!");

            } else {
                resultArea.setText("Que pena! O número sorteado foi " + randomNumber);
            }

        } catch (NumberFormatException ex) {
            resultArea.setText("Por favor, digite um número válido.");
        }
    }
}
