package fileiterator;

public class MyFileReader implements Iterable<String>{
private  String file;
    public static void main(String[] args) {
        for (String s : new MyFileReader("E:\\asd.txt")) {
            System.out.println(s);
        }
    }
private MyFileReader(String file){
        this.file = file;
}
    @Override
    public FileIterator iterator() {
        return new FileIterator(file);
    }
}

