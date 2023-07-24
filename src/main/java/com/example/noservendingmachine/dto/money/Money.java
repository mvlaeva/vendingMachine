package com.example.noservendingmachine.dto.money;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dime.class, name = "10st"),
        @JsonSubTypes.Type(value = FifthLev.class, name = "20st"),
        @JsonSubTypes.Type(value = HalfLev.class, name = "50st"),
        @JsonSubTypes.Type(value = Lev.class, name = "1lv"),
        @JsonSubTypes.Type(value = DoubleLev.class, name = "2lv"),
        @JsonSubTypes.Type(value = FiveLev.class, name = "5lv"),
        @JsonSubTypes.Type(value = TenLev.class, name = "10lv")
})
public abstract class Money {
    @NotNull
    @JsonProperty
    private final Integer value;
}
