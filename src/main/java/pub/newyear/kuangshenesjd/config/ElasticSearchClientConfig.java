package pub.newyear.kuangshenesjd.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchClientConfig {
    private final static String ES_USER = "elastic";
    private final static String ES_PASSWORD = "123456";

    @Bean
    public RestHighLevelClient restHighLevelClient(){
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(ES_USER, ES_PASSWORD));
        return new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1",9200,"http"))
        .setHttpClientConfigCallback(f->f.setDefaultCredentialsProvider(credentialsProvider)));
    }
}
