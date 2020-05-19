package tfidf;

import com.hankcs.hanlp.corpus.occurrence.TermFrequency;
import com.hankcs.hanlp.mining.word.TermFrequencyCounter;
import lombok.extern.java.Log;

/**
 * 《自然语言处理入门》9.2 关键词提取
 */
@Log
public class DemoTermFrequency {
    public static void main(String[] args) {
        TermFrequencyCounter counter = new TermFrequencyCounter();
        counter.add("對早期人類來說，創作的型態就是各種野生動物與抽象圖案的洞穴壁畫，使用各種顏料仔細且有方法地畫在岩石上。");
        counter.add("人類最獨特的能力之一就是創作能力。從最早期住在洞穴裡的人類，就開始不斷探索各種創作的可能性。");
        for(TermFrequency termFrequency : counter) {
            log.info(termFrequency.getTerm() + ":" + termFrequency.getFrequency());
        }
        log.info("Top3: " + counter.top(3));
    }
}
