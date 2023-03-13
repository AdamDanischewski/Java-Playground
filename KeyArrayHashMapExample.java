/* 
 *   ######################################################################
 ######################################################################
## Author: Adam M. Danischewski, Created Date: 20230312, Version: v0.1
## File ID: db5e861076d128a4e6be5b880ba8b587
## Filename: KeyArrayHashMapExample.java
## Classes: KeyArrayHashMapExample
## Last Modified: 2023-03-13
## Issues: If you find any issues emai1 me at my <first name> dot
##         <my last name> at gmail dot com.
##
## Requirements: KeyArrayHashMap.class (in same directory as this class)
## 
## The purpose of this class is to provide example functionality of 
## KeyArrayHashMap. 
## E.g. 
  $ java KeyArrayHashMapExample 134
  Found key 134 it's [34, 134, 234].
  Searching for key 134, found value [first value for 34, second value for 34, third value for 34].
  $ java KeyArrayHashMapExample 234
  Found key 234 it's [34, 134, 234].
  Searching for key 234, found value [first value for 34, second value for 34, third value for 34].
  $ java KeyArrayHashMapExample 34
  Found key 34 it's [34, 134, 234].
  Searching for key 34, found value [first value for 34, second value for 34, third value for 34].
  $ java KeyArrayHashMapExample 235
  Found key 235 it's [35, 135, 235].
  Searching for key 235, found value [first value for 35, second value for 35, third value for 35].

## This header is required to follow any reuse of this code and is not 
## allowed to be modified or deleted except by the Author. This program is 
## free software: you can redistribute it and/or modify it under the terms 
## of the GNU General Public License as published by the Free Software 
## Foundation, version 3 of the License.
##
## This program is distributed in the hope that it will be useful,
## but WITHOUT ANY WARRANTY; without even the implied warranty of
## MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
## GNU General Public License for more details.
 ######################################################################
  ######################################################################
 */

import java.util.ArrayList;
import java.util.Objects; 

public class KeyArrayHashMapExample { 
   
     public static void main(String[] args) {
     KeyArrayHashMap mykeymap = new KeyArrayHashMap(); 
     String srchKey = args[0]; 
     String srchVal1 = "first value for "+srchKey; 
     String srchVal2 = "second value for "+srchKey; 
     String srchVal3 = "third value for "+srchKey; 
     ArrayList<String> newKeys; 
     ArrayList<String> newValues = new ArrayList<String>(); 
     // Create a new KeyArrayHashMap, that will have tuples of keys and values 
     //  
     System.out.println("Building test arrays for our KeyArrayHashMap:"); 
     for(int i=1; i<=50; i++) { 
       newKeys = new ArrayList<String>();
       newKeys.add(Integer.toString(i));  
       newKeys.add(Integer.toString(i+100));  
       newKeys.add(Integer.toString(i+200));  
       newValues = new ArrayList<String>();
       newValues.add("first value for "+Integer.toString(i)); 
       newValues.add("second value for "+Integer.toString(i)); 
       newValues.add("third value for "+Integer.toString(i));   
       System.out.printf("Entry %02d, KeyArr: [%s] ValArr[%s].\n", i, newKeys.toString(), newValues.toString()); 
       mykeymap.put(newKeys, newValues); 
    }
    
    System.out.printf("Searching all keys for all values: key %s, found value %s.\n", srchKey, Objects.toString(mykeymap.getV(srchKey), "(*** key not found ***)")); 
    System.out.printf("Searching 2nd key for all values: key %s, found value %s.\n", srchKey, Objects.toString(mykeymap.getV(srchKey, 2), "(*** key not found ***)")); 
    System.out.printf("Searching 3rd keys for 1st value: key %s, found value %s.\n", srchKey, Objects.toString(mykeymap.getV(srchKey, 3, 1), "(*** key not found ***)")); 
    System.out.printf("Searching 1st val for all keys: key %s, found value %s.\n", srchKey, Objects.toString(mykeymap.getK(srchVal1, 1), "(*** key not found ***)")); 
    System.out.printf("Searching 2nd val for 3rd key: key %s, found value %s.\n", srchKey, Objects.toString(mykeymap.getK(srchVal2, 2, 3), "(*** key not found ***)"));     
    System.out.printf("Searching all values for all keys: key %s, found value %s.\n", srchKey, Objects.toString(mykeymap.getK(srchVal3), "(*** key not found ***)")); 
    
    System.out.printf("Searching 2nd val for 10th key (out of bounds): key %s, found value %s.\n", srchKey, Objects.toString(mykeymap.getK(srchVal2, 2, 10), "(*** key not found ***)")); 
    System.out.printf("Searching 10th val for 3rd key (out of bounds): key %s, found value %s.\n", srchKey, Objects.toString(mykeymap.getK(srchVal2, 10, 3), "(*** key not found ***)")); 
    System.out.printf("Searching 1st val for all keys: key %s (out of bounds val index).\n", srchKey, Objects.toString(mykeymap.getK(srchVal1, 10), "(*** key not found ***)")); 
   
    }
}
    