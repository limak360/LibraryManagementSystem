package pl.jackokamil.librarymanagementsystem;


import pl.jackokamil.librarymanagementsystem.enums.AccountStatus;

import javax.validation.constraints.NotNull;

public abstract class Account {
    @NotNull
    private int id;
    @NotNull
    private String password;
    @NotNull
    private AccountStatus status;
    @NotNull
    private Person person;

    protected abstract static class BaseBuilder<T extends BaseBuilder<T>> {
        private int id;
        private String password;
        private AccountStatus status;
        private Person person;

        public BaseBuilder<T> id(int id) {
            this.id = id;
            return this;
        }

        public BaseBuilder<T> password(String password) {
            this.password = password;
            return this;
        }

        public BaseBuilder<T> status(AccountStatus status) {
            this.status = status;
            return this;
        }

        public BaseBuilder<T> person(Person person) {
            this.person = person;
            return this;
        }

        abstract Account build();

        protected abstract T self();
    }

    public Account(BaseBuilder<?> baseBuilder) {
        this.id = baseBuilder.id;
        this.password = baseBuilder.password;
        this.status = baseBuilder.status;
        this.person = baseBuilder.person;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public boolean resetPassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", person=" + person +
                '}';
    }
}
