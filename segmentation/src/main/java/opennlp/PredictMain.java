package opennlp;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * from Natural Language Processing with Java Cookbook
 */
public class PredictMain {
    private static final Logger logger = LoggerFactory.getLogger(PredictMain.class);
    public static void main(String[] args) {
        String sampleText = "In addition, the rook was moved too far to be effective.";
        try(InputStream modelInputStream = new FileInputStream(new File("/Users/tzuyichao/lab/projects/natural-processing-language-java/segmentation/data/mymodel.bin"))) {
            TokenizerModel tokenizerModel = new TokenizerModel(modelInputStream);
            Tokenizer tokenizer = new TokenizerME(tokenizerModel);
            String[] tokens = tokenizer.tokenize(sampleText);
            for(String token : tokens) {
                logger.info("Token: {}", token);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
