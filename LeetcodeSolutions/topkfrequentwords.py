class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:

        my_dict = {}

        for word in words:
            if word not in my_dict:
                my_dict[word] = 0
            my_dict[word]+=1
        
        max_words = []

        sorted_by_keys = dict(sorted(my_dict.items()))

        for i in range(k):
            max_word = max (sorted_by_keys,key=sorted_by_keys.get)
            sorted_by_keys.pop(max_word)
            max_words.append(max_word)
        
        return max_words
        
