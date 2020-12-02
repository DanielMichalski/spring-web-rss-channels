package com.danielmichalski.rss.core.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.danielmichalski.rss.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: Daniel
 */
public class UsernameUniqueValidator implements ConstraintValidator<UsernameUnique, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UsernameUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return userRepository == null || userRepository.findByName(username) == null;
    }

}
