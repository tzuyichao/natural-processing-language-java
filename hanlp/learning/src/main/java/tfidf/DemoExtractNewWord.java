package tfidf;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.mining.word.WordInfo;
import com.hankcs.hanlp.utility.TestUtility;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.List;

@Log
/**
 * https://github.com/krisjin/HanLP/blob/master/src/test/java/com/hankcs/book/ch09/DemoExtractNewWord.java
 */
public class DemoExtractNewWord {
    static final String HLM_PATH = TestUtility.ensureTestData("红楼梦.txt", "http://file.hankcs.com/corpus/红楼梦.zip");
    static final String XYJ_PATH = TestUtility.ensureTestData("西游记.txt", "http://file.hankcs.com/corpus/西游记.zip");
    static final String SHZ_PATH = TestUtility.ensureTestData("水浒传.txt", "http://file.hankcs.com/corpus/水浒传.zip");
    static final String SAN_PATH = TestUtility.ensureTestData("三国演义.txt", "http://file.hankcs.com/corpus/三国演义.zip");
    static final String WEIBO_PATH = TestUtility.ensureTestData("weibo-classification", "http://file.hankcs.com/corpus/weibo-classification.zip");

    public static void main(String[] args) throws IOException {
        extract(SAN_PATH);
    }

    private static void extract(String corpus) throws IOException {
        log.info(corpus + " 熱詞");
        List<WordInfo> wordInfoList = HanLP.extractWords(IOUtil.newBufferedReader(corpus), 100, true);
        log.info("新詞：" + wordInfoList);
    }
}
