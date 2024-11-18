import java.util.Scanner;

public class Player {
    int pid;
    char symbol;
    int wins = 0;

    public Player(int pid, char symbol){
        this.pid = pid;
        this.symbol = symbol;
    }

    public int getPid() {
        return pid;
    }

    public char getSymbol() {
        return symbol;
    }
    public void move(Board board){
        Scanner sc = new Scanner(System.in);
        boolean occupied = false;
        int tx = 8;
        int ty = 8;
        int x;
        int y;
        do {
            while ((tx > 3) || (ty > 3)) {
                System.out.println("Player " + this.getPid());
                System.out.print("Enter X [1-3] Y [1-3] coordinates for your next move: ");
                tx = sc.nextInt();
                ty = sc.nextInt();
            }
            x = 3 - tx;
            y = ty - 1;
            occupied = false;
            if (board.grid[x][y] != 0){
                System.out.print("That place is already occupied! \n");
                occupied = true;
                tx = 5;
            }
        }while(occupied);
        board.grid[x][y] = this.getPid();
        System.out.println("Your move: \nX: " + tx + " Y: " + ty);

    }
}