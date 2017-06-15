import java.util.*;
import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.*;
import java.io.*;
public class Trial {
    public static void main(String args[])throws IOException{
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        BufferedReader br = new BufferedReader(new FileReader("/home/vivekk/Documents/demo.txt"));
        final  Map m=new HashMap();
        String temp=" ";
        String s = br.readLine();
        while(s!=null)
        {
            temp=temp+s+'\n';
            s=br.readLine();
        }
        final String str=temp;
        parser.setSource(str.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        cu.accept(new ASTVisitor() {
            Set names = new HashSet();
            public boolean visit(MethodDeclaration node) {
                SimpleName name = node.getName();
                this.names.add(name.getIdentifier());
                String n;
                n=name.toString();
                System.out.println(n);
                     node.accept(new ASTVisitor() {
                         Set names2 = new HashSet();
                         public boolean visit(MethodInvocation node) {
                             SimpleName name = node.getName();
                             this.names2.add(name.getIdentifier());
                             Map m = new HashMap();
                             int i, j;
                             int index = 0;
                             String n;
                             n = name.toString();
                            for (i = 0; i < str.length(); i++) {
                                 for (j = i + 1; j < str.length(); j++) {
                                     String t = str.substring(i, j);
                                     if (n.equalsIgnoreCase(t)) {
                                         index = i;
                                         break;
                                     }
                                 }
                             }
                             char v;
                             for (i = index - 2; str.charAt(i) != '.' && str.charAt(i) != ';' && str.charAt(i) != '='; i--);
                             int x = i + 1;
                             String y = str.substring(x, index - 1);
                             int ob = 0;
                             ob = str.indexOf(y);
                             for (i = ob - 2; str.charAt(i) != '.' && str.charAt(i) != '\n' && str.charAt(i) != '='; i--);
                             int l = i + 1;
                             String z = str.substring(l, ob - 1);
                             if (y.equalsIgnoreCase("Integer") || y.equalsIgnoreCase("Double") || y.equalsIgnoreCase("Float")) {
                                 m.put(y, n);
                             } else {
                                 if (z.substring(0, 3).equalsIgnoreCase("new")) {
                                     int p;
                                     for (p = 0; z.charAt(p) != '('; p++) ;
                                     z = z.substring(4, p);
                                 }
                                 m.put(z, n);
                             }
                             System.out.println();
                             System.out.println("\t" + m);
                             return false;
                         }
            });
        return false;
        }
    });
}
}
