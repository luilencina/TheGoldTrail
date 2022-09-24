import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

 public class Main {
     public static void main(String[] args) throws IOException{
        String fileName = args[0];
        String[][] matrizPercorrer = readyFile(fileName);

        for(int i=0; i<=matrizPercorrer.length; i++){
            for (int j = 0; j < matrizPercorrer[0].length; j++)     {
                System.out.print(matrizPercorrer[i][j] + "  ");
            }
            System.out.println("  ");
        }
    }

    public static String[][] lerMensagem(String fileName) throws IOException {
        String[][] matriz = new String[0][0];
        try (BufferedReader br = new BufferedReader(new FileReader("../testes/" + fileName))) {
            String line = br.readLine();
            line.trim();
            int matrizLength = Integer.parseInt(line);
            boolean isFirstLine = false;
            int index = 0;
            while (line != null && index < matrizLength) {
                if (!isFirstLine) {
                    isFirstLine = true;
                    matriz = new String[matrizLength][matrizLength];
                    line = br.readLine();
                } else {
                    String[] splited = line.trim().split("\\s+");
                    for (int i = 0; i < matriz.length; i++) {
                        matriz[index][i] = splited[i];
                    }
                    index++;
                    line = br.readLine();
                }
            }
            br.close();
            return matriz;
        } catch (IOException e) {
            System.out.println(e);
        }
        return matriz;
    }

     public static String[][] readyFile(String fileName) throws IOException {
        FileReader file = new FileReader("../testes/" + fileName);
        BufferedReader fileBuffer = new BufferedReader(file);
        String[][] way  = new String[0][0];
        String line = fileBuffer.readLine();
        line.trim();
        int matrizLength = Integer.parseInt(line);
        boolean isFirstLine = false;
        int index = 0;
       
        while (line != null && index < matrizLength) {
            if (!isFirstLine) {
                isFirstLine = true;
                way = new String[matrizLength][matrizLength];
                line = fileBuffer.readLine();
            } else {
                String[] splited = line.trim().split("\\s+");
                for (int i = 0; i < way.length; i++) {
                    way[index][i] = splited[i];
                }
                index++;
                line = fileBuffer.readLine();
            }
        }
        System.out.print(way);
        return way;
    }

}



