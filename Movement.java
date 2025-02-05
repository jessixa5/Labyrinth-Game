public enum Movement {
    SOUTH(0, 1), SW(-1,1), WEST(-1, 0), NW(-1,-1), NORTH(0, -1), NE(1,-1), EAST(1, 0), SE(1,1);
    
    Movement(int x, int y){
        this.x = x;
        this.y = y;
    }
    public final int x, y;
}
