/* 
 *   ######################################################################
 ######################################################################
## Author: Adam M. Danischewski, Created Date: 20230312, Version: v0.1
## File ID: ed330953e83d67c146c488dd81a3280e
## Filename: KeyArrayHashMap.java
## Classes: KeyArrayHashMap
## Last Modified: 2023-03-12
## Issues: If you find any issues emai1 me at my <first name> dot
##         <my last name> at gmail dot com.
##
## The purpose of this class is to provide a flexible and somewhat quick 
## mechanism for supporting multi-keys and eventually the ability to search 
## via multi-keys and/or multi-values mapped back to multi-keys. For instance 
## using known length keys and values, it should (eventually its a wip) be able 
## to do things like: 
##  getV("match", 3, 5); // find "match" in key 3 and return 5th value. 
##  getV("match", 0, 2); // find "match" in any key, return 2nd value. 
##  getV("match", 0);    // find "match" in any key, return all values. 
##  getK("match", 3, 5); // find "match" in value 3 and return 5th key. 
##  getK("match", 0, 2); // find "match" in any value, return 2nd key. 
##  getK("match", 0);    // find "match" in any value, return all keys. 
## 
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
import java.util.List;

import java.util.HashMap; 

@SuppressWarnings("serial")
class KeyArrayHashMap extends HashMap<ArrayList<String>, ArrayList<String>> { 

 public ArrayList<String> get(String findKey) { 
    ArrayList<String> retVal = null; 
        for ( ArrayList<String> key : this.keySet() ) {
        if (key.contains(findKey)) {           
             //System.out.printf( "Found key %s it's %s.\n", findKey, key.toString());
            retVal = key; 
            break; 
            }
    }
return this.get(retVal);
}

// Return the value array for specific hit on keys[findkey].  
public ArrayList<String> getV(String findKey, int keyIndex) { 
    ArrayList<String> retVal = null; 
        for ( ArrayList<String> key : this.keySet() ) {
        if (key.get(keyIndex-1).equals(findKey)) {           
             //System.out.printf( "Found key %s it's %s.\n", findKey, key.toString());
            retVal = key; 
            break; 
            }
    }
return this.get(retVal);
}

// Return the value array for specific hit on keys[findkey].  
public String getV(String findKey, int keyIndex, int valIndex) { 
        ArrayList<String> retVal = null; 
        for ( ArrayList<String> key : this.keySet() ) {
        if (key.get(keyIndex-1).equals(findKey)) {           
            //System.out.printf( "Found key %s it's %s.\n", findKey, key.toString());
            retVal = key; 
            break; 
        }
    }
return (retVal == null) ? null : this.get(retVal).get(valIndex-1);
}



//  @Override
//  public boolean equals(Object o) {
//      Keys other = (Keys)o;
//      return other.s.equals(s) && other.i.equals(i);
//  }

//  @Override
//  public int hashCode() {
//      return toString().hashCode();
//  }

// @Override 
// public String toString() {
//     return i + "," + s;
// }

}  

