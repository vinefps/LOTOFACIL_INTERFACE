package lotoFacil;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Scanner;

public class InterfaceMenu {
    public InterfaceMenu() {
        JFrame frame = new JFrame("Loto Facil");
        frame.setSize(400, 300); // Define o tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        interfaceItems(panel);

        frame.setVisible(true);



    }
    private void interfaceItems(JPanel panel) {
        JLabel titleLabel = new JLabel("Menu:");

        titleLabel.setBounds(10, 20, 80, 25);
        panel.add(titleLabel);

        JButton btnApostarNum = new JButton("Apostar de 0 a 100");
        btnApostarNum.setBounds(10, 50, 180, 25);
        panel.add(btnApostarNum);

        JButton btnApostarLetra = new JButton("Apostar de A a Z");
        btnApostarLetra.setBounds(10, 80, 180, 25);
        panel.add(btnApostarLetra);

        JButton btnApostarParImpar = new JButton("Apostar em par ou ímpar");
        btnApostarParImpar.setBounds(10, 110, 180, 25);
        panel.add(btnApostarParImpar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(10, 140, 180, 25);
        panel.add(btnSair);


        btnApostarNum.addActionListener(e -> {
               new InterfaceApostaNum();
        });

        btnApostarLetra.addActionListener(e -> {
                InterfaceLetra.jogar();
        });

        btnApostarParImpar.addActionListener( e -> {
                InterfaceParImpar.jogar();
        });

        btnSair.addActionListener(e -> {
                System.out.println("Obrigado por participar");
                System.exit(0);
        });
    }


        public void menuGame(){

            System.out.println(
                    "Menu:\n " +
                            "1)Apostar de 0 a 100\n" +
                            "2)Apostar de A a Z\n" +
                            "3)Apostar em par ou ímpar\n" +
                            "0)Sair"
            );



            Scanner scanner = new Scanner(System.in);

            int userMenu = scanner.nextInt();

            switch (userMenu) {
                case 0:
                    System.out.println("Obrigado por participar");
                    return;
                case 1:
                    new InterfaceApostaNum();
                    break;
                case 2:
                    new InterfaceLetra();
                    break;
                case 3:
                    new InterfaceParImpar();
                    break;
                default:
                    System.out.println("Valor inválido");

            }

        }
}


