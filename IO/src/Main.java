import java.io.*;
import java.util.Arrays;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        // java.io.file
        File file = new File ("/usr/bin/java");
        System.out.println(file.isAbsolute()); //true
        System.out.println(file.getPath()); // usr bin java
        System.out.println(file.getName()); // java
        System.out.println(file.getParent()); // usr bin
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.canRead());
        System.out.println(file.length());
        System.out.println(file.lastModified());

        // Directory
        File usrbin = new File ("usr/bin");
        System.out.println(usrbin.exists());
        System.out.println(usrbin.isDirectory());
        System.out.println(Arrays.toString(usrbin.list()));
        System.out.println(Arrays.toString(usrbin.listFiles()));

        // Modifications of file system
        try {
            System.out.println(usrbin.createNewFile()); // true or false
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(usrbin.delete()); // true or false
        System.out.println(usrbin.renameTo(file)); // true or false
        System.out.println(usrbin.mkdir()); // true or false
        System.out.println(usrbin.mkdirs()); // true or false

        //Java.nio.file.path
        Path path = Paths.get("/usr/bin/java");
        System.out.println(path.isAbsolute());
        System.out.println(path.toString()); // return path -  usr bin java
        System.out.println(path.getFileName()); // get last component of path - java
        System.out.println(path.getParent()); // get previous components - usr bin
        System.out.println(path.getNameCount()); // get number of components - 3
        System.out.println(path.getName(1)); // get component by index

        //Work with files

        Files.exists(path); // true or false
        Files.isRegularFile(path); // true of false
        Files.isReadable(path); // true or false
        try {
            Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.getLastModifiedTime(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Work with directories

        Path usBin = Paths.get("/usr/bin");
        Files.exists(usBin); //  true or false
        Files.isDirectory(usBin); // true or false

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(usBin)){
            for (Path child : dirStream){
                System.out.println(child);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path newPath = Paths.get("/usr/bin/newPath");

        try {
            Files.move(path,newPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.copy(path , newPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.createDirectory(usBin);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.createDirectories(usBin);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Byte Streams
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("input.data")); // read file
            System.out.println(inputStream.read()); // read the first byte and move the pointer to the next


        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream byteArrayInputStream =
                new ByteArrayInputStream(new byte[] {1,2,3}); // read byte array
        DataInputStream dataInputStream= new DataInputStream(inputStream); //
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File("output.data"));
            fileOutputStream.write(1); // write first byte
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


        // Copying
        byte [] buf = new byte[1024];
        int bytesRead;
        while(true){
            try {
                if (!((bytesRead= inputStream.read(buf)) > 0)) break;
                fileOutputStream.write(buf,0,bytesRead);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Reader and Writer
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(inputStream,"UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        new BufferedReader(reader);
        OutputStreamWriter writer = null;
        writer = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);


    }
}
