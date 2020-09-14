package Kakao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class No1 {
    public static void main(String args[]) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String result = new No1().solution(new_id);

        System.out.println(result);
    }

    public String solution(String new_id) {
        // id = 3 ~ 15글자
        // 소문자, 숫자, -, _, . 만 사용가능
        // .는 연속으로 또는 마지막에 사용 불가능

        // 가능한 elements들의 리스트
        List<Character> elementsList = new ArrayList<>();
        for(int i=(int)'0'; i<=(int)'9'; i++) {
            elementsList.add((char)i);
        }
        for(int i=(int)'a'; i<=(int)'z'; i++) {
            elementsList.add((char)i);
        }
        elementsList.add('-');
        elementsList.add('_');
        elementsList.add('.');

        new_id = new_id.toLowerCase();
        List<Character> chars = new ArrayList<>();
        for(int i=0; i<new_id.length(); i++) {
            chars.add(new_id.charAt(i));
        }

        // 가능한 문자를 제외하고 모두 제거
        chars.removeIf(c -> !elementsList.contains(c));

        // .가 연속해서 나오는 경우 제거
        boolean flag = false;
        int i=0;
        Iterator<Character> iter = chars.iterator();
        while(iter.hasNext()) {
            char c = iter.next();
            if(c == '.') {
                if(flag) {
                    iter.remove();
                }
                else {
                    flag = true;
                }
            }
            else {
                flag = false;
            }
        }

        // .가 처음이나 마지막에 오는 경우 제거
        removeDot(chars);

        // chars가 비었다면 'a'를 추가
        if(chars.isEmpty()) {
            chars.add('a');
        }

        // 16자 이상이면 제거하고 맨앞, 맨뒤의 dot을 제거
        if(chars.size() >= 16) {
            for(i=15; i<chars.size(); i++) {
                chars.remove(i);
                i--;
            }
            removeDot(chars);
        }
        else if(chars.size() <= 2){ // 2자 이하이면 길이가 3이 될때까지 반복해서 붙임.
            while(chars.size() < 3) {
                chars.add(chars.get(chars.size()-1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            sb.append(c);
        }

        return sb.toString();
    }

    public void removeDot(List<Character> chars) {
        while(!chars.isEmpty() && (chars.get(0) == '.' || chars.get(chars.size() -1) == '.')) {
            if(chars.get(0) == '.') {
                chars.remove(0);
                continue;
            }
            if(chars.get(chars.size()-1) == '.') {
                chars.remove(chars.size()-1);
            }
        }
    }
}
