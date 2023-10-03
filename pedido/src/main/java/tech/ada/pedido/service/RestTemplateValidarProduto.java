package tech.ada.pedido.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.ada.produto.model.Produto;

@Service
@ConditionalOnSingleCandidate(ValidarProduto.class)
public class RestTemplateValidarProduto implements ValidarProduto {

    private final EurekaClient eurekaClient;

    public RestTemplateValidarProduto(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @Override
    public void execute(int produtoId) {
        InstanceInfo destination = eurekaClient.getApplication("produto")
                .getInstances()
                .get(0);

        String hostName = destination.getHostName();
        int port = destination.getPort();
        String url = "http://" + hostName + ":" + port + "/" + produtoId;
        new RestTemplate().getForObject(url, Produto.class);
    }
}
