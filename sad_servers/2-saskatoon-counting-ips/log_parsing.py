import re

def find_pattern(line):
    pattern = r'^([\w.]+)'
    result =  re.search(pattern,line)
    if result is not None:
        return result[0]
    return None


dicti = {}
file = 'access.log'

with open(file) as f:
    for line in f:
        ip = find_pattern(line)
        if ip not in dicti:
            dicti[ip] = 0
        dicti[ip] +=1

max_ip_name = ""
max_ip_count = 0

for ip,count in dicti.items():
    current_ip = ip
    current_count = count
    if current_count > max_ip_count:
        max_ip_count = current_count
        max_ip_name = current_ip

print(max_ip_name.strip())
