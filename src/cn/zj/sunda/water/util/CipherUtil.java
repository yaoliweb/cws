package cn.zj.sunda.water.util;
import java.security.MessageDigest;
public class CipherUtil {
	 private final static String[] hexDigits = {"0", "1", "2", "3", "4",     
         "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};     
          
     /** * ��inputString����     */     
     public static String generatePassword(String inputString){     
         return encodeByMD5(inputString);     
     }     
          
         
     public static boolean validatePassword(String password, String inputString){     
         if(password.equals(encodeByMD5(inputString))){     
             return true;     
         } else{     
             return false;     
         }     
     }     
     public static String returnEncodeByMde(String originString){   
         return encodeByMD5(originString);   
     }   
     /**  ���ַ����MD5����     */     
     private static String encodeByMD5(String originString){     
         if (originString != null){     
             try{     
                 MessageDigest md = MessageDigest.getInstance("MD5");     
                 //ʹ��ָ�����ֽ������ժҪ���������£�Ȼ�����ժҪ����     
                 byte[] results = md.digest(originString.getBytes());     
                 //���õ����ֽ��������ַ���     
                 String resultString = byteArrayToHexString(results);     
                 String pass =  resultString.toUpperCase();
                 System.out.println(pass);
                 return pass;   
             } catch(Exception ex){     
                 ex.printStackTrace();     
             }     
         }     
         return null;     
     }     
          
      
     private static String byteArrayToHexString(byte[] b){     
         StringBuffer resultSb = new StringBuffer();     
         for (int i = 0; i < b.length; i++){     
             resultSb.append(byteToHexString(b[i]));     
         }     
         return resultSb.toString();     
     }     
          
     /** ��һ���ֽ�ת����ʮ�������ʽ���ַ�     */     
     private static String byteToHexString(byte b){     
         int n = b;     
         if (n < 0)     
             n = 256 + n;     
         int d1 = n / 16;     
         int d2 = n % 16;     
         return hexDigits[d1] + hexDigits[d2];     
     }     
}
