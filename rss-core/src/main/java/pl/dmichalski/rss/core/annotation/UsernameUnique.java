package pl.dmichalski.rss.core.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Author: Daniel
 */
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UsernameUniqueValidator.class})
public @interface UsernameUnique {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
