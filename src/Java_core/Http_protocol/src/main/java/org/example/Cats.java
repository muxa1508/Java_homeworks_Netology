package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cats {
    String id;
    String text;
    String type;
    int upvotes;

    public Cats(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("upvotes") int upvotes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.upvotes = upvotes;
    }

    public int getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "{" +
                "\n\"id\": \"" + id + "\"" +
                ", \n\"text\": \"" + text + '\"' +
                ", \n\"type\": \"" + type + '\"' +
                ", \n\"upvotes\": \"" + upvotes + '\"' +
                '}';
    }

}
