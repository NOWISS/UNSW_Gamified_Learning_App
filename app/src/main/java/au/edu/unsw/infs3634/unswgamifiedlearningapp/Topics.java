package au.edu.unsw.infs3634.unswgamifiedlearningapp;

/* This class should be created by using APIs */

public class Topics {
    String name,length,iurl;

    // constructor for firebase
    Topics(){}

    public Topics(String name, String length, String iurl) {
        this.name = name;
        this.length = length;
        this.iurl = iurl;
    }

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
}
