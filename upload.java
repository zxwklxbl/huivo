import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.glacier.AmazonGlacierClient;
import com.amazonaws.services.glacier.transfer.ArchiveTransferManager;
import com.amazonaws.services.glacier.transfer.UploadResult;

public class AmazonGlacierUploadArchive_GettingStarted {

    public static String vaultName = "zxwklxbl";
    public static String archiveToUpload = "*** provide name of file to upload ***";
    
    public static AmazonGlacierClient client;
    
    public static void main(String[] args) throws IOException {
        
    	ProfileCredentialsProvider credentials = new ProfileCredentialsProvider();
        client = new AmazonGlacierClient(credentials);
        client.setEndpoint("https://glacier.ap-northeast-1.amazonaws.com/");

        try {
            ArchiveTransferManager atm = new ArchiveTransferManager(client, credentials);
            
            UploadResult result = atm.upload(vaultName, "/root/pip-1.5.6.tar.gz" + (new Date()), new File(archiveToUpload));
            System.out.println("Archive ID: pip" + result.getArchiveId());
            
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }
}
