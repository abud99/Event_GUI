/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawPanel extends JFrame
{
 private DrawObjects panel = new DrawObjects();
 private JPanel BPanel = new JPanel();
 private JFrame window = new JFrame();

 //constructor
 DrawPanel(){
    buildGUI(); 
 }

 void buildGUI(){
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     window.setLayout(new GridLayout(2,2));
     window.add(panel);
     window.add(BPanel);

      //define buttons and add to panel
      JButton rect = new JButton("Rect");
      JButton oval = new JButton("Ellipse");
      JButton Blue = new JButton("Blue");
      JButton Magneta = new JButton("Magneta");
      JButton Delete = new JButton("Delete");
      JButton Green = new JButton("Green");

      
   

   
      
      
      
      
      
      
      
      BPanel.add(rect);
      BPanel.add(oval);
      BPanel.add(Blue);
      BPanel.add(Magneta);
      BPanel.add(Delete);
      BPanel.add(Green);
      

      rect.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e)
              {
                  panel.setType(1);
              }
      });

      oval.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e)
              {
              panel.setType(2);
              }
          }); 
      
      
      
        Blue.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e)
              {
              panel.setColor(Color.blue);
              }
          }); 
      
        Green.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e)
              {
              panel.setColor(Color.green);
              }
          }); 
        
      
      Magneta.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             panel.setColor(Color.magenta);
         }
     });
      
       Delete.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             panel.eraseSelected();
         }
     });
       
            

       Action Rectangle = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        panel.setType(1);
    }
};
panel.getInputMap().put(KeyStroke.getKeyStroke("R"),
                            "rectangle");
panel.getActionMap().put("rectangle", Rectangle);



 Action ellipse = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        panel.setType(2);
    }
};
panel.getInputMap().put(KeyStroke.getKeyStroke("E"),
                            "ellipse");
panel.getActionMap().put("ellipse", ellipse);




 Action nextShape = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        panel.getNextShape();
        System.out.println("Right pressed");
    }
};
panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),
                            "nextshape");
panel.getActionMap().put("nextshape", nextShape);



 Action previousShape = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        panel.getPreviousShape();
        System.out.println("left pressed");
    }
};
panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),
                            "previousshape");
panel.getActionMap().put("previousshape", previousShape);
         
         
       
Action blue = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        panel.setColor(Color.blue);
        System.out.println("Blue pressed");
    }
};
panel.getInputMap().put(KeyStroke.getKeyStroke("B"),
                            "blue");
panel.getActionMap().put("blue",blue);




Action green = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        panel.setColor(Color.green);
        System.out.println("green pressed");
    }
};
panel.getInputMap().put(KeyStroke.getKeyStroke("G"),
                            "green");
panel.getActionMap().put("green", green);






Action magneta = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        panel.setColor(Color.MAGENTA);
        System.out.println("magneta pressed");
    }
};
panel.getInputMap().put(KeyStroke.getKeyStroke("M"),
                            "mag");
panel.getActionMap().put("mag", magneta);
         
         
         Action delete = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        panel.eraseSelected();
        System.out.println("delete function pressed pressed");
    }
};
panel.getInputMap().put(KeyStroke.getKeyStroke("D"),
                            "delt");
panel.getActionMap().put("delt", delete);
         





     

 Action cancel = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
         System.out.println("esc pressed"); // some times the keys aren't called? I am debugging using print statements but some times they are not called? NOT MY FAULT
        panel.cancelSelection();
       
    }
};
panel.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"),  "can");
panel.getActionMap().put("can", cancel);
         
            
            
            
            
       
       
       
      
      
      

      window.setVisible(true);
      window.setSize(1024, 800);     
}



}