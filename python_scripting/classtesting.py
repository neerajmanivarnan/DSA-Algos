class Square:

    def __init__(self,length):
        self.length = length
    
    def calculate_area(self):
        self.area = self.length *  self.length

        
    def __str__(self):
        # self.calculate_area()
        return "An Square with the length {} and area {}".format(self.length,self.area)

newsquare = Square(5)
print(newsquare)
