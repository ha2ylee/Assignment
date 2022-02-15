package org.techtown.workerholic;

public interface Callback {
    void success(String[] data);
    void fail(String errorMessage);

}
