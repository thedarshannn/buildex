package dev.darshan.buildex.entity;

import dev.darshan.buildex.enums.MessageRole;

import java.time.Instant;

public class ChatMessage {

    Long id;

    ChatSession chatSession;

    String message;

    MessageRole role;

    String toolCalls;

    Integer tokensUsed;

    Instant createdAt;

}
