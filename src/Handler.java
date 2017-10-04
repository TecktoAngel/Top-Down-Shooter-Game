import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> objects = new LinkedList<GameObject>();

	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject tempObject = objects.get(i);
			tempObject.tick();
		}
	}

	public void render(Graphics graphics) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject tempObject = objects.get(i);
			tempObject.render(graphics);
		}
	}

	public void addObject(GameObject tempObject) {
		objects.add(tempObject);
	}
	
	public void removeObject(GameObject tempObject) {
		objects.remove(tempObject);
	}

}
