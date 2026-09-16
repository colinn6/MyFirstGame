import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Drawing extends JPanel implements KeyListener
  {
    private int a; //for x direction movement
    private int b; //for y direction movement
    private int x;
    private int y;
    private int score;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private int x3movement;
    private int x4;
    private int y4;
    private int x4movement;
    private int x5;
    private int y5;
    private int y5movement;      
    
    public Drawing()
    {
      addKeyListener(this);
      setFocusable(true);
      a = 200; //blue block position
      b = 200; //blue block position
      x = 800; //red block position
      y = 200; //red block position
      x2 = ((int)(Math.random()*650)+50); //coin position
      y2 = ((int)(Math.random()*250)+50);
      x3 = 800;
      y3 = 85;
      x3movement = ((int)(Math.random()*20)+5);
      x4 = 800;
      y4 = 310;
      x4movement = ((int)(Math.random()*20)+5);
      x5 = 380;
      y5 = -100;
      y5movement = ((int)(Math.random()*20)+5);      
    }

    

    public void keyPressed(KeyEvent k)
    {
      int val = k.getKeyCode(); //stores the keypress in val


      
      if(val == KeyEvent.VK_LEFT || val == KeyEvent.VK_A)
      {
        a-=5;
        if(score>=25)
          a-=5.5;
      }
      
      if(val == KeyEvent.VK_RIGHT || val == KeyEvent.VK_D)
      {
        a+=5;  
        if(score>=25)
          a+=5.5;        
      } 
      
      if(val == KeyEvent.VK_UP)
      {
        b-=5;   
        if(score>=25)
          b-=5.5;        
      } 

      if(val == KeyEvent.VK_DOWN)
      {
        b+=5;  
        if(score>=25)
          b+=5.5;        
      }       
      repaint();
    }

    public void keyReleased(KeyEvent k)
    {       
           
    }      

    public void keyTyped(KeyEvent k)
    {

    }
    public void paintComponent(Graphics g)
    {
      super.paintComponent(g); //required
      this.setBackground(new Color(209, 255, 233));
      
      g.setColor(new Color(245, 223, 144));
      g.setFont(new Font("Serif", Font.BOLD, 45));  
      g.drawString(("Coins: " + score), 25, 50);
        
      g.setColor(new Color(123, 163, 227));
      g.fillRect(a, b, 40, 40); //x pos, y pos, length, height
                                           //a and b added for movement
      g.setColor(new Color(227, 142, 123));
      g.fillRect(x, y, 100, 50);

      g.setColor(new Color(245, 223, 144));
      g.fillOval(x2, y2, 20, 20);

      x -= 10;

      if(x < -100)
        x = 800;
      
      if(a==200 && b==200 && score==0)      
      {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 450);
        
        g.setColor(new Color(245, 223, 144));
        g.setFont(new Font("Serif", Font.BOLD, 33));  
        g.drawString("USE THE ARROW KEYS TO MOVE", 75, 150);  
        g.drawString("AVOID THE RED RECTANGLES", 95, 200); 
        g.drawString("COLLECT THE COINS TO EARN POINTS", 15, 250);         
      }
      


      if((a <= x2+20 || a+40 <= x2+20) && (a+40 >= x2 || a >= x2) && (b <= y2+20 || b+40 <= y2+20 ) && (b+40 >= y2 || b >= y2))
      {
        score++;
        x2 = ((int)(Math.random()*650)+50);
        y2 = ((int)(Math.random()*250)+50);
      }

      if((a <= x+99 || a+30 <= x+99) && (a+30 >= x || a >= x) && (b <= y+49 || b+30 <= y+49) && (b+30 >= y || b >= y))
      {
        score = 0;
        a = 200;
        b = 200;
        x = 800;
        y = 200;      
      }
      
      if(score>=10)
      {
        g.setColor(new Color(227, 142, 123));
        g.fillRect(x3, y3, 100, 50);
        x3 -= x3movement;   
        
        if(x3 < -100)
          x3 = 800;

        if((a <= x3+99 || a+30 <= x3+99) && (a+30 >= x3 || a >= x3) && (b <= y3+49 || b+30 <= y3+49) && (b+30 >= y3 || b         >= y3))
        {
          score = 0;
          a = 200;
          b = 200;
          x = 800;
          y = 200;      
        }        
      }

      if(score>=20)
      {
        g.setColor(new Color(227, 142, 123));
        g.fillRect(x4, y4, 100, 50);
        x4 -= x4movement;   
        
        if(x4 < -100)
          x4 = 800;
        if((a <= x4+99 || a+30 <= x4+99) && (a+30 >= x4 || a >= x4) && (b <= y4+49 || b+30 <= y4+49) && (b+30 >= y4 || b         >= y4))
        {
          score = 0;
          a = 200;
          b = 200;
          x = 800;
          y = 200;      
        }
      }      

      if(score>=30)
      {
        g.setColor(new Color(227, 142, 123));
        g.fillRect(x5, y5, 50, 100);
        y5 += y5movement;   
        
        if(y5 > 400)
          y5 = -100;
        if((a <= x5+49 || a+30 <= x5+49) && (a+30 >= x5 || a >= x5) && (b <= y5+99 || b+30 <= y5+99) && (b+30 >= y5 || b >= y5))
        {
          score = 0;
          a = 200;
          b = 200;
          x = 800;
          y = 200;
          y5 = -100;
        }        
      }      
      
      if((a <= x2+10 && a >= x2-10) && (b <= y2+10 && b >= y2-10))
      {
        score++;
        x2 = ((int)(Math.random()*650)+50);
        y2 = ((int)(Math.random()*250)+50);
      }
    }
  }