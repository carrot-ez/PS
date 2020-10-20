package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LIS5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] splits = br.readLine().split(" ");

        List<Integer> list = new ArrayList<>();
        int[] idx = new int[N];
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        list.add(Integer.parseInt(splits[0]));

        for(int i=1; i<N; i++) {
            if( arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
                idx[i] = list.size() - 1;
            }
            else {
                int b = binarySearch(list, arr[i]);
                list.set(b, arr[i]);
                idx[i] = b;
            }
        }

        Stack<Integer> stack = new Stack<>();
        int max = list.get(list.size()-1);
        int size = list.size() - 1;
        for(int i = N-1; i>= 0; i--) {
            if(arr[i] <= max && size == idx[i]) {
                max = arr[i];
                stack.push(max);
                size--;
            }
        }

        System.out.println(stack.size());
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }

    public static int binarySearch(List<Integer> list, int e) {
        int l = 0;
        int r = list.size() - 1;

        while(l < r) {
            int mid = (l + r) / 2;

            if(list.get(mid) >= e) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return l;
    }
}
