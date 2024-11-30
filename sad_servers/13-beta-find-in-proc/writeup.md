## Task 
The task needs us to find a file with with a word `secret` in the `/proc/sys` directory with a word next to which it calls as password.We need to find the password and write it to another file.The trick here is that it contains lots of file and we have to find the solution from all of that.

### Solutions
- Bash
    - We can find the file that contains the word 'secret' using the command `find . -type f -exec grep 'secret' {} +` 
    - I used the `.` to indicate the current directory, so you will have to be in the `/proc/sys/`
    directory.Else you can mention the directory explicitly.
    - You'll get the name of the file which contain the word.You can the file and then write the password to the intended file.
