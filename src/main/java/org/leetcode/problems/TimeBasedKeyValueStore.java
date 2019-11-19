package org.leetcode.problems;

/*Create a timebased key-value store class TimeMap, that supports two operations.

1. set(string key, string value, int timestamp)

Stores the key and value, along with the given timestamp.

2. get(string key, int timestamp)

Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
If there are multiple such values, it returns the one with the largest timestamp_prev.
If there are no values, it returns the empty string ("").


Example 1:

Input:
inputs = ["TimeMap","set","get","get","set","get","get"],
inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]

Output: [null,null,"bar","bar",null,"bar2","bar2"]

Explanation:

TimeMap kv;

kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
kv.get("foo", 1);  // output "bar"
kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2,
then the only value is at timestamp 1 ie "bar"
kv.set("foo", "bar2", 4);
kv.get("foo", 4); // output "bar2"
kv.get("foo", 5); //output "bar2"

Example 2:

Input:
inputs = ["TimeMap","set","set","get","get","get","get","get"],
inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
Output: [null,null,null,"","high","high","low","low"]


Note:

All key/value strings are lowercase.
All key/value strings have length in the range [1, 100]
The timestamps for all TimeMap.set operations are strictly increasing.
1 <= timestamp <= 10^7
TimeMap.set and TimeMap.get functions will be called a total of 120000 times (combined) per test case.*/


/*["TimeMap","set","set","set","set","get","get","get","get","get","get","set","get","get","get","set","set","set","set","get","get"]
[[],["ctondw","ztpearaw",1],["vrobykydll","hwliiq",2],["gszaw","ztpearaw",3],["ctondw","gszaw",4],["gszaw",5],["ctondw",6],["ctondw",7],["gszaw",8],["vrobykydll",9],["ctondw",10],["vrobykydll","kcvcjzzwx",11],["vrobykydll",12],["ctondw",13],["vrobykydll",14],["ztpearaw","zondoubtib",15],["kcvcjzzwx","hwliiq",16],["wtgbfvg","vrobykydll",17],["hwliiq","gzsiivks",18],["kcvcjzzwx",19],["ztpearaw",20]]


//expected = [null,null,null,null,null,"ztpearaw","gszaw","gszaw","ztpearaw","hwliiq","gszaw",null,"kcvcjzzwx","gszaw","kcvcjzzwx",null,null,null,null,"hwliiq","zondoubtib"]

*/

import java.util.HashMap;
import java.util.Map;

public class TimeBasedKeyValueStore {

    private Map<Integer, Map<String, String>> map;

    public TimeBasedKeyValueStore() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Map<String, String> entry = new HashMap<>();
        entry.put(key, value);
        map.put(timestamp, entry);
    }

    public String get(String key, int timestamp) {
        while (timestamp > 0) {
            Map<String, String> valueMap = map.get(timestamp);

            if(valueMap != null) {
                if(valueMap.containsKey(key)) {
                    return valueMap.get(key);
                }
            }

            timestamp -- ;
        }

        return "";
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore valueStore = new TimeBasedKeyValueStore();

        /*valueStore.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1

        System.out.println(valueStore.get("foo", 1));  // output "bar"
        System.out.println(valueStore.get("foo", 3));  // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2,

        valueStore.set("foo", "bar2", 4);
        System.out.println(valueStore.get("foo", 4));  // output "bar2"
        System.out.println(valueStore.get("foo", 5));  //output "bar2"*/

        valueStore.set("ctondw","ztpearaw",1);
        valueStore.set("vrobykydll","hwliiq",2);
        valueStore.set("gszaw","ztpearaw",3);
        valueStore.set("ctondw","gszaw",4);

        System.out.println(valueStore.get("gszaw",5));
        System.out.println(valueStore.get("ctondw",6));

        System.out.println(valueStore.get("ctondw",7));
        System.out.println(valueStore.get("gszaw",8));
        System.out.println(valueStore.get("vrobykydll",9));
        System.out.println(valueStore.get("ctondw",10));

        valueStore.set("vrobykydll","kcvcjzzwx",11);

        System.out.println(valueStore.get("vrobykydll",12));
        System.out.println(valueStore.get("ctondw",13));
        System.out.println(valueStore.get("vrobykydll",14));

        valueStore.set("ztpearaw","zondoubtib",15);
        valueStore.set("kcvcjzzwx","hwliiq",16);
        valueStore.set("wtgbfvg","vrobykydll",17);
        valueStore.set("hwliiq","gzsiivks",18);

        System.out.println(valueStore.get("kcvcjzzwx",19));
        System.out.println(valueStore.get("ztpearaw",20));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */