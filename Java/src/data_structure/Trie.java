package data_structure;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = this.rootNode;

        for(int i=0; i<word.length(); i++) {
            node = node.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }

        node.setLastChar(true);
    }

    boolean contains(String word) {
        TrieNode node = this.rootNode;
        for(int i=0; i<word.length(); i++) {
            char character = word.charAt(i);

            TrieNode tn = node.getChildNodes().get(character);

            if(tn == null) {
                return false;
            }

            node = tn;
        }

        return node.isLastChar();
    }



}

class TrieNode {
    private Map<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLastChar;

    public Map<Character, TrieNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(Map<Character, TrieNode> childNodes) {
        this.childNodes = childNodes;
    }

    public boolean isLastChar() {
        return isLastChar;
    }

    public void setLastChar(boolean lastChar) {
        isLastChar = lastChar;
    }
}