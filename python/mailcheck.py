#!/usr/bin/env python3

import re

def is_mail(username):
    if re.match(r"^\w{6}@tkmce\.ac\.in$", username):
        return True
    else:
        return False


def create_mail(numbers):
    emails = []

    for number in numbers:
        email = str(number)+"@tkmce.ac.in"
        emails.append(email)

    return emails

numbers = [
730027, 461607, 184556, 953622, 335518, 481952, 472750, 421738, 560217, 933371
]


emails = create_mail(numbers)

for email in emails:
    if is_mail(email):
        print("{} : {}".format(email,is_mail(email)))

print(is_mail("210252@tkmce.ac.in."))
