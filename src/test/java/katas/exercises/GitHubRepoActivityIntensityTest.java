package katas.exercises;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GitHubRepoActivityIntensityTest {

    @Test
    void testCalculateAverageTimeBetweenCommits() throws Exception {
        List<Instant> mockTimestamps = List.of(
                Instant.parse("2023-12-01T12:00:00Z"),
                Instant.parse("2023-12-01T14:00:00Z"),
                Instant.parse("2023-12-01T18:00:00Z"),
                Instant.parse("2023-12-02T06:00:00Z")
        );

        double averageTime = GitHubRepoActivityIntensity.calculateAverageTimeBetweenCommits(mockTimestamps);
        assertEquals(4.5,averageTime);
    }

//    @Test
//    void testFetchCommitTimestamps() throws Exception {
//        HttpURLConnection mockConnection = mock(HttpURLConnection.class);
//        URL url = new URL("https://api.github.com/repos/mockOwner/mockRepo/commits");
//
//        when(mockConnection.getResponseCode()).thenReturn(200);
//        when(mockConnection.getInputStream()).thenReturn(new java.io.ByteArrayInputStream(
//                ("[{\"commit\":{\"author\":{\"date\":\"2023-12-01T12:00:00Z\"}}}," +
//                        "{\"commit\":{\"author\":{\"date\":\"2023-12-01T14:00:00Z\"}}}," +
//                        "{\"commit\":{\"author\":{\"date\":\"2023-12-01T18:00:00Z\"}}}," +
//                        "{\"commit\":{\"author\":{\"date\":\"2023-12-02T06:00:00Z\"}}}]").getBytes()
//        ));
//
//        List<Instant> timestamps = GitHubRepoActivityIntensity.fetchCommitTimestamps("mockOwner", "mockRepo");
//
//        assertEquals(4, timestamps.size(), "There should be 4 commit timestamps fetched");
//        assertEquals(Instant.parse("2023-12-01T12:00:00Z"), timestamps.get(0), "First timestamp should match");
//        assertEquals(Instant.parse("2023-12-02T06:00:00Z"), timestamps.get(3), "Last timestamp should match");
//    }
}
