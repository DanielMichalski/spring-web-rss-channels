package pl.dmichalski.rss.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.dmichalski.rss.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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
        if (userRepository == null) {
            return true;
        }
        return userRepository.findByName(username) == null;
    }

}
