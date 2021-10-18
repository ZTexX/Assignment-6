import java.util.Scanner;

class Assignment6C {
  static class Grid {
    private int size;
    private char[][][] grid;

    public Grid(int size) {
      this.size = size;
      grid = new char[size][size][2];
    }

    public void Initialize() {
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          grid[i][j][0] = '?';
          grid[i][j][1] = '_';
        }
        grid[i][(int)(Math.random() * (grid[i].length))][1] = 'X';
      }
    }

    public void printGrid() {
      for (char[][] grid : grid) {
        for (char[] grid_ : grid) {
          System.out.print(grid_[0]);
        }
        System.out.println();
      }
    }

    public boolean Reveal(int x, int y) {
      grid[y][x][0] = grid[y][x][1];

      System.out.println();
      printGrid();

      return grid[y][x][0] == '_';
    }
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int size, x, y, counter = 0;

    System.out.println("[Minesweeper - DOS Edition]");

    System.out.print("What is the grid size? ");
    size = sc.nextInt();

    Grid grid = new Grid(size);
    grid.Initialize();

    grid.printGrid();

    do {
      counter++;

      do {
        System.out.print("Enter your X Coordinate: ");
        x = sc.nextInt();

        System.out.print("Enter your Y Coordinate: ");
        y = sc.nextInt();
      } while (x < 0 || y < 0 || x > size - 1 || y > size - 1);

      if (!grid.Reveal(x, y)) {
        System.out.println("Sorry, you hit a mine!");
        break;
      }
    } while (counter < size);

    if (counter == size) {
      System.out.println("You win!");
    }
  }
}