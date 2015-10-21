package pl.dmichalski.rss.service.impl;

import org.junit.Before;
import org.junit.Test;
import pl.dmichalski.rss.entity.RssFeedEntryEntity;
import pl.dmichalski.rss.exception.RSSException;

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
    public void shouldReturnAllXmlItems() throws RSSException {
        // given
        File file = new File("src/test/resources/javavids.xml");

        // when
        List<RssFeedEntryEntity> itemEntities = rssService.getItems(file);
        RssFeedEntryEntity firstRssFeedEntryEntity = itemEntities.get(0);

        // then
        assertThat(8, is(itemEntities.size()));
        assertThat("How to solve Source not found error during debug in Eclipse", is(firstRssFeedEntryEntity.getTitle()));
        assertThat("22 06 2014 22:35:49", is(new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstRssFeedEntryEntity.getPublishedDate())));
    }
}