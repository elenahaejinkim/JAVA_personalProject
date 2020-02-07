package kh.java.run;

import java.util.Scanner;

import kh.java.func.ATMDetail;

public class ATM {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ATMDetail atm = new ATMDetail();
		atm.frontScreen();
		while (true) {

			System.out.println("\n=========== ����(51) ���� ATM ============\n");
			System.out.println("�ȳ��ϼ��� ����. ������ ���͵帱���?\n");
			System.out.println("1. ���� �Ա�");
			System.out.println("2. ���� ���");
			System.out.println("3. ��ü");
			System.out.println("4. �ܾ� Ȯ��");
			System.out.println("5. ���α׷� ����");
			System.out.println("");
			System.out.println("=======================================");
			System.out.print("���� > ");
			int select = sc.nextInt();
			System.out.println("");

			switch (select) {

			case 1:
				System.out.println("�󸶸� �Ա��Ͻðڽ��ϱ�?");
				while (true) {
					System.out.print("�Ա� �ݾ� �Է� > ");
					int inAmount = sc.nextInt();
					if (inAmount > 0) {
						System.out.println("");
						System.out.printf("�Է��Ͻ� �ݾ��� %d���� �½��ϱ�[1.yes/2.no]?\n", inAmount);
						System.out.print("���� > ");
						int amountCheck = sc.nextInt();
						if (amountCheck == 1) {
							atm.input(inAmount);
							break;
						} else if (amountCheck == 2) {
							atm.rewrite();
							return;
						} else {
							System.out.println("1�� 2 �߿� �����Ͽ� �ֽʽÿ�.");
							break;
						}

					} else {
						System.out.println("�ݾ��� �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���.\n");
					}
				}
				break;
			case 2:
				System.out.println("�󸶸� ����Ͻðڽ��ϱ�?");
				while (true) {
					System.out.print("��� �ݾ� �Է� > ");
					int outAmount = sc.nextInt();
					if (outAmount < atm.statusAmount) {
						System.out.println("");
						System.out.printf("�Է��Ͻ� �ݾ��� %d���� �½��ϱ�[1.yes/2.no]?\n", outAmount);
						System.out.print("���� > ");
						int amountCheck = sc.nextInt();
						if (amountCheck == 1) {
							atm.widraw(outAmount);
							break;
						} else if (amountCheck == 2) {
							atm.rewrite();
							return;
						} else {
							System.out.println("1�� 2 �߿� �����Ͽ� �ֽʽÿ�.");
							break;
						}

					} else {
						System.out.printf("��� ���� �ݾ� %d���� �ʰ��Ͽ����ϴ�.\n�ٽ� �Է����ּ���.\n", atm.statusAmount);
					}
				}
				break;
			case 3:
				System.out.println("��ü ����� �������ּ���(��ȣ�Է�)");
				System.out.println("1. ������ü");
				System.out.println("2. Ÿ����ü");
				System.out.println("");
				System.out.print("���� > ");
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
				System.out.printf("���� �ܰ�� %d���Դϴ�.", atm.statusAmount);
				System.out.println("\n�ʱ� ȭ������ ���ư��ϴ�.");
				break;
			case 5:
				System.out.println("");
				System.out.println("�� ������, �ҵ��� ȣ����");
				return;
			}

		}

	}

}
