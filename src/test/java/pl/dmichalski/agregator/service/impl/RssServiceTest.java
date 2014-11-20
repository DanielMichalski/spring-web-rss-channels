package pl.dmichalski.agregator.service.impl;

import org.junit.Before;
import org.junit.Test;
import pl.dmichalski.agregator.entity.Item;
import pl.dmichalski.agregator.exception.RSSException;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RssServiceTest {

    private RssService rssService;

    @Before
    public void setUp() throws Exception {
        rssService = new RssService();
    }

    @Test
    public void testGetItems() throws RSSException {
        File file = new File("src/test/resources/javavids.xml");
        List<Item> items = rssService.getItems(file);
        assertThat(10, is(items.size()));
        Item firstItem = items.get(0);
        assertThat("How to solve Source not found error during debug in Eclipse", is(firstItem.getTitle()));
        assertThat("22 06 2014 22:35:49", is(new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate())));

    }
}