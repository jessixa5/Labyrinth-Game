import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Dragon extends GameObject {
    
    private Movement direction;
    private Timer animation;

    /**
     * Sets the position and the sprite of the dragon. Also starts an animation for the sprite of the dragon.
     * @param x
     * @param y 
     */
    public Dragon(int x, int y) {
        super(x, y, 40, 30, new ImageIcon("data/enemy/walkS/enemy_walkA_0000.png").getImage(), false);
        chooseDirection();
        animation = new Timer(1000/28, new Animate());
        animation.start();
    }
    
    public void move(){
        this.x += direction.x*40;
        this.y += direction.y*30;
    }
    
    /**
     * Randomly chooses a direction
     */
    public void chooseDirection(){
        Movement direction = Movement.SOUTH;
        int randomDirection = (int) Math.round(Math.random()*3) + 1;
        switch(randomDirection){
            case 1: direction = Movement.SOUTH; break;
            case 2: direction = Movement.EAST; break;
            case 3: direction = Movement.NORTH; break;
            case 4: direction = Movement.WEST;
        }
        this.direction = direction;
    }
    
    /**
     * Checks if the coordinates of the neighboring tiles match with the player's position. 
     * @param hero The player
     * @return a boolean value
     */
    public boolean catches(Player hero){
        Point heroCoords = hero.getCoords();
        Point enemyCoords = this.getCoords();
        
        if(enemyCoords.equals(heroCoords) ||
           enemyCoords.addDirection(Movement.SOUTH).equals(heroCoords) ||
           enemyCoords.addDirection(Movement.SW).equals(heroCoords)    ||
           enemyCoords.addDirection(Movement.WEST).equals(heroCoords)  ||
           enemyCoords.addDirection(Movement.NW).equals(heroCoords)    ||
           enemyCoords.addDirection(Movement.NORTH).equals(heroCoords) ||
           enemyCoords.addDirection(Movement.NE).equals(heroCoords)    ||
           enemyCoords.addDirection(Movement.EAST).equals(heroCoords)  ||
           enemyCoords.addDirection(Movement.SE).equals(heroCoords) ) 
             return true;
        else return false;
    }
    
    public Movement getDirection(){
        return direction;
    }
    
    /**
     * Used in a Timer object to loop through 13 pictures of the dragon twice every second.
     */
    class Animate implements ActionListener{
        private int frame = 0;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            frame = (frame+1)%14;
            String stringPath = frame >= 10 ? String.valueOf(frame) : "0"+frame;
            image = new ImageIcon("data/enemy/walkS/enemy_walkA_00" + stringPath + ".png").getImage();
        }
                
    }
}
