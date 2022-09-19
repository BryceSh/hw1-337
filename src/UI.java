import java.io.*;

public class UI
{
    private static Drive vfs = new Drive();
    public static String[] parseCommand(String command)
    {
        return command.split("\\s+");
    }

    public static void importFile(String[] tokens)
    {
        if (tokens.length == 3) {
            // Check to see if the file is already in the VFS
            char output = tokens[2].charAt(0); // Converts the string to char
            if (vfs.getFile(output) == null) {
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(tokens[1]));
                    vfs.setFile(output, br.readLine());
                    br.close();
                } catch (Exception e) {
                    System.out.println("Something happened: " + e.getMessage());
                }
            } else {
                System.out.println("File already exist!");
            }
        } else {
            System.out.println("Invalid Command Arguments: import <INPUT PATH> <VFS OUTPUT>");
        }
    }

    public static void exportFile(String[] tokens)
    {
        if (tokens.length == 3) {
            char input = tokens[1].charAt(0);
            try {
                File output = new File(tokens[2]);
                if (!output.exists()) {
                    BufferedWriter outFile = new BufferedWriter(new FileWriter(output));
                    outFile.write(vfs.getFile(input));
                    outFile.close();
                } else {
                    System.out.println("File already exist!");
                }
            } catch (Exception e){
                System.out.println("Export Error: " + e.getMessage());
            }
        }
    }

    public static void ls(String[] tokens)
    {
        char[] files = vfs.names();
        for (char name : files) {
            System.out.println("" + name + " " + vfs.getFile(name).length());
        }
    }

}