package org.techtown.workerholic;

public class NoticeData {
    String text;

    public NoticeData(String text) {
        this.text = text;
    }
    public NoticeData() { }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
