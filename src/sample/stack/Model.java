package sample.stack;

import java.util.Locale;

public class Model {
    public static Stack undo= new Stack();
    public static Stack redo= new Stack();

    public static String unDO(String s){
        Node n = undo.pop();
        if(n.remove){
            String update = "";
            if(n.pos<s.length()){
                for (int i = 0; i < s.length(); i++) {
                    if(i==n.pos){
                        update+=n.data+"";
                    }
                    update+=""+s.charAt(i);
                }
                System.out.println(update);
                s=update;
            }
            else{
                s+=""+n.data;
            }

        }else{
            String update ="";
            for(int i=0 ; i< s.length() ; i++ ){
                if(i!=n.pos){
                    update+=s.charAt(i)+"";
                }
            }
            s= update;
        }
        redo.push(n);
        return  s;
    }

    public static String reDO(String s){
        Node n = redo.pop();
        if(n.remove){
            String update ="";
            for(int i=0 ; i< s.length() ; i++ ){
                if(i<n.pos || i>=n.pos+n.data.length()){
                    update+=s.charAt(i)+"";
                }
            }
            s= update;
        }else{
            String update = "";
            if(n.pos<s.length()){
                for (int i = 0; i < s.length(); i++) {
                    if(i==n.pos){
                        update+=n.data+"";
                    }
                    update+=""+s.charAt(i);
                }
                System.out.println(update);
                s=update;
            }
            else{
                s+=""+n.data;
            }
        }
        undo.push(n);
        return  s;
    }

    public static String joinStack(Stack s){
        String k="";
        Node n = s.pop();
        while(n!=null){
            k=n.data+k;
            n = s.pop();
            System.out.println(k);
        }
        return k;
    }

    public static int[] findOne(String s, String f){
        int t = -1;
        if(s.toLowerCase().contains(f.toLowerCase())){
            t = s.toLowerCase().indexOf(f.toLowerCase());
        }
        return new int[]{t, t+f.length()-1};
    }


}
