package pl.jackokamil.librarymanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest extends Account {

    private String pass;
    private Account account;

    public MemberTest(BaseBuilder<?> baseBuilder) {
        super(baseBuilder);
    }

    @BeforeEach
    void setUp() {
         account = new Member.Builder()
                .totalBooksCheckedout(111)
                .password(pass)
                .build();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Account>> errors = validator.validate(account);
        errors.forEach(error -> System.err.println(error.getPropertyPath() + " " + error.getMessage()));
    }

    @Test
    void testResetPassword() {
        pass = "Haslo";
        assertTrue(account.resetPassword(pass,"noweHaslo"));
    }
}