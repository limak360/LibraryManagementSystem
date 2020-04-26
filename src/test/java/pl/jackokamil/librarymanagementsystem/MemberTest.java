package pl.jackokamil.librarymanagementsystem;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    Member member = new Member.Builder()
            .totalBooksCheckedout(0)
            .dateOfMembership(new Date())
            .build();

    BookItem bookItem = new BookItem.Builder().build();




    @Test
    void ShouldIncrementTotalBooksCheckedoutValue() {
        member.checkoutBookItem(bookItem);
        assertEquals(1, member.getTotalBooksCheckedout());
    }

}