package katas.exercises;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Read about how to perform simple operations in SQLite3 in Java: https://github.com/xerial/sqlite-jdbc
 *
 *You have two SQLite databases:
 *
 *
 * Source Database (source.db) - contains a table users with the following schema:
 *
 *     CREATE TABLE users (
 *         id INTEGER PRIMARY KEY,
 *         name TEXT NOT NULL,
 *         email TEXT NOT NULL,
 *         age INTEGER,
 *         registration_date TEXT
 *     );
 *
 * Example Data:
 *  id	name	        email	            age	registration_date
 *  1	Elon Musk   	elon@spacex.com	    52	2002-12-01
 *  2	Greta Thunberg	greta@climate.org	20	2018-08-20
 *  3	Joe Biden   	joe@whitehouse.gov	81	1972-11-05
 *
 * Target Database (target.db) - You need to create a table `transformed_users` with the following schema:
 *
 *    CREATE TABLE transformed_users (
 *        user_id INTEGER PRIMARY KEY,
 *        full_name TEXT NOT NULL,
 *        email TEXT NOT NULL,
 *        age_group TEXT,
 *        years_registered INTEGER
 *    );
 *
 * The target table will store the transformed data. Transformation Rules:
 *
 *     Rename Columns:
 *         id → user_id
 *         name → full_name
 *
 *     Transform Age:
 *         Convert the age into an age_group:
 *             Under 30: for users aged less than 30.
 *             30-60: for users aged 30 to 60.
 *             60+: for users aged over 60.
 *
 *     Calculate years_registered:
 *         Compute the number of years since the registration_date.
 *
 */
public class ETLTask {

    /**
     * Performs the ETL operation from source.db to target.db.
     *
     * @param sourceDbPath the path to the source SQLite database
     * @param targetDbPath the path to the target SQLite database
     * @throws SQLException if an error occurs during database access
     */
    public static void performETL(String sourceDbPath, String targetDbPath) throws SQLException {
        try (Connection sourceConn = DriverManager.getConnection("jdbc:sqlite:" + sourceDbPath);
             Connection targetConn = DriverManager.getConnection("jdbc:sqlite:" + targetDbPath);
             Statement sourceStmt = sourceConn.createStatement()) {

            try (Statement targetStmt = targetConn.createStatement()) {
                targetStmt.execute("CREATE TABLE IF NOT EXISTS transformed_users (" +
                        "user_id INTEGER PRIMARY KEY, " +
                        "full_name TEXT NOT NULL, " +
                        "email TEXT NOT NULL, " +
                        "age_group TEXT, " +
                        "years_registered INTEGER)");

                // Clear the table to avoid duplicate primary keys
                targetStmt.execute("DELETE FROM transformed_users");
            }


            // Extract data from source database
            ResultSet rs = sourceStmt.executeQuery("SELECT * FROM users");

            String insertSQL = "INSERT INTO transformed_users (user_id, full_name, email, age_group, years_registered) " +
                    "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = targetConn.prepareStatement(insertSQL)) {

                
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    int age = rs.getInt("age");
                    String registrationDate = rs.getString("registration_date");
                    
                    String ageGroup = getAgeGroup(age);
                    int yearsRegistered = calculateYearsRegistered(registrationDate);

                    insertStmt.setInt(1, id);
                    insertStmt.setString(2, name);
                    insertStmt.setString(3, email);
                    insertStmt.setString(4, ageGroup);
                    insertStmt.setInt(5, yearsRegistered);

                    insertStmt.addBatch();
                }

                insertStmt.executeBatch();
            }

            System.out.println("ETL process completed successfully!");
        }
    }

    private static String getAgeGroup(int age) {
        if (age < 30)
        {
            return "Under 30";

        } else if (age <= 60)
        {
            return "30-60";

        } else
        {
            return "60+";
        }
    }
    private static int calculateYearsRegistered(String registrationDate) {
        LocalDate regDate = LocalDate.parse(registrationDate, DateTimeFormatter.ISO_DATE);
        LocalDate currentDate = LocalDate.now();
        return Period.between(regDate, currentDate).getYears();
    }
    public static void main(String[] args) throws SQLException {
        String sourceDb = "source.db";
        String targetDb = "target.db";

        performETL(sourceDb, targetDb);
        System.out.println("ETL process completed!");
    }
}


