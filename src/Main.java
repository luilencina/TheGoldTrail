import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

 public class Main {
     public static void main(String[] args) throws IOException{
        String[][] way = wayConstruct(args[0]);

        System.out.println(" ");
        System.out.println("A Matriz de valores de ouro que o garimpeiro tem:");
        wayPrinter(way);

        System.out.println(" ");
        System.out.println("----------------------------------");
        System.out.println("Problema 1: Recursão simples sem memorização (quantidade de ouro)");
        OneExercise x1 = new OneExercise(way);
        x1.goldCalc();

        System.out.println(" ");
        System.out.println("----------------------------------");
        System.out.println("Problema 2: Recursão simples com memorização (quantidade de ouro e caminho)");
        Memory x2 = new Memory(way, null);
        x2.goldCalc();
    }

     public static String[][] wayConstruct(String fileName) throws IOException {
        String errorString = "Arquivo não encontrado, por favor tente novamente!";
        String[][] way = new String[0][0];
        try(BufferedReader file = new BufferedReader(new FileReader("../testes/" + fileName))){
            String l =  file.readLine();
            int length = Integer.parseInt(l);
            way = new String[length][length];
            int j = 0;
            try (Scanner in = new Scanner(file)) {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String[] array = line.trim().split("\\s+");
                    for (int i = 0; i < way.length; i++) {
                        way[j][i] = array[i];
                    }
                    j++;
                }
                return way;
            }
         } catch(IOException e){
            System.out.println(errorString);
        }
        System.out.println(errorString);
        return way;
       }


     public static void wayPrinter(String[][] way) throws IOException{
        for(int i=0; i < way.length; i++){
            for (int j = 0; j < way[0].length; j++)     {
                System.out.print(way[i][j] + "  ");
            }
            System.out.println("  ");
        }
     }
     
    }




