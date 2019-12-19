package fr.reference.it.projectref.security.rest.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class JwtUserDetails implements UserDetails {
    String subject;
    Long userId;
    String token;
    List<GrantedAuthority> grantedAuthorityList;

    public JwtUserDetails(String subject, Long userId, String token, List<GrantedAuthority> grantedAuthorityList) {
        this.subject = subject;
        this.userId = userId;
        this.token = token;
        this.grantedAuthorityList = grantedAuthorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return subject;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getSubject() {
        return subject;
    }

    public Long getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public List<GrantedAuthority> getGrantedAuthorityList() {
        return grantedAuthorityList;
    }
}
