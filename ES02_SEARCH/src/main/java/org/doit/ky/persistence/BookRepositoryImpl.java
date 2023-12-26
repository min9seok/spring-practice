package org.doit.ky.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.doit.ky.domain.BookDTO;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;


@Repository
public class BookRepositoryImpl implements BookRepository {

   @Override
   public List<Map<String, Object>> search(String word) {
      
      try {
         
         List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
         
         RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
                  
         SearchRequest searchRequest = new SearchRequest("book");
         
         SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(100);
         
         searchSourceBuilder
                 .query(QueryBuilders.boolQuery()
                 .must(QueryBuilders.matchQuery("title", word))
                 .should(QueryBuilders.matchPhraseQuery("title",  word)));
                  
         searchRequest.source(searchSourceBuilder);
         
         SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
         SearchHits searchHits = response.getHits();
         
         for (SearchHit hit : searchHits) {
            Map<String,Object> sourceMap = hit.getSourceAsMap();
            sourceMap.put("id", hit.getId());
            list.add(sourceMap);
         }
                           
         client.close();
         
         return list;
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return null;
   }
   
   @Override
   public void add(BookDTO dto) {
      
      try {
         
         RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
         
         ObjectMapper om = new ObjectMapper();
                  
         String data = om.writeValueAsString(dto);

         IndexRequest request = new IndexRequest("book")
                                             .source(data, XContentType.JSON)
                                             .setRefreshPolicy("wait_for");
         
         request.id(dto.getSeq());
         
         IndexResponse response = client.index(request, RequestOptions.DEFAULT);
         
         client.close();
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
   }
   
}