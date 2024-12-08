import requests

url = 'https://tkmce.ac.in/btech-cse.php'

resp = requests.get(url)

if resp.ok:
    con = resp.text
    print(con)
