/*
cCourse: CSC189
pProject: Hw09
dDate: Oct. 27, 2021
aAuthor: Chris Ball
pPurpose: Make a cipher encoded based on a text
 */
package hw09;
class MyCipher{
    int key;
    MyCipher(){
        key = 0;
    }
    
    void setKey(int k){
        key = k;
    }
    
    String encode(String p){
        String code="";
        int len = p.length()-1;
        for(int i=0;i<=len;i++){
            if(p.charAt(i) == ' ')
                code = code+((char) ('a'+(key-1)));
            else if((char)(p.charAt(i)+key) == (char)('z'+1))
                code = code+' ';
            else if((char) (p.charAt(i)+key)>'z'){
                char track = 'a';
                track -= (char)(('z'-1-p.charAt(i)-(key-('z'-p.charAt(i))))/2);
                code = code+track;
                }
            else
            code = code+((char) (p.charAt(i)+key));
            
        }
        return code;
    }
    
    String decode(String c){
        String code="";
        int len = c.length()-1;
        for(int i=len;i>=0;i--){
            if(c.charAt(i) == ' ')
                code = ((char) ('z'-key+1))+code;
            else if((char)(c.charAt(i)-key) == (char)('a'-1))
                code = ' '+code;
            else if((char) (c.charAt(i)-key)<'a'-1){
                char track = 'z';
                track += (char)('z'-3-c.charAt(i)-(key-(key-('z'-c.charAt(i)))));
                code = track+code;
                }
            else
            code = ((char) (c.charAt(i)-key))+code;
        }
        return code;
    }
}
public class Hw09 {
    public static void main(String[] args) {
        MyCipher test = new MyCipher();
        
        test.setKey(5);
        System.out.println(test.encode("attack at dawn"));
        System.out.println(test.decode("fyyfhpefyeifas"));
    }
   
}