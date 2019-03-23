package net.sheetbuilder.common.entity;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;

import java.util.Date;
import java.util.UUID;

public class Template {

    private UUID templateId;
    private UUID creatorId;

    private String name;
    private String description;

    private Date created;
    private Date lastUpdated;

    private JsonObject templateData;

    public static Builder newBuilder() {
        return new Builder();
    }

    private Template(Builder builder) {
        Preconditions.checkNotNull(builder.templateId);
        Preconditions.checkNotNull(builder.creatorId);
        Preconditions.checkNotNull(builder.name);
        Preconditions.checkNotNull(builder.description);
        Preconditions.checkNotNull(builder.created);
        Preconditions.checkNotNull(builder.lastUpdated);
        Preconditions.checkNotNull(builder.templateData);

        this.templateId = builder.templateId;
        this.creatorId = builder.creatorId;
        this.name = builder.name;
        this.description = builder.description;
        this.created = builder.created;
        this.lastUpdated = builder.lastUpdated;
        this.templateData = builder.templateData;
    }

    public UUID getTemplateId() {
        return this.templateId;
    }

    public UUID getCreatorId() {
        return this.creatorId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getCreated() {
        return this.created;
    }

    public Date getLastUpdated() {
        return this.lastUpdated;
    }

    public JsonObject getTemplateData() {
        return this.templateData;
    }

    public static class Builder {

        private UUID templateId;
        private UUID creatorId;

        private String name;
        private String description;

        private Date created;
        private Date lastUpdated;

        private JsonObject templateData;

        private Builder() { }

        public Builder withTemplateId(UUID templateId) {
            this.templateId = templateId;

            return this;
        }

        public Builder withCreatorId(UUID creatorId) {
            this.creatorId = creatorId;

            return this;
        }

        public Builder withName(String name) {
            this.name = name;

            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;

            return this;
        }

        public Builder withCreated(Date created) {
            this.created = created;

            return this;
        }

        public Builder withLastUpdated(Date lastUpdated) {
            this.lastUpdated = lastUpdated;

            return this;
        }

        public Builder withTemplateData(JsonObject templateData) {
            this.templateData = templateData;

            return this;
        }

        public Template build() {
            return new Template(this);
        }
    }
}
