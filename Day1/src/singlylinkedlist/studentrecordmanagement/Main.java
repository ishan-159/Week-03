package singlylinkedlist.studentrecordmanagement;

public class Main {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addAtEnd(62, "Ishan Tiwari", 22, "A");
        list.addAtEnd(82, "Naman Banke", 22, "A");
        list.addAtBeginning(98, "Om Yadav", 24, "B+");
        list.displayAllStudents();

        System.out.println("Searching for Roll Number 2:");
        list.searchByRollNumber(2);

        System.out.println("Updating Grade for Roll Number 1:");
        list.updateGradeByRollNumber(1, "A+");
        list.displayAllStudents();

        System.out.println("Deleting Roll Number 3:");
        list.deleteByRollNumber(3);
        list.displayAllStudents();
    }
}

