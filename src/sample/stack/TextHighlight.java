package sample.stack;

import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;

public class TextHighlight extends DefaultHighlighter.DefaultHighlightPainter {

    static Highlighter.HighlightPainter hp =new TextHighlight(Color.YELLOW);

    public TextHighlight(Color c) {
        super(c);
    }

    public static void highLight(JTextComponent jc, String s){
        try{
            Highlighter hl = jc.getHighlighter();
            hl.removeAllHighlights();
            Document dc = jc.getDocument();
            String text = dc.getText(0, dc.getLength());
            int index =  0;
            while((index=text.toUpperCase().indexOf(s.toUpperCase(), index))>=0){
                hl.addHighlight(index, index+s.length(),hp);
                index+=index+s.length();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void highLight(JTextComponent jc, int[] x){
        try{
            Highlighter hl = jc.getHighlighter();
            System.out.println(x[0]+"  ---  "+x[1]);
            hl.addHighlight(x[0], x[1],hp);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void highLightRemove(JTextComponent jc){
        jc.getHighlighter().removeAllHighlights();
    }

    public static ArrayList<String> indexes(String s, String word)
    {
        s=s.toUpperCase();
        word = word.toUpperCase();
        int k=0,count=0;
        ArrayList<String> ind= new ArrayList<>();
        for(int i=0; i<s.length(); i++ )
        {
            k=i;
            count=0;
            if(s.charAt(i)==word.charAt(0))
            {
                for(int j=1; j<word.length(); j++)
                {
                    if(++k<s.length())
                    {
                        if(s.charAt(k)==word.charAt(j))
                        {
                            count++;
                        }
                    }
                }

                if(count==(word.length()-1))
                {
                    ind.add(""+i+","+(i+(word.length())));
                    count=0;
                }
            }
        }
        for (String x: ind) {
            System.out.println(x);
        }
        return ind;
    }
}
