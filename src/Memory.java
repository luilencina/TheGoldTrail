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
            this.route[x][y].gold = gold +  Integer.parseInt(way[x][y]);
            saveWay(x,y, "leste");
            return gold +  Integer.parseInt(way[x][y]);
        }
        if (y == way.length - 1){
            int gold = routeCalc(way, x - 1, y);
            this.route[x][y].gold = gold + Integer.parseInt(way[x][y]);
            saveWay(x,y, "norte");
            return gold + Integer.parseInt(way[x][y]);
        } else{
            return Math.max(Math.max(routeCalc(way, x - 1, y + 1), routeCalc(way, x - 1, y)),routeCalc(way, x, y + 1)) 
            + Integer.parseInt(way[x][y]);
        }
    }

    public RouteMemory saveWay(int x, int y, String compass){
        ArrayList<String> way = new ArrayList<>();
        RouteMemory memory = new RouteMemory(0, way);

        if(compass.equals("norte")){
            if(memory.route.isEmpty()) {
                memory.route.add("N");
                memory.update(0, memory.route);
                return memory;
            }
            memory.route.add("N");
            // return new RouteMemory(norte+Integer.parseInt(way[x][y]), memory.route);
        } 
        if(compass.equals("leste")) memory.route.add("E");
        if(compass.equals("nordeste")) memory.route.add("NE");

        System.out.println(memory.route);
        this.route[x][y].route = memory.route;
        return memory;
    }

    public void goldCalc() {
        System.out.println("O Garimpeiro conseguiu: " + routeCalc(way, way.length - 1, 0) + " de Ouro");
    }   

}
