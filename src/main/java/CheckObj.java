
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class CheckObj {
    public static void main(String[] args) {
        try {
            //           if you are using environment variables for access key and secret access key use this
//            EnvironmentVariableCredentialsProvider environmentVariableCredentialsProvider = new EnvironmentVariableCredentialsProvider();
            ProfileCredentialsProvider profileCredentialsProvider = new ProfileCredentialsProvider("default");
            //make  sure you use the correct variable name in the withCredentials(<CredentialProvider>)
            final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(profileCredentialsProvider).withRegion("<Region in which you set up your bucket>").build();
            try {
                boolean doesItExists = s3.doesObjectExist("<Bucket Name>", "<Object Name>");
            System.out.println("Does the object exist in the given bucket " + doesItExists);
            } catch (Exception error) {
                System.out.println("this is the error "+ error);
            }

        } catch (Exception error) {
            System.out.println("Error "+error);
        }
    }
}
