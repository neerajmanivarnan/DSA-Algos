# Taipei - Come a-knocking

The port 80 is protected with PortKnocking. We need to find out the correct knock sequence to open this port and thus make this sad server happy.
- We could use the `nmap -n- localhost` to search all the open ports.
- I got three open ports  
- knocked on them sequentially and was able to `curl localhost 80`
