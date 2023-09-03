package com.androiddevs.shoppinglisttestingyt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

   /*
    * @param strs: a list of strings
    * @return: encodes a list of strings to a single string.
    */
   public String encode(List<String> strs) {
      // write your code here
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < strs.size(); i++) {
         if (i == strs.size() -1 ) {
            result.append(strs.get(i));
         } else {
            result.append(strs.get(i)).append(":;");
         }
      }
      return result.toString();
   }

   /*
    * @param str: A string
    * @return: decodes a single string to a list of strings
    */
   public List<String> decode(String str) {
      // write your code here
      List<String> result = new ArrayList<>();

      return Arrays.asList(str.split(":;"));
   }

}
