package nath;

public class Main {
    public static void main(String[] args) {
        int comb = Combination.getCombination(6, 2);
        int[] arr = {2, 5, 8, 10};
        boolean[] visited = new boolean[arr.length];
        Combination.printCombination2(arr, visited, 0, 4, 2);
    }
}
