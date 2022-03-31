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
			System.out.println("二쇱냼 �봽濡쒓렇�옩 湲곕뒫�쓣 �엯�젰�븯�꽭�슂. I(�엯�젰) / U(�닔�젙) / R(�궘�젣) /Q(�봽濡쒓렇�옩醫낅즺)");
			String input = sc.next();
			if(input.toUpperCase().equals("I")) {//�엯�젰
				People people = new People();

				System.out.println("二쇱냼濡� �뜲�씠�꽣瑜� �엯�젰�븯�꽭�슂.");
				System.out.print("�씠由� : ");
				people.setName(sc.next());
				System.out.print("�굹�씠 : ");
				people.setAge(sc.nextInt());
				System.out.print("�꽦蹂� : ");
				people.setGender(sc.next());
				System.out.print("二쇱냼 : ");
				sc.nextLine();
				people.setAdress(sc.nextLine());
				peopleList.add(people);


				printList(peopleList);




			}else if(input.toUpperCase().equals("U")) {
				System.out.println("�닔�젙�븷 二쇱냼濡� 踰덊샇瑜� �엯�젰�븯�꽭�슂.");
				People people = new People();
				System.out.print("�닔�젙�븷 踰덊샇 : ");
				int updateNum = sc.nextInt() -1;
				System.out.println("二쇱냼濡� �뜲�씠�꽣瑜� �엯�젰�븯�꽭�슂.");
				System.out.print("�씠由� : ");
				people.setName(sc.next());
				System.out.print("�굹�씠 : ");
				people.setAge(sc.nextInt());
				System.out.print("�꽦蹂� : ");
				people.setGender(sc.next());
				System.out.print("二쇱냼 : ");
				sc.nextLine();
				people.setAdress(sc.nextLine());
				peopleList.set(updateNum, people);

				printList(peopleList);


			}else if(input.toUpperCase().equals("R")) {
				System.out.println("�궘�젣�븷 二쇱냼濡� 踰덊샇瑜� �엯�젰�븯�꽭�슂.");
				System.out.print("�궘�젣�븷 踰덊샇 : ");
				peopleList.remove(sc.nextInt() - 1);


				printList(peopleList);

			}else if(input.toUpperCase().equals("Q")) {
				System.out.println("�봽濡쒓렇�옩�씠 醫낅즺�릺�뿀�뒿�땲�떎!");
				break;
			}
		}





	}




	private static void printList(List list) {
		if(list.size() == 0) {
			System.out.println("���옣�맂 �젙蹂닿� �뾾�뒿�땲�떎.");
		}else {
			System.out.println("���옣�맂 二쇱냼濡� �젙蹂대뒗 �떎�쓬怨� 媛숈뒿�땲�떎.");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(i+1 + "  " + list.get(i));
			}

			System.out.println("\n==========================================================\n");
		}


	}


}
