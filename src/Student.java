import java.util.Scanner;

/**
 * @author Công Toàn
 */
public class Student {
    static Scanner sc = new Scanner(System.in);
    private String Name, Email, Academic;
    private Double Marks;

    public Student() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAcademic() {
        return Academic;
    }

    public void setAcademic(String academic) {
        Academic = academic;
    }

    public Double getMark() {
        return Marks;
    }

    public void setMark(Double mark) {
        Marks = mark;
    }

    void input() {
        System.out.print("Nhập Họ và Tên: ");
        Name = sc.nextLine();
        System.out.print("Nhập Email: ");
        Email = sc.nextLine();
        System.out.print("Nhập Điểm (VD: 5,0): ");
        Marks = sc.nextDouble();
        Academic = academicLevel();
    }

    String academicLevel() {
        if (Marks >= 9)
            Academic = "Xuat sac";
        else if (Marks >= 7.5)
            Academic = "Gioi";
        else if (Marks >= 6.5)
            Academic = "Kha";
        else if (Marks >= 5)
            Academic = "Trung Binh";
        else
            Academic = "Yeu";
        return Academic;
    }

    public void print() {
        System.out.println(Name + "\t" + Email + "\t" + Marks + "\t" + Academic);
    }
}
