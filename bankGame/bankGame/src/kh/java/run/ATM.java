package kh.java.run;

import java.util.Scanner;

import kh.java.func.ATMDetail;

public class ATM {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ATMDetail atm = new ATMDetail();
		atm.frontScreen();
		while (true) {

			System.out.println("\n=========== 쉰한(51) 은행 ATM ============\n");
			System.out.println("안녕하세요 고객님. 무엇을 도와드릴까요?\n");
			System.out.println("1. 현금 입금");
			System.out.println("2. 현금 출금");
			System.out.println("3. 이체");
			System.out.println("4. 잔액 확인");
			System.out.println("5. 프로그램 종료");
			System.out.println("");
			System.out.println("=======================================");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			System.out.println("");

			switch (select) {

			case 1:
				System.out.println("얼마를 입금하시겠습니까?");
				while (true) {
					System.out.print("입금 금액 입력 > ");
					int inAmount = sc.nextInt();
					if (inAmount > 0) {
						System.out.println("");
						System.out.printf("입력하신 금액이 %d원이 맞습니까[1.yes/2.no]?\n", inAmount);
						System.out.print("선택 > ");
						int amountCheck = sc.nextInt();
						if (amountCheck == 1) {
							atm.input(inAmount);
							break;
						} else if (amountCheck == 2) {
							atm.rewrite();
							return;
						} else {
							System.out.println("1과 2 중에 선택하여 주십시오.");
							break;
						}

					} else {
						System.out.println("금액이 잘못되었습니다. 다시 입력해주세요.\n");
					}
				}
				break;
			case 2:
				System.out.println("얼마를 출금하시겠습니까?");
				while (true) {
					System.out.print("출금 금액 입력 > ");
					int outAmount = sc.nextInt();
					if (outAmount < atm.statusAmount) {
						System.out.println("");
						System.out.printf("입력하신 금액이 %d원이 맞습니까[1.yes/2.no]?\n", outAmount);
						System.out.print("선택 > ");
						int amountCheck = sc.nextInt();
						if (amountCheck == 1) {
							atm.widraw(outAmount);
							break;
						} else if (amountCheck == 2) {
							atm.rewrite();
							return;
						} else {
							System.out.println("1과 2 중에 선택하여 주십시오.");
							break;
						}

					} else {
						System.out.printf("출금 가능 금액 %d원을 초과하였습니다.\n다시 입력해주세요.\n", atm.statusAmount);
					}
				}
				break;
			case 3:
				System.out.println("이체 방식을 선택해주세요(번호입력)");
				System.out.println("1. 당행이체");
				System.out.println("2. 타행이체");
				System.out.println("");
				System.out.print("선택 > ");
				int transferSelect = sc.nextInt();
				switch (transferSelect) {
				case 1:
					atm.sameBank();
					break;
				case 2:
					atm.differentBank();
					break;
				}
				break;
			case 4:
				System.out.printf("현재 잔고는 %d원입니다.", atm.statusAmount);
				System.out.println("\n초기 화면으로 돌아갑니다.");
				break;
			case 5:
				System.out.println("");
				System.out.println("또 오세요, 소듕한 호갱님");
				return;
			}

		}

	}

}
