import java.io.*;
import java.util.*;
import org.apache.commons.io.*;
class ExploreJar
{
static File jar_dir = new File(System.getProperty("user.dir"),"JarSets");
static String bluej_userlib_dir = "";
static File jar_list[];
static
{
ListText lt = new ListText();
bluej_userlib_dir=lt.fileToList("bluej_userlib_path.txt").getFirst();
jar_list = jar_dir.listFiles();
}
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
ExploreJar ej = new ExploreJar();
System.out.println("JAR INCLUDE OPTIONS");
System.out.println("_____________________________________________________________________________________");
int indx=0;
for(File ff : jar_list)
{
System.out.println(indx+"\t : \t"+ff.getName());
indx++;
}
System.out.println("_____________________________________________________________________________________");
while(true)
{
System.out.println("_____________________________________________________________________________________");
System.out.println("Enter 'x' to Exit");
System.out.println("Enter 'd' to Delete Jars");
System.out.println("_____________________________________________________________________________________");
String str=sc.next();
if(str.indexOf("x")==0)
{
System.out.println("PROGRAM EXIT");
break;
}
else if(str.indexOf("d")==0)
{
ej.deleteJars();
}
else
{
ej.copyJars(str);
}
}
}
void deleteJars()
{
try
{
for(File ff : (new File(bluej_userlib_dir)).listFiles())
{
try
{
if(FileUtils.deleteQuietly(ff))
{
System.out.println("Deleted : "+ff.getName());
continue;
}
}
catch(Exception e)
{
}
System.out.println("Deletion Error : "+ff.getName());
}
}
catch(Exception e)
{
}
}
void copyJars(String n)
{
try
{
int a=Integer.parseInt(n);
System.out.println("Copying Content :- "+jar_list[a].getName());
System.out.println("_____________________________________________________________________________________");
for(File ff : jar_list[a].listFiles())
{
try
{
FileUtils.copyFileToDirectory(ff,(new File(bluej_userlib_dir)));
System.out.println("Copied : "+ff.getName());
}
catch(Exception e)
{
System.out.println("Copy Error:");
}
}
}
catch(Exception e)
{
System.out.println("Copying Content Error : "+n);
}
}
}