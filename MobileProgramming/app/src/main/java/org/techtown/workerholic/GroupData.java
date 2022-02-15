package org.techtown.workerholic;

import android.widget.EditText;

public class GroupData {
    String groupName;
    String codeNumber;
    String noticeTxt;
    String part1_start,part1_end, part2_start,part2_end,part3_start,part3_end,part4_start,part4_end;
    String part1_edt,part2_edt,part3_edt,part4_edt;

    public GroupData() {


    }

    public GroupData(String groupName, String codeNumber, String noticeTxt, String part1_start, String part1_end, String part2_start, String part2_end, String part3_start, String part3_end, String part4_start, String part4_end, String part1_edt, String part2_edt, String part3_edt, String part4_edt) {
        this.groupName = groupName;
        this.codeNumber = codeNumber;
        this.noticeTxt = noticeTxt;
        this.part1_start = part1_start;
        this.part1_end = part1_end;
        this.part2_start = part2_start;
        this.part2_end = part2_end;
        this.part3_start = part3_start;
        this.part3_end = part3_end;
        this.part4_start = part4_start;
        this.part4_end = part4_end;
        this.part1_edt = part1_edt;
        this.part2_edt = part2_edt;
        this.part3_edt = part3_edt;
        this.part4_edt = part4_edt;
    }

    public String getPart4_start() {
        return part4_start;
    }

    public void setPart4_start(String part4_start) {
        this.part4_start = part4_start;
    }

    public String getPart4_end() {
        return part4_end;
    }

    public void setPart4_end(String part4_end) {
        this.part4_end = part4_end;
    }

    public String getPart4_edt() {
        return part4_edt;
    }

    public void setPart4_edt(String part4_edt) {
        this.part4_edt = part4_edt;
    }

    public String getNoticeTXT() {
        return noticeTxt;
    }

    public void setNoticeTXT(String noticeTXT) {
        this.noticeTxt = noticeTXT;
    }

    public GroupData(String groupName, String codeNumber) {
        this.groupName = groupName;
        this.codeNumber = codeNumber;

    }

    public String getPart1_start() {
        return part1_start;
    }

    public void setPart1_start(String part1_start) {
        this.part1_start = part1_start;
    }

    public String getPart1_end() {
        return part1_end;
    }

    public void setPart1_end(String part1_end) {
        this.part1_end = part1_end;
    }

    public String getPart2_start() {
        return part2_start;
    }

    public void setPart2_start(String part2_start) {
        this.part2_start = part2_start;
    }

    public String getPart2_end() {
        return part2_end;
    }

    public void setPart2_end(String part2_end) {
        this.part2_end = part2_end;
    }

    public String getPart3_start() {
        return part3_start;
    }

    public void setPart3_start(String part3_start) {
        this.part3_start = part3_start;
    }

    public String getPart3_end() {
        return part3_end;
    }

    public void setPart3_end(String part3_end) {
        this.part3_end = part3_end;
    }

    public String getPart1_edt() {
        return part1_edt;
    }

    public void setPart1_edt(String part1_edt) {
        this.part1_edt = part1_edt;
    }

    public String getPart2_edt() {
        return part2_edt;
    }

    public void setPart2_edt(String part2_edt) {
        this.part2_edt = part2_edt;
    }

    public String getPart3_edt() {
        return part3_edt;
    }

    public void setPart3_edt(String part3_edt) {
        this.part3_edt = part3_edt;
    }

    public String getName() {
        return groupName;
    }

    public void setName(String groupName) {
        this.groupName = groupName;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

}
