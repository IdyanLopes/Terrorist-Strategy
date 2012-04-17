package terroriststrategy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javaPlay.GameEngine;
import javaPlay.Keyboard;
import javaPlay.Sprite;

public class CharZero extends ObjetoComMovimento {

    Sprite spriteAtual;
    Sprite spriteCima;
    Sprite spriteBaixo;
    Sprite spriteEsquerda;
    Sprite spriteDireita;
    int velocidade;
    private int frame;
    private int timeElapsedInMiliseconds;

    public CharZero() {

        try {            
            this.spriteAtual = new Sprite("resources/terrorist/BBMCIMA.png", 3, 26, 26);
            this.spriteCima = new Sprite("resources/terrorist/BBMCIMA.png", 3, 26, 26);
            this.spriteBaixo = new Sprite("resources/terrorist/BBMBAIXO.png", 3, 26, 26); 
            this.spriteEsquerda = new Sprite("resources/terrorist/BBMESQUERDA.png", 3, 26, 26);
            this.spriteDireita = new Sprite("resources/terrorist/BBMDIREITA.png", 1, 26, 26);
        } catch (Exception ex) {
            System.out.println("Imagem não encontrada: " + ex.getMessage());
        }

        this.x = 420;
        this.y = 290;
        this.altura = 26;
        this.largura = 26;
    }

    public void step(long timeElapsed){
        Keyboard teclado = GameEngine.getInstance().getKeyboard();
        
        velocidade = 4;
      
        
       

        if( teclado.keyDown( Keys.D ) ){
            this.spriteDireita.setCurrAnimFrame(this.frame);
            this.moveDireita(this.velocidade);
            this.spriteAtual = spriteDireita;
            this.timeElapsedInMiliseconds += timeElapsed;

            if(this.timeElapsedInMiliseconds > 200){
                if(this.frame >=8){
                    this.frame = 0;
                }
                this.frame = (this.frame + 1);
                this.spriteAtual.setCurrAnimFrame(this.frame);
                this.timeElapsedInMiliseconds -= 200;
            }
            
        } else if( teclado.keyDown( Keys.A ) ){
            this.spriteDireita.setCurrAnimFrame(this.frame);
            this.moveEsquerda(this.velocidade);
            this.spriteAtual = spriteEsquerda;
            this.timeElapsedInMiliseconds += timeElapsed;

            if(this.timeElapsedInMiliseconds > 200){
                if(this.frame >=5){
                    this.frame = 0;
                }
                this.frame = (this.frame + 1);
                this.spriteAtual.setCurrAnimFrame(this.frame);
                this.timeElapsedInMiliseconds -= 200;
            }

        } else if( teclado.keyDown( Keys.W ) ){
            this.spriteDireita.setCurrAnimFrame(this.frame);
            this.moveCima(this.velocidade);
            this.spriteAtual = spriteCima;
           this.timeElapsedInMiliseconds += timeElapsed;

            if(this.timeElapsedInMiliseconds > 200){
                if(this.frame >=5){
                    this.frame = 0;
                }
                this.frame = (this.frame + 1);
                this.spriteAtual.setCurrAnimFrame(this.frame);
                this.timeElapsedInMiliseconds -= 200;
            }

        } else if( teclado.keyDown( Keys.S ) ){
            this.spriteDireita.setCurrAnimFrame(this.frame);
            this.moveBaixo(this.velocidade);
            this.spriteAtual = spriteBaixo;
            this.timeElapsedInMiliseconds += timeElapsed;

            if(this.timeElapsedInMiliseconds > 200){
                if(this.frame >=5){
                    this.frame = 0;
                }
                this.frame = (this.frame + 1);
                this.spriteAtual.setCurrAnimFrame(this.frame);
                this.timeElapsedInMiliseconds -= 200;
            }

        }
        
        
        
        
    }

    public void draw(Graphics g) {        
        g.setColor(Color.white);        

        this.spriteAtual.draw(g, this.x, this.y);        
    }
       
    public Rectangle getRetangulo(){
        return new Rectangle(this.x+4, this.y+4, 56, 56);
    }
}
