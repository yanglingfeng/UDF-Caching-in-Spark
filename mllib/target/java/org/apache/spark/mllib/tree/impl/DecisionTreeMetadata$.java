package org.apache.spark.mllib.tree.impl;
// no position
public  class DecisionTreeMetadata$ implements org.apache.spark.Logging, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DecisionTreeMetadata$ MODULE$ = null;
  public   DecisionTreeMetadata$ () { throw new RuntimeException(); }
  /**
   * Construct a {@link DecisionTreeMetadata} instance for this dataset and parameters.
   * This computes which categorical features will be ordered vs. unordered,
   * as well as the number of splits and bins for each feature.
   */
  public  org.apache.spark.mllib.tree.impl.DecisionTreeMetadata buildMetadata (org.apache.spark.rdd.RDD<org.apache.spark.mllib.regression.LabeledPoint> input, org.apache.spark.mllib.tree.configuration.Strategy strategy, int numTrees, java.lang.String featureSubsetStrategy) { throw new RuntimeException(); }
  /**
   * Version of {@link buildMetadata()} for DecisionTree.
   */
  public  org.apache.spark.mllib.tree.impl.DecisionTreeMetadata buildMetadata (org.apache.spark.rdd.RDD<org.apache.spark.mllib.regression.LabeledPoint> input, org.apache.spark.mllib.tree.configuration.Strategy strategy) { throw new RuntimeException(); }
  /**
   * Given the arity of a categorical feature (arity = number of categories),
   * return the number of bins for the feature if it is to be treated as an unordered feature.
   * There is 1 split for every partitioning of categories into 2 disjoint, non-empty sets;
   * there are math.pow(2, arity - 1) - 1 such splits.
   * Each split has 2 corresponding bins.
   */
  public  int numUnorderedBins (int arity) { throw new RuntimeException(); }
}
