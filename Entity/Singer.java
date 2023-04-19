package Entity;

import java.util.Objects;

/**
 * Singer - An entity class representing a singer.
 */
public class Singer implements Comparable<Singer>{
    // Data members
    private String id;
    private String name;
    private String password;
    private String icNo;
    private String gender;
    private String age;
    private String songTitles;
    private static int voteCount = 0;

    public Singer(){

    }
    public Singer(String id) {
        this(id, "","", "", "", "", "");
    }

    public Singer(String id, String name, String password, String icNo, String gender, String age, String songTitles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.icNo = icNo;
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

    public String getIcNo() {
        return icNo;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getSongTitles() {
        return songTitles;
    }

    public String getPassword() {
        return password;
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

    public void setIcNo(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSongTitles(String songTitles) {
        this.songTitles = songTitles;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int compareTo(Singer o) {
        return 0;
    }
}
