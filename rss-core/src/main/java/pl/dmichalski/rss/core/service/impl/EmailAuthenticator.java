package pl.dmichalski.rss.core.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

@Component
public class EmailAuthenticator extends Authenticator {

    @Value("${mail.sender.username}")
    private String username;
    
    @Value("${mail.sender.password}")
    private String password;

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }

}
