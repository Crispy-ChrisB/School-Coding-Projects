//which word appears most hw

/*
getMode:
String maxWord="";
int maxCount=0;
int i,j;
String tmpS = s.toLowerCase();
String tmpS1 = "";

if(tmpS.charAt(tmp.length()-1 != ' ')
    tmpS+=" ";

for(int i = 0; i < tmpS.length();i++){
    if(tmpS.charAt(i)<'a' || tmpS.charAt(i)>'z'){
        if(tmpWord.length() != 0){
            int cnt = 1;
            int k = i+1;

            while((k=tmpS.indexOf(tmpWord, k)) != -1){
                char ch1 = tmpS.charAt(k-1);
                char ch2 = tmpS.charAt(k+tmpWord.length());

                if((ch1<'a' || ch1>'z')&&(ch2<'a'||ch2>'z'))
                    cnt++;
                k += tmpWord.length();
            }
            
            if(cnt>maxCount) {
                maxCount = cnt;
                maxWord = tmpWord;
            }
        }
    }
}
    else
        tmpWord += tmpS.charAt(i);
*/