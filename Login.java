import java.util.Scanner;

public class Login
{
  private String username;
  private String password;
  private String name;
  private String year;

  Scanner input = new Scanner(System.in);

  public Login()
  {
    username = "";
    password = "";
  }

  public void getLoginInfo()
  {
    System.out.println("What is your first and last name?");
    name = input.nextLine();
    System.out.println("What year were you employed?");
    year = input.nextLine();
  }

  public void createLoginDetails()
  {
    username = name.substring(0,1) + name.substring((name.indexOf(" ")) + 1);
    password = name.substring(0,3) + year + name.substring(name.indexOf(" ") + 1, name.indexOf(" ") + 4);
    System.out.println("Your username is: " + username);
    System.out.println("Your password is: " + password);
  }

  public boolean loginMethod()
  {
    String loginUsername = "";
    String loginPassword = "";
    while (!(loginUsername.equals(username) && loginPassword.equals(password))) {
      System.out.println("Please enter your username.");
      loginUsername = input.nextLine();
      System.out.println("Please enter your password.");
      loginPassword = input.nextLine();
      if (!(loginUsername.equals(username) && loginPassword.equals(password)))
      {
        System.out.println("Login failed. Please try again.");
      }
    } 
    System.out.println("Login successful.");
    return true;
  }

  public void changePassword()
  {
    if (loginMethod())
    {
      System.out.println("Would you like to change your password? (Y/N)");
      String passwordAnswer = input.nextLine();
      if (passwordAnswer.equals("Y"))
      {
        System.out.println("Please enter your username.");
        username = input.nextLine();
        System.out.println("Please enter your new password.");
        password = input.nextLine();

        System.out.println("Please login again to confirm your credentials. You have three attempts.");
        if (confirmUserCredentials())
        {
          System.out.println("Login successful. Your password has been changed.");
        }
        else
        {
          System.out.println("Login failed. Your account has been locked.");
        }
      }
    }
  }

  public boolean confirmUserCredentials()
  {
    int counter = 0;
    String loginUserConfirm = "";
    String loginPassConfirm = "";
    while (!(loginUserConfirm.equals(username) && loginPassConfirm.equals(password))) {
      System.out.println("Please enter your username.");
      loginUserConfirm = input.nextLine();
      System.out.println("Please enter your password.");
      loginPassConfirm = input.nextLine();
      if (!(loginUserConfirm.equals(username) && loginPassConfirm.equals(password)))
      {
        System.out.println("Login failed. Please try again.");
        counter++;
      }
      if (counter == 3)
      {
        return false;
      }
    }
    System.out.println("Login successful.");
    return true;
  }
}