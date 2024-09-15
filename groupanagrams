class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> anagramMap = new HashMap<>();

        for(String word:strs){
            char[] arr = word.toCharArray();
            Arrays.sort(arr);

            String newWord = new String(arr);

            if(!anagramMap.containsKey(newWord)) anagramMap.put(newWord,new ArrayList<>());

            anagramMap.get(newWord).add(word);

        }

        return new ArrayList<>(anagramMap.values());
    }
}
