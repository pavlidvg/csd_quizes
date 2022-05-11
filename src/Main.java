import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Question q1 = new Question("th a title","this is a desc");
        Question q2 = new Question("title of q2","extra description");
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(q1);
        questions.add(q2);
        Quiz quiz = new Quiz();

        try
        {
            q1.writeToXML(new FileOutputStream("output_testing.xml") );
            System.out.println("will now xmlize");
            writeToXML(questions,new FileOutputStream("ArrayList.xml"));

        }catch(Exception e)
        {
            //
        }
    }

    public static boolean writeToXML(ArrayList<Question> questions, FileOutputStream f)
    {
        try
        {


            XMLEncoder encoder = new XMLEncoder(f);
            encoder.writeObject(questions);
            encoder.close();
            f.close();
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }
}
