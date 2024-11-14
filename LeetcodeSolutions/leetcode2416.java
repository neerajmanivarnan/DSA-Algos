import java.util.*;

public class leetcode2416 {

  class TrieNode {
    TrieNode[] children;
    int count;

    public TrieNode() {
      children = new TrieNode[26];
      count = 0;
    }
  }

  class Trie {
    TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    public void insert(String word) {
      TrieNode node = root;
      for (char c : word.toCharArray()) {
        int index = c - 'a';
        if (node.children[index] == null) {
          node.children[index] = new TrieNode();
        }
        node = node.children[index];
        node.count++;
      }
    }

    public int getPrefixScore(String word) {
      TrieNode node = root;
      int score = 0;
      for (char c : word.toCharArray()) {
        int index = c - 'a';
        node = node.children[index];
        score += node.count;
      }
      return score;
    }
  }

  public int[] sumPrefixScores(String[] words) {
    Trie trie = new Trie();
    int[] result = new int[words.length];

    for (String word : words) {
      trie.insert(word);
    }

    for (int i = 0; i < words.length; i++) {
      result[i] = trie.getPrefixScore(words[i]);
    }

    return result;
  }

}
