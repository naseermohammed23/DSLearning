package Trie;

import java.util.HashMap;
import java.util.Map;


class TrieNode {
    char ch;
    boolean isWord = false;
    Map<Character, TrieNode> trieMap;

    TrieNode(char _ch) {
        this.ch = _ch;
        trieMap = new HashMap<>();
    }

}

class Trie {

    TrieNode root;

    Trie() {
        root = new TrieNode((char)0);
    }

    public void add(String word) {
        TrieNode temp = root;
        for (int i=0; i<word.length();i++) {
            char ch = word.charAt(i);
            TrieNode child = temp.trieMap.get(ch);
            if (child == null) {
                child = new TrieNode(ch);
                temp.trieMap.put(ch, child);
            } 

            temp = child;
        }

        temp.isWord = true;
        
    }

    public void print() {
        TrieNode temp = root; 
        for (TrieNode node : temp.trieMap.values()) {
            StringBuilder stringBuilder = new StringBuilder();
            dfs(node, stringBuilder);
        }
    }

    private void dfs(TrieNode node, StringBuilder stringBuilder) {
        stringBuilder.append(node.ch);
        if (node.isWord) {
            System.out.println(stringBuilder.toString());
        }

        for (TrieNode n  : node.trieMap.values()) {
            dfs(n, stringBuilder);
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1 ); // backtrack will remove the last char in the stringbuilder.. 

        return; // optional 
    }

    boolean search(String word) {
        TrieNode temp = root;

        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            TrieNode child = temp.trieMap.get(ch);
            if (child == null) {
                return false;
            } else {
                if (child.isWord && i == word.length() - 1) {
                    return true;
                }
            }

            temp = child;
        }

        return false;
    }

    boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i=0;i<prefix.length();i++) {
            char ch = prefix.charAt(i);
            TrieNode child = temp.trieMap.get(ch);
            if (child == null) {
                return false;
            }

            temp = child;
        }

        return true;
    }

    
}



public class Trie2021 {
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("apple");
        trie.add("app");
        trie.add("hi");
        trie.add("he");
        trie.add("hip");
        
    
        trie.print();
        System.out.println("search app : " + trie.search("app"));
        System.out.println("search app using startsWith : " + trie.startsWith("app"));
            
    }
}
