package net.sheetbuilder.common.entity;

import com.google.common.base.Preconditions;

import java.util.UUID;

public class Session {

    private UUID sessionId;
    private UUID userId;

    public static Builder newBuilder() {
        return new Builder();
    }

    private Session(Builder builder) {
        Preconditions.checkNotNull(builder.sessionId);
        Preconditions.checkNotNull(builder.userId);

        this.sessionId = builder.sessionId;
        this.userId = builder.userId;
    }

    public UUID getSessionId() {
        return this.sessionId;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public static class Builder {

        private UUID sessionId;
        private UUID userId;

        private Builder() { }

        public Builder withSessionId(UUID sessionId) {
            this.sessionId = sessionId;

            return this;
        }

        public Builder withUserId(UUID userId) {
            this.userId = userId;

            return this;
        }

        public Session build() {
            return new Session(this);
        }
    }
}
