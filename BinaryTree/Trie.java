package BinaryTree;

// Trie is used for information retrieval, autocomplete, google search - Time complexity - O(M), M = word length

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private class TrieNode {

        Map<Character, TrieNode> map;
        boolean isLeaf;
        public TrieNode(){
            map = new HashMap<>();
            isLeaf = false;
        }

    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }


    public void insert(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            Character ch = word.charAt(i);
            TrieNode node = current.map.get(ch);
            if(node == null){
                node = new TrieNode();
                current.map.put(ch,node);
            }
            current = node;
        }
        current.isLeaf = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            if(current.map.get(word.charAt(i)) == null)
                return false;
            current = current.map.get(word.charAt(i));
        }
        return current.isLeaf;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i=0;i<prefix.length();i++){
            if(current.map.get(prefix.charAt(i))==null)
                return false;
            current = current.map.get(prefix.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("app");
        obj.insert("apple");
        obj.insert("beer");
        obj.insert("add");
        obj.insert("jam");
        obj.insert("rental");
        boolean param_2 = obj.search("apps");
        System.out.println(obj.search("app"));
        boolean param_3 = obj.startsWith("a");
        System.out.println(param_2);
        System.out.println(param_3);
    }
}
