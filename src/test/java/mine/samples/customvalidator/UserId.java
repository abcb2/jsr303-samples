package mine.samples.customvalidator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
@NotNull(message = "need UserId")
@Size(min = 4, max = 10, message = "userid is between {min} to {max} chars")
public @interface UserId {
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		UserId[] value();
	}

	Class<?>[] groups() default {};

	//String message() default "{org.yamkazu.jsr303_samples.customvalidator.UserId.message}";
	String message() default "";

	Class<? extends Payload>[] payload() default {};
}
