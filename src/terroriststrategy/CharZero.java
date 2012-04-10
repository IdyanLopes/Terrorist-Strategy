package terroriststrategy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javaPlay.GameEngine;
import javaPlay.Keyboard;
import javaPlay.Sprite;

public class CharZero extends ObjetoComMovimento {

    Sprite sprite;
    int vida;
    int velocidade;

    public CharZero() {

        try {            
            this.sprite = new Sprite("resources/nave.png", 4, 64, 64);                        
        } catch (Exception ex) {
            System.out.println("Imagem não encontrada: " + ex.getMessage());
        }

        this.x = 400;
        this.y = 272;
        this.vida = 666;
    }

    public void step(long timeElapsed){
        Keyboard teclado = GameEngine.getInstance().getKeyboard();                   

        if( teclado.keyDown( Keys.NUM_1) ){
            this.velocidade = 50;
        } else {
            this.velocidade = 12;
        }
        
        if( teclado.keyDown( Keys.ESQUERDA) && teclado.keyDown( Keys.CIMA) ){
            this.sprite.setCurrAnimFrame(8);
            this.moveEsquerdaCima(this.velocidade);

        } else if ( teclado.keyDown( Keys.ESQUERDA ) && teclado.keyDown( Keys.BAIXO) ){
            this.sprite.setCurrAnimFrame(6);
            this.moveEsquerdaBaixo(this.velocidade);

        } else if ( teclado.keyDown( Keys.DIREITA ) && teclado.keyDown( Keys.CIMA) ){
            this.sprite.setCurrAnimFrame(2);
            this.moveDireitaCima(this.velocidade);

        } else if ( teclado.keyDown( Keys.DIREITA ) && teclado.keyDown( Keys.BAIXO) ){
            this.sprite.setCurrAnimFrame(4);
            this.moveDireitaBaixo(this.velocidade);

        } else if( teclado.keyDown( Keys.DIREITA ) ){
            this.sprite.setCurrAnimFrame(3);
            this.moveDireita(this.velocidade);

        } else if( teclado.keyDown( Keys.ESQUERDA ) ){
            this.sprite.setCurrAnimFrame(7);
            this.moveEsquerda(this.velocidade);

        } else if( teclado.keyDown( Keys.CIMA ) ){
            this.sprite.setCurrAnimFrame(1);
            this.moveCima(this.velocidade);

        } else if( teclado.keyDown( Keys.BAIXO ) ){
            this.sprite.setCurrAnimFrame(5);
            this.moveBaixo(this.velocidade);

        }
    }

    public void draw(Graphics g) {        
        g.setColor(Color.white);
        g.drawString(this.vida+"", this.x+5, this.y-15);

        this.sprite.draw(g, this.x, this.y);        
    }
       
    public Rectangle getRetangulo(){
        return new Rectangle(this.x+4, this.y+4, 56, 56);
    }
}
