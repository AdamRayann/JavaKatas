package katas.exercises;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;

import java.util.ArrayList;
import java.util.List;


public class GitHubRepoActivityIntensity {
    /**
     * Analyze the activity level of a specific GitHub repository.
     *
     * Calculate the average time (in hours) between commits in a given GitHub repository.
     *
     * Use the GitHub API to:
     *
     *     - Fetch commit timestamps for a given repository (paginate to fetch ALL commits!!!)
     *     - Calculate the average time (in hours) between consecutive commits.
     *
     * Use the GitHub REST API to fetch commit data for a repository.
     * The API endpoint is: GET https://api.github.com/repos/{owner}/{repo}/commits
     *
     *
     * Note: the unittest for this kata is partially implemented under `GitHubRepoActivityIntensityTest`.
     */

    private static final String GITHUB_API_BASE_URL = "https://api.github.com/repos";

    /**
     * Fetches commit timestamps for the specified repository using the GitHub API.
     *
     * @param owner the owner of the repository
     * @param repo the name of the repository
     * @return a list of commit timestamps as Instant objects
     * @throws Exception if there is an error fetching or parsing the data
     */
    public static List<Instant> fetchCommitTimestamps(String owner, String repo) throws Exception {
        // example:
        URL url = new URL(GITHUB_API_BASE_URL + "/" + owner+"/" + repo + "/commits");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/vnd.github+json");
        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed to fetch commits: HTTP error code " + responseCode);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null ) {

            response.append(inputLine);

        }
        in.close();
        String jsonResponse = response.toString();
        //System.out.println(jsonResponse);

        return extractDatesFromJson(jsonResponse);
    }

    private static List<Instant> extractDatesFromJson(String jsonResponse) {
        List<Instant> timestamps = new ArrayList<>();
        String key = "\"date\":\"";

        int index = jsonResponse.indexOf(key);
        while (index != -1) {
            int start = index + key.length();
            int end = jsonResponse.indexOf("\"", start);
            if (end != -1) {
                String date = jsonResponse.substring(start, end);
                System.out.println(date);
                timestamps.add(Instant.parse(date));
            }
            index = jsonResponse.indexOf(key, end);
        }

        return timestamps;
    }


    /**
     * Calculates the average time between consecutive commits.
     *
     * @param timestamps a list of commit timestamps
     * @return the average time in hours
     */
    public static double calculateAverageTimeBetweenCommits(List<Instant> timestamps) {
        int avg=0,cnt = 1;
        Instant prevDate=null;
        if (timestamps.size()<2)
            return 0;
        for(Instant i : timestamps)
        {
            if(prevDate!=null)
            {
                avg+= Duration.between(prevDate,i).toHoursPart();
                cnt++;
            }
              prevDate=i;

        }

        return (double) avg/cnt;
    }

    public static void main(String[] args) {
        try {
            List<Instant> timestamps = fetchCommitTimestamps("torvalds", "linux");
            double avgTime = calculateAverageTimeBetweenCommits(timestamps);

            System.out.printf("The average time between commits in the repository is %.2f hours.%n", avgTime);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


