package org.techtown.workerholic;

public class WageData {

    String[] date = new String[20];
    String[] time = new String[20];

    public WageData(String[] date, String[] time) {
        this.date = date;
        this.time = time;
    }

    public WageData() {
    }

    public String[] getDate() {
        return date;
    }

    public void setDate(String[] date) {
        this.date = date;
    }

    public String[] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        this.time = time;
    }
}
