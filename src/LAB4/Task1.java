package LAB4;

public class Task1 {

    public String[] findRelativeRanks(int[] score) {
        int count = 0;
        int len = score.length;
        String[] answer = new String[len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j ++) {
                if(score[i] < score[j]) {
                    count++;
                }
            }
            answer[i] = switch (count) {
                case 0 -> "Gold Medal";
                case 1 -> "Silver Medal";
                case 2 -> "Bronze Medal";
                default -> String.valueOf(count + 1);
            };
            count = 0;
        }
        return answer;
    }
}
