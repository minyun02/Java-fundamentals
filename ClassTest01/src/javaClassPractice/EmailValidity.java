package javaClassPractice;

import java.util.Scanner;

public class EmailValidity {
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String id;
		String domain;
		
		while(true) {
			
			System.out.print("이메일 입력= ");
			id = scan.next();
			
			String email_reg = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			
			boolean b = id.matches(email_reg);
			
			if(b) {
				if(id.matches(".com")) {
					b = false;
				}
				System.out.println(id+"는 잘못 입력된 메일입니다");
			} else {
				String showId[] = id.split("@");
				System.out.println("아이디 = "+showId[0]);
				System.out.println("도메인 = "+showId[1]);
			}
				
		
		}

	}

}
