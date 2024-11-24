class Solution:
    def isCircularSentence(self, sentence: str) -> bool:

        length = len(sentence)

        if sentence[0] != sentence[length - 1]:
            return False

        for i in range(0,length-1):
            if sentence[i] == ' ':
                if sentence[i-1] != sentence[i+1]:
                    return False
                
        return True
