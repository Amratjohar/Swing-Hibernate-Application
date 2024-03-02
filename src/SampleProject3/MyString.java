package SampleProject3;

public class MyString 
{
    public static void main(String[] args) 
    {
        String str="HEHE";
        char[] chArr= str.toCharArray();
        System.out.println(chArr.length);
       
        String result="";
        
        for(int i=0;i<chArr.length;i++)
        {
            if(!result.contains(chArr[i]+""))
            {
                result=result.concat(chArr[i]+"");
            }
        }
        
        char[] ch=result.toCharArray();
        System.out.println(ch.length);
        
        for(int i=0;i<ch.length;i++)
        {
            int count=0;   
            for(int j=0;j<chArr.length;j++)
            {
                if(ch[i]==chArr[j])
                {
                    count++;
                }
            }  
            System.out.println(ch[i]+":"+count);
        }
    }
}
