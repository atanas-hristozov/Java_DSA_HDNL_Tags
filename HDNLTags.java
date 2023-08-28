import java.util.*;

public class HDNLTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Tag> tags = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                char letter = line.charAt(0);
                int num = Integer.parseInt(line.substring(1));
                tags.add(new Tag(letter, num));
            }
        }

        Stack<Tag> stack = new Stack<>();
        for (Tag tag : tags) {
            while (!stack.isEmpty() && stack.peek().num >= tag.num) {
                Tag popped = stack.pop();
                System.out.println(getIndent(popped.num) + "</" + popped.letter + popped.num + ">");
            }
            System.out.println(getIndent(tag.num - 1) + "<" + tag.letter + tag.num + ">");
            stack.push(tag);
        }

        while (!stack.isEmpty()) {
            Tag tag = stack.pop();
            System.out.println(getIndent(tag.num - 1) + "</" + tag.letter + tag.num + ">");
        }
    }

    static String getIndent(int num) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < num; i++) {
            indent.append(" ");
        }
        return indent.toString();
    }
}

class Tag {
    char letter;
    int num;

    public Tag(char letter, int num) {
        this.letter = letter;
        this.num = num;
    }
}