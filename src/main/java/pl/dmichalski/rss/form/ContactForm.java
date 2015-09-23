package pl.dmichalski.rss.form;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

/**
 * Author: dmichalski
 */
public class ContactForm {

    @Size(min = 3, message = "Name must be at least 3 characters!")
    private String name;

    @Email(message = "Invalid e-mail address!")
    @Size(min = 3, message = "E-mail must be at least 3 characters!")
    private String mail;

    @Size(min = 3, message = "Message must be at least 3 characters!")
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ContactForm{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
