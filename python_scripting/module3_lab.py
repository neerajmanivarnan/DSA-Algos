import re

def find_url(website):
 pattern = r"https://[\w+.-]+\.com"#enter the regex pattern here
 result = re.findall(pattern, website) #enter the re method here
 return result


print(find_url("Go to the website https://www.coursera.com find more information about Google Certificate Programs. Then, visit https://www.python.org/ to learn more about Python. ")) # Should return ['https://www.coursera.com', 'https://www.python.org']
print(find_url("You can find anything on https://www.google.com!")) # Should return ['https://www.google.com']
print(find_url("You can find anything on http://www.google.com!")) # Should return []
print(find_url("Check out python.org!")) # Should return []
