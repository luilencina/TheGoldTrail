public class OneExercise {

    private String[][] way;

    public OneExercise(String[][] way) {
        this.way = way;
    }

    public int routeCalc(String[][] way, int x, int y) {
        if(way[x][y].equals("x")) return (int) Double.NEGATIVE_INFINITY;
        if (x == 0 && y == way.length - 1) return Integer.parseInt(way[x][y]);
        if (x == 0) {
            int gold = routeCalc(way, x, y + 1);
            return gold + Integer.parseInt(way[x][y]);
        } else if (y == way.length - 1){
            int gold = routeCalc(way, x - 1, y);
            return gold + Integer.parseInt(way[x][y]);
        } else{
            int goldMax = Math.max(Math.max(routeCalc(way, x - 1, y + 1), routeCalc(way, x - 1, y)),routeCalc(way, x, y + 1));
            return goldMax + Integer.parseInt(way[x][y]);
        }
    }

    public void goldCalc() {
        int gold = routeCalc(way, way.length - 1, 0);
        System.out.println("O Garimpeiro conseguiu: " + gold + " de Ouro");
    }   
}   
