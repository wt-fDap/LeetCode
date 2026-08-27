import java.util.Arrays;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        int n = target.length();

        for (int i = 0; i < n; i++) {
            int targetChar = target.charAt(i) - 'a';

            // Case 1: Try to match target[i]
            if (cnt[targetChar] > 0) {
                cnt[targetChar]--;
                if (canFormGreater(cnt, target, i + 1)) {
                    res.append(target.charAt(i));
                    continue;
                }
                // Backtrack if it doesn't lead to a valid greater permutation
                cnt[targetChar]++;
            }

            // Case 2: Try to place a strictly larger character than target[i]
            for (int j = targetChar + 1; j < 26; j++) {
                if (cnt[j] > 0) {
                    cnt[j]--;
                    res.append((char) ('a' + j));
                    res.append(getMinString(cnt));
                    return res.toString();
                }
            }

            // If we can't match or bump up at this point, no solution exists
            return "";
        }

        return "";
    }

    private boolean canFormGreater(int[] cnt, String target, int start) {
        String maxStr = getMaxString(cnt);
        String suffix = target.substring(start);
        return maxStr.compareTo(suffix) > 0;
    }

    private String getMaxString(int[] cnt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            for (int k = 0; k < cnt[i]; k++) {
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }

    private String getMinString(int[] cnt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < cnt[i]; k++) {
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }
}