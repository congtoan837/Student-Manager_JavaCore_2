import java.io.Serializable;
import java.util.Scanner;

/**
 * @author Công Toàn
 */
public class Student implements Serializable {
    static Scanner sc = new Scanner(System.in);
    private String id, name, image, address, note;
    private Double Marks;

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getMarks() {
        return Marks;
    }

    public void setMarks(Double marks) {
        Marks = marks;
    }

    void input() {
        System.out.print("Nhập MHS: ");
        id = sc.nextLine();
        System.out.print("Nhập tên: ");
        name = sc.nextLine();
        System.out.print("Nhập điểm: ");
        Marks = sc.nextDouble();
        System.out.print("Nhập hình ảnh: ");
        image = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        address = sc.nextLine();
        System.out.print("Nhập ghi chú: ");
        note = sc.nextLine();
    }

    public void print() {
        System.out.println(id + "\t" + name + "\t" + Marks + "\t" + image + "\t" + address + "\t" + note);
    }
}
