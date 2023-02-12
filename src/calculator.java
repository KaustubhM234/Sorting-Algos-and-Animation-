import java.awt.*;
import java.awt.event.*;

public class calculator extends Frame { 
            TextField tf1; 
            TextField tf2; 
            Label l1; 
            Button b1,b2,b3,b4;
                    calculator() { 
                          setTitle("Calculator"); 
                          tf1 = new TextField(); 
                          tf1.setBounds(100, 50, 85, 20);
                          tf2 = new TextField(); 
                          tf2.setBounds(100, 100, 85, 20); 
                          b1 = new Button("Add"); 
                          b1.setBounds(50,220,60,40);
                          b2 = new Button("Subtract");
                          b2.setBounds(140,220,60,40);
                          b3 = new Button("Multiply");
                          b3.setBounds(230,220,60,40);
                          b4 = new Button("Divide");
                          b4.setBounds(320,220,60,40);
                          l1 = new Label(""); 
                          l1.setBounds(50, 150, 85, 20); 
                          add(b1); 
                          add(b2);
                          add(b3);
                          add(b4);
                          add(tf1); 
                          add(tf2); 
                          add(l1); 
                          setSize(400,400); 
                          setVisible(true); 

        b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) { 
                    int a = Integer.parseInt(tf1.getText());
                    int b = Integer.parseInt(tf2.getText()); 
                    int c = a + b; 
                    l1.setText("Addition is = " + String.valueOf(c)); 
                                      }
                });
        b2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) { 
                    int a = Integer.parseInt(tf1.getText());
                    int b = Integer.parseInt(tf2.getText()); 
                    int c = a - b; 
                    l1.setText("Subtraction is = " + String.valueOf(c)); 
                    }
                });  
        b3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) { 
                    int a = Integer.parseInt(tf1.getText());
                    int b = Integer.parseInt(tf2.getText()); 
                    int c = a * b; 
                    l1.setText("Multiplication is = " + String.valueOf(c)); 
                    }
                });
        b4.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) { 
                        int a = Integer.parseInt(tf1.getText());
                        int b = Integer.parseInt(tf2.getText()); 
                        int c = a / b; 
                        l1.setText("Division is = " + String.valueOf(c)); 
                        }
                });    
            } 
public static void main(String []args) { 
                   new calculator();
          } 
}