import getpass
import instaloader

# Initialize Instaloader
L = instaloader.Instaloader()

# Function to handle login and 2FA
def login_with_2fa(username, password):
    try:
        # Try to login using the provided username and password
        L.login(username, password)

        otp_code = input("Enter the 2FA code: (First block)")
        L.two_factor_login(otp_code)
    except instaloader.TwoFactorAuthRequiredException:
        # Handle 2FA by prompting the user for the OTP code
        print("Two-factor authentication required.")
        otp_code = input("Enter the 2FA code: ")
        try:
            L.two_factor_login(otp_code)
            print("Logged in successfully with 2FA.")
        except instaloader.BadCredentialsException as e:
            print("Failed to log in with 2FA:", str(e))
            return False
        except Exception as e:
            print("Error during 2FA login:", str(e))
            return False

    return True

# Login to your Instagram account
username = input("Enter username")
password = getpass.getpass("Enter your password")

if login_with_2fa(username, password):
    # Load the profile of the logged-in user
    profile = instaloader.Profile.from_username(L.context, username)

    # Get followers and followees (the people you follow)
    followers = set(profile.get_followers())
    followees = set(profile.get_followees())

    # Find users who you follow but they don't follow you back
    non_followers = followees - followers

    # Output the usernames of non-followers
    print("These users don't follow you back:")
    for user in non_followers:
        print(user.username)
else:
    print("Login failed.")
