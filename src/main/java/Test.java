/**
 * Created by vivekk on 24/5/17.
 */
import java.util.*;
import org.eclipse.jdt.core.dom.*;
import java.io.*;
public class Test {
    public static void main(String args[])throws IOException{
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        BufferedReader br = new BufferedReader(new FileReader("/home/vivekk/Documents/demo.txt"));
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
          public boolean visit(MethodInvocation node) {
                SimpleName name = node.getName();
                this.names.add(name.getIdentifier());
              Map m=new HashMap();
              int i,j;
              int index = 0;
              String n;
              n=name.toString();
             for(i=0;i<str.length();i++) {
                  for (j = i + 1; j < str.length(); j++) {
                      String t = str.substring(i, j);
                      if (n.equalsIgnoreCase(t)) {
                          index = i;
                          break;
                      }
                  }
              }
              char v;
              for(i=index-2;str.charAt(i)!='.' && str.charAt(i)!=';' && str.charAt(i)!='=';i--);
              int x=i+1;
              String y=str.substring(x,index-1);
              int ob=0;
              ob=str.indexOf(y);
              for(i=ob-2;str.charAt(i)!='.' && str.charAt(i)!='\n' && str.charAt(i)!='=';i--);
              int l=i+1;
              String z=str.substring(l,ob-1);
              if(y.equalsIgnoreCase("Integer")||y.equalsIgnoreCase("Double")||y.equalsIgnoreCase("Float"))
              {
                  m.put(y,n);
              }
             else
              {
                 if(z.substring(0,3).equalsIgnoreCase("new"))
                  {
                      int p;
                      for(p=0;z.charAt(p)!='(';p++);
                      z=z.substring(4,p);
                  }
                  m.put(z,n);
              }
              System.out.println();
              System.out.print("\t" + m);
                return false;
            }
        });
    }
}
/*import java.util.*;
import org.eclipse.jdt.core.dom.*;
import java.io.*;
public class Test {
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
                int index=str.indexOf(n);
                System.out.println(index);
                int i,j;
                /*for(i=index;str.charAt(i)!=')';i++)
                {
                //    System.out.println(1);
                    int t=0;
                    if(str.charAt(i)=='(')
                    {
                      //  System.out.println(2);
                        String s1=" ",s2=" ";
                        for(j=i+1;str.charAt(j)!=','&& str.charAt(j)!=')';j++)
                        {
                  //          System.out.println(3);
                            if(str.charAt(j)==' ')
                            {
                    //            System.out.println(4);
                                s1=str.substring(i+1,j);
                            }
                        }
                        t=i+1;
                        s2=str.substring(t,j);
                        t=j+1;
                        m.put(s2,s1);
                        i=t;
                    }
                }*/
                /*String x=" ";
                for(i=index+1;str.charAt(i)!=')';i++)
                {
                    x=x+str.charAt(i);
                }
                System.out.println(x);
                //System.out.println();
                //System.out.print("\t" + m);

               /*      node.accept(new ASTVisitor() {
                         Set names2 = new HashSet();
                         public boolean visit(MethodInvocation node) {
                             SimpleName name2 = node.getName();
                             this.names2.add(name2.getIdentifier());
                             String w;
                             w = name2.toString();
                             int x=str.indexOf(w);
                             System.out.println(m.get(w));
                             return false;
                         }
            });*/
              /*  return false;
        }
    });
}
}*/