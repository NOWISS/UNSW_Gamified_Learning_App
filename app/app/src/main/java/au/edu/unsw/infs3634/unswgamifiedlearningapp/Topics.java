package au.edu.unsw.infs3634.unswgamifiedlearningapp;

/* This class should be created by using APIs */

public class Topics {
    String id,name,length,iurl,m1_text,m1_v;


    public Topics(String id, String name, String length, String iurl, String m1_text, String m1_v) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.iurl = iurl;
        this.m1_text = m1_text;
        this.m1_v = m1_v;
    }

    // constructor for firebase
    Topics(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getIurl() {
        return iurl;
    }

    public void setIurl(String iurl) {
        this.iurl = iurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getM1_text() {
        return m1_text;
    }

    public void setM1_text(String m1_text) {
        this.m1_text = m1_text;
    }

    public String getM1_v() {
        return m1_v;
    }

    public void setM1_v(String m1_v) {
        this.m1_v = m1_v;
    }
}
