package com.salary.holder;

import java.util.HashMap;
import java.util.Map;

public class AccessTokenHolder {
   private static final Map<Long,String> userMap = new HashMap<>();

   public static void addUserToken(Long userId,String accessToken){
       if(userMap.containsKey(userId)){
           userMap.replace(userId,accessToken);
       }else{
           userMap.put(userId,accessToken);
       }
   }

   public static void removeUserToken(Long userId){
       userMap.remove(userId);
   }

   public static String getUserToken(Long userId){
       return userMap.get(userId);
   }

}
