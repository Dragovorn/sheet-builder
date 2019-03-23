package net.sheetbuilder.common.entity;

import com.google.common.base.Preconditions;

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

    public static Builder newBuilder() {
        return new Builder();
    }

    private User(Builder builder) {
        Preconditions.checkNotNull(builder.firstName);
        Preconditions.checkNotNull(builder.lastName);
        Preconditions.checkNotNull(builder.email);
        Preconditions.checkNotNull(builder.passwordHash);
        Preconditions.checkNotNull(builder.accountCreated);
        Preconditions.checkNotNull(builder.lastLogin);
        Preconditions.checkNotNull(builder.userId);

        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.passwordHash = builder.passwordHash;
        this.accountCreated = builder.accountCreated;
        this.lastLogin = builder.lastLogin;
        this.userId = builder.userId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        if (hasFirstName() && hasLastName()) {
            return this.firstName + " " + this.lastName;
        } else if (!hasFirstName()) {
            return this.lastName;
        } else if (!hasLastName()) {
            return this.firstName;
        } else {
            return "";
        }
    }

    public String getEmail() {
        return this.email;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public Date getAccountCreated() {
        return this.accountCreated;
    }

    public Date getLastLogin() {
        return this.lastLogin;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public boolean hasFirstName() {
        return !this.firstName.equals("");
    }

    public boolean hasLastName() {
        return !this.lastName.equals("");
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

            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;

            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;

            return this;
        }

        public Builder withPasswordHash(String passwordHash) {
            this.passwordHash = passwordHash;

            return this;
        }

        public Builder withAccountCreated(Date accountCreated) {
            this.accountCreated = accountCreated;

            return this;
        }

        public Builder withLastLogin(Date lastLogin) {
            this.lastLogin = lastLogin;

            return this;
        }

        public Builder withUserId(UUID userId) {
            this.userId = userId;

            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
