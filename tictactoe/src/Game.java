import java.util.Scanner;
public class Game {
    Board board = new Board();

    public void play() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter player symbol: ");
        char symbol = sc.next().charAt(0);
        Player p1 = new Player(1, symbol);

        System.out.print("Enter player symbol: ");
        symbol = sc.next().charAt(0);
        Player p2 = new Player(2, symbol);
        Player next = p2;
        int count = 0;
        p1.move(board);
        this.board.printGrid(p1, p2);
        while(count < 8){
            next.move(board);
            this.board.printGrid(p1, p2);
            if (board.winCheck(next)){
                System.out.println("Player " + next.getPid() + " won.");
                return;
            }
            if (next == p1){
                next = p2;
            }else{
                next = p1;
            }
            count++;
        }
        System.out.println("Draw");
    }
}