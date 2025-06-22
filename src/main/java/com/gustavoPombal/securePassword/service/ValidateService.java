package com.gustavoPombal.securePassword.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidateService {


    public String validate(String password){
        StringBuilder failures = new StringBuilder();

        validateLenght(password, failures);
        validateUpperCase(password, failures);
        validateLowerCase(password, failures);
        validateNumbers(password, failures);
        validateSimbols(password, failures);

        return failures.toString();
    }

    public void validateLenght(String password, StringBuilder failures){
        if (password.isBlank() || password.length() < 8) {
            failures.append("A senha deve conter no mínimo 8 caracteres /n");
        }
    }

    public void validateUpperCase(String password, StringBuilder failures){
        if (!Pattern.matches(".*[A-Z].*", password)){
            failures.append("A senha deve conter no mínimo um caractere maíusculo");
        }
    }

    public void validateLowerCase(String password, StringBuilder failures){
        if (!Pattern.matches(".*[a-z].*", password)){
            failures.append("A senha deve conter no mínimo um caractere minúsculo");
        }
    }

    public void validateNumbers(String password, StringBuilder failures){
        if (!Pattern.matches(".*\\\\d.*", password)){
            failures.append("A senha deve conter no mínimo um caractere numérico");
        }
    }

    public void validateSimbols(String password, StringBuilder failures){
        if (!Pattern.matches(".*[!@#$%^&*()-+].*", password)){
            failures.append("A senha deve conter no mínimo um caractere especial");
        }
    }
}
