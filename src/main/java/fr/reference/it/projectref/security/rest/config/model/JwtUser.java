package fr.reference.it.projectref.security.rest.config.model;

public class JwtUser {
    String subject;
    String role;
    Long userId;

    public void setUserName(String subject) {
        this.subject = subject;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(long userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public String getRole() {
        return role;
    }

    public Long getUserId() {
        return userId;
    }
}
