package arr.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileComparer {
	protected static void compareFiles(String firstFile, String secondFile)
	        throws Exception {

	    Scanner x = new Scanner(new File(firstFile));
	    List<String> list1 = getScannerList(x);

	    x = new Scanner(new File(secondFile));
	    List<String> list2 = getScannerList(x);

	    x.close();

	    System.out.println("File Extras");
	    printLnList(listExtras(list1, new ArrayList<String>(list2)));

	    System.out.println("File Removals");
	    printLnList(listExtras(list2, list1));  
	}

	protected static List<String> listExtras(List<String> list1,
	        List<String> list2) throws Exception {      
	    list2.removeAll(list1);
	    return list2;
	}

	protected static List<String> getScannerList(Scanner sc) throws Exception {

	    List<String> scannerList = new ArrayList<String>();

	    while (sc.hasNext())
	        scannerList.add(sc.nextLine());

	    return scannerList;
	}

	protected static void printLnList(List<String> list) {
	    for (String string : list)
	        System.out.println(string);
	}
}
