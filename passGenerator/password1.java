package passGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class password1 {

	private final String str = "~`!@#$%^&*()-_+={}[]|;:',<>./? \"\\";

	public password1(){}

	public void autoPass(){
		PrintWriter pw = new PrintWriter(System.out,true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String req = getPermissions();
		int len = getLength();
//		printArray();
		generatePassword(req, len);

		boolean found = false;
		while(!found) {

			pw.printf("Refresh Password? y/n ");
			try{
				if (Character.toLowerCase(br.read()) == 'y') generatePassword(req, len);
				else found = true;


//				DO NOT REMOVE THIS
//				This is to remove trailing space from br.read in above line
				br.readLine();

			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
	}

//	private void printArray(){
//		for(char c:array){
//			System.out.print(c+" ");
//		}
//		System.out.println();
//
//		String s = new String(array);
//		System.out.println(s);
//	}

	private String getPermissions(){
		PrintWriter pw = new PrintWriter(System.out,true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		pw.println("c : small letters");
		pw.println("C : capital letters");
		pw.println("n : numbers");
		pw.println("s : special characters");
		pw.println("Input format : string to set password req (eg. cCn for small and capital letters and numbers)");
		pw.printf("Enter string: ");

		String req = "";
		try {
			req = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		pw.println(req);
		return req;
	}

	private int getLength(){

		PrintWriter pw = new PrintWriter(System.out,true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		pw.printf("Do you want a specific length of password? y/n");
		int len = 0;
		try {
			if( Character.toLowerCase((char) br.read())  == 'y'){

//				DO NOT REMOVE THIS
//				This is to remove trailing space from br.read in above
				br.readLine();


				pw.printf("Enter length: ");
				len = Integer.parseInt(br.readLine());
//				pw.println(len);
			}
			else len = 15;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return len;
	}

//	function to generate password using given requirements
	private void generatePassword(String req, int len){

		PrintWriter pw = new PrintWriter(System.out,true);

		char[] pass1 = new char[len];

		for(int i=0;i<len; i++){
			switch (req.charAt((int) (Math.random() * req.length()))) {
				case 'c' -> pass1[i] = (char) ((int) (Math.random() * 26) + 97);
				case 'C' -> pass1[i] = (char) ((int) (Math.random() * 26) + 65);
				case 'n' -> pass1[i] = (char) ((int) (Math.random() * 10) + 48);
				case 's' -> pass1[i] = str.charAt((int) (Math.random() * str.length()));
			}
		}

		String pass = new String(pass1);
		pw.println(pass);
	}


	public void chkPass(){

		PrintWriter pw = new PrintWriter(System.out,true);

		String pass = getPassword();

		//password length here
		if(pass.length() >= 8) {
			pw.println("Password length: Okay");
		}
		else pw.println("Password length GREATER THAN 8 is recommended");

		boolean eol = false;
		boolean sl = false, cl = false, num = false, sc = false;
		int i=0;
		while(!eol){
			pw.printf("%c",pass.charAt(i));

			if((int) pass.charAt(i) >= 97 && (int) pass.charAt(i) <= (97+26)) sl = true;
			if((int) pass.charAt(i) >= 65 && (int) pass.charAt(i) <= (65+26)) cl = true;
			if((int) pass.charAt(i) >= 48 && (int) pass.charAt(i) <= (48+10)) num = true;
			if(contains(pass.charAt(i))) sc = true;


			i++;
			if(i == pass.length()) eol = true;
		}


		if(sl) pw.println("\n\nat least 1 Small Letter: Okay");
		else pw.println("at least 1 Small Letter: Recommended");

		if(cl) pw.println("at least 1 Capital Letter: Okay");
		else pw.println("at least 1 Capital Letter: Recommended");

		if(num) pw.println("at least 1 Numeric: Okay");
		else pw.println("at least 1 Numeric: Recommended");

		if(sc) pw.println("at least 1 Special Character: Okay");
		else pw.println("at least 1 Special Character: Recommended");

	}


	private String getPassword(){
		PrintWriter pw = new PrintWriter(System.out,true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		pw.printf("Enter your password: ");
		String pass = "";
		try {
			pass = br.readLine();
		}
		catch (IOException e){
			e.printStackTrace();
		}

		return pass;
	}


	private boolean contains(char c){

		int i=0;

		while(true){

			if(str.charAt(i) == c) return true;

			i++;
			if(i == str.length()) return false;
		}
	}

}
