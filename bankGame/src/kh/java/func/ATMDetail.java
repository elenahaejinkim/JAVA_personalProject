package kh.java.func;

import java.util.Scanner;

public class ATMDetail {
	Scanner sc = new Scanner(System.in);
	// 입금, 출금, 잔액
	public boolean compareAmount = false;
	public int statusAmount = 5000000;

	// 아스키 아트1
	public void frontScreen() {
		System.out.println("");
		System.out.println(" $$\\                        $$\\       ");
		System.out.println(" $$ |                       $$ |      ");
		System.out.println(" $$$$$$$\\  $$$$$$\\ $$$$$$$\\ $$ |  $$\\ ");
		System.out.println(" $$  __$$\\ \\____$$\\$$  __$$\\$$ | $$  |");
		System.out.println(" $$ |  $$ |$$$$$$$ $$ |  $$ $$$$$$  / ");
		System.out.println(" $$ |  $$ $$  __$$ $$ |  $$ $$  _$$<  ");
		System.out.println(" $$$$$$$  \\$$$$$$$ $$ |  $$ $$ | \\$$\\ ");
		System.out.println(" \\_______/ \\_______\\__|  \\__\\__|  \\__|");
	}

	// 기본 입금 - 후에 case 1 과정도 빼올 것.
	public void input(int inAmount) {
		statusAmount += inAmount;
		System.out.printf("입금된 금액 : %d원\n", inAmount);
		System.out.println("◆◇◇◇◇");
		delay(1 * 500);
		System.out.println("◆◆◇◇◇");
		delay(1 * 500);
		System.out.println("처리중");
		delay(1 * 500);
		System.out.println("◆◆◆◇◇");
		delay(1 * 500);
		System.out.println("◆◆◆◆◇");
		delay(1 * 500);
		System.out.println("입금이 완료되었습니다.");
	}

	// 기본 출금 - 후에 case 2 과정도 빼올 것.
	public void widraw(int outAmount) {
		statusAmount -= outAmount;
		System.out.printf("출금된 금액 : %d원\n", outAmount);
		System.out.println("◆◇◇◇◇");
		delay(1 * 500);
		System.out.println("◆◆◇◇◇");
		delay(1 * 500);
		System.out.println("처리중");
		delay(1 * 500);
		System.out.println("◆◆◆◇◇");
		delay(1 * 500);
		System.out.println("◆◆◆◆◇");
		delay(1 * 500);
		System.out.println("출금이 완료되었습니다.");
	}

	// 당행이체 - 나중에 타행이체랑 합쳐볼 것.
	public void sameBank() {
		System.out.println("계좌를 입력하세요(숫자만 입력).");
		System.out.print("입력 > ");
		String account = sc.next();
		System.out.println("얼마를 이체하시겠습니까?");
		while (true) {
			System.out.print("이체 금액 입력 > ");
			int outAmount = sc.nextInt();
			if (outAmount < statusAmount) {
				System.out.println("");
				System.out.printf("입력하신 금액이 %d원이 맞습니까[1.yes/2.no]?\n", outAmount);
				System.out.print("선택 > ");
				int amountCheck = sc.nextInt();
				if (amountCheck == 1) {
					widraw(outAmount);
					break;
				} else if (amountCheck == 2) {
					rewrite();
					continue;
				} else {
					System.out.println("1과 2 중에 선택하여 주십시오.");
					break;
				}

			} else if (statusAmount <= 0) {
				System.out.println("출금 가능한 금액이 없습니다. 거지래요~~~거지래요~~~~~");
				System.out.println("당신의 경제력이 없으므로, 시스템을 종료합니다.");
				return;
			} else {
				System.out.printf("이체 가능 금액 %d원을 초과하였습니다.\n다시 입력해주세요.\n", statusAmount);
			}
		}
	}

	// 타행이체 인출
	public void differentBankWidraw(int outAmount) {
		statusAmount -= (outAmount + 900);
		System.out.println("◆◇◇◇◇");
		delay(1 * 500);
		System.out.println("◆◆◇◇◇");
		delay(1 * 500);
		System.out.println("처리중");
		delay(1 * 500);
		System.out.println("◆◆◆◇◇");
		delay(1 * 500);
		System.out.println("◆◆◆◆◇");
		delay(1 * 500);
		System.out.printf("출금된 금액 : %d원\n", outAmount);
		System.out.println("수수료 : 900원");
		System.out.printf("전체 출금 금액 : %d원\n", outAmount + 900);
		System.out.println("타행이체가 완료되었습니다.");
	}

	// 타행이체
	public void differentBank() {
		System.out.println("타행이체를 선택하시면 수수료(900원)가 부과됩니다.\n거래를 진행하시겠습니까[1.yes/2.no]?");
		System.out.print("선택 > ");
		int transselect = sc.nextInt();
		if (transselect == 1) {
			System.out.println("\n은행을 선택해주세요.");
			System.out.println("1. 궁민 은행");
			System.out.println("2. 아진짜자습그만하고집에가고싶다 은행");
			System.out.println("3. 너네은행");
			System.out.print("선택 > ");
			int bankselect = sc.nextInt();
			System.out.println("계좌를 입력하세요(숫자만 입력).");
			System.out.print("입력 > ");
			String account = sc.next();

			switch (transselect) {
			case 1:
				System.out.println("얼마를 이체하시겠습니까?");
				while (true) {
					System.out.print("이체할 금액 입력 > ");
					int outAmount = sc.nextInt();
					if (outAmount < statusAmount) {
						System.out.println("");
						System.out.printf("입력하신 금액이 %d원이 맞습니까[1.yes/2.no]?\n", outAmount);
						System.out.print("선택 > ");
						int amountCheck = sc.nextInt();
						if (amountCheck == 1) {
							differentBankWidraw(outAmount);
							break;
						} else if (amountCheck == 2) {
							rewrite();
							continue;
						} else {
							System.out.println("1과 2 중에 선택하여 주십시오.");
							break;
						}

					} else if (statusAmount <= 0) {
						System.out.println("이체 가능한 금액이 없습니다. 거지래요~~~거지래요~~~~~");
						System.out.println("당신의 경제력이 없으므로, 시스템을 종료합니다.");
						return;
					} else {
						System.out.printf("이체 가능 금액 %d원을 초과하였습니다.\n다시 입력해주세요.\n", statusAmount);
					}
				}
				break;
			case 2:
				System.out.println("시스템을 종료합니다.");
				break;

			}
		} else {
			System.out.println("시스템을 종료합니다. 처음부터 다시 선택해주세요.");
			return;
		}
	}

	// 재입력 method
	public void rewrite() {
		while (true) {
			System.out.println("\n다시 입력하시겠습니까[1.yes/2.no]?");
			System.out.print("선택 > ");
			int inputCheck = sc.nextInt();
			if (inputCheck == 1) {
				break;
			} else if (inputCheck == 2) {
				System.out.println("");
				System.out.println("아니 뭐 어쩌라고 진짜;;; 에이 퉤퉤!!!!");
				System.out.println("시스템을 종료해버릴거임.");
				return;
			} else {
				System.out.println("");
				System.out.println("1과 2 중에 선택하여 주십시오.");
			}
		}
	}

	// 지연
	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
