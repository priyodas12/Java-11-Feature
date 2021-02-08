package stringAPI;

public class StringEnhancement {
    public static void main(String[] args) {
        String s1=" ";
        System.out.println("Blank?"+s1.isBlank()+"\nEmpty?"+s1.isEmpty());

        String s2="abc\n" +
                "bcs\n" +
                "def\n";
        s2.lines().forEach(System.out::println);

        String s3="  aasl  as ";
        System.out.println(s3.strip());
        System.out.println(s3.trim());

        String s4="a";
        System.out.println(s4.repeat(100));
    }
}
