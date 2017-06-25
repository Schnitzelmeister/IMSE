package imse.SS2017.team1.database;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

public class PictureUtility {

	public final static int HEIGHT = 200;
	public final static int WIDTH = 200;
	
	public static String convertPicToString(String fileUrl) throws IOException {
		
		URL url = new URL(fileUrl);
		Image image = ImageIO.read(url);
		BufferedImage convertedImage = createResizedCopy(image, HEIGHT, WIDTH, true);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write( convertedImage, "jpeg", baos );
		baos.flush();
		byte[] pictureData = baos.toByteArray();
		baos.close();
/*		
		File file = new File(fileUrl);
		FileInputStream inputStream = new FileInputStream(file);
		byte[] pictureData = new byte[(int) file.length()];
		
		inputStream.read(pictureData);
		inputStream.close();
	*/	
		return Base64.encodeBase64String(pictureData);
	}
	
	public static byte[] convertStringToPic(String pictureString){
		return Base64.decodeBase64(pictureString);
	}
	
	public static BufferedImage createResizedCopy(Image originalImage, 
            int scaledWidth, int scaledHeight, 
            boolean preserveAlpha)
    {
        System.out.println("resizing...");
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
        g.dispose();
        return scaledBI;
    }
}