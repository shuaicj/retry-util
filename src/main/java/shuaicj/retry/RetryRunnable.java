package shuaicj.retry;

/**
 * The Runnable to support throwing exceptions in run().
 */
public interface RetryRunnable {

    void run() throws Exception;
}
