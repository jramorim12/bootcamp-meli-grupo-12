package com.danilopeixoto.application;

class Password {
  private final String pattern;
  private String secret;

  public Password(String pattern) {
    this.pattern = pattern;
  }

  public String getPattern() {
    return pattern;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    if (!secret.matches(this.pattern)) {
      throw new IllegalArgumentException("Invalid parameter: secret does not match password pattern.");
    }

    this.secret = secret;
  }
}

class WeakPassword extends Password {
  public WeakPassword() {
    super("^(?=\\S+$).{6,}$");
  }
}

class MediumPassword extends Password {
  public MediumPassword() {
    super("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$");
  }
}

class StrongPassword extends Password {
  public StrongPassword() {
    super("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
  }
}

public class Exercise51 {
  public static void main(String[] args) {
    String password = "@4596$*5nfmD";

    WeakPassword weakPassword = new WeakPassword();

    try {
      weakPassword.setSecret(password);
    } catch (IllegalArgumentException exception) {
      System.err.println("Invalid weak password.");
    }

    MediumPassword mediumPassword = new MediumPassword();

    try {
      mediumPassword.setSecret(password);
    } catch (IllegalArgumentException exception) {
      System.err.println("Invalid medium password.");
    }

    StrongPassword strongPassword = new StrongPassword();

    try {
      strongPassword.setSecret(password);
    } catch (IllegalArgumentException exception) {
      System.err.println("Invalid strong password.");
    }
  }
}
