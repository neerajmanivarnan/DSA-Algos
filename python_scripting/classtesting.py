class Square:

    def __init__(self,length,area):
        self.length = length
    
    def calculate_area(self,area):
        self.area = self.length *  self.length

        
    def __str__(self):
        return "An Square with the length {} and area {}".format(self.length,self.area)

newsquare = Square(5)
print(newsquare)
