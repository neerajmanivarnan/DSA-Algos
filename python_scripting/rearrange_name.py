#!/usr/bin/env python3
import re 

def rearrange(name):
    pattern = r"([\w.]*), ([\w.]*)$"
    result = re.search(pattern,name)
    return "result is : {} {}".format(result[0],result[1])

print(rearrange("Lovelace, Ada"))
