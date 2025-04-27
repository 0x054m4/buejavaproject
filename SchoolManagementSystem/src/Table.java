import java.io.*;
import java.util.*;
public class Table {
    private File file;
    Table(String file){
        this.file = new File("data/" + file + ".txt");
    }
    public boolean update(String old, String newString){
        try {
            File tempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String line;
            while((line = reader.readLine()) != null){
                writer.write(line.replace(old, newString));
                writer.newLine();
            }
            reader.close();
            writer.close();
            file.delete();
            tempFile.renameTo(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(String toDelete){
        try {
            File tempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String line;
            while((line = reader.readLine()) != null){
                if(!line.contains(toDelete)){
                    writer.write(line);
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();
            file.delete();
            tempFile.renameTo(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean insert(String toInsert){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(toInsert);
            writer.newLine();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<String> dump(){
        ArrayList<String> data = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                data.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
