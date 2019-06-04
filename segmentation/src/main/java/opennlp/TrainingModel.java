package opennlp;

import opennlp.tools.tokenize.*;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * from Natural Language Processing with Java Cookbook
 */
public class TrainingModel {
    private static final Logger logger = LoggerFactory.getLogger(TrainingModel.class);
    public static void main(String[] args) {
        InputStreamFactory inputStreamFactory = new InputStreamFactory() {

            @Override
            public InputStream createInputStream() throws IOException {
                return new FileInputStream("/Users/tzuyichao/lab/projects/natural-processing-language-java/segmentation/data/training-data-2.train");
            }
        };
        try {
            ObjectStream<String> stringObjectStream = new PlainTextByLineStream(inputStreamFactory, "UTF-8");
            ObjectStream<TokenSample> tokenSampleObjectStream = new TokenSampleStream(stringObjectStream);
            TokenizerModel tokenizerModel = TokenizerME.train(tokenSampleObjectStream, new TokenizerFactory("en", null, true, null), TrainingParameters.defaultParams());
            BufferedOutputStream modelOutputStream = new BufferedOutputStream(new FileOutputStream(new File("/Users/tzuyichao/lab/projects/natural-processing-language-java/segmentation/data/mymodel2.bin")));
            tokenizerModel.serialize(modelOutputStream);
            logger.info("model training completed.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
