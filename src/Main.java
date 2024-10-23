import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите размер сдвига: "); int shift = in.nextInt(); in.nextLine();
        System.out.print("Введите текст: "); String str = in.nextLine();

        CaesarCipher caesarCipher = new CaesarCipher(shift);

        String encStr = caesarCipher.encrypt(str);
        String decStr = caesarCipher.decrypt(encStr);

        System.out.printf("Зашифрованная строка: %s\n", encStr);
        System.out.printf("Расшифрованная строка: %s\n", decStr);

        String encFile = caesarCipher.encryptFile("encryptFile.txt");
        String decFile = caesarCipher.decryptFile("decryptFile.txt");

        System.out.printf("Зашифрованный файл: %s\n", encFile);
        System.out.printf("Расшифрованный файл: %s\n", decFile);
    }
}