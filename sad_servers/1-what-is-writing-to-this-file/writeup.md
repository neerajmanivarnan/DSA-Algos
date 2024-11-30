## Task 
A developer created a testing program that is continuously writing to a log file /var/log/bad.log and filling up disk. You can check for example with `tail -f /var/log/bad.log.`
This program is no longer needed. Find it and terminate it.

### Solutions
- Bash
    - `fuser /var/log/bad.log` gives the user and process id of the log.
    - extract the process id using either awk  ( `fuser /var/log/bad.log | awk '{print $2}'` )or just blankly copy the process id before redirecting.
    - `kill PROCESS_ID` to complete the challenge.

