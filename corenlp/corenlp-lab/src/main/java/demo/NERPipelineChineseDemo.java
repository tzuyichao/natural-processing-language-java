package demo;

import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.IOException;
import java.util.Properties;
import java.util.stream.Collectors;

public class NERPipelineChineseDemo {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.load(IOUtils.readerFromString("StanfordCoreNLP-chinese.properties"));

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        CoreDocument doc = new CoreDocument("美國太平洋空軍指出，司令布朗（CQ Brown Jr.）在夏威夷當地時間4月29日主持視訊會議，與包含台灣在內5大洲19國的空軍司令討論疫情與今後合作。韓國媒體拍到中華民國國旗與各國並列。");
        pipeline.annotate(doc);
        System.out.println("---");
        System.out.println("entities found");
        for(CoreEntityMention em: doc.entityMentions()) {
            System.out.println("\tdetected entity: \t" + em.text() + "\t" + em.entityType());
        }
        System.out.println("---");
        System.out.println("tokens and ner tags");
        String tokensAndNERTags = doc.tokens().stream().map(token -> "("+token.word()+","+token.ner()+")").collect(
                Collectors.joining(" "));
        System.out.println(tokensAndNERTags);
        for(CoreSentence sentence: doc.sentences()) {
            System.out.println("----");
            System.out.println(sentence.text());
            for(CoreLabel label: sentence.tokens()) {
                System.out.println(label.word());
            }
        }
    }
}
