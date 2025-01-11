package katas.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueWithFailoverTest {

    private QueueWithFailover queue;

    @BeforeEach
    void setUp() {
        queue = new QueueWithFailover(3); // jobTimeout is 3 minutes
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty(), "Queue should be empty initially");

        queue.sendJob("Job 1");
        assertFalse(queue.isEmpty(), "Queue should not be empty after adding a job");
    }

    @Test
    void testSendJob() {
        queue.sendJob("Job 1");
        assertEquals(1, queue.size(), "Queue size should be 1 after adding a job");

        queue.sendJob("Job 2");
        assertEquals(2, queue.size(), "Queue size should be 2 after adding another job");
    }

    @Test
    void testSendEmptyJob() {
        assertThrows(UnsupportedOperationException.class, () -> queue.sendJob(""), "Sending an empty job should throw an exception");
        assertThrows(UnsupportedOperationException.class, () -> queue.sendJob("   "), "Sending a blank job should throw an exception");
    }

    @Test
    void testGetJob() {
        queue.sendJob("Job 1");
        queue.sendJob("Job 2");

        String job = queue.getJob();
        assertEquals("Job 1", job, "The first job retrieved should be 'Job 1'");
        assertEquals(1, queue.size(), "Queue size should decrease after retrieving a job");
        assertEquals(1, queue.inFlightSize(), "In-flight size should increase after retrieving a job");
    }

    @Test
    void testGetJobFromEmptyQueue() {
        assertThrows(QueueWithFailover.EmptyQueueException.class, queue::getJob, "Retrieving a job from an empty queue should throw an exception");
    }

    @Test
    void testJobDone() {
        queue.sendJob("Job 1");
        String job = queue.getJob();

        queue.jobDone(job);
        assertEquals(0, queue.inFlightSize(), "In-flight size should be 0 after marking the job as done");
    }

    @Test
    void testJobDoneForNonExistentJob() {
        assertThrows(IllegalArgumentException.class, () -> queue.jobDone("NonExistentJob"), "Marking a non-existent job as done should throw an exception");
    }




    @Test
    void testSize() {
        assertEquals(0, queue.size(), "Queue size should be 0 initially");

        queue.sendJob("Job 1");
        queue.sendJob("Job 2");

        assertEquals(2, queue.size(), "Queue size should reflect the number of jobs added");
    }

    @Test
    void testInFlightSize() {
        assertEquals(0, queue.inFlightSize(), "In-flight size should be 0 initially");

        queue.sendJob("Job 1");
        queue.getJob();

        assertEquals(1, queue.inFlightSize(), "In-flight size should increase after retrieving a job");
    }
}
