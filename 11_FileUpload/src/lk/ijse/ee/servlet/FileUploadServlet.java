package lk.ijse.ee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ishanka on 5/29/21 at 7:02 PM
 * @since 0.0.1
 */
@WebServlet(urlPatterns = "/up")
@MultipartConfig
public class FileUploadServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //catch the file from the request
        Part file = req.getPart("file");
        //get the file name
        String submittedFileName = file.getSubmittedFileName();
        ////select a place to upload
        String realPath = getServletContext().getRealPath("");
        // get the input stream
        InputStream inputStream = file.getInputStream();

        // create a new file to store the uploaded file
        File file1 = new File(realPath + File.separator + submittedFileName);
        file1.createNewFile();

        // to write down the file
        FileOutputStream fileOutputStream = new FileOutputStream(file1);

        // read all bytes from uploaded file

/*
        int read1;

        while ((read1=inputStream.read()) != -1){
            fileOutputStream.write(read1);
        }
*/

        int read;

        byte[] buffer = new byte[1024];

        while ( (read=inputStream.read(buffer,0,buffer.length)) != -1){
            fileOutputStream.write(buffer,0,buffer.length);
//            resp.getOutputStream().write(buffer,0,buffer.length);
        }

        fileOutputStream.close();

    }
}
