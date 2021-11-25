package ru.moskalevms.model;

/**
 * The type Unique words.
 */
public class UniqueWords {

    private long id;

    private String word;

    private String count;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UniqueWords{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
