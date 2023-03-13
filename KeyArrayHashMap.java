/* 
 *   ######################################################################
 ######################################################################
## Author: Adam M. Danischewski, Created Date: 20230312, Version: v0.1
## File ID: ed330953e83d67c146c488dd81a3280e
## Filename: KeyArrayHashMap.java
## Classes: KeyArrayHashMap
## Last Modified: 2023-03-13
## Issues: If you find any issues emai1 me at my <first name> dot
##         <my last name> at gmail dot com.
##
## The purpose of this class is to provide a flexible and somewhat quick 
## mechanism for supporting multi-keys and eventually the ability to search 
## via multi-keys and/or multi-values mapped back to multi-keys. For instance 
## using known length keys and values, it should (eventually its a wip) be able 
## to do things like: 
##  getV("match", 3, 5); // find "match" in key 3 and return 5th value. 
##  getV("match", 2);    // find "match" in 2nd key, return all values. 
##  getV("match");       // find "match" in any key, return all values. 
##  getK("match", 3);    // find "match" in 3rd value and return all keys. 
##  getK("match", 2, 2); // find "match" in 2nd value , return 2nd key. 
##  getK("match");       // find "match" in any value, return all keys. 
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

  // Returns the first matching key set's value array. 
 public ArrayList<String> getV(String findKey) { 
    ArrayList<String> retVal = null; 
        for ( ArrayList<String> key : this.keySet() ) {
        if (key.contains(findKey)) {           
            retVal = key; 
            break; 
            }
    }
return (retVal == null) ? null : this.get(retVal);
}

// Return the value array for keys[keyIndex] == findKey.  
public ArrayList<String> getV(String findKey, int keyIndex) { 
    ArrayList<String> retVal = null; 
        for ( ArrayList<String> key : this.keySet() ) {
            if ((keyIndex<key.size()) && (keyIndex>0) && key.get(keyIndex-1).equals(findKey)) {           
            retVal = key; 
            break; 
            }
    }
return (retVal == null) ? null : this.get(retVal);
}

 // Return String val[valIndex] for keys[keyIndex]==findKey  
public String getV(String findKey, int keyIndex, int valIndex) { 
        ArrayList<String> retVal = null; 
        for ( ArrayList<String> key : this.keySet() ) {
          if ((keyIndex<key.size()) && (keyIndex>0) && key.get(keyIndex-1).equals(findKey)) {           
            retVal = key; 
            break; 
        }
    }
             // Sanity check - retVal is non-null and valIndex is within [1..retVal.size()], null otherwise  
    return ((retVal == null) || ((valIndex > retVal.size())||(valIndex<1))) ? null : retVal.get(valIndex-1);
}

 // Return the key array for valArray.contains(findVal) 
public ArrayList<String> getK(String findVal) { 
    ArrayList<String> retVal = null; 
    ArrayList<String> valSet = null; 
    for ( ArrayList<String> key : this.keySet() ) { 
        valSet = this.get(key); // Value set for current key 
        if (valSet.contains(findVal)) {           
            retVal = key; 
        }
    }
    return (retVal == null) ? null : retVal;
}


// Return the key array for vals[valIndex]=findVal  
public ArrayList<String> getK(String findVal, int valIndex) { 
    ArrayList<String> retVal = null; 
    ArrayList<String> valSet = null; 
    for ( ArrayList<String> key : this.keySet() ) {
        valSet = this.get(key); // Value set for current key 
        if ((valIndex<valSet.size()) && (valIndex>0) && valSet.get(valIndex-1).equals(findVal)) {           
            retVal = key; 
            break; 
            }
    }
return  (retVal == null) ? null : retVal;
}

// Return String valArray[valIndex] for keys[keyIndex] == findVal  
public String getK(String findVal, int valIndex, int keyIndex) { 
    ArrayList<String> retVal = null; 
    ArrayList<String> valSet = null; 
    for ( ArrayList<String> key : this.keySet() ) {
        valSet = this.get(key); // Value set for current key 
               // Make sure our requested val index is sane, within [1..key.size()], quietly   
               // skip o/w since variable length key and value ArrayLists are possible.  
           if ((valIndex<valSet.size()) && (valIndex>0) && valSet.get(valIndex-1).equals(findVal)) {           
            retVal = key; 
            break; 
            }
        }
        // Sanity check - retVal is non-null and keyIndex is within [1..key.size()], null otherwise  
return ((retVal == null) || ((keyIndex > retVal.size())||(keyIndex<1))) ? null : retVal.get(keyIndex-1);
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

