package org.apache.spark.mllib.tree;
/**
 * :: Experimental ::
 * A class that implements a {@link http://en.wikipedia.org/wiki/Random_forest  Random Forest}
 * learning algorithm for classification and regression.
 * It supports both continuous and categorical features.
 * <p>
 * The settings for featureSubsetStrategy are based on the following references:
 *  - log2: tested in Breiman (2001)
 *  - sqrt: recommended by Breiman manual for random forests
 *  - The defaults of sqrt (classification) and onethird (regression) match the R randomForest
 *    package.
 * @see <a href="http://www.stat.berkeley.edu/~breiman/randomforest2001.pdf  Breiman (2001)"/>
 * @see {@link http://www.stat.berkeley.edu/~breiman/Using_random_forests_V3.1.pdf  Breiman manual for
 *     random forests}
 * <p>
 * @param strategy The configuration parameters for the random forest algorithm which specify
 *                 the type of algorithm (classification, regression, etc.), feature type
 *                 (continuous, categorical), depth of the tree, quantile calculation strategy,
 *                 etc.
 * @param numTrees If 1, then no bootstrapping is used.  If > 1, then bootstrapping is done.
 * @param featureSubsetStrategy Number of features to consider for splits at each node.
 *                              Supported: "auto", "all", "sqrt", "log2", "onethird".
 *                              If "auto" is set, this parameter is set based on numTrees:
 *                                if numTrees == 1, set to "all";
 *                                if numTrees > 1 (forest) set to "sqrt" for classification and
 *                                  to "onethird" for regression.
 * @param seed Random seed for bootstrapping and choosing feature subsets.
 */
public  class RandomForest implements scala.Serializable, org.apache.spark.Logging {
  static public  class NodeIndexInfo implements scala.Serializable {
    public  int nodeIndexInGroup () { throw new RuntimeException(); }
    public  scala.Option<int[]> featureSubset () { throw new RuntimeException(); }
    // not preceding
    public   NodeIndexInfo (int nodeIndexInGroup, scala.Option<int[]> featureSubset) { throw new RuntimeException(); }
  }
  /**
   * Method to train a decision tree model for binary or multiclass classification.
   * <p>
   * @param input Training dataset: RDD of {@link org.apache.spark.mllib.regression.LabeledPoint}.
   *              Labels should take values {0, 1, ..., numClasses-1}.
   * @param strategy Parameters for training each tree in the forest.
   * @param numTrees Number of trees in the random forest.
   * @param featureSubsetStrategy Number of features to consider for splits at each node.
   *                              Supported: "auto", "all", "sqrt", "log2", "onethird".
   *                              If "auto" is set, this parameter is set based on numTrees:
   *                                if numTrees == 1, set to "all";
   *                                if numTrees > 1 (forest) set to "sqrt".
   * @param seed  Random seed for bootstrapping and choosing feature subsets.
   * @return a random forest model that can be used for prediction
   */
  static public  org.apache.spark.mllib.tree.model.RandomForestModel trainClassifier (org.apache.spark.rdd.RDD<org.apache.spark.mllib.regression.LabeledPoint> input, org.apache.spark.mllib.tree.configuration.Strategy strategy, int numTrees, java.lang.String featureSubsetStrategy, int seed) { throw new RuntimeException(); }
  /**
   * Method to train a decision tree model for binary or multiclass classification.
   * <p>
   * @param input Training dataset: RDD of {@link org.apache.spark.mllib.regression.LabeledPoint}.
   *              Labels should take values {0, 1, ..., numClasses-1}.
   * @param numClasses number of classes for classification.
   * @param categoricalFeaturesInfo Map storing arity of categorical features.
   *                                E.g., an entry (n -> k) indicates that feature n is categorical
   *                                with k categories indexed from 0: {0, 1, ..., k-1}.
   * @param numTrees Number of trees in the random forest.
   * @param featureSubsetStrategy Number of features to consider for splits at each node.
   *                              Supported: "auto", "all", "sqrt", "log2", "onethird".
   *                              If "auto" is set, this parameter is set based on numTrees:
   *                                if numTrees == 1, set to "all";
   *                                if numTrees > 1 (forest) set to "sqrt".
   * @param impurity Criterion used for information gain calculation.
   *                 Supported values: "gini" (recommended) or "entropy".
   * @param maxDepth Maximum depth of the tree.
   *                 E.g., depth 0 means 1 leaf node; depth 1 means 1 internal node + 2 leaf nodes.
   *                  (suggested value: 4)
   * @param maxBins maximum number of bins used for splitting features
   *                 (suggested value: 100)
   * @param seed  Random seed for bootstrapping and choosing feature subsets.
   * @return a random forest model  that can be used for prediction
   */
  static public  org.apache.spark.mllib.tree.model.RandomForestModel trainClassifier (org.apache.spark.rdd.RDD<org.apache.spark.mllib.regression.LabeledPoint> input, int numClasses, scala.collection.immutable.Map<java.lang.Object, java.lang.Object> categoricalFeaturesInfo, int numTrees, java.lang.String featureSubsetStrategy, java.lang.String impurity, int maxDepth, int maxBins, int seed) { throw new RuntimeException(); }
  /**
   * Java-friendly API for {@link org.apache.spark.mllib.tree.RandomForest$#trainClassifier}
   */
  static public  org.apache.spark.mllib.tree.model.RandomForestModel trainClassifier (org.apache.spark.api.java.JavaRDD<org.apache.spark.mllib.regression.LabeledPoint> input, int numClasses, java.util.Map<java.lang.Integer, java.lang.Integer> categoricalFeaturesInfo, int numTrees, java.lang.String featureSubsetStrategy, java.lang.String impurity, int maxDepth, int maxBins, int seed) { throw new RuntimeException(); }
  /**
   * Method to train a decision tree model for regression.
   * <p>
   * @param input Training dataset: RDD of {@link org.apache.spark.mllib.regression.LabeledPoint}.
   *              Labels are real numbers.
   * @param strategy Parameters for training each tree in the forest.
   * @param numTrees Number of trees in the random forest.
   * @param featureSubsetStrategy Number of features to consider for splits at each node.
   *                              Supported: "auto", "all", "sqrt", "log2", "onethird".
   *                              If "auto" is set, this parameter is set based on numTrees:
   *                                if numTrees == 1, set to "all";
   *                                if numTrees > 1 (forest) set to "onethird".
   * @param seed  Random seed for bootstrapping and choosing feature subsets.
   * @return a random forest model that can be used for prediction
   */
  static public  org.apache.spark.mllib.tree.model.RandomForestModel trainRegressor (org.apache.spark.rdd.RDD<org.apache.spark.mllib.regression.LabeledPoint> input, org.apache.spark.mllib.tree.configuration.Strategy strategy, int numTrees, java.lang.String featureSubsetStrategy, int seed) { throw new RuntimeException(); }
  /**
   * Method to train a decision tree model for regression.
   * <p>
   * @param input Training dataset: RDD of {@link org.apache.spark.mllib.regression.LabeledPoint}.
   *              Labels are real numbers.
   * @param categoricalFeaturesInfo Map storing arity of categorical features.
   *                                E.g., an entry (n -> k) indicates that feature n is categorical
   *                                with k categories indexed from 0: {0, 1, ..., k-1}.
   * @param numTrees Number of trees in the random forest.
   * @param featureSubsetStrategy Number of features to consider for splits at each node.
   *                              Supported: "auto", "all", "sqrt", "log2", "onethird".
   *                              If "auto" is set, this parameter is set based on numTrees:
   *                                if numTrees == 1, set to "all";
   *                                if numTrees > 1 (forest) set to "onethird".
   * @param impurity Criterion used for information gain calculation.
   *                 Supported values: "variance".
   * @param maxDepth Maximum depth of the tree.
   *                 E.g., depth 0 means 1 leaf node; depth 1 means 1 internal node + 2 leaf nodes.
   *                  (suggested value: 4)
   * @param maxBins maximum number of bins used for splitting features
   *                 (suggested value: 100)
   * @param seed  Random seed for bootstrapping and choosing feature subsets.
   * @return a random forest model that can be used for prediction
   */
  static public  org.apache.spark.mllib.tree.model.RandomForestModel trainRegressor (org.apache.spark.rdd.RDD<org.apache.spark.mllib.regression.LabeledPoint> input, scala.collection.immutable.Map<java.lang.Object, java.lang.Object> categoricalFeaturesInfo, int numTrees, java.lang.String featureSubsetStrategy, java.lang.String impurity, int maxDepth, int maxBins, int seed) { throw new RuntimeException(); }
  /**
   * Java-friendly API for {@link org.apache.spark.mllib.tree.RandomForest$#trainRegressor}
   */
  static public  org.apache.spark.mllib.tree.model.RandomForestModel trainRegressor (org.apache.spark.api.java.JavaRDD<org.apache.spark.mllib.regression.LabeledPoint> input, java.util.Map<java.lang.Integer, java.lang.Integer> categoricalFeaturesInfo, int numTrees, java.lang.String featureSubsetStrategy, java.lang.String impurity, int maxDepth, int maxBins, int seed) { throw new RuntimeException(); }
  /**
   * List of supported feature subset sampling strategies.
   */
  static public  java.lang.String[] supportedFeatureSubsetStrategies () { throw new RuntimeException(); }
  /**
   * Pull nodes off of the queue, and collect a group of nodes to be split on this iteration.
   * This tracks the memory usage for aggregates and stops adding nodes when too much memory
   * will be needed; this allows an adaptive number of nodes since different nodes may require
   * different amounts of memory (if featureSubsetStrategy is not "all").
   * <p>
   * @param nodeQueue  Queue of nodes to split.
   * @param maxMemoryUsage  Bound on size of aggregate statistics.
   * @return  (nodesForGroup, treeToNodeToIndexInfo).
   *          nodesForGroup holds the nodes to split: treeIndex --> nodes in tree.
   * <p>
   *          treeToNodeToIndexInfo holds indices selected features for each node:
   *            treeIndex --> (global) node index --> (node index in group, feature indices).
   *          The (global) node index is the index in the tree; the node index in group is the
   *           index in [0, numNodesInGroup) of the node in this group.
   *          The feature indices are None if not subsampling features.
   */
  static public  scala.Tuple2<scala.collection.immutable.Map<java.lang.Object, org.apache.spark.mllib.tree.model.Node[]>, scala.collection.immutable.Map<java.lang.Object, scala.collection.immutable.Map<java.lang.Object, org.apache.spark.mllib.tree.RandomForest.NodeIndexInfo>>> selectNodesToSplit (scala.collection.mutable.Queue<scala.Tuple2<java.lang.Object, org.apache.spark.mllib.tree.model.Node>> nodeQueue, long maxMemoryUsage, org.apache.spark.mllib.tree.impl.DecisionTreeMetadata metadata, scala.util.Random rng) { throw new RuntimeException(); }
  /**
   * Get the number of values to be stored for this node in the bin aggregates.
   * @param featureSubset  Indices of features which may be split at this node.
   *                       If None, then use all features.
   */
  static public  long aggregateSizeForNode (org.apache.spark.mllib.tree.impl.DecisionTreeMetadata metadata, scala.Option<int[]> featureSubset) { throw new RuntimeException(); }
  private  org.apache.spark.mllib.tree.configuration.Strategy strategy () { throw new RuntimeException(); }
  private  int numTrees () { throw new RuntimeException(); }
  private  int seed () { throw new RuntimeException(); }
  // not preceding
  public   RandomForest (org.apache.spark.mllib.tree.configuration.Strategy strategy, int numTrees, java.lang.String featureSubsetStrategy, int seed) { throw new RuntimeException(); }
  /**
   * Method to train a decision tree model over an RDD
   * @param input Training data: RDD of {@link org.apache.spark.mllib.regression.LabeledPoint}
   * @return a random forest model that can be used for prediction
   */
  public  org.apache.spark.mllib.tree.model.RandomForestModel run (org.apache.spark.rdd.RDD<org.apache.spark.mllib.regression.LabeledPoint> input) { throw new RuntimeException(); }
}
