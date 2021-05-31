import java.security.Key;
import java.util.*;


public class CustomManager {
    private Map<Integer, Customer> map = null;
    ReaderCustom rc = new ReaderCustom();
    public Map<Integer, Customer> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Customer> map) {
        this.map = map;
    }

    public CustomManager() {
        map = rc.readerCustom("src/writeFile.csv");

    }
    public void addCus(int key, Customer customer) {
        map.put(key, customer);
    }

    public void display(Map<Integer,Customer> disMap) {
        if (!disMap.isEmpty()){
            System.out.println("Danh sách:");
            Set<Integer> keys = disMap.keySet();
            for (Integer key : keys) {
                System.out.println(key + ": " + disMap.get(key));
            }
        }else {
            System.out.println("Danh sách rỗng!");
        }
    }

    public int findCusKey(int key) {
        if (map.containsKey(key)) {
            return key;
        }
        return -1;
    }

    public void deleteCus(int key) {
            map.remove(findCusKey(key));
    }

    public Map<Integer,Customer> findByName(String name) {
        List<Map.Entry<Integer, Customer>> entries = new ArrayList<>(map.entrySet());
        Map<Integer,Customer> listName = new LinkedHashMap<>();
        int count = 0;
        for (Map.Entry<Integer, Customer> entry : entries) {
            if (entry.getValue().getName().equals(name)) {
                listName.put(entry.getKey(),entry.getValue());
                count++;
            }
        }
        if (count!=0){
            return listName;
        }else {
            return null;
        }
    }



    public Map<Integer,Customer> findByAge(int ageFirst, int ageLast) {
        List<Map.Entry<Integer, Customer>> entries = new ArrayList<>(map.entrySet());
        Map<Integer,Customer> listAge = new LinkedHashMap<>();
        int count = 0;
        for (Map.Entry<Integer, Customer> entry : entries) {
            if (entry.getValue().getAge() >= ageFirst && entry.getValue().getAge()<=ageLast) {
                listAge.put(entry.getKey(),entry.getValue());
                count++;
            }
        }
        if (count!=0){
            return listAge;
        }else {
            return null;
        }
    }

    public Map<Integer,Customer> findByAddress(String address) {
        List<Map.Entry<Integer, Customer>> entries = new ArrayList<>(map.entrySet());
        Map<Integer,Customer> listAddress = new LinkedHashMap<>();
        int count = 0;
        for (Map.Entry<Integer, Customer> entry : entries) {
            if (entry.getValue().getAddress().equals(address)) {
                listAddress.put(entry.getKey(),entry.getValue());
                count++;
            }
        }
        if (count!=0){
            return listAddress;
        }else {
            return null;
        }
    }

    public Map<Integer,Customer> findByID(String id) {
        List<Map.Entry<Integer, Customer>> entries = new ArrayList<>(map.entrySet());
        Map<Integer,Customer> listID = new LinkedHashMap<>();
        int count = 0;
        for (Map.Entry<Integer, Customer> entry : entries) {
            if (entry.getValue().getId().equals(id)) {
                listID.put(entry.getKey(),entry.getValue());
                count++;
            }
        }
        if (count!=0){
            return listID;
        }else {
            return null;
        }
    }

    public void editCus(int key, Customer customer) {
        List<Map.Entry<Integer, Customer>> entries = new ArrayList<>(map.entrySet());
        for (Map.Entry<Integer, Customer> entry : entries) {
            if (findCusKey(key) == entry.getKey()) {
                map.replace(key, customer);
            }
        }
    }

    public void sortByName() {
        List<Map.Entry<Integer, Customer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Customer>>() {
            @Override
            public int compare(Map.Entry<Integer, Customer> o1, Map.Entry<Integer, Customer> o2) {
                return o1.getValue().getName().compareTo(o2.getValue().getName());
            }
        });
        Map<Integer, Customer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Customer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        map = sortedMap;
    }

    public void sortByAge() {
        List<Map.Entry<Integer, Customer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Customer>>() {
            @Override
            public int compare(Map.Entry<Integer, Customer> o1, Map.Entry<Integer, Customer> o2) {
                return o1.getValue().getAge() - o2.getValue().getAge();
            }
        });
        Map<Integer, Customer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Customer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        map = sortedMap;
    }

    public void sortByNameAndAge() {
        List<Map.Entry<Integer, Customer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Customer>>() {
            @Override
            public int compare(Map.Entry<Integer, Customer> o1, Map.Entry<Integer, Customer> o2) {
                if (o1.getValue().getName().compareTo(o2.getValue().getName()) == 0) {
                    return o1.getValue().getAge() - o2.getValue().getAge();
                }
                return o1.getValue().getName().compareTo(o2.getValue().getName());
            }
        });
        Map<Integer, Customer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Customer> entry : entries) {
                sortedMap.put(entry.getKey(),entry.getValue());
        }
        map = sortedMap;
    }
}


