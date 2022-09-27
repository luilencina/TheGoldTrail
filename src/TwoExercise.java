// import java.util.ArrayList;

// public class TwoExercise {

//     private String[][] way;
//     private RouteMemory[][] route;

//     public TwoExercise(String[][] way, RouteMemory[][] route) {
//         this.way = way;
//         this.route = new RouteMemory[way.length][way.length];
//     }

//     public RouteMemory routeCalc(String[][] way, int x, int y, ArrayList<String> parkour) {
//         RouteMemory verify = this.route[way.length - 1][way.length - 1];
//         if(x < way.length && y < way.length){
//             verify = this.route[x][y] == null ? null : this.route[x][y];
//             if (verify != null) {
//                 ArrayList<String> newWay = new ArrayList<>();
//                 RouteMemory betterWay = verify;
//                 for (String caminho : betterWay.route) {
//                     newWay.add(caminho);
//                 }
//                 return new RouteMemory(betterWay.gold, newWay);
//             }
//             if (x == 0 && y == way.length - 1) return new RouteMemory(Integer.parseInt(way[x][y]), parkour);;
//             if (x == 0) { 
//                 RouteMemory selectParkour = routeCalc(way, x, y + 1,
//                 parkour);
//         ArrayList<String> novoCaminhoPercorrido = new ArrayList<>(selectParkour.route);
//         novoCaminhoPercorrido.add("E");
//         if (verify == null) {
//             // adicionaMelhorCaminho(x, y,
//             //         new RouteMemory((selectParkour.gold + Integer.parseInt(way[x][y])),
//             //                 novoCaminhoPercorrido));
//         }
//         return new RouteMemory(selectParkour.gold + Integer.parseInt(way[x][y]),
//                 novoCaminhoPercorrido);
//             }
//             if (y == way.length - 1){
//                 RouteMemory selectParkour = routeCalc(way, x, y + 1,
//                 parkour);
//                 ArrayList<String> novoparkour = new ArrayList<>(selectParkour.route);
//                 novoparkour.add("E");
//                 if (verify == null) return route[x][y] =  new RouteMemory((selectParkour.gold + Integer.parseInt(way[x][y])),
//                     novoparkour);
//                 return new RouteMemory(selectParkour.gold + Integer.parseInt(way[x][y]),
//                 novoparkour);
//             } else{
//                 RouteMemory selectParkour = retornaCaminhoEscolhido(
//                         routeCalc(way, x - 1, y + 1, parkour),
//                         routeCalc(way, x - 1, y, parkour),
//                         routeCalc(way, x, y + 1, parkour));
//                 RouteMemory caminhoFinal = new RouteMemory(
//                         selectParkour.gold + Integer.parseInt(way[x][y]),
//                         selectParkour.route);
//                 if (verify == null) {
//                     // adicionaMelhorCaminho(x, y, caminhoFinal);
//                 }
//                 return caminhoFinal;
//         } 
//         }
//         return verify;
//     }

//     public RouteMemory routeCalcFinal(int compass, RouteMemory memory) {
        
//             int norte = routeCalc(way, x - 1, y);
//             int leste = routeCalc(way, x, y + 1);
//             int nordeste = routeCalc(way, x - 1, y + 1);
//             int max = Math.max(Math.max(norte, leste),nordeste);

//             if(compass == max) {
//                 if(memory.route.isEmpty()) {
//                     memory.route.add("N");
//                     memory.update(norte+Integer.parseInt(way[x][y]), memory.route);
//                     return memory;
//                 }
//                 memory.route.add("N");
//                 return new RouteMemory(norte+Integer.parseInt(way[x][y]), memory.route);
//             }
//             if(leste==max) {
//                 if(memory.route.isEmpty()) {
//                     memory.route.add("L");
//                     memory.update(norte+Integer.parseInt(way[x][y]), memory.route);
//                     return memory;
//                 }
//                 memory.route.add("L");
//                 return new RouteMemory(norte+Integer.parseInt(way[x][y]), memory.route);
//             }
//             if(nordeste==max) {
//                 if(memory.route.isEmpty()) {
//                     memory.route.add("NE");
//                     memory.update(norte+Integer.parseInt(way[x][y]), memory.route);
//                     return memory;
//                 }
//                 memory.route.add("NE");
//                 return new RouteMemory(norte+Integer.parseInt(way[x][y]), memory.route);
//             }
//         return memory;
//     }

//     public void goldCalc() {
//         ArrayList<String> parkour = new ArrayList<>();
//         RouteMemory memory = routeCalc(way, way.length - 1, 0,parkour);
//         // int gold = routeCalc(way, way.length - 1, 0, memory);
//         System.out.println("O Garimpeiro conseguiu: " + memory.gold + " de Ouro");
//         System.out.println("O Caminho feito foi:");
//         System.out.println(String.join(",", memory.route));

//     }
// }
