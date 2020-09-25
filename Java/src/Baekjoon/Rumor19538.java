package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Rumor19538 {
    private static List<Integer>[] adList;
    private static Queue<Integer> queue;
    private static int[] threshold;
    private static int[] d;
    private static int[] count;
    private static Map<Integer, Integer> map;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numHuman =  Integer.parseInt(br.readLine());
        adList = new List[numHuman + 1];
        queue = new LinkedList<>();
        map = new HashMap<>();
        threshold = new int[numHuman + 1];
        d = new int[numHuman + 1];
        count = new int[numHuman + 1];
        Arrays.fill(d, -1);

        for(int i=0; i<numHuman + 1; i++) {
            adList[i] = new ArrayList<>();
        }

        // fill adlist
        for(int k=1; k<numHuman + 1; k++) {
            String[] splits = br.readLine().split(" ");
            for (int i = 0; i < splits.length; i++) {
                int x = Integer.parseInt(splits[i]);
                if (x == 0) {
                    break;
                }

                adList[k].add(x);
            }
        }

        // rumors
        int numRumor = Integer.parseInt(br.readLine());
        String[] splits = br.readLine().split(" ");
        for(int i=0; i<numRumor; i++) {
            int n = Integer.parseInt(splits[i]);
            queue.add(n);
            d[n] = 0;
        }

        // threshold
        // map
        for(int i=1; i<numHuman + 1; i++) {
            threshold[i] = (adList[i].size() + 1) / 2;
            map.put(i, 0);
        }

        while(!queue.isEmpty()) {
            int n = queue.poll();

            for(int e : adList[n] ) {
                if(d[e] == -1) {
                    count[e] += 1;
                    if(count[e] >= threshold[e]) {
                        queue.add(e);
                        d[e] = map.get(n) + 1;
                        map.replace(e, d[e]);
                    }
                }
            }
        }

        for(int i=1; i<numHuman + 1; i++) {
            System.out.print(d[i]+" ");
        }
    }
}