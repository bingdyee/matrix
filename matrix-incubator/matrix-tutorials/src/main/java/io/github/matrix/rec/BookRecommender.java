package io.github.matrix.rec;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


/**
 * @author Noa Swartz
 * @date 2020/12/15
 */
public class BookRecommender implements RecommenderBuilder {

    public static final Logger logger = LoggerFactory.getLogger(BookCrossing.class);

    private Recommender recommender;

    public void fit(DataModel dataModel) throws TasteException {
        UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, dataModel);
        recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
    }

    @Override
    public Recommender buildRecommender(DataModel dataModel) throws TasteException {
        if (recommender == null) {
            fit(dataModel);
        }
        return recommender;
    }

    public List<RecommendedItem> recommend(long userID, int howMany) throws TasteException {
        return recommender.recommend(userID, howMany, new NewestIDRescorer());
    }

    public static StringItemIDFileDataModel loadDataModel(File dataFile, String regex) throws IOException {
        return new StringItemIDFileDataModel(dataFile, regex);
    }

    public static HashMap<String, String> loadBooks(String filename) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.replace("\"", "").split(";");
                map.put(parts[0], parts[1]);
            }
        }
        return map;
    }

    public double evaluate(DataModel dataModel) throws TasteException {
        RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
        return evaluator.evaluate(this, null, dataModel, 0.3, 0.1);
    }

}
