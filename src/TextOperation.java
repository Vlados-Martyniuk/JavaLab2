
public class TextOperation {

    public StringBuilder processText(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст не може бути порожнім!");
        }


        String[] sentences = text.split("(?<=\\.|\\!|\\?)");
        StringBuilder result = new StringBuilder();

        for (String sentence : sentences) {
            // Розділення речення на слова
            String[] words = sentence.trim().split("\\s+");
            if (words.length > 1) {

                String firstWord = words[0];
                String lastWord = words[words.length - 1];

                words[0] = lastWord.replaceAll("[.!?]", "");
                words[words.length - 1] = firstWord;


                StringBuilder sentenceBuilder = new StringBuilder();
                for (int i = 0; i < words.length; i++) {
                    sentenceBuilder.append(words[i]);
                    if (i < words.length - 1) {
                        sentenceBuilder.append(" ");
                    }
                }

                char lastChar = sentence.charAt(sentence.length() - 1);
                if (".!?".indexOf(lastChar) != -1) {
                    sentenceBuilder.append(lastChar);
                }

                result.append(sentenceBuilder).append(" ");
            } else {
                result.append(sentence).append(" ");
            }
        }

        return result;
    }
}
