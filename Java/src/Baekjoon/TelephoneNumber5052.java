package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TelephoneNumber5052 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            boolean flag = false;
            Trie tr = new Trie();

            for(int k=0; k<n; k++) {
                String s = br.readLine();
                if( !tr.insert(s) ) {
                    flag = true;
                }
            }

            if(flag)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}


class Trie {
    private TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    boolean insert(String word) {
        TrieNode node = this.rootNode;

        for(int i=0; i<word.length(); i++) {
            node = node.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            if(node.isLastChar()) {
                return false;
            }
        }
        node.setLastChar(true);
        if(!node.getChildNodes().isEmpty()) {
            return false;
        }
        return true;
    }
}

class TrieNode {
    private Map<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLastChar = false;

    public Map<Character, TrieNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(Map<Character, TrieNode> childNodes) {
        this.childNodes = childNodes;
    }

    public boolean isLastChar() {
        return isLastChar;
    }

    public void setLastChar(boolean isLastChar) {
        this.isLastChar = isLastChar;
    }
}