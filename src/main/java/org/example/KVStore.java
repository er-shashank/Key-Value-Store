package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO The key-value store should be thread-safe.
public class KVStore {

    static Map<String, List<Pair>> kvStore= new HashMap<>();
    static Map<String, Class> attributeAndValueDataType= new HashMap<>();
// values could be string, integer, double or boolean.
//    Map<String, T>

    //title: SDE-Kickstart, price: 4000.00, enrolled: true, estimated_time: 8
    public static String get(String key){
        List<Pair> pairs = kvStore.get(key);
        String json = "";
        if (pairs != null && !pairs.isEmpty())
            for (Pair pair : pairs) {
                json = json+ pair.attribute+": "+pair.value+",";
            }

        return json.equals("") ? "null" : json;
    }

    public static boolean isValidDataType(String attribute, Class dataType) {
        if(attributeAndValueDataType.get(attribute) == null)
            attributeAndValueDataType.put(attribute,dataType);
        return  attributeAndValueDataType.get(attribute).equals(dataType);
    }

    String search(String attributeKey, String attributeValue) {
        String keyList="";
        for(Map.Entry<String , List<Pair>> entry:kvStore.entrySet()){
            String key = entry.getKey();

            for (Pair pair: entry.getValue()){
                if(pair.attribute.equals(attributeKey) && pair.value.equals(attributeValue)){
                    keyList+=key;
                    break;
                }
            }
        }
        return keyList;
    }
    void put(String key, List<Pair> listOfAttributePairs){
        kvStore.put(key,listOfAttributePairs);
    }

    void delete(String key){
        kvStore.remove(key);
    }
    String keys(){
        return kvStore.keySet().toString();
    }
}
