public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
    // Write your code here
        List<Integer> list = new ArrayList<>();
        for (String s : query) {
            for (int j = 0; j < dictionary.size(); j++) {
                String q = dictionary.get(j);
                if (s.length() != q.length()) continue;
                int count = 0;
                if (c(q, s)) {
                    count++;
                }
                if (j == dictionary.size() - 1) {
                    list.add(count);
                }
            }
        }

        return list;
    }

    private static boolean c(String query, String dict) {

        if (query.length() != dict.length()) return false;

        final int length = query.length();

        for (char st : query.toCharArray()) {
            if (!dict.contains(String.valueOf(st))) return false;
        }

        final char[] queryArray = query.toCharArray();
        final char[] dictArray = dict.toCharArray();
        int total = 0;

        for (int i = 0; i < length; i++) {
            int queryCounter = 0;
            char queryChar = queryArray[i];
            for (int j = 0; j < length; j++) {
                if (queryArray[j] == queryChar) {
                    queryCounter++;
                }
            }
            for (int a = 0; a < length; a++) {
                int dictCounter = 0;
                char dictChar = dictArray[a];
                for (int q = 0; q < length; q++) {
                    if (dictArray[q] == dictChar) dictCounter++;
                }
                if (dictCounter == queryCounter && queryChar == dictChar) {
                    total++;
                    break;
                }
            }
        }
        return total == length;
    }
