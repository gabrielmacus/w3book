package w3b;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import w3b.DAOs.GenericDAO;
import w3b.DAOs.ImagenDAO;
import w3b.Entidades.Imagen;

public class Main {

	public static void main(String[] args) throws IOException {
/*
ImagenDAO imDao =new ImagenDAO();
System.out.println(org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(imDao.getLista().get(0).getImagen()));
System.out.println(imDao.getLista().get(0).getImagen().length);
*/
		System.out.println(Property.getProp("maxsize"));
/*
FileOutputStream fos = new FileOutputStream(new File("C:\\f.png"));
fos.write(imDao.getLista().get(0).getImagen());
fos.close();
	*/

	
	
	}

}
