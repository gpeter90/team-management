package com.bredex.teammanagement.persistence.exception;

public class NoTeamFoundException extends RuntimeException {
    public NoTeamFoundException() {
        super("No Team was found!");
    }
}
