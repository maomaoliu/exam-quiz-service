package com.thoughtworks.exam.domain.shared;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
