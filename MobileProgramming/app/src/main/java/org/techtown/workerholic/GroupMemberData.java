package org.techtown.workerholic;

public class GroupMemberData {

    String[] workerName = new String[8];

    public GroupMemberData() {
    }




    public GroupMemberData(String[] workerName) {
        this.workerName = workerName;
    }

    public String[] getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String[] workerName) {
        this.workerName = workerName;
    }
}
