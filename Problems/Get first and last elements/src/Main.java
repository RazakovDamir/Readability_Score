import java.util.*;

public class Main {

    public static int[] getFirstAndLast(int[] array) {
        int[] a = new int[2];
        a[0] = array[0];
        a[1] = array[array.length - 1];
        return a;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] result = getFirstAndLast(array);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
}