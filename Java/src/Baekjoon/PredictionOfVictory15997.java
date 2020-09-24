package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PredictionOfVictory15997 {
    private static Match[] matches;
    private static int[] score;
    private static double[] resultProb;

    public static void main(String args[]) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        score = new int[4];
        resultProb = new double[4];
        matches = new Match[6];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splits = br.readLine().split(" ");
        map.put(splits[0], 0);
        map.put(splits[1], 1);
        map.put(splits[2], 2);
        map.put(splits[3], 3);


        for(int i=0; i<6; i++) {
            splits = br.readLine().split(" ");
            int home = map.get(splits[0]);
            int away = map.get(splits[1]);
            double win = Double.parseDouble(splits[2]);
            double dual = Double.parseDouble(splits[3]);
            double lose = Double.parseDouble(splits[4]);
            matches[i] = new Match(home, away, win, dual, lose);
        }

        dfs(0, 1.0);
        for(double e:resultProb) {
            System.out.println(e);
        }
    }

    public static void dfs(int n, double p) {
        if(n == 6) {
            ScoreNode[] nodes = new ScoreNode[4];
            for(int i=0; i<4; i++) {
                nodes[i] = new ScoreNode(i, score[i]);
            }
            Arrays.sort(nodes);

            if(nodes[1].value != nodes[2].value) {
                resultProb[nodes[2].idx] += p;
                resultProb[nodes[3].idx] += p;
            }
            else if(nodes[0].value == nodes[1].value && nodes[2].value == nodes[3].value) {
                resultProb[nodes[0].idx] += p / 2.0;
                resultProb[nodes[1].idx] += p / 2.0;
                resultProb[nodes[2].idx] += p / 2.0;
                resultProb[nodes[3].idx] += p / 2.0;
            }
            else if(nodes[0].value == nodes[1].value) {
                resultProb[nodes[0].idx] += p / 3.0;
                resultProb[nodes[1].idx] += p / 3.0;
                resultProb[nodes[2].idx] += p / 3.0;
                resultProb[nodes[3].idx] += p;
            }
            else if(nodes[2].value == nodes[3].value){
                resultProb[nodes[1].idx] += (2*p)/3.0;
                resultProb[nodes[2].idx] += (2*p)/3.0;
                resultProb[nodes[3].idx] += (2*p)/3.0;
            }
            else {
                resultProb[nodes[1].idx] += p/2.0;
                resultProb[nodes[2].idx] += p/2.0;
                resultProb[nodes[3].idx] += p;
            }
            return;
        }
        int home = matches[n].home;
        int away = matches[n].away;
        double win = matches[n].win;
        double dual = matches[n].dual;
        double lose = matches[n].lose;

        score[home] += 3;
        dfs(n+1, p * win);
        score[home] -= 3;

        score[home] += 1;
        score[away] += 1;
        dfs(n+1, p * dual);
        score[home] -= 1;
        score[away] -= 1;

        score[away] += 3;
        dfs(n+1, p * lose);
        score[away] -= 3;
    }
}
class ScoreNode implements Comparable{
    int idx;
    int value;

    @Override
    public int compareTo(Object o) {
        return this.value - ((ScoreNode)o).value;
    }

    public ScoreNode(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}

class Match {
    int home;
    int away;
    double win;
    double dual;
    double lose;

    public Match(int home, int away, double win, double dual, double lose) {
        this.home = home;
        this.away = away;
        this.win = win;
        this.dual = dual;
        this.lose = lose;
    }
}