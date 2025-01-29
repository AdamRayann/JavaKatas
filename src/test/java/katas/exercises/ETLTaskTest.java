package katas.exercises;

import org.junit.jupiter.api.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static katas.exercises.ETLTask.performETL;
import static org.junit.jupiter.api.Assertions.*;

class ETLTaskTest {
    private static final String SOURCE_DB = "jdbc:sqlite:source.db:";
    private static final String TARGET_DB = "dbc:sqlite:target.db";
    private Connection sourceConn;
    private Connection targetConn;

    @Test
    void setupDatabases() throws SQLException {
        String sourceDb = "source.db";
        String targetDb = "target.db";

        performETL(sourceDb, targetDb);
    }

    @AfterEach
    void closeConnections() throws SQLException {
        if (sourceConn != null) sourceConn.close();
        if (targetConn != null) targetConn.close();
    }




}
