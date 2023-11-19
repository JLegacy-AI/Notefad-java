package sample.stack;

import java.io.*;
import java.util.Scanner;

public class FilingControl {
    public static File f;

    public static File getF() {
        return f;
    }

    public static void setF(File f) {
        FilingControl.f = f;
    }

    public String readFile(String fpath) throws FileNotFoundException
    {
        f=new File(fpath);
        String str="";
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine())
        {
            str=str.concat(sc.nextLine()+"\n");
        }
        return str;
    }

    public String readFile()
    {
        try {
            String str="";
            Scanner sc = null;
            sc = new Scanner(f);
            while(sc.hasNextLine())
            {
                str=str.concat(sc.nextLine()+"\n");
            }
            return str;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void writeFile(String s){

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(f));
            br.write(s);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
