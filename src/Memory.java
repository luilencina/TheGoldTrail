import java.util.ArrayList;

public class Memory {

    private String[][] way;
    private RouteMemory route;

    public Memory(String[][] way, RouteMemory[][] route) {
        ArrayList<String> newRoute = new ArrayList<>();
        this.way = way;
        this.route = new RouteMemory(0, newRoute);
    }

    public int routeCalc(String[][] way, int x, int y) {
        if(way[x][y].equals("x")) return (int) Double.NEGATIVE_INFINITY;
        if (x == 0 && y == way.length - 1) return Integer.parseInt(way[x][y]);
        if (x == 0){
            int gold = routeCalc(way, x, y + 1);
            saveWay(way, x, y, "leste");
            this.route.gold += Integer.parseInt(way[x][y]) + gold;
            return gold + Integer.parseInt(way[x][y]);
        }
        if (y == way.length - 1){
            int gold = routeCalc(way, x - 1, y);
            saveWay(way, x, y, "norte");
            this.route.gold += Integer.parseInt(way[x][y]) + gold;
            return gold + Integer.parseInt(way[x][y]);
        } else{
            int norte = routeCalc(way, x - 1, y);
            int leste = routeCalc(way, x, y + 1);
            int nordeste = routeCalc(way, x - 1, y + 1);
            int max = Math.max(Math.max(norte, leste),nordeste); 

            if(max == norte) saveWay(way, x, y, "norte");
            if(max == nordeste) saveWay(way, x, y, "nordeste");
            if(max == leste) saveWay(way, x, y, "leste");
            this.route.gold += Integer.parseInt(way[x][y]) + max;
            return max + Integer.parseInt(way[x][y]);
        }
    }

    public RouteMemory saveWay(String[][] way, int x, int y, String compass){
        ArrayList<String> newWay = new ArrayList<>();
        RouteMemory memory = new RouteMemory(0, newWay);

        if(compass.equals("norte")){
            if(memory.route.isEmpty()) {
                // memory.route.add("N");
                this.route.route.add("N");
                this.route.update(Integer.parseInt(way[x][y]), this.route.route);
                return memory;
            }
            // memory.route.add("N");
            this.route.route.add("N");
            return new RouteMemory(Integer.parseInt(way[x][y]), this.route.route);
        } 
        if(compass.equals("leste")) {
            if(memory.route.isEmpty()) {
                // memory.route.add("E");
                // this.route = memory;
                this.route.route.add("E");
                this.route.update(Integer.parseInt(way[x][y]), this.route.route);
                return memory;
            }
            // memory.route.add("E");
            this.route.route.add("E");
            return new RouteMemory(Integer.parseInt(way[x][y]), this.route.route);
        }
        if(compass.equals("nordeste")) {
            if(memory.route.isEmpty()) {
                // memory.route.add("NE");
                this.route.route.add("NE");
                this.route.update(Integer.parseInt(way[x][y]), this.route.route);
                return memory;
            }
            // memory.route.add("NE");
            this.route.route.add("NE");
            return new RouteMemory(Integer.parseInt(way[x][y]), this.route.route);
        }

        // System.out.println(memory.route);
        return this.route;
    }

    public void goldCalc() {
        System.out.println("O Garimpeiro conseguiu: " + this.route.gold + " de Ouro");
        // System.out.println(this.route.route);
        // for (int i = 0; i < way.length; i++) {
        //     System.out.print(this.route[i] + " ");
        // }
        // System.out.println(this.route);
    }   

}
