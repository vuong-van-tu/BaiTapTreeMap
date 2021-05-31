public class MainT {
    public static void main(String[] args) {
        CustomManager customer = new CustomManager();
        ReaderCustom readerCustom = new ReaderCustom();
        System.out.println(readerCustom.readerCustom("src/writeFile.csv"));;
    }
}
