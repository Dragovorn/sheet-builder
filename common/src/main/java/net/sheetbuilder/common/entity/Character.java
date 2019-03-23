package net.sheetbuilder.common.entity;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.UUID;

public class Character {

    private UUID characterId;
    private UUID creatorId;
    private UUID templateId;

    private Map<String, Object> characterData;

    public static Builder newBuilder() {
        return new Builder();
    }

    private Character(Builder builder) {
        Preconditions.checkNotNull(builder.characterId);
        Preconditions.checkNotNull(builder.creatorId);
        Preconditions.checkNotNull(builder.templateId);
        Preconditions.checkNotNull(builder.characterData);

        this.characterId = builder.characterId;
        this.creatorId = builder.creatorId;
        this.templateId = builder.templateId;
        this.characterData = builder.characterData;
    }

    public UUID getCharacterId() {
        return this.characterId;
    }

    public UUID getCreatorId() {
        return this.creatorId;
    }

    public UUID getTemplateId() {
        return this.templateId;
    }

    public ImmutableMap<String, Object> getCharacterData() {
        return ImmutableMap.copyOf(this.characterData);
    }

    public <T>T getCharacterData(String key) {
        return (T) this.characterData.get(key);
    }

    public static class Builder {

        private UUID characterId;
        private UUID creatorId;
        private UUID templateId;

        private Map<String, Object> characterData;

        private Builder() { }

        public Builder withCharacterId(UUID characterId) {
            this.characterId = characterId;

            return this;
        }

        public Builder withCreatorId(UUID creatorId) {
            this.creatorId = creatorId;

            return this;
        }

        public Builder withTemplateId(UUID templateId) {
            this.templateId = templateId;

            return this;
        }

        public Builder withCharacterData(Map<String, Object> characterData) {
            this.characterData = characterData;

            return this;
        }

        public Character build() {
            return new Character(this);
        }
    }
}
