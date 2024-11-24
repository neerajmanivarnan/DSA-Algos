#!/usr/bin/env python3


import re


def validate_email(username):
    pattern = r"[\w.%+-^_]+@[\w.-]+"
    if re.search(pattern,username):
        print("{} is valid".format(username))
    else:
        print("{} is not valid".format(username))



validate_email("neerajmanivarnan@gmail.com")
validate_email("neeraj.manivarnan@gmail.com")
validate_email("neeraj+manivarna%.@gmail.com")
validate_email("neeraj+-manivarna%.@gmail.com")
validate_email("neeraj_manivarnan@us-india.com")
validate_email("neerajmanivarnan@us-india.com")
