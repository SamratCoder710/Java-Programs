package com.coder.sanam;


class Trie {
	
	class TrieNode {
	    private boolean isEndOfWord;
	    private TrieNode[] children;

	    public TrieNode(){
	        this.isEndOfWord = false;
	        this.children = new TrieNode[26];
	    }
	}

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch-'a'] == null) {
            	curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
    	TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch-'a'] == null) {
            	return false;
            }
            curr = curr.children[ch-'a'];
        }
        return curr.isEndOfWord;
        
    }
    
    public boolean startsWith(String prefix) {
    	TrieNode curr = root;
        for(char ch : prefix.toCharArray()){
            if(curr.children[ch-'a'] == null) {
            	return false;
            }
            curr = curr.children[ch-'a'];
        }
        return true;
        
    }
    
    public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.startsWith("app"));
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
