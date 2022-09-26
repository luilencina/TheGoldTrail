import java.util.ArrayList;

public class TwoExercise {

    private String[][] way;
    private RouteMemory[][] route;

    public TwoExercise(String[][] way, RouteMemory[][] route) {
        this.way = way;
        this.route = new RouteMemory[way.length][way.length];
    }

    public int routeCalc(String[][] way, int x, int y) {
        if(way[x][y].equals("x")) return 0;
        if (x == 0 && y == way.length - 1) return Integer.parseInt(way[x][y]);
        if (x == 0) return routeCalc(way, x, y + 1) + Integer.parseInt(way[x][y]);
        if (y == way.length - 1){
            return routeCalc(way, x - 1, y) + Integer.parseInt(way[x][y]);
        } else{
            return Math.max(Math.max(routeCalc(way, x - 1, y + 1), routeCalc(way, x - 1, y)),routeCalc(way, x, y + 1)) + Integer.parseInt(way[x][y]);
        }
    }

    public RouteMemory routeCalcFinal(String[][] way, int x, int y, RouteMemory memory) {
        
            int norte = routeCalc(way, x - 1, y);
            int leste = routeCalc(way, x, y + 1);
            int nordeste = routeCalc(way, x - 1, y + 1);
            int max = Math.max(Math.max(norte, leste),nordeste);

            if(norte==max) {
                // if(memory.route.isEmpty()) {
                //     memory.route.add("N");
                //     memory.update(norte+Integer.parseInt(way[x][y]), memory.route);
                //     return memory;
                // }
                memory.route.add("N");
                return new RouteMemory(norte+Integer.parseInt(way[x][y]), memory.route);
            }
            if(leste==max) {
                // if(memory.route.isEmpty()) {
                //     memory.route.add("L");
                //     memory.update(norte+Integer.parseInt(way[x][y]), memory.route);
                //     return memory;
                // }
                memory.route.add("L");
                return new RouteMemory(norte+Integer.parseInt(way[x][y]), memory.route);
            }
            if(nordeste==max) {
                // if(memory.route.isEmpty()) {
                //     memory.route.add("NE");
                //     memory.update(norte+Integer.parseInt(way[x][y]), memory.route);
                //     return memory;
                // }
                memory.route.add("NE");
                return new RouteMemory(norte+Integer.parseInt(way[x][y]), memory.route);
            }
        return memory;
    }

    public void goldCalc() {
        ArrayList<String> caminhoPercorrido = new ArrayList<>();
        // RouteMemory memory = routeCalcFinal(way, way.length - 1, 0, new RouteMemory(0, caminhoPercorrido));
        int gold = routeCalc(way, way.length - 1, 0);
        System.out.println("O Garimpeiro conseguiu: " + gold + " de Ouro");
        System.out.println("O Caminho feito foi:");
        // System.out.println(memory.route);

    }
}
