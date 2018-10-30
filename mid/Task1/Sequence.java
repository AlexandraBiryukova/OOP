package mid.Task1;

public class Sequence {
    private String s;
    Sequence(String ss){
        s=ss;
    }
    public void setWord(String s){this.s=s;}
    public String getWord(){return s;}
    public boolean isPalindrome(){
        int left;
        int right=s.length()-1;
        for(left=0;left<s.length()/2;left++){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            right--;
        }
        return true;

    }
    public boolean isSubString(Sequence s2){
        if(this.s.contains(s2.s))
            return true;
        return false;


    }
}
