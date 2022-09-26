import java.util.ArrayList;

public class RouteMemory {
    public int gold;
    public ArrayList<String> route;

    public RouteMemory(int gold, ArrayList<String> route){
        this.gold = gold;
        this.route = route;
    }

    public void update(int gold, ArrayList<String> route){
        this.gold = gold;
        this.route = route;
    }
}
