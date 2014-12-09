/**Class: CIT-130-BIN1
Name: Meghan Moore
Date: 11/15/2014
Programming Assignment 11, Chapter 18 - Assignment11 class
Purpose: Implement a simple calculator.*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Assignment11 extends JFrame implements ActionListener{
  
  private double total = 0, storedInput = 0;
  private String storedOperator = "", totalDisplay = "", inputString = "";
  
  public static void main(String[] args){
   Assignment11 calculator = new Assignment11();
   calculator.setVisible(true);
  }
  
  public Assignment11(){
    setTitle("Simple Calculator by Meghan Moore");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 550);
    setVisible(true);
    
    JPanel basePanel = new JPanel();
    setLayout(new BorderLayout());
    add(basePanel,BorderLayout.CENTER);
    //basePanel.setLayout(new GridLayout(2,1));
    JPanel textPanel = new JPanel();
    textPanel.setLayout(new BorderLayout());
    basePanel.add(textPanel, BorderLayout.CENTER);
    totalField = new JTextField();
    textPanel.add(totalField);
  
    //add buttons
    JPanel buttonPanel = new JPanel();
    add(buttonPanel, BorderLayout.SOUTH);
    buttonPanel.setLayout(new GridLayout(4, 4));
    JButton button1 = new JButton("1");
    button1.addActionListener(this);
    buttonPanel.add(button1);
    JButton button2 = new JButton("2");
    button2.addActionListener(this);
    buttonPanel.add(button2);
    JButton button3 = new JButton("3");
    button3.addActionListener(this);
    buttonPanel.add(button3);
    JButton buttonDiv = new JButton("/");
    buttonDiv.addActionListener(this);
    buttonPanel.add(buttonDiv);
    JButton button4 = new JButton("4");
    button4.addActionListener(this);
    buttonPanel.add(button4);
    JButton button5 = new JButton("5");
    button5.addActionListener(this);
    buttonPanel.add(button5);
    JButton button6 = new JButton("6");
    button6.addActionListener(this);
    buttonPanel.add(button6);
    JButton buttonMult = new JButton("*");
    buttonMult.addActionListener(this);
    buttonPanel.add(buttonMult);
    JButton button7 = new JButton("7");
    button7.addActionListener(this);
    buttonPanel.add(button7);
    JButton button8 = new JButton("8");
    button8.addActionListener(this);
    buttonPanel.add(button8);
    JButton button9 = new JButton("9");
    button9.addActionListener(this);
    buttonPanel.add(button9);
    JButton buttonSub = new JButton("-");
    buttonSub.addActionListener(this);
    buttonPanel.add(buttonSub);
    JButton buttonClear = new JButton("C");
    buttonClear.addActionListener(this);
    buttonPanel.add(buttonClear);
    JButton button0 = new JButton("0");
    button0.addActionListener(this);
    buttonPanel.add(button0);
    JButton buttonEquals = new JButton("=");
    buttonEquals.addActionListener(this);
    buttonPanel.add(buttonEquals);
    JButton buttonAdd = new JButton("+");
    buttonAdd.addActionListener(this);
    buttonPanel.add(buttonAdd);
  } //end constructor
  
  public void actionPerformed(ActionEvent e){
    String buttonClick = e.getActionCommand();
    /*NOTE: example uses:
    if(e.getActionCommand().equals("A")){
      jtf.setText(jtf.getText()+"A");*/
    
    switch (buttonClick){
      case "1":
          inputString = (inputString + "1");
          totalField.setText(inputString);
          break;
      case "2":
          inputString = (inputString + "2");
          totalField.setText(inputString);
          break;
      case "3":
          inputString = (inputString + "3");
          totalField.setText(inputString);
          break;
      case "4":
          inputString = (inputString + "4");
          totalField.setText(inputString);
          break;
      case "5":
          inputString = (inputString + "5");
          totalField.setText(inputString);
          break;
      case "6":
          inputString = (inputString + "6");
          totalField.setText(inputString);
          break;
      case "7":
          inputString = (inputString + "7");
          totalField.setText(inputString);
          break;
      case "8":
          inputString = (inputString + "8");
          totalField.setText(inputString);
          break;
      case "9":
          inputString = (inputString + "9");
          totalField.setText(inputString);
          break;
      case "0":
          inputString = (inputString + "0");
          totalField.setText(inputString);
          break;
      case "+":
      case "-":
      case "*":
      case "/":
      case "=":
          operatorAction(buttonClick, inputString);
          inputString = "";
          break;
      case "C":
          inputString = "";
          total = 0;
          storedInput = 0;
          storedOperator = "";
          totalDisplay = "";
          totalField.setText(inputString);
          break;
    } //end switch
  } //end method actionPerformed
  
  public void operatorAction(String operator, String inputString){
    double input;
    
    if (inputString == "")
      input = 0;
    else
      input = Double.parseDouble(inputString.trim());
    
    if ((total != 0) & (storedOperator != "")){
      if (storedInput != 0){
        total = calculate(storedInput, input);
        storedInput = 0;
      } // end if
      else
        total = calculate(total, input);
      
      //display total:
      totalDisplay = (Double.toString(total));
      totalField.setText(totalDisplay);
      
      if (operator == "="){
        storedOperator = "";
        totalField.setText(totalDisplay);
      } //end if
      else
        storedOperator = operator;
    } //end if
    if (total == 0)
      total = input;
    if (storedOperator == ""){
      storedInput = input;
      storedOperator = operator;
    } // end else if
  } //end method opeartorAction
  
  public double calculate(double number1, double number2){
    double result = 0;
    
    switch (storedOperator){
      case "+":
        result = number1 + number2;
        break;
      case "-":
        result = number1 - number2;
        break;
      case "*":
        result = number1 * number2;
        break;
      case"/":
        result = number1 / number2;
        break;
    } //end switch
    
    return result;
  } //end method calculate
} //end class Assignment11
