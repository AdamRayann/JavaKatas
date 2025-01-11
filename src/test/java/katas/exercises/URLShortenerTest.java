package katas.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URLShortenerTest {

    private URLShortener urlShortener;

    @BeforeEach
    void setUp() {
        urlShortener = new URLShortener();
    }

    @Test
    void testShortenAndRetrieve() {
        String longUrl = "https://www.example.com/some/really/long/url";
        String shortUrl = urlShortener.shorten(longUrl);

        assertNotNull(shortUrl, "Short URL should not be null");
        assertTrue(shortUrl.startsWith("http://short.ly/"), "Short URL should start with the base URL");

        String retrievedUrl = urlShortener.retrieve(shortUrl);
        assertEquals(longUrl, retrievedUrl, "Retrieved URL should match the original long URL");
    }

    @Test
    void testShortenDuplicateUrls() {
        String longUrl = "https://www.example.com/duplicate/url";

        String shortUrl1 = urlShortener.shorten(longUrl);
        String shortUrl2 = urlShortener.shorten(longUrl);

        assertEquals(shortUrl1, shortUrl2, "Shortened URL for the same long URL should be consistent");

        String retrievedUrl = urlShortener.retrieve(shortUrl1);
        assertEquals(longUrl, retrievedUrl, "Retrieved URL should match the original long URL");
    }

    @Test
    void testRetrieveInvalidShortUrl() {
        String invalidShortUrl = "http://short.ly/invalid";
        String retrievedUrl = urlShortener.retrieve(invalidShortUrl);

        assertNull(retrievedUrl, "Retrieving an invalid short URL should return null");
    }

    @Test
    void testShortenWithSpecialCharacters() {
        String longUrl = "https://www.example.com/special?query=param&other=value#anchor";
        String shortUrl = urlShortener.shorten(longUrl);

        assertNotNull(shortUrl, "Short URL should not be null");
        assertTrue(shortUrl.startsWith("http://short.ly/"), "Short URL should start with the base URL");

        String retrievedUrl = urlShortener.retrieve(shortUrl);
        assertEquals(longUrl, retrievedUrl, "Retrieved URL should match the original long URL");
    }

    @Test
    void testShortenAndRetrieveEmptyUrl() {
        String longUrl = "";
        String shortUrl = urlShortener.shorten(longUrl);

        assertNotNull(shortUrl, "Short URL should not be null");
        String retrievedUrl = urlShortener.retrieve(shortUrl);

        assertEquals(longUrl, retrievedUrl, "Retrieved URL should match the original long URL (empty string)");
    }

    @Test
    void testShortenAndRetrieveNullUrl() {
        assertThrows(NullPointerException.class, () -> urlShortener.shorten(null), "Shortening a null URL should throw NullPointerException");
    }
}
