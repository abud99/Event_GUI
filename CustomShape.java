/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Color;
import java.awt.Shape;

/**
 *
 * @author b00069477
 */
public class CustomShape {
    private Shape shape;
    private Color next_color = Color.black;
    private boolean selected = false;
    
    CustomShape(Shape s, Color c)
    {
        shape = s;
        next_color = c;
    }
    
    
    public boolean isSelected()
    {
        return selected;
    }
    
    
    public void setSelected(boolean s)
    {
        this.selected = s;
    }
    
    
    
    public void setShape(Shape s)
    {
        this.shape = s;
    }
    
    
   public Shape getShape()
   {
       return this.shape;
   }
   
   public void setColor(Color c)
   {
       next_color = c;
   }
   
   public Color getColor()
   {
       return next_color;
   }
   
   
    
    
}
