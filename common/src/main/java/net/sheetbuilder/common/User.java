package net.sheetbuilder.common;

import java.util.Date;
import java.util.UUID;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;

    private Date accountCreated;
    private Date lastLogin;

    private UUID userId;

    private User(Builder builder) {

    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private String email;
        private String passwordHash;

        private Date accountCreated;
        private Date lastLogin;

        private UUID userId;

        private Builder() { }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
        }

        public Builder withEmail(String email) {
            this.email = email;
        }

        public Builder

        public User build() {
            return new User(this);
        }
    }
}
