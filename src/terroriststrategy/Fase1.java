package terroriststrategy;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import javaPlay.GameStateController;
import javaPlayExtras.CenarioComColisao;
import javaPlayExtras.CenarioComColisaoCima;
import javax.swing.JOptionPane;

public class Fase1 implements GameStateController{

  private CenarioComColisaoCima cenario;
  private CharZero charZero;
  private MenuEsquerdo menuEsquerdo;

  public void load() {              
      try {
        this.cenario = new CenarioComColisaoCima("resources/cenario1.scn");
    } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
      
    this.menuEsquerdo = new MenuEsquerdo();
    this.charZero = new CharZero(); 
    this.cenario.adicionaObjeto(this.charZero);
  }

  public void step(long timeElapsed) {
     this.charZero.step(timeElapsed); 
     
     
     this.cenario.step(timeElapsed);
     
     
     
  }

  public void draw(Graphics g) {
      
      g.fillRect(0, 0, 800, 640);
      this.charZero.draw(g);
      this.menuEsquerdo.draw(g);
      this.cenario.draw(g);
  }

  public void unload() {}
  public void start() {}
  public void stop() {}

}