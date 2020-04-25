package pl.jackokamil.librarymanagementsystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account memberStub = new Member.Builder()
            .password("123123")
            .build();

    @Test
    void ShouldResetPassword() {
        assertTrue(memberStub.resetPassword("123123", "noweHaslo"));
    }

    @Test
    void ShouldNotResetPassword() {
        assertFalse(memberStub.resetPassword("123", "noweHaslo"));
    }
}