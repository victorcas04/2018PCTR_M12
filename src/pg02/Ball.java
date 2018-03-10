package pg02;
import java.awt.Image;
import javax.swing.ImageIcon;

// Transform the code to be used safely in a concurrent context.  
public class Ball {
	private String Ball = "Ball.png"; 

	private double x,y,dx,dy;
	private final double speed = 5;
	private double v,fi;
	private Image image;
	private final int IMG_TAM_X,IMG_TAM_Y;

	public Ball() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(Ball));
		image = ii.getImage();
		
		IMG_TAM_X = ii.getIconWidth();
		IMG_TAM_Y = ii.getIconHeight();
		
		x = Billiards.Width/4-16;
		y = Billiards.Height/2-16;
		v = speed;
		fi =  Math.random() * Math.PI * 2;
	}

	public void move() {
		v = v*Math.exp(-v/1000);
		dx = v*Math.cos(fi);
		dy = v*Math.sin(fi);
		if (Math.abs(dx) < 1 && Math.abs(dy) < 1) {
			dx = 0;
			dy = 0;
		}
		
		x += dx;   
		y += dy;

		postCondition(x, y);
		reflect();

	}

	private void reflect() {
		if (Math.abs(x + IMG_TAM_X - Board.RIGHTBOARD) <  Math.abs(dx)) {
			fi = Math.PI - fi;
		}
		if (Math.abs(y + IMG_TAM_Y - Board.BOTTOMBOARD) <  Math.abs(dy)) {
			fi = - fi;
		}
		if (Math.abs(x - Board.LEFTBOARD) <  Math.abs(dx)) {
			fi = Math.PI - fi;
		}
		if (Math.abs(y - Board.TOPBOARD) <  Math.abs(dy)) {
			fi = - fi;
		}
	}

	public int getX() {
		return (int)x;
	}
	
	public int getY() {
		return (int)y;
	}
	
	public double getFi() {
		return fi;
	}

	public double getdr() {
		return Math.sqrt(dx*dx+dy*dy);
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public void stopBall() {
		this.v = 0;
	}
	
	public void restartSpeed() {
		this.v = speed;
	}
	
	private synchronized void postCondition (double pos1, double pos2){
		
		//pos1(x) entre la coordenada derecha y la izquierda.
		assert pos1>Board.LEFTBOARD && pos1<Board.RIGHTBOARD;
		//pos2(y) entre la coodernada superior y la inferior.
		assert pos2<Board.TOPBOARD && pos2>Board.BOTTOMBOARD;
	}

}

