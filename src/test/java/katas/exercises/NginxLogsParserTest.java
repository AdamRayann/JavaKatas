package katas.exercises;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NginxLogsParserTest {
    NginxLogsParser nginxLogsParser=new NginxLogsParser();

    @Test
    @DisplayName("valid ")
    public void test1() {
        String logEntry = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] " +
                "\"GET /web-enabled/Enhanced-portal/bifurcated-forecast.js HTTP/1.1\" 200 1684 " +
                "\"-\" \"Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00\"";
        Map<String, String> expectedParsedLog = new HashMap<>();
        expectedParsedLog.put("date", "05/Feb/2024:08:29:40 +0000");
        expectedParsedLog.put("path", "/web-enabled/Enhanced-portal/bifurcated-forecast.js");
        expectedParsedLog.put("http_method", "GET");
        expectedParsedLog.put("http_version", "HTTP/1.1");
        expectedParsedLog.put("client_ip", "122.176.223.47");
        expectedParsedLog.put("response_bytes", "1684");
        expectedParsedLog.put("user_agent", "Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00");
        expectedParsedLog.put("status", "200");

        // Compare the actual parsed log with the expected one
        assertEquals(expectedParsedLog, nginxLogsParser.parseLog(logEntry));
    }
}
