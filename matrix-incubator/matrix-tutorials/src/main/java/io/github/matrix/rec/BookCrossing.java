package io.github.matrix.rec;

import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.Preference;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

/**
 * Github mirror: https://hub.fastgit.org/
 *
 * @author Noa Swartz
 * @date 2020/12/15
 */
public class BookCrossing {

    public static final Logger logger = LoggerFactory.getLogger(BookCrossing.class);

    public static final String DATA_PATH = "E:\\datasets\\Book-Crossing\\";

    public static final String BX_BOOK_RATINGS_PATH = DATA_PATH + "BX-Book-Ratings.csv";
    public static final String BX_BOOKS_PATH = DATA_PATH + "BX-Books.csv";
    public static final String BX_USERS_PATH = DATA_PATH + "BX-Users.csv";


    public static void main(String[] args) throws Exception {
        long userId = 80683;
        int noItems = 10 ;
        HashMap<String, String> books = BookRecommender.loadBooks(BX_BOOKS_PATH);
        StringItemIDFileDataModel dataModel = BookRecommender.loadDataModel(new File(BX_BOOK_RATINGS_PATH), ";");
        logger.info("Total items: {}", dataModel.getNumItems());
        logger.info("Total users: {}", dataModel.getNumUsers());

        logger.debug("Rated items by user:");
        for (Preference preference : dataModel.getPreferencesFromUser(userId)) {
            String itemISBN = dataModel.getItemIDAsString(preference.getItemID());
            logger.info("Item id: {} | Item: {} | Value: {}", itemISBN , books.get(itemISBN), preference.getValue());
        }
//
//        BookRecommender bookRecommender = new BookRecommender();
//        bookRecommender.fit(dataModel);
//
//        logger.debug("Recommended items:");
//        bookRecommender.recommend(userId, noItems).forEach(recommend -> {
//            String itemISBN = dataModel.getItemIDAsString(recommend.getItemID());
//            logger.info("Item id: {} | Item: {} | Value: {}", itemISBN , books.get(itemISBN), recommend.getValue());
//        });

        logger.debug("Evaluate result: {}", new BookRecommender().evaluate(dataModel));
    }

}

