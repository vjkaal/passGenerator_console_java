package passGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class password1 {

	private final char[] array = {'~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_','+', '=', '{', '}', '[', ']', '\\', '|', ';', ':', '\'', '"', ',', '<', '>', '.', '/', '?', ' '};

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
//				This is to remove trailing space from br.read in line 28
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
//				This is to remove trailing space from br.read in line 86
				br.readLine();


				pw.printf("Enter length: ");
				len = Integer.parseInt(br.readLine());
//				pw.println(len);
			}
			else len = 15;
//			pw.println("length: "+len);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return len;
	}

//	make a function to generate password using given values

	private void generatePassword(String req, int len){

		PrintWriter pw = new PrintWriter(System.out,true);

//		pw.println("Vanshaj kaushal");
		char[] pass1 = new char[len];
//		pw.println(req);
//		pw.println(len);

		for(int i=0;i<len; i++){
			switch (req.charAt((int) (Math.random() * req.length()))){

				case 'c' : pass1[i] = (char) ((int) (Math.random() * 26) + 97);
					break;

				case 'C': pass1[i] = (char) ((int) (Math.random() * 26) + 65);
					break;

				case 'n': pass1[i] = (char) ((int) (Math.random() * 10) + 48);
					break;

				case 's': pass1[i] = array[(int) (Math.random() * array.length)];
					break;
			}
		}

		String pass = new String(pass1);
		pw.println(pass);
	}


	public void chkPass(){

		PrintWriter pw = new PrintWriter(System.out,true);

		pw.println("Feature under development\nPlease chk in later");
	}
}
