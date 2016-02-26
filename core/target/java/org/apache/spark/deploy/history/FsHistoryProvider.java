package org.apache.spark.deploy.history;
/**
 * A class that provides application history from event logs stored in the file system.
 * This provider checks for new finished applications in the background periodically and
 * renders the history application UI by parsing the associated event logs.
 */
public  class FsHistoryProvider extends org.apache.spark.deploy.history.ApplicationHistoryProvider implements org.apache.spark.Logging {
  static public  java.lang.String DEFAULT_LOG_DIR () { throw new RuntimeException(); }
  public   FsHistoryProvider (org.apache.spark.SparkConf conf) { throw new RuntimeException(); }
  private  java.lang.String NOT_STARTED () { throw new RuntimeException(); }
  private  int UPDATE_INTERVAL_MS () { throw new RuntimeException(); }
  private  java.lang.String logDir () { throw new RuntimeException(); }
  private  org.apache.hadoop.fs.FileSystem fs () { throw new RuntimeException(); }
  private  long lastLogCheckTimeMs () { throw new RuntimeException(); }
  private  long lastModifiedTime () { throw new RuntimeException(); }
  private  scala.collection.mutable.LinkedHashMap<java.lang.String, org.apache.spark.deploy.history.FsApplicationHistoryInfo> applications () { throw new RuntimeException(); }
  public  java.lang.String LOG_PREFIX () { throw new RuntimeException(); }
  public  java.lang.String SPARK_VERSION_PREFIX () { throw new RuntimeException(); }
  public  java.lang.String COMPRESSION_CODEC_PREFIX () { throw new RuntimeException(); }
  public  java.lang.String APPLICATION_COMPLETE () { throw new RuntimeException(); }
  /**
   * A background thread that periodically checks for event log updates on disk.
   * <p>
   * If a log check is invoked manually in the middle of a period, this thread re-adjusts the
   * time at which it performs the next log check to maintain the same period as before.
   * <p>
   * TODO: Add a mechanism to update manually.
   */
  private  java.lang.Thread logCheckingThread () { throw new RuntimeException(); }
  private  void initialize () { throw new RuntimeException(); }
  public  scala.collection.Iterable<org.apache.spark.deploy.history.FsApplicationHistoryInfo> getListing () { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.ui.SparkUI> getAppUI (java.lang.String appId) { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> getConfig () { throw new RuntimeException(); }
  /**
   * Builds the application list based on the current contents of the log directory.
   * Tries to reuse as much of the data already in memory as possible, by not reading
   * applications that haven't been updated since last time the logs were checked.
   */
  public  void checkForLogs () { throw new RuntimeException(); }
  /**
   * Replays the events in the specified log file and returns information about the associated
   * application.
   */
  private  org.apache.spark.deploy.history.FsApplicationHistoryInfo replay (org.apache.hadoop.fs.FileStatus eventLog, org.apache.spark.scheduler.ReplayListenerBus bus) { throw new RuntimeException(); }
  /**
   * Loads a legacy log directory. This assumes that the log directory contains a single event
   * log file (along with other metadata files), which is the case for directories generated by
   * the code in previous releases.
   * <p>
   * @return 2-tuple of (input stream of the events, version of Spark which wrote the log)
   */
  public  scala.Tuple2<java.io.InputStream, java.lang.String> openLegacyEventLog (org.apache.hadoop.fs.Path dir) { throw new RuntimeException(); }
  /**
   * Return whether the specified event log path contains a old directory-based event log.
   * Previously, the event log of an application comprises of multiple files in a directory.
   * As of Spark 1.3, these files are consolidated into a single one that replaces the directory.
   * See SPARK-2261 for more detail.
   */
  private  boolean isLegacyLogDirectory (org.apache.hadoop.fs.FileStatus entry) { throw new RuntimeException(); }
  private  long getModificationTime (org.apache.hadoop.fs.FileStatus fsEntry) { throw new RuntimeException(); }
  /** Returns the system's mononotically increasing time. */
  private  long getMonotonicTimeMs () { throw new RuntimeException(); }
}
