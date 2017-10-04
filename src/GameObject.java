import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int x, y;
	protected float speedX = 0, speedY = 0;
	protected ID id;
	
	public GameObject (int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public abstract void tick();
	public abstract void render(Graphics graphics);
	public abstract Rectangle getBounds();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public float getSpeedY() {
		return speedY;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
	
}
