import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -6112428091888191314L;

	private boolean isRunning = false;
	private Thread thread;
	private Handler handler;
	

	public Game() {
		new Window(1000, 563, "Top-Down Shooter", this);
		start();
		
		handler = new Handler();
		
		handler.addObject(new Box(100, 100, ID.Block));
	}

	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	private void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics graphics = bs.getDrawGraphics();
		
		//////////////////////////////////////////////////
		graphics.setColor(Color.RED);
		graphics.fillRect(0, 0, 1000, 563);
		
		handler.render(graphics);
		//////////////////////////////////////////////////
		
		graphics.dispose();
		bs.show();
	}

	private void tick() {
		handler.tick();
		
	}

	public static void main(String[] args) {
		new Game();
	}
}
