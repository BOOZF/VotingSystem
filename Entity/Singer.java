package Entity;

import java.util.Objects;

/**
 * Singer - An entity class representing a singer.
 */
public class Singer implements Comparable<Singer>{
    // Data members
    private String id;
    private String name;
    private String gender;
    private int age;
    private String songTitles;
    private static int voteCount = 0;

    public Singer(String id) {
        this(id, "", "", 0, "");
    }

    public Singer(String id, String name, String gender, int age, String songTitles) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.songTitles = songTitles;
        voteCount++;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getSongTitles() {
        return songTitles;
    }

    public int getVoteCount() {
        return voteCount;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSongTitles(String songTitles) {
        this.songTitles = songTitles;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    // Entity methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Singer singer = (Singer) obj;
        return Objects.equals(id, singer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", songTitles='" + songTitles + '\'' +
                '}';
    }

    @Override
    public int compareTo(Singer o) {
        return name.compareTo(o.name);
    }
}
