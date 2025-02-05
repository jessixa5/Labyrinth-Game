public class HighScores implements Comparable<HighScores>{
    private final String name;
    public final int level;
    public final double time;
    
    public HighScores(String name, int level, double time){
        this.name = name;
        this.level = level;
        this.time = time;
    }
    
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getTime() {
        return time;
    }

    @Override
    public String toString() {
        return name + ": " + level + " level " + time + " seconds";
    }
    
    /**
     * Compares two LeaderBoard objects by their level value, then by time value, and finally by name.
     * @param o second LeaderBoard object
     * @return a negative value if this is less than the second object, 0 if equal, and positive if more than.
     */
    @Override
    public int compareTo(HighScores o) {
        int levelDif = -Integer.compare(this.level, o.level);
        int timeDif = (int) Double.compare(this.time, o.time);
        int nameDif = this.name.compareTo(o.name);
        if(levelDif != 0){
            return levelDif;
        }
        else if(timeDif != 0){
            return timeDif;
        }
        else return nameDif;
    }
}
