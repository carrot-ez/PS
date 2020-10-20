package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LIS1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] splits = br.readLine().split(" ");

        // LIS의 last element를 저장할 리스트
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(splits[0]));

        for(int i=1; i<N; i++) {
            int x = Integer.parseInt(splits[i]);
            if(x > list.get(list.size()-1)) {
                list.add(x);
            }
            else {
                list.set(binarySearch(list, x), x);
            }
        }

        System.out.println(list.size());
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
