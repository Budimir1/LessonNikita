package algoritms.ex_14;

public class Ex_14 {

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,0,0,0}
        };

        int x = 0, y = 0;
        int goalX = 3, goalY = 3;

        System.out.println("Путь:");
        while (x != goalX || y != goalY) {
            System.out.println("(" + x + "," + y + ")");

            if (x < goalX && grid[x+1] [y] == 0){
                x++;
            }
            else if (y < goalY && grid[x][y+1] == 0) {
                y++;
            }
            else if (x < goalX && y < goalY && grid[x+1][y+1] == 0) {
                x++; y++;
            }
            else {
                System.out.println("Путь заблокирован!");
                break;
            }
        }

        System.out.println("(" + x + "," + y + ")");
    }
}