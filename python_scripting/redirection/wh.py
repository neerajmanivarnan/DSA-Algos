
import pywhatkit as kit
import datetime

# Get the current time and calculate the next minute
now = datetime.datetime.now()
next_minute = now.minute + 1
if next_minute == 60:
    next_minute = 0
    hour = now.hour + 1
else:
    hour = now.hour

# Send the message immediately at the next minute
kit.sendwhatmsg("+91 9447011691", "Hello from Python!", hour, next_minute)
