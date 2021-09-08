import passGenerator.password1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
	// write your code here

        PrintWriter pw = new PrintWriter(System.out,true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        password1 pass = new password1();


        pw.println("\n\n\n\n");
        pw.println("Auto generate password? Press 1");
        pw.println("Check given password against conditions? Press 2");
        pw.println("Exit : Press 0");

        try{
            int input = Integer.parseInt(br.readLine());

            if(input == 1){
                pass.autoPass();
            }
            else if(input == 2) {
                pass.chkPass();
            }
            else pw.println("Thank you!!!\nVisit Again!!!");

            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        pw.close();
    }
}
