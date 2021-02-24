/**This program will execute simple commands given in machine language, TML
 * @author Rachel
 */

package javainterpreter;
import java.io.*;
import java.util.ArrayList;

public class JavaInterpreter {

	/*
	 * Initialization of ArrayLists that identify the registers, which go by Name, Value, 
	 * and Register Number
	 */
    private final ArrayList<String> registerName = new ArrayList<String>();
    private final ArrayList<String> registerValues = new ArrayList<String>();
    private final ArrayList<String> registerRegister = new ArrayList<String>();

    /*
     * Instruction that when given the appropriate values will add a register to the ArrayList
     */
    public void store(String name, String val, String register, int i) {
        registerName.add(name);
        registerValues.add(val);
        registerRegister.add(register);
    }
    
    /*
     * Instruction that will add two registers together and store their sum in an ArrayList
     */
    public void add(String a, String b, int i, String reg) {
        registerName.add(reg);
        int posa = registerRegister.indexOf(a);
        int posb = registerRegister.indexOf(b);
        int element = Integer.parseInt(registerValues.get(posa));
        int element1 = Integer.parseInt(registerValues.get(posb));
        int sum = element + element1;
        registerValues.add(Integer.toString(sum));
    }

    /*
     * Instruction that will subtract two registers together and store their sum in an ArrayList
     */
    public void sub(String a, String b, int i, String reg) {
        registerName.add(reg);
        int posa = registerRegister.indexOf(a);
        int posb = registerRegister.indexOf(b);
        int element = Integer.parseInt(registerValues.get(posa));
        int element1 = Integer.parseInt(registerValues.get(posb));
        int sub = element - element1;
        registerValues.add(Integer.toString(sub));
    }

    /*
     * Instruction that will multiply two registers together and store their sum in an ArrayList
     */
    public void mul(String a, String b, int i, String reg) {
        registerName.add(reg);
        int posa = registerRegister.indexOf(a);
        int posb = registerRegister.indexOf(b);
        int element = Integer.parseInt(registerValues.get(posa));
        int element1 = Integer.parseInt(registerValues.get(posb));
        int mul = element * element1;
        registerValues.add(Integer.toString(mul));
    }

    /*
     * Instruction that will divide two registers together and store their sum in an ArrayList
     */
    public void div(String a, String b, int i, String reg) {
        registerName.add(reg);
        int posa = registerRegister.indexOf(a);
        int posb = registerRegister.indexOf(b);
        int element = Integer.parseInt(registerValues.get(posa));
        int element1 = Integer.parseInt(registerValues.get(posb));
        int div = element / element1;
        registerValues.add(Integer.toString(div));
    }

    /*
     * Instruction that will print the contents of a register onto the java console
     */
    public void out(String reg) {
//        System.out.println(Arrays.toString(registerName.toArray()));
//        System.out.println(Arrays.toString(registerValues.toArray()));
        registerRegister.add(reg);
        int pos = registerRegister.indexOf(reg);
        int element = Integer.parseInt(registerValues.get(pos));
        System.out.printf("The register values of %s is %d", reg, element);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        try (FileReader freader = new FileReader("Data2.txt")) {
            BufferedReader br = new BufferedReader(freader);
            JavaInterpreter ji = new JavaInterpreter();
            String s;
            int i = 0;
            while ((s = br.readLine()) != null) {		
                i = i + 1;								
                System.out.println(s);					
                String[] tokens = s.split(" ");			
                String hold = tokens[1];
                switch (hold) {
                    case "sto":
                        //                System.out.println("it have");
                        ji.store(tokens[0], tokens[3], tokens[2], i);
                        break;
                    case "add":
                        ji.add(tokens[3], tokens[4], i, tokens[2]);
                        break;
                    case "sub":
                        ji.sub(tokens[3], tokens[4], i, tokens[2]);
                        break;
                    case "mul":
                        ji.mul(tokens[3], tokens[4], i, tokens[2]);
                        break;
                    case "div":
                        ji.div(tokens[3], tokens[4], i, tokens[2]);
                        break;
                    case "out":
                        ji.out(tokens[2]);
                        break;
//                System.out.println("it have not");
                     default:
                        break;
                }
            }
        }
    }
}
