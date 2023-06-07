import java.util.*;

public class CamelCase {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        String[] dict = { "Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity", "HiTechLab" };
        String pat = sc.nextLine();
        findAllWords(dict, pat);
        sc.close();
    }

    private static void findAllWords(String[] dict, String pattern) {
        var res = new TreeMap<String, ArrayList<String>>();
        int n = dict.length;
        for (int i = 0; i < n; i++) {
            insert(res, dict[i], pattern);
        }
        if (res.size() == 0) {
            System.out.println("No match found");
            return;
        }
        for (var entry : res.entrySet()) {
            Collections.sort(entry.getValue());
            for (var item : entry.getValue()) {
                System.out.println(item);
            }
        }
    }

    private static void insert(TreeMap<String, ArrayList<String>> res, String str,
            String pat) {
        int n = str.length();
        int m = pat.length();
        int j = 0;
        var abbr = new StringBuilder();
        boolean matched = false;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                if (j < m) {
                    if (str.charAt(i) == pat.charAt(j)) {
                        j++;
                        abbr.append(str.charAt(i));
                    } else
                        break;
                    if (j == m) {
                        matched = true;
                        j++;
                    }
                } else
                    abbr.append(str.charAt(i));

            }
        }

        if (matched) {
            String temp = abbr.toString();
            if (res.containsKey(temp)) {
                res.get(temp).add(str);
            } else {
                res.put(temp, new ArrayList<String>(Arrays.asList(str)));
            }
        }
        return;
    }
}