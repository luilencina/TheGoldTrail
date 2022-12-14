public class OneExercise {

    private String[][] way;

    public OneExercise(String[][] way) {
        this.way = way;
    }

    public int routeCalc(String[][] way, int x, int y) {
        if(way[x][y].equals("x")) return (int) Double.NEGATIVE_INFINITY;
        if (x == 0 && y == way.length - 1) return Integer.parseInt(way[x][y]);
        if (x == 0) return routeCalc(way, x, y + 1) + Integer.parseInt(way[x][y]);
        if (y == way.length - 1){
            return routeCalc(way, x - 1, y) + Integer.parseInt(way[x][y]);
        } else{
            return Math.max(Math.max(routeCalc(way, x - 1, y + 1), routeCalc(way, x - 1, y)),routeCalc(way, x, y + 1)) 
            + Integer.parseInt(way[x][y]);
        }
    }

    public void goldCalc() {
        System.out.println("O Garimpeiro conseguiu: " + routeCalc(way, way.length - 1, 0) + " de Ouro");
    }   
}   
