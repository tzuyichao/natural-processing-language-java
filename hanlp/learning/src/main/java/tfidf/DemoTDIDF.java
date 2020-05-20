package tfidf;

import com.hankcs.hanlp.mining.word.TfIdfCounter;
import lombok.extern.java.Log;

@Log
public class DemoTDIDF {
    public static void main(String[] args) {
        TfIdfCounter counter = new TfIdfCounter();
        counter.add("doc1", "Apple rolls out temperature checks and mask requirements as stores reopen");
        counter.add("doc2", "US pushes for new crackdown on Huawei, raising concerns of retaliation against American companies");
        counter.add("doc3", "Apple reveals what might be next for your screen");

        counter.compute();

        for(Object id : counter.documents()) {
            log.info(id + ":" + counter.getKeywordsOf(id, 3));
        }
        log.info("Print Term Frequency");
        counter.allTf().forEach((key, val) -> {
            log.info(key + ":" + val);
        });
    }
}
