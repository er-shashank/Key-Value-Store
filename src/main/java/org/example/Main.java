package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//put sde_bootcamp title SDE-Bootcamp price 30000.00 enrolled false estimated_time 30
//get sde_bootcamp
//keys
//put sde_kickstart title SDE-Kickstart price 4000 enrolled true estimated_time 8
//get sde_kickstart
//keys
//put sde_kickstart title SDE-Kickstart price 4000.00 enrolled true estimated_time 8
//get sde_kickstart
//keys
//delete sde_bootcamp
//get sde_bootcamp
//keys
//put sde_bootcamp title SDE-Bootcamp price 30000.00 enrolled true estimated_time 30
//search price 30000.00
//search enrolled true

public class Main {
    static KVStore kvStore= new KVStore();

    public static void main(String[] args) throws Exception {

        Scanner sc= new Scanner(System.in);

        while (sc.hasNext()){
            String []command= sc.nextLine().split(" ");

            switch (command[0]){
                case "put":
                    processPut(command);
                    break;
                case "get":
                    System.out.println(processGet(command));
                    break;
                case "delete":
                     processDelete(command);
                    break;
                case "search":
                    System.out.println(search(command[1],command[2]));
                    break;
                case "keys":
                    System.out.println(getKeys());
                    break;
            }
//            get <key>
//            put <key> <attributeKey1> <attributeValue1> <attributeKey2> <attributeValue2>....
//            delete <key>
//            search <attributeKey> <attributeValue>
//            keys
//            exit

            if(command.equals("exit")){
                break;
            }
        }


        System.out.println(Utils.getDataType("12.22"));
    }

    private static String getKeys() {
        return kvStore.keys();
    }

    private static String search(String atrribute, String value) {
        return kvStore.search(atrribute,value);
    }

    private static void processDelete(String[] command) {
        kvStore.delete(command[1]);
    }

    private static String processGet(String[] command) {
        String key= command[1];
        return kvStore.get(key);
    }

    //put sde_bootcamp title SDE-Bootcamp price 30000.00 enrolled false estimated_time 30
    private static void processPut(String[] command) throws Exception {
        try{
            String key = command[1];
            List<Pair> value= new ArrayList<>();
            for(int i=2; i<command.length; i=i+2){
                String attribute= command[i];
                String localvalue= command[i+1];
                Class dataType= Utils.getDataType(localvalue);

                if(!kvStore.isValidDataType(attribute, dataType)){
                    throw new Exception("Data Type Error");
                }
                value.add(new Pair(attribute,localvalue,dataType));
            }

            kvStore.put(key,value);
        }
        catch (Exception e){
            System.out.println("Data Type Error");
        }

    }

}