package pg02;

public class Movimiento extends Thread{
	Ball ball;
	Board tablero;
	
	public Movimiento(Ball bola, Board tab) {
		this.ball=bola;
		this.tablero=tab;
	}
	
	public void run(){
		while(true) {
			try {
				ball.move();
				ball.reflect();
				tablero.repaint();
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
