import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CaesarCipher
{
    private int shift;

    CaesarCipher()
    {
        this.shift = 3;
    }

    CaesarCipher(int shift)
    {
        this.shift = shift;
    }


    private char performChar(char ch, int min, int max, boolean encrypt)
    {
        int temp;

        if(encrypt)
        {
            temp = (int)ch + this.shift;
        }
        else
        {
            temp = (int)ch + -1 * this.shift;
        }

        if (temp > max)
        {
            return (char) (min - 1 + (temp - max));
        }
        else if (temp < min)
        {
            return (char) (max + 1 - (min - temp));
        }
        else
        {
            return (char) temp;
        }
    }

    public String encrypt(String str)
    {
        String newStr = "";
        str = str.replaceAll("\\p{Punct}", "");

        for (int i = 0; i < str.length(); i++)
        {
            if ((int) str.charAt(i) >= 65 && (int) str.charAt(i) <= 90)
            {
                newStr += performChar(str.charAt(i), 65, 90, true);
            }
            else if ((int) str.charAt(i) >= 97 && (int) str.charAt(i) <= 122)
            {
                newStr += performChar(str.charAt(i), 97, 122, true);
            }
            else if(str.charAt(i) == ' ')
            {
                newStr += str.charAt(i);
            }
        }

        return newStr;
    }

    public String decrypt(String str)
    {
        String newStr = "";
        str = str.replaceAll("\\p{Punct}", "");

        for (int i = 0; i < str.length(); i++)
        {
            if ((int) str.charAt(i) >= 65 && (int) str.charAt(i) <= 90)
            {
                newStr += performChar(str.charAt(i), 65, 90, false);
            }
            else if ((int) str.charAt(i) >= 97 && (int) str.charAt(i) <= 122)
            {
                newStr += performChar(str.charAt(i), 97, 122, false);
            }
            else if(str.charAt(i) == ' ')
            {
                newStr += str.charAt(i);
            }
        }

        return newStr;
    }
    public String encryptFile(String file)
    {
        String str = "";

        try(FileReader reader = new FileReader(file))
        {
            int c;
            while((c=reader.read())!=-1){

                str += (char)c;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        String encryptStr = "";
        try(FileWriter writer = new FileWriter("outEncrypt.txt", false))
        {
            encryptStr = encrypt(str);
            writer.write(encryptStr);

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return encryptStr;
    }

    public String decryptFile(String file)
    {
        String str = "";

        try(FileReader reader = new FileReader(file))
        {
            int c;
            while((c=reader.read())!=-1){

                str += (char)c;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        String decryptStr = "";
        try(FileWriter writer = new FileWriter("outDecrypt.txt", false))
        {
            decryptStr = decrypt(str);
            writer.write(decryptStr);

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return decryptStr;
    }
}
