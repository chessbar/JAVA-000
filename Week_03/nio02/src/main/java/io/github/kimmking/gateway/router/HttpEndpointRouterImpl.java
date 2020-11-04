package io.github.kimmking.gateway.router;

import java.util.List;
import java.util.Random;

public class HttpEndpointRouterImpl implements HttpEndpointRouter {
    @Override
    public String route(List<String> endpoints) {
        int nums = endpoints.size();
        Random random = new Random();
        int randmonNum = random.nextInt(nums);
        return endpoints.get(randmonNum);
    }
}
