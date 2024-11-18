public class Board {
    int[][] grid = new int[3][3];


    public void printGrid(Player p1, Player p2) {
        for (int k = 0; k < grid.length+ 1; k++){
            System.out.print("———");
        }
        System.out.println("—");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < grid[i].length; j++) {
                int p = grid[i][j];
                if (p == 1){
                    System.out.print(p1.getSymbol() + " | ");
                } else if (p==2) {
                    System.out.print(p2.getSymbol() + " | ");
                }else{
                    System.out.print("  | ");
                }
            }
            System.out.println();
            for (int k = 0; k < grid.length+ 1; k++){
                System.out.print("———");
            }

            System.out.println("—");
        }

    }

    public boolean winCheck(Player p){
        int pid = p.getPid();
        int counth;
        int countv;
        for (int x = 0; x < 3; x++){
            counth = 0;
            countv = 0;
            for (int y = 0; y < 3; y++){
                if (this.grid[x][y] == pid){
                    counth++;
                }
                if (this.grid[y][x] == pid){
                    countv++;
                }
            }
            if (counth == 3 || countv == 3){
                return true;
            }
        }
        return (this.grid[0][0] == pid && this.grid[1][1] == pid && this.grid[2][2] == pid) || (this.grid[0][2] == pid && this.grid[1][1] == pid && this.grid[2][0] == pid);
    }
}