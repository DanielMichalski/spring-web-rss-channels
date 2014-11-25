package pl.dmichalski.rss.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.dmichalski.rss.repository.UserRepo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Author: Daniel
 */
public class UsernameUniqueValidator implements ConstraintValidator<UsernameUnique, String> {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void initialize(UsernameUnique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (userRepo == null) {
            return true;
        }
        return userRepo.findByName(username) == null;
    }

}
