package com.ghoshtubai.moviecatalogservice.resource;

import com.ghoshtubai.moviecatalogservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    Logger logger = LoggerFactory.getLogger(MovieCatalogResource.class);
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ratings/{userId}")
    public UserRatingData getRatingsByUser(@PathVariable final String userId){
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate.getForObject("http://ratings-movie-service/rating/"+userId, UserRatingData.class);
    }
    @GetMapping("/{userId}")
    public List<CatalogService> getCatalogByUser(@PathVariable final String userId){
        // call to rating-data-service using user ID.
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        UserRatingData userRatingData= restTemplate.getForObject("http://ratings-movie-service/rating/"+userId, UserRatingData.class);
        // call Movie info service to get Movie Details
        if (userRatingData!=null && userRatingData.getRating()!=null && userRatingData.getRating().size()!=0){
            return userRatingData.getRating().stream()
                    .map(rating -> {
                        MovieInfo movieInfo = restTemplate.getForObject(
                                "http://movie-info-service/movieinfo/"+rating.getMovieName(),
                                MovieInfo.class);
                        return new CatalogService(rating.getMovieName(),
                                movieInfo.getDetails().getDescription(),
                                rating.getRating(),
                                movieInfo.getDetails().getGenre(),
                                movieInfo.getDetails().getReleaseDate());
                    })
                    .collect(Collectors.toList());
        }
        logger.info("User "+ userId +" details not available in the DB");
        List<CatalogService> catalogServices = new ArrayList<>();
        return catalogServices;
    }
}
