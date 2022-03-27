public class Solution {
    public String solution(String newId) {

        // new_id의 모든 대문자를 대응되는 소문자로 치환
        newId = newId.toLowerCase();

        // new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        String removeChar = "[^0-9a-z\\-\\_\\.]";
        newId = newId.replaceAll(removeChar, "");

        // new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        String dots = "..";
        for (int i = 1; i < newId.length(); i++) {
            newId = newId.replace(dots, ".");
            newId = newId.replace(dots, ".");
            dots += ".";
        }

        // new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거
        StringBuffer buffer = null;
        if (newId.indexOf(".") == 0 || newId.lastIndexOf(".") == (newId.length() - 1)) {
            if (newId.indexOf(".") == 0) {
                buffer = new StringBuffer(newId);
                newId = buffer.substring(1, (newId.length()));
            } else if (newId.lastIndexOf(".") == (newId.length() - 1)) {
                buffer = new StringBuffer(newId);
                newId = buffer.substring(0, (newId.length() - 1));
            }
        }

        // new_id가 빈 문자열이라면, new_id에 "a"를 대입
        if (newId.isEmpty()) {
            newId = "a";
        }
        // new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
        if (newId.length() >= 16) {
            buffer = new StringBuffer(newId);
            newId = buffer.substring(0, 15);
            if (newId.length() == 15 && newId.lastIndexOf(".") == (newId.length() - 1)) {
                buffer = new StringBuffer(newId);
                newId = buffer.substring(0, (newId.length() - 1));
            }
        }

        // new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임
        if (newId.length() <= 2) {
            String lastChar = String.valueOf(newId.charAt(newId.length() - 1));

            while (newId.length() < 3) {
                newId += lastChar;
            }
        }

        return newId;
    }
}
