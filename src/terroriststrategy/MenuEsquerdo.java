
package terroriststrategy;

import java.awt.Color;
import java.awt.Graphics;
import javaPlay.GameObject;


public class MenuEsquerdo extends GameObject{
    
   
    public MenuEsquerdo(){
        
        this.x = 800;
        this.y = 0;
              
        
    }
    
    
    public void step(long timeElapsed) {
       
    }

    
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(800, 0, 200, 640);
        
       
    }
    
    
    
    
    
    
    
    
    
}
