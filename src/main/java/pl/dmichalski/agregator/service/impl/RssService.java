package pl.dmichalski.agregator.service.impl;

import org.springframework.stereotype.Service;
import pl.dmichalski.agregator.entity.Item;
import pl.dmichalski.agregator.exception.RSSException;
import pl.dmichalski.agregator.rss.ObjectFactory;
import pl.dmichalski.agregator.rss.TRss;
import pl.dmichalski.agregator.rss.TRssChannel;
import pl.dmichalski.agregator.rss.TRssItem;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: Daniel
 */
@Service
public class RssService {

    public List<Item> getItems(File file) throws RSSException {
        return getItems(new StreamSource(file));
    }

    public List<Item> getItems(String url) throws RSSException {
        return getItems(new StreamSource(url));
    }

    private List<Item> getItems(Source source) throws RSSException {
        List<Item> list = new ArrayList<>();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<TRss> jaxbElement = unmarshaller.unmarshal(source, TRss.class);
            TRss rss = jaxbElement.getValue();

            List<TRssChannel> channel = rss.getChannel();
            for (TRssChannel chanel : channel) {
                List<TRssItem> items = chanel.getItem();
                for (TRssItem rssItem : items) {
                    Item item = new Item();
                    item.setTitle(rssItem.getTitle());
                    item.setDescription(rssItem.getDescription());
                    item.setLink(rssItem.getLink());
                    Date pubDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z").parse(rssItem.getPubDate());
                    item.setPublishedDate(pubDate);
                    list.add(item);
                }
            }

        } catch (JAXBException | ParseException e) {
            throw new RSSException(e);
        }

        return list;
    }

}
