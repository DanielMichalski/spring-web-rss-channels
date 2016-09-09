package pl.dmichalski.rss.core.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.dmichalski.rss.core.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Author: Daniel
 */
public class UsernameUniqueValidator implements ConstraintValidator<UsernameUnique, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UsernameUnique constraintAnnotation) {}

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return userRepository.findByName(username) == null;
    }

}
