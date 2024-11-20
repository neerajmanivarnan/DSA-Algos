#!/usr/bin/env python3

import re

regex_pattern = r"\[(\d+)\]"

i = 0


with open("file.txt","r") as file:

    for line in file:
        result =  re.search(regex_pattern,line)
        if not result:
            print("No log lines detected")
        else:
            print("line number {} : log_number :{}".format(i,result[1]))
        i+=1



