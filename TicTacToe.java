import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToe
{
  static JPanel content = new JPanel();
  



  public TicTacToe() {}
  


  public static void main(String[] args)
  {
    TicTacToe.Drawer displayPanel = new TicTacToe.Drawer();
    JButton newGame = new JButton("New Game!");
    TicTacToe.ButtonHandler listener = new TicTacToe.ButtonHandler();
    newGame.addActionListener(listener);
    
    content.setLayout(new java.awt.BorderLayout());
    content.add(displayPanel, "Center");
    content.add(newGame, "South");
    content.setBackground(new Color(175, 175, 250));
    
    JFrame window = new JFrame("Tic-Tac-Toe");
    window.setContentPane(content);
    window.setResizable(false);
    window.setDefaultCloseOperation(3);
    window.setLocation(100, 100);
    window.setSize(390, 330);
    window.setVisible(true);
  }
  
  public static class ButtonHandler implements java.awt.event.ActionListener { public ButtonHandler() {}
    
    public void actionPerformed(ActionEvent e) { TicTacToe.Drawer.xn = 3;TicTacToe.Drawer.yn = 3;TicTacToe.Drawer.t = 0;TicTacToe.Drawer.c = 0;TicTacToe.Drawer.c2 = 0;TicTacToe.Drawer.xn2 = 3;TicTacToe.Drawer.yn2 = 3;
      TicTacToe.Drawer.is1 = false;TicTacToe.Drawer.is2 = false;TicTacToe.Drawer.is3 = false;TicTacToe.Drawer.sign = true;TicTacToe.Drawer.player = true;TicTacToe.Drawer.line = false;
      for (int i = 0; i < 3; i++)
      {
        for (int j = 0; j < 3; j++)
        {
          TicTacToe.Drawer.p[i][j] = 2;
        }
      }
      TicTacToe.content.repaint();
    }
  }
  
  public static class Drawer extends JPanel implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener
  {
    public void useCustomCursor(String imageResourceName) {
      ClassLoader cl = TicTacToe.class.getClassLoader();
      java.net.URL resourceURL = cl.getResource(imageResourceName);
      if (resourceURL != null) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        java.awt.Image image = toolkit.createImage(resourceURL);
        Point hotSpot = new Point(0, 0);
        java.awt.Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "smiley");
        setCursor(cursor);
      }
    }
    
    private void playAudioResource(String audioResourceName)
    {
      ClassLoader cl = TicTacToe.class.getClassLoader();
      java.net.URL resourceURL = cl.getResource(audioResourceName);
      

      java.applet.AudioClip sound = javax.swing.JApplet.newAudioClip(resourceURL);
      sound.play();
    }
    


    public Drawer()
    {
      setBackground(new Color(175, 175, 250));
      addMouseListener(this);
      addMouseMotionListener(this);
    }
    

    public void mousePressed(MouseEvent evt)
    {
      if (line) return;
      Graphics g = getGraphics();
      
      int x = evt.getX();
      int y = evt.getY();
      int x3 = Math.floor((x - 110) / 50);
      int y3 = Math.floor((y - 80) / 50);
      if ((x > 110) && (x < 260) && (y > 80) && (y < 230) && (p[x3][y3] == 2) && (evt.getButton() == 1))
      {
        xn = x3;
        yn = y3;
        g.setColor(new Color(175, 175, 250));
        g.fillRect(110, 60, 150, 200);
        gameBoard();
        players();
        g.setColor(new Color(190, 190, 250));
        g.fillRect(12 + x3 * 50 + 100, 81 + y3 * 50 + 1, 48, 48);
      }
      else {}
    }
    



    public void mouseClicked(MouseEvent evt) {}
    


    public void mouseReleased(MouseEvent evt)
    {
      if (line) return;
      Graphics g = getGraphics();
      g.setColor(new Color(175, 175, 250));
      
      int x = evt.getX();
      int y = evt.getY();
      int x1 = Math.floor((x - 110) / 50);
      int y1 = Math.floor((y - 80) / 50);
      if ((x > 110) && (x < 260) && (y > 80) && (y < 230) && (x1 == xn) && (y1 == yn) && (evt.getButton() == 1))
      {
        g.setColor(new Color(175, 175, 250));
        Functs.pause(300L);
        is1 = false;
        if (player) p[x1][y1] = 0; else
          p[x1][y1] = 1;
        g.fillRect(110, 80, 150, 200);
        gameBoard();
        players();
      }
      else {
        return;
      }
      
      int[][] pos = new int[3][2];
      int xs = 110;int ys = 80;int ap = 0;long st = System.currentTimeMillis();
      
      for (int i = 0; i < 3; i++)
      {

        if ((p[i][0] == p[i][1]) && (p[i][0] == p[i][2]) && (p[i][2] != 2))
        {
          line = true;
          for (int ci = 0; ci < 3; ci++)
          {
            pos[ci][0] = i;
            pos[ci][1] = ci;
          }
          g.setColor(Color.BLACK);
          st = System.currentTimeMillis();
          for (ap = 0; ap < 150; ap += 4) {
            g.drawLine(135 + 50 * i, 80, 135 + 50 * i, 80 + ap);
            Functs.pause(1L, st);
            
            st = System.currentTimeMillis();
          }
        }
        
        if ((p[0][i] == p[1][i]) && (p[0][i] == p[2][i]) && (p[2][i] != 2))
        {
          line = true;
          for (int ci = 0; ci < 3; ci++)
          {
            pos[ci][0] = ci;
            pos[ci][1] = i;
          }
          g.setColor(Color.BLACK);
          st = System.currentTimeMillis();
          for (ap = 0; ap < 150; ap += 4) {
            g.drawLine(110, 105 + 50 * i, 110 + ap, 105 + 50 * i);
            Functs.pause(1L, st);
            
            st = System.currentTimeMillis();
          }
        }
        
        if ((p[0][0] == p[1][1]) && (p[1][1] == p[2][2]) && (p[2][2] != 2))
        {
          line = true;
          for (int ci = 0; ci < 3; ci++)
          {
            pos[ci][0] = ci;
            pos[ci][1] = ci;
          }
          g.setColor(Color.BLACK);
          st = System.currentTimeMillis();
          for (ap = 0; ap < 150; ap += 4) {
            g.drawLine(110, 80, 110 + ap, 80 + ap);
            Functs.pause(1L, st);
            
            st = System.currentTimeMillis();
          }
        }
        
        if ((p[0][2] == p[1][1]) && (p[2][0] == p[0][2]) && (p[0][2] != 2))
        {
          line = true;
          for (int ci = 0; ci < 3; ci++)
          {
            pos[ci][0] = ci;
            pos[ci][1] = ci;
          }
          g.setColor(Color.BLACK);
          st = System.currentTimeMillis();
          for (ap = 0; ap < 150; ap += 4) {
            g.drawLine(260, 80, 260 - ap, 80 + ap);
            Functs.pause(1L, st);
            
            st = System.currentTimeMillis();
          }
        }
      }
      if (line == true)
      {
        Font f = new Font("Times New Roman", 1, 18);
        g.setColor(Color.blue);
        g.setFont(f);
        if (player) {
          st = System.currentTimeMillis();
          for (int t = 0; t > -20; t--) {
            Functs.pause(30L, st);
            g.setColor(Color.blue);
            g.drawString("First Player Won!", 0, 250);
            g.setColor(Color.black);
            
            g.setColor(Color.red);
            g.fillRect(39, 90 + Math.floor(t / 2), 43, 10 - Math.floor(t / 2) + 1);
            g.setColor(Color.black);
            g.drawOval(40, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
            
            g.drawOval(41, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
            g.setColor(Color.red);
            g.fillRect(39, 90 + Math.floor(t / 2), 42, (10 - Math.floor(t / 2)) / 2);
            
            g.setColor(Color.blue);
            g.drawString("Second Player Lost!", 225, 250);
            
            g.setColor(Color.red);
            g.fillRect(299, 90 + Math.floor(-t / 2), 43, 10 - Math.floor(-t / 2) + 1);
            g.setColor(Color.black);
            g.drawOval(300, 90 + Math.floor(-t / 2), 40, 10 - Math.floor(-t / 2));
            
            g.drawOval(301, 90 + Math.floor(-t / 2), 40, 10 - Math.floor(-t / 2));
            
            g.setColor(Color.red);
            g.fillRect(299, 90 + Math.floor(-t / 2), 42, (10 - Math.floor(-t / 2)) / 2);
            st = System.currentTimeMillis();
          }
        }
        else {
          st = System.currentTimeMillis();
          for (int t = 0; t > -20; t--) {
            Functs.pause(30L, st);
            g.setColor(Color.blue);
            g.drawString("First Player Lost!", 0, 250);
            g.setColor(Color.black);
            
            g.setColor(Color.red);
            g.fillRect(39, 90 + Math.floor(-t / 2), 43, 10 - Math.floor(-t / 2) + 1);
            g.setColor(Color.black);
            g.drawOval(40, 90 + Math.floor(-t / 2), 40, 10 - Math.floor(-t / 2));
            
            g.drawOval(41, 90 + Math.floor(-t / 2), 40, 10 - Math.floor(-t / 2));
            g.setColor(Color.red);
            g.fillRect(39, 90 + Math.floor(-t / 2), 42, (10 - Math.floor(-t / 2)) / 2);
            
            g.setColor(Color.blue);
            g.drawString("Second Player Won!", 225, 250);
            
            g.setColor(Color.red);
            g.fillRect(299, 90 + Math.floor(t / 2), 43, 10 - Math.floor(t / 2) + 1);
            g.setColor(Color.black);
            g.drawOval(300, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
            
            g.drawOval(301, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
            
            g.setColor(Color.red);
            g.fillRect(299, 90 + Math.floor(t / 2), 42, (10 - Math.floor(t / 2)) / 2);
            st = System.currentTimeMillis();
          }
        }
      }
      else {
        boolean lm = false;

        label1694:
        for (int i = 0; i < 3; i++)
        {
          for (int j = 0; j < 3; j++)
          {
            if (p[i][j] == 2)
            {
              lm = true;
              break label1694;
            } }
        }
        if (!lm)
        {
          Font f = new Font("Times New Roman", 1, 18);
          g.setColor(Color.blue);
          g.setFont(f);
          g.drawString("No Chance for any player's winning,Draw", 30, 250);
        } else {
          Font f = new Font("Times New Roman", 1, 14);
          g.setColor(Color.blue);
          g.setFont(f);
          if (!player) {
            g.drawString("First Player's Turn", 130, 250);
          } else
            g.drawString("Second Player's Turn", 130, 250);
        } }
      player = !player;
    }
    
    public void mouseEntered(MouseEvent evt)
    {
      v = true;
      Graphics g = getGraphics();
      long st = System.currentTimeMillis();
      for (int t = 1; t > -20; t--) {
        Functs.pause(30L, st);
        g.setColor(Color.black);
        
        g.setColor(Color.red);
        g.fillRect(39, 90 + Math.floor(t / 2), 43, 10 - Math.floor(t / 2) + 1);
        g.setColor(Color.black);
        g.drawOval(40, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
        
        g.drawOval(41, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
        
        g.setColor(Color.red);
        g.fillRect(39, 90 + Math.floor(t / 2), 42, (10 - Math.floor(t / 2)) / 2);
        

        g.setColor(Color.red);
        g.fillRect(299, 90 + Math.floor(t / 2), 43, 10 - Math.floor(t / 2) + 1);
        g.setColor(Color.black);
        g.drawOval(300, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
        
        g.drawOval(301, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
        
        g.setColor(Color.red);
        g.fillRect(299, 90 + Math.floor(t / 2), 42, (10 - Math.floor(t / 2)) / 2);
        st = System.currentTimeMillis();
      }
    }
    
    public void mouseExited(MouseEvent evt)
    {
      v = true;
      Graphics g = getGraphics();
      long st = System.currentTimeMillis();
      for (int t = 1; t < 20; t++) {
        Functs.pause(30L, st);
        

        g.setColor(Color.red);
        g.fillRect(39, 90 + Math.floor(t / 2), 43, 10 - Math.floor(t / 2) + 1);
        g.setColor(Color.black);
        g.drawOval(40, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
        
        g.drawOval(41, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
        
        g.setColor(Color.red);
        g.fillRect(39, 90 + Math.floor(t / 2), 42, (10 - Math.floor(t / 2)) / 2);
        

        g.setColor(Color.red);
        
        g.fillRect(299, 90 + Math.floor(t / 2), 43, 10 - Math.floor(t / 2) + 1);
        g.setColor(Color.black);
        g.drawOval(300, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
        
        g.drawOval(301, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
        
        g.setColor(Color.red);
        g.fillRect(299, 90 + Math.floor(t / 2), 42, (10 - Math.floor(t / 2)) / 2);
        st = System.currentTimeMillis();
      }
    }
    
    public void mouseMoved(MouseEvent evt)
    {
      if (line) return;
      int x = evt.getX();int t = 0;
      int y = evt.getY();
      int x2 = Math.floor((x - 110) / 50);
      int y2 = Math.floor((y - 80) / 50);
      Graphics g = getGraphics();
      if ((x2 == xn2) && (y2 == yn2)) return;
      if ((x <= 110) || (x >= 260) || (y <= 80) || (y >= 230))
      {
        if (is1)
        {
          g.setColor(new Color(175, 175, 250));
          g.fillRect(110, 80, 150, 200);
          gameBoard();
          players();
          Font m = new Font("Times New Roman", 1, 14);
          g.setColor(Color.blue);
          g.setFont(m);
          if (player) {
            g.drawString("First Player's Turn", 130, 250);
          } else
            g.drawString("Second Player's Turn", 130, 250);
          is1 = false;
          xn2 = 3;
          yn2 = 3;
          if (v == true)
          {
            g.setColor(Color.red);
            g.fillRect(39, 90 + Math.floor(t / 2), 43, 10 - Math.floor(t / 2) + 1);
            g.setColor(Color.black);
            g.drawOval(40, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
            
            g.drawOval(41, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
            
            g.setColor(Color.red);
            g.fillRect(39, 90 + Math.floor(t / 2), 42, (10 - Math.floor(t / 2)) / 2);
            

            g.setColor(Color.red);
            
            g.fillRect(299, 90 + Math.floor(t / 2), 43, 10 - Math.floor(t / 2) + 1);
            g.setColor(Color.black);
            g.drawOval(300, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
            
            g.drawOval(301, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
            
            g.setColor(Color.red);
            g.fillRect(299, 90 + Math.floor(t / 2), 42, (10 - Math.floor(t / 2)) / 2);
          } }
        return;
      }
      


      if ((x > 110) && (x < 260) && (y > 80) && (y < 230) && (p[x2][y2] == 2))
      {
        g.setColor(new Color(175, 175, 250));
        g.fillRect(110, 80, 150, 200);
        gameBoard();
        players();
        g.setColor(new Color(165, 165, 250));
        g.fill3DRect(11 + x2 * 50 + 100 + 1, 81 + y2 * 50 + 1, 48, 48, true);
        Font m = new Font("Times New Roman", 1, 14);
        g.setColor(Color.blue);
        g.setFont(m);
        if (player) {
          g.drawString("First Player's Turn", 130, 250);
        } else
          g.drawString("Second Player's Turn", 130, 250);
        is1 = true;
        xn2 = x2;
        yn2 = y2;
        if (v == true)
        {
          g.setColor(Color.red);
          g.fillRect(39, 90 + Math.floor(t / 2), 43, 10 - Math.floor(t / 2) + 1);
          g.setColor(Color.black);
          g.drawOval(40, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
          
          g.drawOval(41, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
          
          g.setColor(Color.red);
          g.fillRect(39, 90 + Math.floor(t / 2), 42, (10 - Math.floor(t / 2)) / 2);
          

          g.setColor(Color.red);
          
          g.fillRect(299, 90 + Math.floor(t / 2), 43, 10 - Math.floor(t / 2) + 1);
          g.setColor(Color.black);
          g.drawOval(300, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
          
          g.drawOval(301, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
          
          g.setColor(Color.red);
          g.fillRect(299, 90 + Math.floor(t / 2), 42, (10 - Math.floor(t / 2)) / 2);
        }
      }
    }
    


    static int xn = 3; static int yn = 3; static int t = 0; static int c = 0; static int c2 = 0; static int xn2 = 3; static int yn2 = 3;
    static boolean is1 = false; static boolean is2 = false; static boolean is3 = false; static boolean sign = true; static boolean player = true; static boolean line = false; static boolean v = false;
    static int[][] p = { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 } };
    public void mouseDragged(MouseEvent evt) {}
    
    private class Anim implements java.awt.event.ActionListener {
      private Anim() {}
      
      public void actionPerformed(ActionEvent evt) { int tp = TicTacToe.Drawer.t;
        
        if (Math.abs(tp) >= 19)
        {
          TicTacToe.Drawer.c2 += 1;
          tp = 0;
          TicTacToe.Drawer.sign = !TicTacToe.Drawer.sign;


        }
        else if (TicTacToe.Drawer.sign) { tp++;
        } else { tp--;
        }
        TicTacToe.Drawer.t = tp;
        TicTacToe.Drawer.c += 1;
        repaint();
      }
    }
    
    public void paintComponent(Graphics g) {
      g.setColor(new Color(175, 175, 250));
      g.fillRect(0, 0, 1050, 1000);
      gameBoard(g);
      players(g);
      
      Font k = new Font("Times New Roman", 1, 14);
      g.setColor(Color.blue);
      g.setFont(k);
      g.drawString("First Player's Turn", 130, 250);
      Font f = new Font("Times New Roman", 1, 20);
      g.setColor(Color.red);
      g.setFont(f);
      g.drawString("Play Tic-Tac-Toe!", 110, 20);
      
      g.setColor(Color.red);
      g.fillOval(10, 20, 100, 100);
      g.setColor(Color.black);
      g.drawOval(10, 20, 100, 100);
      
      g.drawOval(11, 21, 98, 98);
      g.drawOval(12, 22, 96, 96);
      int t = -7;
      
      g.setColor(Color.black);
      g.drawOval(25, 40 - t, 30, 30 + 2 * t);
      g.setColor(Color.white);
      g.fillOval(26, 41 - t, 28, 28 + 2 * t);
      g.setColor(Color.blue);
      if (40 - t <= 50) g.fillOval(35, 50, 10, 10); else {
        g.fillOval(35, 50 + (t - 20), 10, 10 + 2 * t);
      }
      g.setColor(Color.black);
      g.drawOval(65, 40 - t, 30, 30 + 2 * t);
      g.setColor(Color.white);
      g.fillOval(66, 41 - t, 28, 28 + 2 * t);
      g.setColor(Color.blue);
      if (40 - t <= 50) g.fillOval(75, 50, 10, 10); else {
        g.fillOval(75, 50 + (t - 10), 10, 10 + 2 * t);
      }
      g.setColor(Color.black);
      g.drawOval(40, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
      
      g.drawOval(41, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
      
      g.setColor(Color.red);
      g.fillRect(39, 90 + Math.floor(t / 2), 42, (10 - Math.floor(t / 2)) / 2);
      

      g.setColor(Color.red);
      g.fillOval(270, 20, 100, 100);
      g.setColor(Color.black);
      g.drawOval(270, 20, 100, 100);
      
      g.drawOval(271, 21, 98, 98);
      g.drawOval(272, 22, 96, 96);
      
      g.setColor(Color.black);
      g.drawOval(285, 40 - t, 30, 30 + 2 * t);
      g.setColor(Color.white);
      g.fillOval(286, 41 - t, 28, 28 + 2 * t);
      g.setColor(Color.blue);
      if (40 - t <= 50) g.fillOval(295, 50, 10, 10); else {
        g.fillOval(295, 50 + (t - 20), 10, 10 + 2 * t);
      }
      g.setColor(Color.black);
      g.drawOval(325, 40 - t, 30, 30 + 2 * t);
      g.setColor(Color.white);
      g.fillOval(326, 41 - t, 28, 28 + 2 * t);
      g.setColor(Color.blue);
      if (40 - t <= 50) g.fillOval(335, 50, 10, 10); else {
        g.fillOval(335, 50 + (t - 10), 10, 10 + 2 * t);
      }
      g.setColor(Color.black);
      g.drawOval(300, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
      
      g.drawOval(301, 90 + Math.floor(t / 2), 40, 10 - Math.floor(t / 2));
      
      g.setColor(Color.red);
      g.fillRect(299, 90 + Math.floor(t / 2), 42, (10 - Math.floor(t / 2)) / 2);
      useCustomCursor("Cursor/starfsh.png");
    }
    
    public void gameBoard() {
      Graphics g = getGraphics();
      for (int i = 0; i < 2; i++)
      {
        g.setColor(Color.black);
        g.drawLine(110, 130 + 50 * i, 260, 130 + 50 * i);
        g.drawLine(60 + 50 * i + 100, 80, 60 + 50 * i + 100, 230);
        g.drawLine(111, 130 + 50 * i + 1, 261, 130 + 50 * i + 1);
        g.drawLine(60 + 50 * i + 100 + 1, 81, 60 + 50 * i + 100 + 1, 231);
      }
    }
    
    public void gameBoard(Graphics g) {
      for (int i = 0; i < 2; i++)
      {
        g.setColor(Color.black);
        g.drawLine(110, 130 + 50 * i, 260, 130 + 50 * i);
        g.drawLine(60 + 50 * i + 100, 80, 60 + 50 * i + 100, 230);
        g.drawLine(111, 130 + 50 * i + 1, 261, 130 + 50 * i + 1);
        g.drawLine(60 + 50 * i + 100 + 1, 81, 60 + 50 * i + 100 + 1, 231);
      }
    }
    
    public void players() {
      Graphics g = getGraphics();
      for (int i = 0; i < 3; i++)
      {
        for (int j = 0; j < 3; j++)
        {
          if (p[j][i] == 0)
          {
            g.setColor(Color.red);
            g.drawLine(20 + j * 50 + 100, 90 + i * 50, 50 + j * 50 + 100, 120 + i * 50);
            g.drawLine(50 + j * 50 + 100, 90 + i * 50, 20 + j * 50 + 100, 120 + i * 50);
          }
          else if (p[j][i] == 1)
          {
            g.setColor(Color.blue);
            g.drawOval(20 + j * 50 + 100, 90 + i * 50, 30, 30);
          }
        }
      }
    }
    
    public void players(Graphics g)
    {
      for (int i = 0; i < 3; i++)
      {
        for (int j = 0; j < 3; j++)
        {
          if (p[j][i] == 0)
          {
            g.setColor(Color.red);
            g.drawLine(20 + j * 50 + 100, 90 + i * 50, 50 + j * 50 + 100, 120 + i * 50);
            g.drawLine(50 + j * 50 + 100, 90 + i * 50, 20 + j * 50 + 100, 120 + i * 50);
          }
          else if (p[j][i] == 1)
          {
            g.setColor(Color.blue);
            g.drawOval(20 + j * 50 + 100, 90 + i * 50, 30, 30);
          }
        }
      }
    }
  }
}
