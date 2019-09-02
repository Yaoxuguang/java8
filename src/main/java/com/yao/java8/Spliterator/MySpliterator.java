package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.Spliterator;

import lombok.extern.slf4j.Slf4j;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 自己定义的可分迭代器
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/8 11:35
 */
@Slf4j
public class MySpliterator implements Spliterator<String> {
    static final String SENTENCE =
            " Nel mezzo del cammin di nostra vita " +
                    "mi ritrovai in una selva oscura" +
                    " ché la dritta via era smarrita ";
    @Override
    public boolean tryAdvance(Consumer<? super String> action) {
        return false;
    }

    @Override
    public Spliterator<String> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }

    static class WordCounter{
        //目前为止数过的字数
        private final int counter;
        //是否遇到空格
        private final boolean lastSpace;

        public WordCounter(int counter, boolean lastSpace) {
            this.counter = counter;
            this.lastSpace = lastSpace;
        }

        public WordCounter accumulate(Character c){
            if(Character.isWhitespace(c)){
                return lastSpace ? this: new WordCounter(counter,true);
            }else{
                return lastSpace ? new WordCounter(counter+1,false):this;
            }
        }

        public WordCounter combine(WordCounter wordCounter){
            return new WordCounter((counter + wordCounter.counter),wordCounter.lastSpace);
        }

        public int getCounter() {
            return counter;
        }

        public static int countWords(Stream<Character> stream){
            WordCounter reduce = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
            return reduce.getCounter();
        }
    }

    public static void main(String[] args) {
        Stream<Character> characterStream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        log.info("Found " + WordCounter.countWords(characterStream) + " words");
        //并行执行，拆分为多个子执行块
        Stream<Character> characterStream1 = IntStream.range(0, SENTENCE.length()).parallel().mapToObj(SENTENCE::charAt);
        log.info("Found " + WordCounter.countWords(characterStream1) + " words");
    }
}
