package w3b;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import w3b.Entidades.Imagen;

public abstract class Upload {

    public static List<FileItem> uploadImage(HttpServletRequest request) throws Exception
    {  
        
   boolean isMultipart;
   //String filePath;
   int maxFileSize = 50 * 1024*1024;//5mb
   int maxMemSize = 4 * 1024 *1024;
  // File file=null ;
              FileItem fi=null;
    // Check that we have a file upload request
     
             // filePath =  System.getProperty("user.dir")+System.getProperty("file.separator")+"users-img"+System.getProperty("file.separator")+(long)request.getSession(false).getAttribute("session_id")+System.getProperty("file.separator");
    /*   filePath =  System.getProperty("user.dir")+System.getProperty("file.separator")+"users-img"+System.getProperty("file.separator");
              File f= new File(filePath);
        if(!f.exists())
        {
            f.mkdirs();
            
            System.out.println("Directorio creado");
        }*/
      isMultipart = ServletFileUpload.isMultipartContent(request);
    
      
      if( !isMultipart ){
       throw new Exception("1500");
      }
      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
      // Location to save data that is larger than maxMemSize.
    //  factory.setRepository(new File("c:\\temp"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );

      
      // Parse the request to get file items.
      List fileItems = upload.parseRequest(request);
 
      // Process the uploaded file items
      Iterator i = fileItems.iterator();
 String url="";
 List<FileItem> streams = new ArrayList<>();
      while ( i.hasNext () ) 
      {
        fi = (FileItem)i.next();
         if ( !fi.isFormField () )	
         {            
             
    //         Main.storeFile("gmhost.net76.net","a9901940", "admin", 21, fi.getInputStream(),fi.getName(),(long)request.getSession(false).getAttribute("session_id"));
     
           //  url="http://gmhost.net76.net/"+(long)request.getSession(false).getAttribute("session_id")+"/"+fi.getName();
           streams.add(fi);
         }
      }
        System.out.println(url);
return streams;

    }
    
    public static void putImageIntoDatabase(HttpServletRequest request) throws Exception
    {
		List<FileItem> files = new ArrayList<>();
		try {
			files = Upload.uploadImage(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String bytes = "";
		EntityManager em = PersistenceManager.getInstance().getEntityManager();
		EntityTransaction t=em.getTransaction();
		t.begin();
		
		int maxSize = Integer.parseInt(Property.getProp("maximagesize"));
		for (FileItem f : files) {


			    
			if (f.getSize() > 0 && f.getSize()<=maxSize) {

				BufferedInputStream bf = new BufferedInputStream(f.getInputStream());

			byte[] array = new byte[(int) f.getSize()];

				bf.read(array);
		
				em.persist(new Imagen(array,f.getName()));
				bf.close();

	                       
			

			}
			else if(f.getSize()>maxSize)
			{
				t.rollback();
				em.close();
				throw new  IOException("1500");
			}
		}
		em.close();
		t.commit();

    }
}
