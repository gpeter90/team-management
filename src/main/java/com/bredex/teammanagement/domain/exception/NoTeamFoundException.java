package com.bredex.teammanagement.domain.exception;

public class NoTeamFoundException extends RuntimeException {
    public NoTeamFoundException() {
        super("No Team was found!");
    }
}
