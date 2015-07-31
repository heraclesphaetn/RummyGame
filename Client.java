
public class Client {

	public static void main(String[] args) {
		CardGame game = new CardGame();
		game.deal();
		System.out.println(game.calcMinCardsForDeclare());

	}

}
