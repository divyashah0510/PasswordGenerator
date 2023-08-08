# PasswordGenerator

This repository contains code snippets for generating secure and random passwords in Java. The code examples provided will help you generate strong passwords for your Java applications and systems.

## Introduction

Creating strong passwords is crucial for ensuring the security of online accounts and sensitive data. Weak passwords are susceptible to hacking attempts, and to mitigate this risk, using a password generator is highly recommended.

## Code Snippet

### Java

```java
private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
private static final String SYMBOLS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
private static final String NUMBERS = "0123456789";
private static final String EMAIL_REGEX = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/";
private boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
private void validateAndProcessEmail() {
        String userEmail = txtEmail.getText().trim(); // Assuming txtEmail is the JTextField for email input

        if (validateEmail(userEmail)) {
            // Email is valid, you can perform further actions here
            System.out.println("Email is valid: " + userEmail);
        } else {
            // Email is not valid
            JOptionPane.showMessageDialog(new JFrame(), "Please provide valid email");
        }
    }

    private String generateRandomPhrase(int length) {
        StringBuilder phraseBuilder = new StringBuilder();

        String allCharacters = ALPHABET + SYMBOLS + NUMBERS;
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            char randomChar = allCharacters.charAt(randomIndex);
            phraseBuilder.append(randomChar);
        }

        return phraseBuilder.toString();
    }
```
# How to Use

1. Copy the provided `PasswordGenerator` class into your Java project.
2. Call the `generatePassword` method with the desired password length as an argument.
3. The method will return a random and secure password.

**Remember to store generated passwords securely and avoid hardcoding them in your code or committing them to version control systems.**

## Example

Here's an example of how to use the Java password generator:

```java
private void cmdGenerateActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String email = txtEmail.getText();
        validateAndProcessEmail();
            int phraseLength = 10; // You can change the desired length here
            String randomPhrase = generateRandomPhrase(phraseLength);
            txtAns.setText("Suggested Password: " + randomPhrase);
        
    } 
```
# Contributing

Contributions to this repository are welcome! If you have additional code snippets or improvements for the Java password generator, feel free to submit a pull request.

# License

This project is licensed under the [MIT License](LICENSE). Feel free to use the code for personal and commercial purposes.

# Look and Feel of Java App
### Home Page
![Password Generator](https://github.com/divyashah0510/PasswordGenerator/assets/102017379/4e0a9801-da54-4778-94d0-a4d7373169ab)

### Login Page

![Login](https://github.com/divyashah0510/PasswordGenerator/assets/102017379/c87b18e3-7e6d-4a08-aa1c-b2b23a743fda)

### SignUp Page

![Signup](https://github.com/divyashah0510/PasswordGenerator/assets/102017379/7d6a13b6-d689-49c4-becd-951b7d5dd8df)
