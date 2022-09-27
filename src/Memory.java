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
        if (verify != null) {
            ArrayList<String> newRoute = new ArrayList<>();
            RouteMemory betterWay = verify;
            for (String caminho : betterWay.route) {
                newRoute.add(caminho);
            }
            new RouteMemory(betterWay.gold, newRoute);
        }
        if(way[x][y].equals("x")) return (int) Double.NEGATIVE_INFINITY;
        if (x == 0 && y == way.length - 1) return Integer.parseInt(way[x][y]);
        if (x == 0){
            int gold = routeCalc(way, x, y + 1);
            saveWay(way, x, y, "leste");
            return gold + Integer.parseInt(way[x][y]);
        }
        if (y == way.length - 1){
            int gold = routeCalc(way, x - 1, y);
            saveWay(way, x, y, "norte");
            return gold + Integer.parseInt(way[x][y]);
        } else{
            int norte = routeCalc(way, x - 1, y);
            int leste = routeCalc(way, x, y + 1);
            int nordeste = routeCalc(way, x - 1, y + 1);
            int max = Math.max(Math.max(norte, leste),nordeste); 

            if(max == norte) saveWay(way, x, y, "norte");
            if(max == nordeste) saveWay(way, x, y, "nordeste");
            if(max == leste) saveWay(way, x, y, "leste");
            return max + Integer.parseInt(way[x][y]);
        }
    }

    public RouteMemory saveWay(String[][] way, int x, int y, String compass){
        ArrayList<String> newWay = new ArrayList<>();
        RouteMemory memory = new RouteMemory(0, newWay);

        if(compass.equals("norte")){
            if(memory.route.isEmpty()) {
                memory.route.add("N");
                memory.update(Integer.parseInt(way[x][y]), memory.route);
                return memory;
            }
            memory.route.add("N");
            return new RouteMemory(Integer.parseInt(way[x][y]), memory.route);
        } 
        if(compass.equals("leste")) {
            if(memory.route.isEmpty()) {
                memory.route.add("E");
                memory.update(Integer.parseInt(way[x][y]), memory.route);
                return memory;
            }
            memory.route.add("E");
            return new RouteMemory(Integer.parseInt(way[x][y]), memory.route);
        }
        if(compass.equals("nordeste")) {
            if(memory.route.isEmpty()) {
                memory.route.add("NE");
                memory.update(Integer.parseInt(way[x][y]), memory.route);
                return memory;
            }
            memory.route.add("NE");
            return new RouteMemory(Integer.parseInt(way[x][y]), memory.route);
        }

        // this.route = ;
        System.out.println(memory.route);
        return memory;
    }

    public void goldCalc() {
        System.out.println("O Garimpeiro conseguiu: " + routeCalc(way, way.length - 1, 0) + " de Ouro");
        // for (int i = 0; i < way.length; i++) {
        //     System.out.print(this.route[i] + " ");
        // }
        // System.out.println(this.route);
    }   

}
