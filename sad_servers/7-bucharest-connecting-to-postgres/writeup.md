## Task 
A web application relies on the PostgreSQL 13 database present on this server. However, the connection to the database is not working. Your task is to identify and resolve the issue causing this connection failure. The application connects to a database named app1 with the user app1user and the password app1user.

### Solutions
- Bash
    - `sudo vim /etc/postgresql/VERSION_NUMBER/main/pg_hba.conf`
    -  comment out the lines with reject 
    -  systemctl restart postgresql


