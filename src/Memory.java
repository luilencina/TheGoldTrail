import java.io.IOException;
import java.util.ArrayList;

public class Memory {

    private String[][] way;
    private RouteMemory[][] route;

    public Memory(String[][] way, RouteMemory[][] route) {
        this.way = way;
        this.route = new RouteMemory[way.length][way.length];
    }

    public int routeCalc(String[][] way, int x, int y) {
        RouteMemory verify = this.route[x][y] == null ? null : this.route[x][y];
        if (verify != null) return verify.gold;
        int thisGold = way[x][y].equals("x") ? -9999999 : Integer.parseInt(way[x][y]);
        if (x == 0 && y == way.length - 1) { 
            this.route[x][y] = new RouteMemory(Integer.parseInt(way[x][y]), new ArrayList<>());
            return thisGold;
        }
        if (x == 0){
            int gold = routeCalc(way, x, y + 1);
            this.route[x][y] = saveWay(way, x, y, "leste");
            return gold + thisGold;
        }
        if (y == way.length - 1){
            int gold = routeCalc(way, x - 1, y);
            this.route[x][y] = saveWay(way, x, y, "norte");
            return gold + thisGold;
        } else{
            int norte = routeCalc(way, x - 1, y);
            int leste = routeCalc(way, x, y + 1);
            int nordeste = routeCalc(way, x - 1, y + 1);
            int max = Math.max(Math.max(norte, leste),nordeste); 

            if(max == norte) this.route[x][y] = saveWay(way, x, y, "norte");
            if(max == nordeste) this.route[x][y] = saveWay(way, x, y, "nordeste");
            if(max == leste) this.route[x][y] = saveWay(way, x, y, "leste");
            return max + thisGold;
        }
    }

    public RouteMemory saveWay(String[][] way, int x, int y, String compass){
        int thisGold = way[x][y].equals("x") ? -9999999 : Integer.parseInt(way[x][y]);

        if(compass.equals("norte")){
            ArrayList<String> newWay = new ArrayList<>(this.route[x - 1][y].route);
            newWay.add(0, "N");
            return new RouteMemory(this.route[x - 1][y].gold + thisGold, newWay);
        } 
        if(compass.equals("leste")) {
            ArrayList<String> newWay = new ArrayList<>(this.route[x][y + 1].route);
            newWay.add(0, "E");
            return new RouteMemory(this.route[x][y + 1].gold + thisGold, newWay);
        }
        if(compass.equals("nordeste")) {
            ArrayList<String> newWay = new ArrayList<>(this.route[x - 1][y + 1].route);
            newWay.add(0, "NE");
            return new RouteMemory(this.route[x - 1][y + 1].gold + thisGold, newWay);
        }

        return null;
    }


    public void goldCalc() {
        int gold = 0;
        if(way[0][0].equals("x") || way[0][0].equals(-9999999)){
            gold = routeCalc(way, way.length - 1, 1);
            this.route[0][0] = saveWay(way, 0, 0, "leste");

        } 
        gold = routeCalc(way, way.length - 1, 0);
        System.out.println("O Garimpeiro conseguiu: " + gold + " de Ouro");
        System.out.println(route[way.length - 1][0].route);
    }   

}
