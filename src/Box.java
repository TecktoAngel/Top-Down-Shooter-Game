import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Box extends GameObject{

	public Box(int x, int y, ID id) {
		super(x, y, id);
		
		//speedX = 1;
	}

	public void tick() {
		x += speedX;
		y += speedY;
	}

	public void render(Graphics graphics) {
		graphics.setColor(Color.BLUE);
		graphics.fillRect(x, y, 32, 32);
	}

	public Rectangle getBounds() {
		return null;
	}

}
