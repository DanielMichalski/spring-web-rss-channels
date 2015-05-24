package pl.dmichalski.rss.service;

/**
 * Author: dmichalski
 */
public interface IMailService {

    boolean sendEMail(String from, String to, String subject, String text);

}
