import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

 public class TicTacToe implements ActionListener,turnFirst,checking,winOfO,winOfX,turnOfO,turnOfX {

        Random random = new Random();
        JFrame frame = new JFrame();
        JPanel title_panel = new JPanel();
        JPanel button_panel = new JPanel();
        JLabel textfield = new JLabel();
        JButton[] buttons = new JButton[9];
        boolean player1_turn;

        TicTacToe(){
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.getContentPane().setBackground(new Color(255, 192, 203));
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);

            textfield.setBackground(new Color(0, 191, 255)); // tlo napisu
            textfield.setForeground(new Color(0, 0, 205)); //kolor napisu
            textfield.setFont(new Font("Monospaced", Font.BOLD, 70));
            textfield.setHorizontalAlignment(JLabel.CENTER);
            textfield.setText("TIC TAC TOE");
            textfield.setOpaque(true);

            title_panel.setLayout(new BorderLayout());
            title_panel.setBounds(0, 0, 800, 100);

            button_panel.setLayout(new GridLayout(3, 3));
            button_panel.setBackground(new Color(255, 105, 180));

            for (int i = 0; i < 9; i++) {
                buttons[i] = new JButton();
                button_panel.add(buttons[i]);
                buttons[i].setFont(new Font("Monospaced", Font.BOLD, 100));
                buttons[i].setFocusable(false);
                buttons[i].addActionListener(this);
                buttons[i].setBackground(new Color(135, 206, 250)); // kolor przycikow
            }

            title_panel.add(textfield);
            frame.add(title_panel, BorderLayout.NORTH);
            frame.add(button_panel);

            firstTurn();
        }

        public void firstTurn(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            if(random.nextInt(2)==0){
                player1_turn=true;
                textfield.setText("X turn");
                textfield.setForeground(new Color(255, 105, 180));
            }
            else{
                player1_turn=false;
                textfield.setText("O turn");
                textfield.setForeground(new Color(0, 0, 205));
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == buttons[i]) {
                    if (player1_turn) {
                        if (buttons[i].getText() == "") {
                            xTurn(i);
                            check();
                        }
                    } else {
                        if (buttons[i].getText() == "") {
                            oTurn(i);
                            check();
                        }
                    }
                }
            }
        }

        public void xTurn(int i){
            buttons[i].setForeground(new Color(255, 105, 180));
            buttons[i].setText("X");
            player1_turn = false;
            textfield.setText("O turn");
            textfield.setForeground(new Color(0, 0, 205));
        }

        public void oTurn(int i){
            buttons[i].setForeground(new Color(0, 0, 205));
            buttons[i].setText("O");
            player1_turn = true;
            textfield.setText("X turn");
            textfield.setForeground(new Color(255, 105, 180));
        }

        public void check(){
            if(
                    (buttons[0].getText()=="X")&&
                            (buttons[1].getText()=="X")&&
                            (buttons[2].getText()=="X")){
                xWins(0,1,2);
            }
            if(
                    (buttons[3].getText()=="X")&&
                            (buttons[4].getText()=="X")&&
                            (buttons[5].getText()=="X")){
                xWins(3,4,5);
            }
            if(
                    (buttons[6].getText()=="X")&&
                            (buttons[7].getText()=="X")&&
                            (buttons[8].getText()=="X")){
                xWins(6,7,8);
            }
            if(
                    (buttons[0].getText()=="X")&&
                            (buttons[3].getText()=="X")&&
                            (buttons[6].getText()=="X")){
                xWins(0,3,6);
            }
            if(
                    (buttons[1].getText()=="X")&&
                            (buttons[4].getText()=="X")&&
                            (buttons[7].getText()=="X")){
                xWins(1,4,7);
            }
            if(
                    (buttons[2].getText()=="X")&&
                            (buttons[5].getText()=="X")&&
                            (buttons[8].getText()=="X")){
                xWins(2,5,8);
            }
            if(
                    (buttons[0].getText()=="X")&&
                            (buttons[4].getText()=="X")&&
                            (buttons[8].getText()=="X")){
                xWins(0,4,8);
            }
            if(
                    (buttons[2].getText()=="X")&&
                            (buttons[4].getText()=="X")&&
                            (buttons[6].getText()=="X")){
                xWins(2,4,6);
            }

            if(
                    (buttons[0].getText()=="O")&&
                            (buttons[1].getText()=="O")&&
                            (buttons[2].getText()=="O")){
                oWins(0,1,2);
            }
            if(
                    (buttons[3].getText()=="O")&&
                            (buttons[4].getText()=="O")&&
                            (buttons[5].getText()=="O")){
                oWins(3,4,5);
            }
            if(
                    (buttons[6].getText()=="O")&&
                            (buttons[7].getText()=="O")&&
                            (buttons[8].getText()=="O")){
                oWins(6,7,8);
            }
            if(
                    (buttons[0].getText()=="O")&&
                            (buttons[3].getText()=="O")&&
                            (buttons[6].getText()=="O")){
                oWins(0,3,6);
            }
            if(
                    (buttons[1].getText()=="O")&&
                            (buttons[4].getText()=="O")&&
                            (buttons[7].getText()=="O")){
                oWins(1,4,7);
            }
            if(
                    (buttons[2].getText()=="O")&&
                            (buttons[5].getText()=="O")&&
                            (buttons[8].getText()=="O")){
                oWins(2,5,8);
            }
            if(
                    (buttons[0].getText()=="O")&&
                            (buttons[4].getText()=="O")&&
                            (buttons[8].getText()=="O")){
                oWins(0,4,8);
            }
            if(
                    (buttons[2].getText()=="O")&&
                            (buttons[4].getText()=="O")&&
                            (buttons[6].getText()=="O")) {
                oWins(2, 4, 6);
            }
        }

        public void oWins(int a, int b, int c){
            buttons[a].setBackground(new Color(0, 0, 205));
            buttons[b].setBackground(new Color(0, 0, 205));
            buttons[c].setBackground(new Color(0, 0, 205));

            for(int i=0;i<9;i++){
                buttons[i].setEnabled(false);
            }
            textfield.setText("O wins");
            textfield.setForeground(new Color(0, 0, 205));
        };

        public void xWins(int a,int b,int c){

            buttons[a].setBackground(new Color(255, 105, 180));
            buttons[b].setBackground(new Color(255, 105, 180));
            buttons[c].setBackground(new Color(255, 105, 180));

            for(int i=0;i<9;i++){
                buttons[i].setEnabled(false);
            }
            textfield.setText("X wins");
            textfield.setForeground(new Color(255, 105, 180));
        };
}