import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Công Toàn
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> listStudent = new ArrayList<>();

    public static void main(String[] args) {
        setListStudent();
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
                    searchByMark();
                    break;
                case 4:
                    searchByAcademic();
                    break;
                case 5:
                    updateStudent();
                    break;
                case 6:
                    sortStudent();
                    break;
                case 7:
                    outputMaximum();
                    break;
                case 8:
                    marksAverage();
                    break;
                case 9:
                    studentUpMarksAverage();
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
        System.out.println("               Tên: Lê Công Toàn              ");
        System.out.println("               MSSV:  PS10057                 ");
        System.out.println(" +------------------MENU---------------------+");
        System.out.println(" |-------------QUẢN LÝ HỌC VIÊN--------------|");
        System.out.println(" | 1. Nhập danh sách học viên                |");
        System.out.println(" | 2. Xuất danh sách học viên                |");
        System.out.println(" | 3. Tìm học viên theo khoảng điểm          |");
        System.out.println(" | 4. Tìm học viên theo học lực              |");
        System.out.println(" | 5. Tìm và cập nhật học viên theo tên      |");
        System.out.println(" | 6. Sắp xếp học viên theo điểm             |");
        System.out.println(" | 7. Xuất 5 học viên có điểm cao nhất       |");
        System.out.println(" | 8. Tính điểm trung bình của lớp           |");
        System.out.println(" | 9. Danh sách học viên có điểm trên điểm TB|");
        System.out.println(" | 0. Kết Thúc                               |");
        System.out.println(" +------------------o0o----------------------+");
        System.out.println();

    }

    public static void setListStudent() {
        Student student = new Student();
        student.setName("Toan");
        student.setEmail("toan@fpt.com");
        student.setMark(5.0);
        student.setAcademic(student.academicLevel());
        listStudent.add(student);

        Student student2 = new Student();
        student2.setName("le");
        student2.setEmail("le@fpt.com");
        student2.setMark(7.0);
        student2.setAcademic(student.academicLevel());
        listStudent.add(student2);
    }

    public static void inputStudent() {
        do {
            Student student = new Student();
            student.input();
            listStudent.add(student);
            System.out.println("Bạn có muốn nhập tiếp không: y/n");
            String x = sc.nextLine();
            if (x.compareTo("n") == 0) {
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

    public static void searchByMark() {
        System.out.println("Tìm kiếm học viên theo khoảng điểm");
        System.out.print("Điểm nhỏ nhất: ");
        double min = sc.nextDouble();
        System.out.print("Điểm lớn nhất: ");
        double max = sc.nextDouble();
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getMark() >= min && listStudent.get(i).getMark() <= max) {
                System.out.println("Học viên tìm được là: ");
                listStudent.get(i).print();
            } else {
                System.out.println("Không tìm được học viên");
            }
        }
    }

    public static void searchByAcademic() {
        System.out.print("Nhập học lực (Yeu, Trung Binh, Kha, Gioi, Xuat sac): ");
        String hocLuc = sc.nextLine();
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getAcademic().equalsIgnoreCase(hocLuc)) {
                System.out.println("Học viên tìm được là: ");
                listStudent.get(i).print();
            } else {
                System.out.println("Không tìm được học viên");
            }
        }
    }

    public static void updateStudent() {
        System.out.print("Mời nhập Họ Tên học viên: ");
        String name = sc.nextLine();
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getName().equalsIgnoreCase(name)) {
                System.out.println("Đã tìm được học viên " + name + " Mời bạn nhập thông tin mới");
                Student student = listStudent.get(i);
                student.input();
                listStudent.remove(i);
                listStudent.add(i, student);
            }
        }
    }

    public static void sortStudent() {
        for (int i = 0; i < listStudent.size(); i++) {
            int m = i;
            for (int j = 0; j < listStudent.size(); j++) {
                if (listStudent.get(m).getMark() > listStudent.get(j).getMark())
                    m = j;
            }
            Student student = listStudent.get(i);
            listStudent.set(i, listStudent.get(m));
            listStudent.set(m, student);
        }
        System.out.println("Danh sách sau khi sắp xếp: ");
        for (Student student : listStudent) {
            student.print();
        }
    }

    public static void outputMaximum() {
        for (int i = 0; i < listStudent.size(); i++) {
            int m = i;
            for (int j = 0; j < listStudent.size(); j++) {
                if (listStudent.get(m).getMark() > listStudent.get(j).getMark())
                    m = j;
            }
            Student student = listStudent.get(i);
            student.print();
        }
    }

    public static void marksAverage() {
        double sumMark = 0, avg;
        for (int i = 0; i < listStudent.size(); i++) {
            sumMark = sumMark + listStudent.get(i).getMark();
        }
        avg = sumMark / listStudent.size();
        System.out.println("Điểm trung bình của sv là: " + avg);
    }

    public static void studentUpMarksAverage() {
        System.out.println("Danh sách học viên có điểm trên điểm TB: ");
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getMark() >= 5) {
                listStudent.get(i).print();
            }
        }
    }
}


