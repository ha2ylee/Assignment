package org.techtown.workerholic;
//사용자 계정 정보 모델 클래스
public class UserAccount {
    private String idToken; // 파이어베이스 고유 정보를 가져옴 (키값)
    private String emailId;
    private String password;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserAccount() { } //파이어베이스 실시간ㄴ 데이터베이스는 꼭 빈생성자!

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
