package pl.jackokamil.librarymanagementsystem;

import pl.jackokamil.librarymanagementsystem.enums.AccountStatus;

public abstract class Account {
    private int id;
    private String password;
    private AccountStatus status;
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

    public Person getPerson() {
        return person;
    }

    public abstract boolean resetPassword();

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
