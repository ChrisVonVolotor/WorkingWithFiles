import java.io.*;
import java.util.ArrayList;

public class Files {
        ArrayList<Person> staff = new ArrayList<Person>();
        ArrayList<Person> fIn = new ArrayList<Person>();

    File file = new File("D:/JavaProjects/WorkingWothFiles/myfile.txt");
    BufferedWriter bw = null;


    public void fileCreator() throws IOException {
        staff.add(new Person("Boris",22,"Tailor"));
        staff.add(new Person("Dolly",27,"Soldier"));
        staff.add(new Person("Amanda",84,"Firefighter"));
        staff.add(new Person("Bob",46,"Tinkerer"));
        staff.add(new Person("Ross",64,"Spy"));

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            for (Person st: staff
                 ) {
                bw.write(st.toString());
                bw.newLine();

                System.out.println("Line Written");
            }

            System.out.println("File Completed");

        }catch (IOException ioe){
            ioe.printStackTrace();
            throw ioe;
        }
        finally {
            try {
                if (bw!=null){
                    bw.close();
                }
            }catch (Exception ex){
                System.out.println("Error in closing BufferWriter: " + ex );
            }
        }




    }

    public void fileReader()throws FileNotFoundException, IOException{

        BufferedReader br = new BufferedReader(new FileReader(file));

        int intLine = 0;
        String tempName;
        String tempAge;
        String tempOcc;

        for (String x = br.readLine(); x != null; x = br.readLine()){
            tempName = x.substring(x.indexOf("Name:") + 5, x.indexOf(" O"));
            tempOcc = x.substring(x.indexOf("Occupation:") + 11, x.indexOf(" A"));
            tempAge = (x.substring(x.indexOf("Age:") + 4, x.length()));

            fIn.add(new Person(tempName,Integer.parseInt(tempAge),tempOcc));
            System.out.println("Person retreived;");
        }

        for (Person per: fIn
             ) {
            System.out.println(per.toString());

        }


    }
}
