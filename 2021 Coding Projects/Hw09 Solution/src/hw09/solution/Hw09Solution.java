//cipher text hw solution

/*
encode(with own table):
String table = " abcdefghijklmnopqrstuvwxyz";
cipherText = "";

for(int i=0; i<plainText.length();i++){
    int tmp;
    
    tmp = (table.indexOf(plainText.charAt(i))+key)%27;
    cipherText += table.charAt(tmp);
}
*/

//------------------------------------

/*
encode(without table):
for(int i=0; i<plainText.length();i++){
    int tmp;
    if(plainText.charAt(i)==' ')
        tmp = 0;
    else
        tmp = plainText.charAt(i)-'a'+1;
    tmp = (tmp+key)%27;
    if(tmp == 0)
        cipherText += " ";
    else
        cipherText +=(char) (tmp+'a'-1);
*/