package code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Code {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<People> peopleList = new LinkedList<People>();
		
		while (true) {
			System.out.println("주소 프로그램 기능을 입력하세요. I(입력) / U(수정) / R(삭제) /Q(프로그램종료)");
			String input = sc.next();
			if(input.toUpperCase().equals("I")) {//입력
				People people = new People();
				
				System.out.println("주소록 데이터를 입력하세요.");
				System.out.print("이름 : ");
				people.setName(sc.next());
				System.out.print("나이 : ");
				people.setAge(sc.nextInt());
				System.out.print("성별 : ");
				people.setGender(sc.next());
				System.out.print("주소 : ");
				sc.nextLine();
				people.setAdress(sc.nextLine());
				peopleList.add(people);
				

				printList(peopleList);
				
				
				
			}else if(input.toUpperCase().equals("U")) {
				System.out.println("수정할 주소록 번호를 입력하세요.");
				People people = new People();
				System.out.print("수정할 번호 : ");
				int updateNum = sc.nextInt() -1;
				System.out.println("주소록 데이터를 입력하세요.");
				System.out.print("이름 : ");
				people.setName(sc.next());
				System.out.print("나이 : ");
				people.setAge(sc.nextInt());
				System.out.print("성별 : ");
				people.setGender(sc.next());
				System.out.print("주소 : ");
				sc.nextLine();
				people.setAdress(sc.nextLine());
				peopleList.set(updateNum, people);
				
				printList(peopleList);
				
				
			}else if(input.toUpperCase().equals("R")) {
				System.out.println("삭제할 주소록 번호를 입력하세요.");
				System.out.print("삭제할 번호 : ");
				peopleList.remove(sc.nextInt() - 1);
				
				
				printList(peopleList);
				
			}else if(input.toUpperCase().equals("Q")) {
				System.out.println("프로그램이 종료되었습니다!");
				break;
			}
		}
		

		

		
	}
	
	
	

	private static void printList(List list) {
		if(list.size() == 0) {
			System.out.println("저장된 정보가 없습니다.");
		}else {
			System.out.println("저장된 주소록 정보는 다음과 같습니다.");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(i+1 + "  " + list.get(i));
			}
			
			System.out.println("\n==========================================================\n");
		}
		
		
	}
	
	
}
