import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TxtWriter {




    public static String[] txtInputs() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array :: ");
        int size = sc.nextInt();
        String myArray[] = new String[size];
        System.out.println("Enter elements of the array (Strings) :: ");
        for(int i=0; i<size; i++) {
            myArray[i] = sc.next();
        }
        System.out.println(Arrays.toString(myArray));
        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(myArray));
        System.out.println("Enter the element that is to be added:");
        String element = sc.next();
        myList.add(element);
        myArray = myList.toArray(myArray);
        return myArray;
    }
}
