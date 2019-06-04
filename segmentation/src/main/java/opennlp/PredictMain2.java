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
public class PredictMain2 {
    private static final Logger logger = LoggerFactory.getLogger(PredictMain2.class);
    public static void main(String[] args) {
        String sampleText = "颱風警報發布台灣北部區域包含桃園、台北、基隆、宜蘭，請注意強風、豪雨，東半部特別留意焚風與高溫。";
        try(InputStream modelInputStream = new FileInputStream(new File("/Users/tzuyichao/lab/projects/natural-processing-language-java/segmentation/data/mymodel2.bin"))) {
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
