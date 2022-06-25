import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> listStudent = new ArrayList<>();

    public static void main(String[] args) {
        readObjectFromFile();
        int select;
        do {
            menu();
            select = loop();
            switch (select) {
                case 1:
                    inputStudent();
                    break;
                case 2:
                    outputStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:

                    break;
                case 0:
                    System.out.println("Bạn đã thoát chương trình");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ mời nhập lại");
            }
            continues();
        }
        while (select != 0);
    }

    public static int loop() {
        int chon;
        System.out.print("Mời chọn chức năng: ");
        chon = sc.nextInt();
        sc.nextLine();
        return chon;
    }

    public static void continues() {
        Scanner keyIn = new Scanner(System.in);
        System.out.println();
        System.out.print("Nhấn phím enter để tiếp tục");
        keyIn.nextLine();
    }

    static void menu() {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("               Tên:                           ");
        System.out.println("               MSSV:                          ");
        System.out.println(" +------------------MENU---------------------+");
        System.out.println(" |-------------QUẢN LÝ HỌC VIÊN--------------|");
        System.out.println(" | 1. Nhập danh sách học viên                |");
        System.out.println(" | 2. Xuất danh sách học viên                |");
        System.out.println(" | 3. Tìm và cập nhật học viên theo MHS      |");
        System.out.println(" | 4. Xóa học viên theo MHS                  |");
        System.out.println(" | 0. Kết Thúc                               |");
        System.out.println(" +------------------o0o----------------------+");
        System.out.println();

    }

    public static void writeObjectToFile() {
        try {
            FileOutputStream inputStream = new FileOutputStream("t.tmp");
            ObjectOutputStream objectOutput = new ObjectOutputStream(inputStream);
            objectOutput.writeObject(listStudent);
            objectOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readObjectFromFile() {
        try {
            FileInputStream fos = new FileInputStream("t.tmp");
            ObjectInputStream objectInputStream = new ObjectInputStream(fos);

            listStudent = (ArrayList<Student>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void inputStudent() {
        do {
            Student student = new Student();
            student.input();
            listStudent.add(student);
            System.out.println(listStudent.get(0).getId());
            System.out.println("Bạn có muốn nhập tiếp không: y/n");
            String x = sc.nextLine();
            if (x.compareTo("n") == 0) {
                writeObjectToFile();
                break;
            }
        } while (true);
    }

    public static void outputStudent() {
        System.out.println("-----Danh sách Học Viên-----");
        for (Student student : listStudent) {
            student.print();
        }
    }

    public static void updateStudent() {
        System.out.print("Nhập MHS: ");
        String id = sc.nextLine();
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId().equalsIgnoreCase(id)) {
                System.out.println("Đã tìm được học viên " + listStudent.get(i).getName() + " Mời bạn nhập thông tin mới");
                Student student = listStudent.get(i);
                student.input();
                listStudent.remove(i);
                listStudent.add(i, student);
            }
        }
        writeObjectToFile();
    }

    public static void deleteStudent() {
        System.out.print("Nhập MHS: ");
        String id = sc.nextLine();
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId().equalsIgnoreCase(id)) {
                listStudent.remove(i);
                System.out.println("Đã xóa học viên " + listStudent.get(i).getName());
            }
        }
        writeObjectToFile();
    }

//    public static void sortStudent() {
//        for (int i = 0; i < listStudent.size(); i++) {
//            int m = i;
//            for (int j = 0; j < listStudent.size(); j++) {
//                if (listStudent.get(m).getMark() > listStudent.get(j).getMark())
//                    m = j;
//            }
//            Student student = listStudent.get(i);
//            listStudent.set(i, listStudent.get(m));
//            listStudent.set(m, student);
//        }
//        System.out.println("Danh sách sau khi sắp xếp: ");
//        for (Student student : listStudent) {
//            student.print();
//        }
//    }

}


