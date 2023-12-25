package org.doit.ky.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/elasticsearch/*")
public class ESController {
  //목록보기
  @GetMapping(value = "list")
  public void list(Model model, String type, String word) {

	if (type == null || type.equals("")) {
	  type = "match_all";
	}

	try {

	  List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

	  RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

	  SearchRequest searchRequest = new SearchRequest("spring");

	  SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(100);

	  if (type.equals("match_all")) {
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
	  } else if (type.equals("match_or")) {
		searchSourceBuilder.query(QueryBuilders.matchQuery("message", word));
	  } else if (type.equals("match_and")) {
		searchSourceBuilder.query(QueryBuilders.matchQuery("message", word).operator(Operator.AND));
	  }

	  searchRequest.source(searchSourceBuilder);

	  SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
	  SearchHits searchHits = response.getHits();

	  for (SearchHit hit : searchHits) {
		Map<String, Object> sourceMap = hit.getSourceAsMap();
		sourceMap.put("id", hit.getId());
		list.add(sourceMap);
	  }
	  log.warn(list);
	  model.addAttribute("list", list);
	  model.addAttribute("type", type);
	  model.addAttribute("word", word);
	  client.close();

	} catch (Exception e) {
	  e.printStackTrace();
	}

  }

  //추가하기(폼)
  @GetMapping(value = "add")
  public void add() {

  }

  //추가하기(처리)
  @PostMapping(value = "add")
  public String add(Model model, String id, String message) {
	try {

	  RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

	  String data = String.format("{\"message\":\"%s\"}", message);

	  IndexRequest request = new IndexRequest("spring").source(data, XContentType.JSON).setRefreshPolicy("wait_for");
	  request.id(id);

	  IndexResponse response = client.index(request, RequestOptions.DEFAULT);

	  client.close();

	} catch (Exception e) {
	  e.printStackTrace();
	  model.addAttribute("e", e);
	}

	return "redirect:/elasticsearch/list";
  }
}
