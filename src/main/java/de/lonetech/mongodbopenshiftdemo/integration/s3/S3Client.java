package de.lonetech.mongodbopenshiftdemo.integration.s3;

import java.io.InputStream;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class S3Client
{
  @Value("${s3.endpoint}")
  private String endpoint;

  @Value("${s3.accesskey}")
  private String accesskey;

  @Value("${s3.secretkey}")
  private String secretkey;

  @Value("${s3.bucketname}")
  private String bucketName;

  public InputStream getContentAsStream(String path)
  {
    AWSCredentials credentials = new BasicAWSCredentials(accesskey, secretkey);

    AmazonS3
      s3client =
      AmazonS3ClientBuilder.standard()
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, Regions.EU_CENTRAL_1.getName()))
        .build();

    S3Object s3object = s3client.getObject(bucketName, path);
    return s3object.getObjectContent();

  }
}
