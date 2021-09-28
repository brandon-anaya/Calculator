// 
// Name: Anaya, Brandon
// Project: #2
// Due:       9.26.21
// Course: CS-  2450  -01-  F21 
// 
// Description: 
// A simple calculator program.
//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JCalculator implements ActionListener {

private JButton[] buttons;
private JLabel display;

ImageIcon icon = new ImageIcon("/Users/brandonanaya/Downloads/JCalculator.png");

//Put button shapes in an array
private String[] button_Shapes = {"7", "8", "9", "/", "4", "5", "6", "x", "1",
                     "2", "3", "-", "0", "C", "=", "+"};

private int operand1, operand2, result;
private String operator;

//Create new form Calculator
public JCalculator(){

    //Create new JFrame container
    JFrame jfrm = new JFrame("Calculator");

    //Set the initial size for frame
    jfrm.setSize(500,500);

    //Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Set the calculator to center on the screen
    jfrm.setLocationRelativeTo(null);
    
    //Set the icon
    jfrm.setIconImage(icon.getImage());

    //Create label
    display = new JLabel("0", JLabel.RIGHT); 

    //Put border around display label
    display.setBorder(BorderFactory.createLineBorder(Color.black));

    //Create a grid layout
    GridLayout layout = new GridLayout(4,4);

    //Create a panel and set layout
    JPanel bottom_Panel = new JPanel();
    bottom_Panel.setLayout(layout);

    //Create an array of buttons
    buttons = new JButton[16];        

    for(int i = 0; i < button_Shapes.length; i++){
        //make new button name
        JButton btn = new JButton("" + button_Shapes[i]);
        buttons[i] = btn;
        //add action listener for each button
        btn.addActionListener(this);
        //add each button to panel
        bottom_Panel.add(btn);
    }

    //Set [=] button to default
    jfrm.getRootPane().setDefaultButton(buttons[14]);

    jfrm.addKeyListener(new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)) {
                System.out.println("(c)Brandon");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    });
    
    //Set Mnemonic to Alt+[C]
    buttons[13].setMnemonic(KeyEvent.VK_C);

    //Add label to content pane
    jfrm.add(display, BorderLayout.NORTH);

    //Add panel to content pane
    jfrm.add(bottom_Panel, BorderLayout.CENTER);

    jfrm.setVisible(true);    
    

}

@Override
public void actionPerformed(ActionEvent e) {
    JButton btn = (JButton)e.getSource();

    if(display.getText().equals("0") 
            || display.getText().equals(button_Shapes[3])
            || display.getText().equals(button_Shapes[7])
            || display.getText().equals(button_Shapes[11])
            || display.getText().equals(button_Shapes[15])){
        display.setText("");
    }

    if(btn == buttons[0] || btn == buttons[1] || btn == buttons[2]
        || btn == buttons[4] || btn == buttons[5] || btn == buttons[6]
        || btn == buttons[8] || btn == buttons[9] || btn == buttons[10]
        || btn == buttons[12]){

        display.setText("" + display.getText()+ btn.getText());

        if(display.getText().length() > 7){
            buttons[0].setEnabled(false);
            buttons[1].setEnabled(false);
            buttons[2].setEnabled(false);
            buttons[4].setEnabled(false);
            buttons[5].setEnabled(false);
            buttons[6].setEnabled(false);
            buttons[8].setEnabled(false);
            buttons[9].setEnabled(false);
            buttons[10].setEnabled(false);
            buttons[12].setEnabled(false);
        }
    }

    if(btn == buttons[3] || btn == buttons[7] || btn == buttons[11]
            || btn == buttons[15]){

        buttons[0].setEnabled(true);
        buttons[1].setEnabled(true);
        buttons[2].setEnabled(true);
        buttons[4].setEnabled(true);
        buttons[5].setEnabled(true);
        buttons[6].setEnabled(true);
        buttons[8].setEnabled(true);
        buttons[9].setEnabled(true);
        buttons[10].setEnabled(true);
        buttons[12].setEnabled(true);

        operand1 = Integer.parseInt(display.getText());
        operator = btn.getText();
        display.setText("" + operator);
    }

    if(btn == buttons[14]){

        buttons[0].setEnabled(true);
        buttons[1].setEnabled(true);
        buttons[2].setEnabled(true);
        buttons[4].setEnabled(true);
        buttons[5].setEnabled(true);
        buttons[6].setEnabled(true);
        buttons[8].setEnabled(true);
        buttons[9].setEnabled(true);
        buttons[10].setEnabled(true);
        buttons[12].setEnabled(true);

        operand2 = Integer.parseInt(display.getText());            
        if(operator.equals(button_Shapes[3])){
            if(operand2 == 0){
                display.setText("Div by 0");
            }
            else{
                result = operand1 / operand2;
            }
        }
        else if(operator.equals(button_Shapes[7])){
            result = operand1 * operand2;
        }
        else if(operator.equals(button_Shapes[11])){
            result = operand1 - operand2;
        }
        else if(operator.equals(button_Shapes[15])){
            result = operand1 + operand2;
        }

        if(String.valueOf(result).length() > 8){
            display.setText("Overflow");
        }
        else{
            display.setText(String.valueOf(result));
        }

    }

    if(btn == buttons[13]){
        buttons[0].setEnabled(true);
        buttons[1].setEnabled(true);
        buttons[2].setEnabled(true);
        buttons[4].setEnabled(true);
        buttons[5].setEnabled(true);
        buttons[6].setEnabled(true);
        buttons[8].setEnabled(true);
        buttons[9].setEnabled(true);
        buttons[10].setEnabled(true);
        buttons[12].setEnabled(true);

        display.setText("0");
    }
}


public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable(){
        public void run(){
            new JCalculator();
        }
    });
    
}
}
