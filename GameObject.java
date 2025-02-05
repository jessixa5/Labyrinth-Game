import java.awt.Graphics;
import java.awt.Image;


public class GameObject {
    /**
     * The coordinates of the top left corner
     */
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image image;
    protected boolean isWall;

    public GameObject(int x, int y, int width, int height, Image image, boolean isWall) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        this.isWall = isWall;
    }
    
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

    public Point getCoords(){
        return new Point(x/40,y/30);
    }
}
