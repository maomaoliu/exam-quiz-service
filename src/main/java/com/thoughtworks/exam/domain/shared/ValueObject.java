package com.thoughtworks.exam.domain.shared;

public interface ValueObject<T> {
    boolean sameValueAs(T other);
}
