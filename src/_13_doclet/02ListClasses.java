import com.sun.javadoc.*;

public class ListClasses extends Doclet {
public static boolean start(RootDoc root) {
        ClassDoc[] classes = root.classes();

        for (ClassDoc cd : classes) {
            System.out.println("Class [" + cd + "] has the following methods");

            for(MemberDoc md : cd.methods()) {
               System.out.println("  " + md);
            }
        }

        return true;
    }}