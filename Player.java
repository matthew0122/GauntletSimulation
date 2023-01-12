public class Player {
    String name;
    int strikes;
    public Player(String name){
        this.name = name;
        strikes = 0;
    }

    public void addStrike(){
        strikes++;
    }
    public boolean shouldBeRemoved(){
        if(strikes >= 3){
            return true;
        }
        return false;
    }
    public String toString(){
        return name + ",strikes: " + strikes;
    }
}