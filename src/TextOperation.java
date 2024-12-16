/**
 * Клас для виконання операцій над текстом.
 */

public class TextOperation {

    /**
     * Обробляє текст, міняючи перше і останнє слово місцями у кожному реченні.
     *
     * Алгоритм роботи:
     *1. Перевірка вхідного тексту: якщо текст є порожнім або `null`, генерується виняток {@link IllegalArgumentException}.
     *2. Розбиття тексту на речення за допомогою регулярного виразу.
     *3. Обробка кожного речення:
     *  - Розбиття речення на слова.
     *  - Заміна першого і останнього слова місцями.
     *  - Збереження розділового знака в кінці речення.
     *  - Додавання обробленого речення до результату.
     *4. Повернення результату як об'єкта {@link StringBuilder}.
     * @param text текст для обробки
     * @return текст із заміненими місцями першим і останнім словами в кожному реченні
     * @throws IllegalArgumentException якщо текст є порожнім або `null`
     */
    public StringBuilder processText(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст не може бути порожнім!");
        }


        String[] sentences = text.split("(?<=\\.|\\!|\\?)");
        StringBuilder result = new StringBuilder();

        for (String sentence : sentences) {
            
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
