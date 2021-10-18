import java.util.Scanner;

class Assignment6B {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int size, highestNum, option = 0;
    int[] arr;

    System.out.print("How large should the array be? ");
    size = sc.nextInt();

    System.out.print("What should be the highest number in the sequence? ");
    highestNum = sc.nextInt();

    arr = new int[size];

    System.out.println();

    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int)(Math.random() * (highestNum + 1));
      System.out.print(arr[i] + ", ");
    }

    do {
      System.out.println("\n\n[Options]");
      System.out.println("1) Reset the array");
      System.out.println("2) Sort (Smallest to Largest)");
      System.out.println("3) Sort (Largest to Smallest)");
      System.out.println("4) Quit");

      do {
        System.out.print("Choice? ");
        option = sc.nextInt();
      } while (option < 1 || option > 4);

      switch (option) {
        case 1:
          System.out.println("\nResetting the array:");
          
          for (int i : arr) {
            System.out.print(i + ", ");
          }
          break;

        case 2:
          System.out.println("\nUsing Insertion Sort:");

          for (int i : insertionSort(arr)) {
            System.out.print(i + ", ");
          }
          break;

        case 3:
          System.out.println("\nUsing Selection Sort:");
          
          for (int i : selectionSort(arr)) {
            System.out.print(i + ", ");
          }
          break;

        case 4:
          System.out.println("\nClosing out...");
      }
    } while (option != 4);
  }

  private static int[] insertionSort(int[] arr) {
      int[] temp = arr.clone();

      for (int i = 0; i < temp.length; i++) {
        int key = temp[i];
        int pos = i;

        while (pos > 0 && key < temp[pos-1]) {
          temp[pos] = temp[pos-1];
          pos--;
        }
        temp[pos] = key;
      }

      return temp;
  }

  private static int[] selectionSort(int[] arr) {
    int[] temp = arr.clone();

    for (int i = 0; i < temp.length - 1; i++) {
      int max = i;

      for (int j = i + 1; j < temp.length; j++) {
        if (temp[max] < temp[j]) max = j;
      }

      if (max != i) {
        int temp_ = temp[i];
        temp[i] = temp[max];
        temp[max] = temp_;
      }
    }

    return temp;
  }
}