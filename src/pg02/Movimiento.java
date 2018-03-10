package pg02;
import pg02.Board;

public class Movimiento implements Runnable{

	private Ball b;
	private Board tab;
	
	public Movimiento(Ball b, Board tab) {
		this.b = b;
		this.tab = tab;
	}
	
	@Override
	public void run() {
		try {
			while(true) {						
				b.move();
				tab.repaint();
				Thread.sleep(30);
			}
		}catch (InterruptedException e) { return; }
	}

}
