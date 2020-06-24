/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author b00069477
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.*;

class DrawObjects extends JPanel
{
private int x1,x2,y1,y2;
private int type = 1;//default draw type
private Color next_color = Color.black;
private boolean selected;
private CustomShape selected_shape;
private int index = -1;
private ArrayList<CustomShape> shapes = new ArrayList();


public DrawObjects()
{
    init();
}




public void init(){
      setBackground(Color.WHITE);
      addMouseListener(new MouseAdapter()
       {
          public void mousePressed(MouseEvent m)
          {
               x1 = m.getX();
               y1 = m.getY();
               repaint();
                      
               
          }
          
          @Override
          public void mouseClicked(MouseEvent m)        
          {
              for(int i =0; i< shapes.size(); i++)
              {
           
                  shapes.get(i).setSelected(false);
                  if (shapes.get(i).getShape().contains(m.getX(), m.getY()))
                  {
                      shapes.get(i).setSelected(true);
                    //System.out.println("selected");
                      selected_shape = shapes.get(i); // my bug with selecting shape is that whenever I make a rectangle then try to select it, a small rectangle is made inside from the click, that's why some time it works weirdly
                      index = i;
                      break;
                  }
                  
                  selected_shape = null;
                  index = -1;
                  
                      
              }
              

              
              repaint();
              
              
          }
                

          @Override
          public void mouseReleased(MouseEvent m)
          {
              CustomShape temp = null;
               x2 = m.getX();
               y2 = m.getY();
               if (type == 1)
               {
                     temp = makeRectangle(x1, y1, x2, y2);
                     shapes.add(temp);
                     System.out.println("From add rectangle = " + shapes.size()); //debugging
               }
              
               else if (type == 2)
               {
                   temp = makeEllipse(x1,y1,x2,y2);
                   shapes.add(temp);
                   System.out.println("From add ellipse = " + shapes.size()); //debugging
               }
               repaint();
          }
        });

      addMouseMotionListener(new MouseMotionAdapter()
        {
           @Override
           public void mouseDragged(MouseEvent m)
              {
                 x2 = m.getX();
                 y2 = m.getY();
                 repaint();
              }
          });
}

public void setType(int arg){
    type = arg;
}

@Override
  public void paintComponent(Graphics g)
  { 
      Graphics2D g2D = (Graphics2D) g;
      super.paintComponent(g);
      

      
      for (CustomShape s : shapes)
      {
          //g2D.setPaint(next_color);
       
          g2D.setPaint(s.getColor());
          g2D.draw(s.getShape());
          g2D.fill(s.getShape());
          repaint();
      
            if(s.isSelected())
          {
              g2D.setPaint(Color.RED);
              g2D.draw(s.getShape());
              repaint();
          }
              
          
      }    
        if (x1 != 0 && x2 != 0 && y2 != 0 && y1 != 0) 
        { //outline     
            CustomShape r = null;
            if (type == 1)
            {
                r = makeRectangle(x1, y1, x2, y2);
                g2D.setPaint(Color.LIGHT_GRAY);
                g2D.draw(r.getShape());
               
            }
            else if (type == 2)
            {   
                r = makeEllipse(x1,y1,x2,y2);
                g2D.setPaint(Color.LIGHT_GRAY);
                g2D.draw(r.getShape());
                
            }
      }
      
      
      
  }
  
  
  public void eraseSelected()
  {
      shapes.remove(selected_shape);
      repaint();
      System.out.println(shapes.size());
  }
  
  
  public void setColor(Color col)
  {
      
     this.next_color = col;
  }
  
  
  public void getPreviousShape()
  {
    
      for(int i = 0; i < shapes.size(); i++)
      {
          shapes.get(i).setSelected(false);
          
      }
 
      index--;
      
       if(index < 0)
       {
           index = shapes.size() - 1;
       }
        
       selected_shape = shapes.get(index);
       selected_shape.setSelected(true);
      repaint();
  }
  
  
  
   public void getNextShape()
  {
      
      
       for(int i = 0; i < shapes.size(); i++)
      {
          shapes.get(i).setSelected(false);
          
      }
      

      index++;
      if (index > shapes.size());
      {
          index = 0;
      }
      
      selected_shape = shapes.get(index);
      selected_shape.setSelected(true);
      repaint();
      
      
  }
   
   
   
   public void cancelSelection()
   {
       selected_shape = null;
       for(int i =0; i < shapes.size(); i++)
       {
           shapes.get(i).setSelected(false);
       }
       
       repaint();
   }


   private CustomShape makeRectangle(int x1, int y1, int x2, int y2) {
      return new CustomShape(new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2)), new Color(next_color.getRGB()));
    }
   private CustomShape makeEllipse(int x1, int y1, int x2, int y2) {
           
       return new CustomShape(new Ellipse2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2)), new Color(next_color.getRGB()));
   
    }
  
  
    }