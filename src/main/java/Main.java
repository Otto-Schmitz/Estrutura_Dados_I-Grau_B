import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String arquivo = "teste.csv";
        BufferedReader br = null;
        String linha = "";
        String divisor = ",";

        try {
            br = new BufferedReader(new FileReader(arquivo));

            while ((linha = br.readLine()) != null) {
                String[] pessoa = linha.split(divisor);

                System.out.println(pessoa[0]);
                System.out.println(pessoa[1]);
                System.out.println(pessoa[2]);
                System.out.println(pessoa[3]);
                System.out.println(pessoa[4]);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
