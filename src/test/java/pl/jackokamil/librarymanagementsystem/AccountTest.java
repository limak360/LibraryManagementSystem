package pl.jackokamil.librarymanagementsystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account member = new Member.Builder()
            .password("123123")
            .build();

    private Account member2 = new Member.Builder()
            .build();




    @Test
    void ShouldResetPassword() {
        assertTrue(member.resetPassword("123123", "noweHaslo"));
    }

    @Test
    void ShouldNotResetPassword() {
        assertFalse(member.resetPassword("123", "noweHaslo"));
    }

    @Test
    void ShouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> member2.resetPassword("123", "222"));
    }
}