import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


public class FonctionsIO {

	public static void copyFile(String srcPath, String destPath1, String destPath2) throws IOException
	{
		File srcFile = new File(srcPath);
		System.out.println(srcFile.getAbsolutePath());
		Reader fis = null;
		Writer fos = null;
		Writer fos2 = null;
			try {
				fis = new FileReader(srcFile);
				fos = new FileWriter(destPath1);
				fos2 = new FileWriter(destPath2);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String str = null;
			
		try
		{
			
			 BufferedReader buff = new BufferedReader(fis);
			 while((str = buff.readLine()) != null){
				 String[] mots = str.split(" ") ;
			    fos.write(mots[0].concat(" ").concat(mots[1]));	
			    fos.write(System.getProperty("line.separator" ));
			    fos2.write(mots[2].concat(" "));	
			    fos2.write(System.getProperty("line.separator" ));
			 }
		fos.close();
		fos2.close();
		fis.close();
		}
		catch (IOException e) {}
	}
	
public static void reconstitution(String destPath, String srcPathNom, String srcPathMail) throws IOException {
		
		Writer out = new FileWriter(destPath);
		Reader fichierNom =  new FileReader(srcPathNom);
		Reader fichierMail =  new FileReader(srcPathMail);
		BufferedReader brN = new BufferedReader(fichierNom);
		BufferedReader brM = new BufferedReader(fichierMail);
		
		
		try
		{
			String[] tab = new String[3];
			String[] tab2 = new String[3];
			boolean fin = false;
			
			while (fin==false) {
				String s = brN.readLine();
				String s1 = brM.readLine();
				
				if (s==null) {
					fin=true;
				}
				else {
					tab = s.split(" ");
					tab2 = s1.split(" ");
					out.write(tab[0]+" "+tab[1]);
					out.write(" ");
					out.write(tab2[0]);
					out.write(System.getProperty("line.separator"));
				}
			}
		
			fichierNom.close();
			fichierMail.close();
			out.close();
		}
		catch (IOException e) {System.out.println(e);}
	}

}
