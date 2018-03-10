package pg02;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pg02.Movimiento;

@SuppressWarnings("serial")
public class Billiards extends JFrame {
	
	public static int Width = 800;
	public static int Height = 600;

	private JButton b_start, b_stop, b_restart;

	private Board board;

	private int n_grupo = 12;
	private final int N_BALL = n_grupo + 3;
	private Ball[] balls;
	private Thread[] hilos;
	private boolean started = false;
	
	public Billiards() {
		
		board = new Board();
		board.setForeground(new Color(0, 128, 0));
		board.setBackground(new Color(0, 128, 0));

		initBalls();

		b_start = new JButton("Empezar");
		b_start.addActionListener(new StartListener());
		b_stop = new JButton("Parar");
		b_stop.addActionListener(new StopListener());
		b_restart = new JButton("Reiniciar");
		b_restart.addActionListener(new RestartListener());

		JPanel p_Botton = new JPanel();
		p_Botton.setLayout(new FlowLayout());
		p_Botton.add(b_start);
		p_Botton.add(b_stop);
		p_Botton.add(b_restart);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(board, BorderLayout.CENTER);
		getContentPane().add(p_Botton, BorderLayout.PAGE_END);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Width, Height);
		setLocationRelativeTo(null);
		setTitle("Práctica programación concurrente objetos móviles independientes");
		setResizable(false);
		setVisible(true);
	}
	
	private void initBalls() {
		System.out.println("Creando bolas.");
		balls = new Ball[N_BALL];
		for(int i = 0; i < N_BALL; i++) {
			balls[i] = new Ball();
		}
		board.setBalls(balls);
	}
	
	private class StartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(!started) {
				System.out.println("Start pulsado...");
				if(balls == null) {
					System.out.println("Bolas no creadas.");
					initBalls();
				}
				System.out.println("Iniciando hilos.");
				hilos = new Thread[N_BALL];
				
				for(int i = 0; i < N_BALL; i++) {
					balls[i].restartSpeed();
					hilos[i] = new Thread(new Movimiento(balls[i], board));
					hilos[i].start();
				}
			}
			started = true;
		}
	}
	
	private class StopListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Code is executed when stop button is pushed
			if(started) {
				System.out.println("Stop pulsado...");
				for(Thread t: hilos) {
					t.interrupt();
					t= null;
				}
				for(Ball b: balls) {
					b.stopBall();
				}
			}
			started = false;
		}
	}
	
	private class RestartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Code is executed when restart button is pushed
			System.out.println("Restart pulsado...");
			if(hilos != null) {
				for(Thread t: hilos) {
					t.interrupt();
					t= null;
				}
			}
			initBalls();
			board.repaint();
			started = false;
		}
	}
	
	public static void main(String[] args) {
		new Billiards();
	}

}