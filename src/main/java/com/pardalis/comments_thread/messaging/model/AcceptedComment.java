package com.pardalis.comments_thread.messaging.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public final class AcceptedComment extends ReviewableComment {
    @Id
    private String id;

    @JsonProperty("timestamp-accepted")
    private Long timestampAccepted;

    public AcceptedComment() {

    }

    public AcceptedComment(String id, Long timestampAccepted) {
        this.id = id;
        this.timestampAccepted = timestampAccepted;
    }

    public AcceptedComment(Long timestampAccepted, String email, String commentText, Long timestamp) {
        super(email, commentText, timestamp);
        this.timestampAccepted = timestampAccepted;
    }

    public AcceptedComment(String id, Long timestampAccepted, String email, String commentText, Long timestamp) {
        super(email, commentText, timestamp);
        this.id = id;
        this.timestampAccepted = timestampAccepted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTimestampAccepted() {
        return timestampAccepted;
    }

    public void setTimestampAccepted(Long timestampAccepted) {
        this.timestampAccepted = timestampAccepted;
    }

    @Override
    public String toString() {
        return "AcceptedComment: {\n"
                + "email: " + getEmail() + "\n"
                + "comment:" + getCommentText() + "\n"
                + "timestamp:" + getTimestamp() + "\n"
                + "acceptedTimestamp:" + timestampAccepted + "\n"
                + "}";
    }
}