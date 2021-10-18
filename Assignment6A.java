class Assignment6A {
  public static void main(String args[]) {
    int[] numbers = new int[1000000];
    int target = (int)(Math.random() * numbers.length);

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i;
    }

    System.out.println("Comparing Linear Search and Binary Search:");
    System.out.println("Our target is " + target);

    int linear = linearSearch(numbers, target), binary = binarySearch(numbers, 0, numbers.length, target);

    System.out.println("Linear Search: " + linear + " loop(s)");
    System.out.println("Binary Search: " + binary + " guess(es)");

    if (linear > binary) {
      System.out.println("Binary Search is faster this time!");
    } else if (linear < binary) {
      System.out.println("Linear Search is faster this time!");
    } else System.out.println("Both were equally as fast");
  }

  private static int linearSearch(int[] arr, int target) {
    int loops = 0;

    for (int i : arr) {
      loops++;
      if (target == i) return loops;
    }

    return -1;
  }

  private static int binarySearch(int[] arr, int low, int high, int target) {
    int guesses = 0, mid;
    
    while (true) {
      guesses++;
      mid = (low + high) / 2;

      if (target == arr[mid]) return guesses;

      if (target < arr[mid]) {
        high = mid;
      } else low = mid;

      if (low >= high - 1) return -1;
    }
  }
}