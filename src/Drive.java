import java.util.HashMap;
public class Drive {

    // This is the virtual file system
    private HashMap<Character, String> vfs = new HashMap<>();

    public void setFile(char name, String data){
        // Adds to the hashmap
        vfs.put(name, data);
    }

    public String getFile(char name) {
        // Returns the string part of the HashMap
        return vfs.get(name);
    }

    public char[] names(){
        // Creates a temp array
        char[] files = new char[vfs.size()];
        int i = 0;
        // Loops through using a for-each loop
        for (char key : vfs.keySet()) {
            files[i] = key;
            ++i;
        }
        // Returns the array we generated
        return files;
    }
}