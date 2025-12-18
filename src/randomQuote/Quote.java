package randomQuote;

import java.util.ArrayList;
import java.util.Scanner;

public class Quote {


    public static int randomNum;

    public static ArrayList countQuote = new ArrayList();

    public static int[] results = new int[14];

    public static Scanner scanner = new Scanner(System.in);

    public static int random() {
        int min = 0;
        int max = 14;
        int range = (max - min) + 1;
        randomNum = (int) ((range * Math.random() + min));
        return randomNum;
    }

    public static void main(String[] args) {

        System.out.println("Введите \"цитата\" для получения новой цитаты или \"выход\" для завершения:");

         String[] quotes = {
                "Жизнь — это то, что происходит, пока ты строишь другие планы. – Джон Леннон",
                "Тот, кто не рискует, не может выиграть. – Джордж Бернард Шоу",
                "Успех — это не конечный пункт, неудача — это не фатально; главное — это мужество продолжать. – Уинстон Черчилль",
                "Счастье не в том, чтобы иметь, а в том, чтобы быть. – Ив Сен-Лоран",
                "Будьте изменениями, которые хотите видеть в мире. – Махатма Ганди",
                "Работа не волк. Никто не волк. Только волк — волк.",
                "Настоящий мужчина, как ковер тети Зины — с каждым годом лысеет.",
                "Мама учила не ругаться матом, но жизнь научила не ругаться матом при маме.",
                "Если закрыть глаза, становится темно.",
                "Если тебе где-то не рады в рваных носках, то и в целых туда идти не стоит.",
                "«Жи-ши» пиши от души.",
                "В Риме был, а папы не видал.",
                "Тут — это вам не там.",
                "Кто рано встает — тому весь день спать хочется.",
                "Если ты смелый, ловкий и очень сексуальный — иди домой, ты пьян."
        };

        while (true){
            String inputText = scanner.nextLine();
            inputText = inputText.toLowerCase();

            if (inputText.equals("цитата")) {
                random();
                System.out.println(quotes[randomNum]);
            }else if(inputText.equals("выход")){
                System.out.println();
                break;
            }else System.out.println();
        }
    }
}
