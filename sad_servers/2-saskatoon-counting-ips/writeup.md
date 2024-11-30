## Task 
The task is to extract the ip address with the most number of requests and write it to a file in another directory

### Solutions
- Python
    - You can use python to parse this log file to extract the highest ip and write it to a file.
    - The script can be found in the file name called `log_parsing.py` 
- Bash
    - Alternatively you could use chain of commands to find the answer
    - `cat access.log| awk '{print $1}' | sort | uniq -c | sort -nr | head -1 | awk '{print $2}'
` 
    #### Command description
    -  cat the contents of the file and pipe it to awk to extract the first field (of IP Addresses) 
    - Redirect and sort the output so that similar output will be together
    - redirect it to uniq with the option `-c` to count the number of occurrences
    - Redirect it and sort the result with the option `-nr` to sort it numberically and in the reverse order (Reverse order to get the output at top)
    - The result will be in the form `count IP_ADDRESS`. We can pipe it to head with the option `-1` to get the first output 
    - Redirect the output to awk and extract the second field which is the most occurred `IP_ADDRESS`
    - You can write it to the desired file using `>` 
