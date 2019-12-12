import java.util.Scanner;

public class WordGameApp {
	private Scanner scanner; // Ű���� �Է�
	private String startWord = "�ƹ���"; // ���� �ܾ�
	private Player[] players; // ���� �����ڵ�
	
	public WordGameApp() {
		scanner = new Scanner(System.in);	
	}

	// ���� ������ ���� �Է¹ް� Player []�� �����ϴ� �޼ҵ�
	private void createPlayers() {
		System.out.print("���ӿ� �����ϴ� �ο��� ����Դϱ�>>");
		int nPlayers = scanner.nextInt();
		players = new Player[nPlayers]; // Player [] ���۷��� �迭 ����
		
		// �� �������� �̸��� �Է¹޾� Player ��ü ����
		for(int i=0; i<nPlayers; i++) {
			System.out.print("�������� �̸��� �Է��ϼ���>>");
			String name = scanner.next();
			players[i] = new Player(name);
		}		
	}
	
	// ������ �����ϴ� �޼ҵ�
	public void run() {
		createPlayers(); // �����ڸ� ���� Player []�� �����Ѵ�.
		String lastWord = startWord; // startWord���� ���� �����Ѵ�.

		System.out.println("�����ϴ� �ܾ�� "+lastWord+ "�Դϴ�");
		int next =  0; // �����ڵ��� ������� ����
		
		// ������ ���� ������ ����
		while(true) {
			String newWord = players[next].sayWord(); // next �����ڰ� �ܾ ���ϵ��� �Ѵ�.
			if(!players[next].succeed(lastWord)) { // next �����ڰ� �����Ͽ����� �˻�.
				System.out.print(players[next].getName() + "�� �����ϴ�.");
				break; // ������ �����Ѵ�.
			}
			next++; // ���� ������
			next %= players.length; // next�� �������� �������� ���� �����ϴ� ���� ���´�.
			lastWord = newWord;
		}
	}
	
	public static void main(String[] args) {
		WordGameApp game = new WordGameApp();
		game.run();
	}
}


// �� ����� �����ڸ� ǥ���ϴ� Ŭ����
class Player {
	Scanner scanner; // Ű���� �Է�
	private String name; // ���� �������� �̸�
	private String word; // �����ڰ� ���� �ܾ�
	
	public Player(String name) {
		this.name = name;
		scanner = new Scanner(System.in);	
	}
	
	public String getName() {return name;}
	
	public String sayWord() {
		System.out.print(name+">>");
		word = scanner.next();
		return word;
	}
	
	// lastWord�� �����ڰ� ���� word�� ���Ͽ� �����ձⰡ �ߵǾ����� �Ǵ�.
	// �����Ͽ����� true ����
	public boolean succeed(String lastWord) {
		int lastIndex = lastWord.length()-1; // ���� �ܾ��� �� ������ ������ �ε���
		
		// ���� �ܾ��� �� ������ ���ڿ� �����ڰ� ���� �ܾ��� ù ���ڰ� ������ ��
		if(lastWord.charAt(lastIndex) == word.charAt(0))
			return true;
		else
			return false;
	}
}