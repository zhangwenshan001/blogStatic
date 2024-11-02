

class Solution:
    """HBD for daily1102 problem(2490: Circular Sentence)
    Keyword dayly problem(1102):
    argument -- string
    Return: Bool
    """
    
    def isCircularSentence(self, sentence: str) -> bool:
        sentence_list = sentence.split(" ")
        sentence_list2 = sentence_list[1:] + [sentence_list[0]]        
        for s1, s2 in zip(sentence_list, sentence_list2):
            if s1[-1] != s2[0]:
                return False

        return True