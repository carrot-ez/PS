package Programmers.level1;

public class 핸드폰_번호_가리기 {

    public String solution(String phone_number) {

        return phone_number.replaceAll(".(?=[0-9]{4})", "*");
    }
}
