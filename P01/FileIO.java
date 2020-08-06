/* FILE: FileIO.java
 * AUTHOR: Connor Kuljis 19459138
 * PURPOSE: class of methods to read and write csv/png's
 */ 
import java.util.*;
import java.io.*;
 
public class FileIO
{
    
    /* Name: readFile
     * IMPORTS: fileName of a csv file
     * EXPORTS: multidimenstional array of csv file
     * Purpose: constructs a 2D array of integers from a csvfile (String)
     * Assertion: if the csv is ragged it will throw an IllegalArgument Exception
     * LastMod: 18th May 2020 
     * CHANGED READ FILE TO RETURN A STRING ARRAY*/
    public static String[] readFile(String fileName) 
    {
        FileInputStream fileStream = null;
        InputStreamReader reader;
        BufferedReader bufReader;
        String line = "";
        int lineNum = 0, totalRows;
        String[] stringArray = null;

        try
        {
            totalRows = getNumRowsInFile(fileName); // get number of lines in file
            stringArray = new String[totalRows]; // making a right sized array to number of lines
            // reading the text to a String array
            fileStream = new FileInputStream(fileName);
            reader = new InputStreamReader(fileStream);
            bufReader = new BufferedReader(reader);
            line = bufReader.readLine();
            while(line != null)
            {
                lineNum++;
                stringArray[lineNum - 1] = line;
                line = bufReader.readLine(); // NOTE: this must be the last line in the loop
            }
            fileStream.close();
        }
        catch(IOException e)
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }
                catch(IOException ex2)
                {
                }
            }
            System.out.println(e.getMessage());
        }
        return stringArray;
    }

    /* Name: getNumRowsInFile
     * IMPORTS: fileName as a string
     * EXPORTS: multidimenstional array of csv file
     * Purpose: constructs a 2D array of integers from a csvfile (String)
     * Assertion: if the csv is ragged it will throw an IllegalArgument Exception
     * Created: 14th May 2020 */
    private static int getNumRowsInFile(String fileName) throws IOException 
    {
        int lineNum = 0;
        String line = "";
        FileInputStream fileStream = new FileInputStream(fileName);
        InputStreamReader reader = new InputStreamReader(fileStream);
        BufferedReader bufReader = new BufferedReader(reader);
        line = bufReader.readLine();
        while(line != null)
        {
            lineNum++;
            line = bufReader.readLine();
        }
        fileStream.close();
        return lineNum;
    }

    private static boolean arrayIsRectangle(String[] stringArray)
    {
        // scan the first line and get the number of elements "size"
        // if the next lines do not equals the size return false

        boolean valid = true;

        StringTokenizer tokenizer = new StringTokenizer(stringArray[0], ",");
        int maxLength = tokenizer.countTokens(); 

        int length;
        int lineMismatch = 0;
        for(int i = 1; i < stringArray.length - 1; i++)
        {
            StringTokenizer st = new StringTokenizer(stringArray[i], ",");
            length = st.countTokens();
            if(length != maxLength)
            {
                lineMismatch++;
            }
        }
        if(lineMismatch != 0)
        {
            valid = false;
        }
        return valid;
    }

    private static int[][] parseStringToInt(String[] stringArray, int totalRows)
    {
        int cols = stringArray.length;
        int rows = totalRows;

        int[][] parsedArray = new int[rows][cols];

        int count = -1;
        int element;
        for(int i = 0; i < rows; i++)
        {
            StringTokenizer tokenizer = new StringTokenizer(stringArray[i], ",");
            while(tokenizer.hasMoreTokens())
            {
                count++;
                element = Integer.parseInt(tokenizer.nextToken());
                parsedArray[i][count] = element;
                // System.out.println(i + ", " + count + "= " + element); 
            }
            count = -1; // resetting the count
        }
        return parsedArray;
    }

    /*
     * attempts to write a 2D array to a file
     *
     *
     */
    public static void writeFile(String fileName, int[][] writeArray)
    {
        String[] stringArray = new String[writeArray.length];
        String line = "";
        FileOutputStream fileStrm = null; 
        PrintWriter pw;
        try
        {
            fileStrm = new FileOutputStream(fileName, false); // true will append the file, false overwrites.
            pw = new PrintWriter(fileStrm);
            for(int i = 0; i < writeArray.length; i++)
            {
                for(int j = 0; j < writeArray[0].length; j++)
                {
                    if(j == writeArray[0].length - 1) // check if the it is the last element in the row
                    {
                        line += String.valueOf(writeArray[i][j]); // this is the last element so dont put an ',' at the end
                    }
                    else
                    {
                        line += String.valueOf(writeArray[i][j] + ","); // append ',' to the end
                    }
                }
                pw.println(line); 
                line = "";
            }
            pw.close();
        }
        catch(IOException e) {
            if (fileStrm != null) {
                try
                {
                    fileStrm.close();
                    
                }
                catch(IOException ex2) {}
                
            }
            System.out.println("Error in writing to file: " + e.getMessage()); 
        }
    }



    public static Student[] readStudentFile(String filename)
    {
        Student[] studentArray = null; // studentArray must be the size of all valid students, cannot exceed 20
        String[] stringArray = null;
        int validCount = 0; 

        // ### COUNTING THE NUMBER OF VALID STUDENTS ###
        // pre-read the file and construct the object, if it is valid increment the count, use this count to construct the array of objects
        try
        {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) // error will be thrown here
            {
                String line = scan.nextLine();

                String[]sLine = line.split(",");
                String name = sLine[0];
                int studentID = Integer.parseInt(sLine[1]);
                double mark = Double.parseDouble(sLine[2]);
                try
                {
                    Student studentObj = new Student(name, studentID, mark);
                    validCount++;
                }
                catch(Exception e)
                {
                    System.out.println("Could not contruct student: " + e.getMessage()); 
                }
            }
            scan.close();
        }
        catch (IOException e)
        {
            System.out.println(e); 
        }

        // ### CREATING THE STUDENT ARRAY (ARRAY OF STUDENTS OF SIZE validCount)
        studentArray = new Student[validCount];

        // ## INSERTING THE VALID STUDENTS INTO THE ARRAY
        int index = 0;
        try
        {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) // error will be thrown here
            {
                String line = scan.nextLine();

                String[]sLine = line.split(",");
                String name = sLine[0];
                int studentID = Integer.parseInt(sLine[1]);
                double mark = Double.parseDouble(sLine[2]);
                try
                {
                    Student studentObj = new Student(name, studentID, mark);
                    studentArray[index] = studentObj;
                    index++;
                }
                catch(Exception e)
                {
                }
            }
            scan.close();
        }
        catch (IOException e)
        {
            System.out.println(e); 
        }

        return studentArray;
    }

    public static void calcStudentAverage(Student[] studentArray)
    {
        double avg = 0;
        int count = 0;
        for(int i = 0; i < studentArray.length; i++)
        {
            if(studentArray[i] != null)
            {
                avg += studentArray[i].getMark();
                count ++;
            }
        }
        avg = avg / count;
        System.out.println("Average: " + avg); 
    }

    public static void viewStudents(Student[] studentArray)
    {
        for(int i = 0; i < studentArray.length; i++)
        {
            if(studentArray[i] != null)
            {
                Student temp = studentArray[i];
                System.out.println(temp.getName() + " (" + temp.getStudentID() + ") scored " + temp.getMark() + "%");
            }
        }
    }

}
