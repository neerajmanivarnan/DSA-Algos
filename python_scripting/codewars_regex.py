import re 

def extract_file_name(dirty_file_name):
    pattern = r"([\d+]*)\_([\w+]*\.[\w]*)\.([\w]*)"
    result  = re.findall(pattern,dirty_file_name)
    return result[0][1]


print(extract_file_name("1231231223123131_FILE_NAME.EXTENSION.OTHEREXTENSION"))



def domain_name(url):
    pattern = r"(http://)(\w*\-*\w*)\.[\w]+"
    result =  re.findall(pattern,url)
    return result[0][1]

print(domain_name("http://neerajmanivarnan.com/neerajmanivarnan"))
