
public class Client {

	public static void main(String[] args) {
		Game game = new Game();
		game.deal();
		System.out.println(game.calcMinCardsForDeclare());

	}

}
