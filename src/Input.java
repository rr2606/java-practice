import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Input {
    //2 ways to read input from a user or a file : Buffered Reader (reads char or sequence [line]) and Scanner (more advanced, reads formatted input like int, char, etc)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String: "); // "Enter an Integer: "
         String s = br.readLine();
        // int s = Integer.parseInt(br.readLine());
        System.out.println("You entered: " + s);
        //Buffered Reader throws a checked Exception, Scanner is easier to use
        Scanner sc = new Scanner(System.in);
        String sc_str = sc.nextLine();
        System.out.println("You entered String: " + sc_str);
        int sc_int = sc.nextInt();
        System.out.println("You entered Integer: " + sc_int);
        float sc_float = sc.nextFloat();
        System.out.println("You entered Float: " + sc_float);
        //BufferedReader is used for character streams, it is more efficient for large inputs, can specify buffer size and it is synchronized
    }
}
